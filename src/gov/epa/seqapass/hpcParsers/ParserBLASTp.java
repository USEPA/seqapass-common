package gov.epa.seqapass.hpcParsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import gov.epa.seqapass.common.Partition;

public class ParserBLASTp {
  private String queryAccessionString;
  private int queryAccessionTaxid = -1;
  private String canonicalAccessionString;
  private int canonicalAccessionTaxid = -1;
  private Set<String> queryTaxidAccessionsAboveIdentity = null;
  private final Map<String, String> blastPxmlTypes = new LinkedHashMap<String, String>();
  private List<String> allLines = new ArrayList<String>();

  // -------------------------------------------------------------------------
  String queryLenString = "<BlastOutput_query-len>(\\d+)</BlastOutput_query-len>";
  Pattern queryLenPattern = Pattern.compile(queryLenString);

  String hitIdString = "gi\\|\\d+\\|[^\\|]+\\|{1,2}([^\\|]+)\\|";
  Pattern hitIdPattern = Pattern.compile(hitIdString);

  String hitDefString = ">gi\\|\\d+\\|([^\\|]+)\\|{1,2}([^\\s\\|]+)\\s*\\|*([A-Za-z0-9]*)";
  Pattern hitDefPattern = Pattern.compile(hitDefString);

  String hitString = "<Hit>(.*?)</Hit>";
  Pattern hitPattern = Pattern.compile(hitString);
  // ---------------------------------------------------------------------------

  public static void main(String[] args) throws IOException, InterruptedException {

    String queryAccessionString = args[0];
    ParserBLASTp parserBlastp = new ParserBLASTp(queryAccessionString);
    parserBlastp.initializeBlastTypes();
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    while (!inputStreamReader.ready()) {
      Thread.sleep(3000);
    }
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    Stream<String> stream1 = bufferedReader.lines();

    List<ArrayList<String>> hitsMasterList = parserBlastp.parseForAccessions(stream1);
    ArrayList<HashMap<String, String>> taxIdMasterList = parserBlastp.sendForTaxIds(hitsMasterList.get(1));
    List<ArrayList<String>> hitRows = parserBlastp.parseBLASTpHPC(hitsMasterList, taxIdMasterList);
    stream1.close();

    if (hitRows != null) {
      if (hitRows.size() > 0) {
        parserBlastp.printAnswers(hitRows);
      }
    }

  }

  public ParserBLASTp(String queryAccessionString) {
    this.queryAccessionString = queryAccessionString;
  }

  List<ArrayList<String>> parseForAccessions(Stream<String> s) {
    StringBuilder patternHitTagsBuilder = new StringBuilder();
    StringBuilder patternHspTagsBuilder = new StringBuilder();

    for (String name : blastPxmlTypes.keySet()) {
      if (name.startsWith("Hit_")) {
        patternHitTagsBuilder.append("<" + name + ">(.*?)</" + name + ">.*?");
      } else if (name.startsWith("Hsp_")) {
        patternHspTagsBuilder.append("<" + name + ">(.*?)</" + name + ">.*?");
      }
    }

    Pattern patternHitTags = Pattern.compile(patternHitTagsBuilder.toString());

    StringBuilder linesToParse = new StringBuilder();
    ArrayList<ArrayList<String>> hitsMasterList = new ArrayList<ArrayList<String>>();
    ArrayList<String> hitCanonicals = new ArrayList<String>();
    ArrayList<String> hitAccessions = new ArrayList<String>();

    Stream<String> stream = s;
    for (String line : (Iterable<String>) stream::iterator) {

      allLines.add(line);
      linesToParse.append(line);
      if (line.matches("</Hit>")) {
        String hitChunk = linesToParse.toString();
        linesToParse.setLength(0);
        Matcher hitMatcher = hitPattern.matcher(hitChunk);
        if (hitMatcher.find()) {
          String oneHit = hitMatcher.group(1);
          Matcher matcherOfHitTags = patternHitTags.matcher(oneHit);
          if (matcherOfHitTags.find()) {
            String parsedAccession = null;
            for (int i = 1; i < matcherOfHitTags.groupCount() + 1; i++) {
              String value = matcherOfHitTags.group(i);
              if (i == 2) {
                Matcher matcherHitId = hitIdPattern.matcher(value);
                if (matcherHitId.find()) {
                  parsedAccession = matcherHitId.group(1);
                }
              }

              if (i == 3) {

                Matcher matcherHitDef = hitDefPattern.matcher(value);
                while (matcherHitDef.find()) {
                  String dbType = matcherHitDef.group(1);
                  String dupAccessionBase = matcherHitDef.group(2);
                  hitCanonicals.add(parsedAccession);
                  if (dbType.equals("pdb")) {
                    hitAccessions.add(dupAccessionBase + "_" + matcherHitDef.group(3));
                  } else {
                    hitAccessions.add(dupAccessionBase);
                  }
                }
              }
              if (i == 4) {

                if (parsedAccession == null || parsedAccession.length() < value.length()) {
                  parsedAccession = value;
                }
              }
            }

            hitCanonicals.add(parsedAccession);
            hitAccessions.add(parsedAccession);
          }
        }
      }
    }
    hitsMasterList.add(hitCanonicals);
    hitsMasterList.add(hitAccessions);
    return hitsMasterList;
  }

  ArrayList<HashMap<String, String>> sendForTaxIds(List<String> hitAccessions) {
    String curl = "/usr/bin/curl";
    String h = "-H";
    String accept = "Accept: application/json";
    String content = "Content-type: application/json";
    String x = "-X";
    String post = "POST";
    String d = "-d";
    String http = "https://seqapass.hesc.epa.gov:8543/SeqAPASS-BE/getTaxids";
    ArrayList<HashMap<String, String>> masterList = new ArrayList<>();

    Partition<String> partition = new Partition<String>(hitAccessions, 3000);
    char quote = '"';
    for (int i = 0; i < partition.size(); i++) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("[");
      int j = 0;
      List<String> dupAccession = partition.get(i);
      for (String dup : dupAccession) {
        if (j == dupAccession.size() - 1) {
          stringBuilder.append("{").append(quote).append("accession").append(quote).append(":").append(quote)
              .append(dup).append(quote).append("}");
        } else {
          stringBuilder.append("{").append(quote).append("accession").append(quote).append(":").append(quote)
              .append(dup).append(quote).append("}").append(", ");
        }
        j++;
      }
      stringBuilder.append("]");
      String data = stringBuilder.toString();
      String[] command = {curl, h, accept, h, content, x, post, d, data, http};
      ProcessBuilder processBuilder = new ProcessBuilder(command);
      final StringBuilder stdOutStringBuilder = new StringBuilder();
      final StringBuilder stdErrStringBuilder = new StringBuilder();
      Process process;
      try {
        process = processBuilder.start();

        InputStream stdOutStream = process.getInputStream();
        InputStreamReader stdOutStreamReader = new InputStreamReader(stdOutStream);
        BufferedReader stdOutBufferedReader = new BufferedReader(stdOutStreamReader);
        String stdOutLine;
        while ((stdOutLine = stdOutBufferedReader.readLine()) != null) {
          stdOutStringBuilder.append(stdOutLine);
        }

        InputStream stdErrStream = process.getErrorStream();
        InputStreamReader stdErrStreamReader = new InputStreamReader(stdErrStream);
        BufferedReader stdErrBufferedReader = new BufferedReader(stdErrStreamReader);
        String stdErrLine;
        while ((stdErrLine = stdErrBufferedReader.readLine()) != null) {
          stdErrStringBuilder.append(stdErrLine);
        }
      } catch (IOException e) {
        return null;
      }

      String out = stdOutStringBuilder.toString();
      if (out.equals(null) || out == null || out.equals("") || out.equals(" ")) {
        System.out.println("Did not retrive taxId information");
        return null;
      }

      String beforeColonString = "(.*?)(?=:)";
      Pattern beforeColonPattern = Pattern.compile(beforeColonString);

      String afterColonString = "(?<=:).*";
      Pattern afterColonPattern = Pattern.compile(afterColonString);

      String proteinSearchString = "\\{(.*?)\\}";
      Pattern proteinSearchPattern = Pattern.compile(proteinSearchString);
      Matcher proteinMatcher = proteinSearchPattern.matcher(out);
      while (proteinMatcher.find()) {
        HashMap<String, String> map = new HashMap<String, String>();
        String protein = proteinMatcher.group(0);
        protein = protein.substring(1, protein.length());
        protein = protein.substring(0, protein.length() - 1);
        String[] proteinValues = protein.split(",");
        for (String val : proteinValues) {
          Matcher beforeColonMatcher = beforeColonPattern.matcher(val);
          if (beforeColonMatcher.find()) {
            String key = beforeColonMatcher.group(0);
            Matcher afterColonMatcher = afterColonPattern.matcher(val);
            if (afterColonMatcher.find()) {
              String value = afterColonMatcher.group(0);
              map.put(key.replaceAll("\"", ""), value.replaceAll("\"", ""));

            }
          }
        }
        masterList.add(map);
      }

    }
    return masterList;
  }

  private List<ArrayList<String>> parseBLASTpHPC(List<ArrayList<String>> hitsMasterList,
      ArrayList<HashMap<String, String>> masterList) {
    int queryLength = -1;
    int identityQueryIndex = -1;
    boolean reachedIdentity = false;
    int identityCanonicalIndex = -1;
    Set<Integer> taxidsSeenSoFar = new HashSet<Integer>();

    List<String> hitCanonicals = hitsMasterList.get(0);
    List<String> hitAccessions = hitsMasterList.get(1);

    StringBuilder patternHitTagsBuilder = new StringBuilder();
    StringBuilder patternHspTagsBuilder = new StringBuilder();

    for (String name : blastPxmlTypes.keySet()) {
      if (name.startsWith("Hit_")) {
        patternHitTagsBuilder.append("<" + name + ">(.*?)</" + name + ">.*?");
      } else if (name.startsWith("Hsp_")) {
        patternHspTagsBuilder.append("<" + name + ">(.*?)</" + name + ">.*?");
      }
    }
    Pattern patternHitTags = Pattern.compile(patternHitTagsBuilder.toString());
    Pattern patternHsps = Pattern.compile(patternHspTagsBuilder.toString());

    List<ArrayList<String>> hitRows = new ArrayList<ArrayList<String>>();

    try {
      StringBuilder linesToParse = new StringBuilder();
      for (String line : allLines) {
        if (queryLength < 0 && line.matches("BlastOutput_query-len")) {
          Matcher queryLenMatcher = queryLenPattern.matcher(line);
          queryLength = Integer.parseInt(queryLenMatcher.group(1));

        }
        linesToParse.append(line);
        if (line.matches("</Hit>")) {
          String hitChunk = linesToParse.toString();
          linesToParse.setLength(0);
          Matcher hitMatcher = hitPattern.matcher(hitChunk);
          if (hitMatcher.find()) {
            String oneHit = hitMatcher.group(1);
            Matcher matcherOfHitTags = patternHitTags.matcher(oneHit);
            ArrayList<String> baseValues = new ArrayList<String>();
            List<String> dupAccessions = new ArrayList<String>();
            Map<String, Integer> dupPairs = new HashMap<String, Integer>();
            if (matcherOfHitTags.find()) {
              String parsedAccession = null;
              for (int i = 1; i < matcherOfHitTags.groupCount() + 1; i++) {
                String value = matcherOfHitTags.group(i);
                if (i == 2) {
                  Matcher matcherHitId = hitIdPattern.matcher(value);
                  if (matcherHitId.find()) {
                    parsedAccession = matcherHitId.group(1);
                  }
                }
                if (i == 3) {
                  Matcher matcherHitDef = hitDefPattern.matcher(value);
                  while (matcherHitDef.find()) {
                    String dbType = matcherHitDef.group(1);
                    String dupAccessionBase = matcherHitDef.group(2);
                    if (dbType.equals("pdb")) {
                      dupAccessions.add(dupAccessionBase + "_" + matcherHitDef.group(3));
                    } else {
                      dupAccessions.add(dupAccessionBase);
                    }
                  }
                }
                if (i == 4) {
                  if (parsedAccession == null || parsedAccession.length() < value.length()) {
                    parsedAccession = value;
                  }
                }
                baseValues.add(value);

              }
              baseValues.add(0, parsedAccession);
              baseValues.add(1, "-1");
              baseValues.add(2, parsedAccession);

              dupAccessions.add(parsedAccession);
              for (HashMap<String, String> proteinMap : masterList) {
                String accessionId = proteinMap.get("accession");
                int taxId = Integer.parseInt(proteinMap.get("taxId"));
                dupPairs.put(accessionId, taxId);
                if (accessionId.equals(canonicalAccessionString) && canonicalAccessionTaxid < 0) {
                  canonicalAccessionTaxid = taxId;
                  identityCanonicalIndex = hitRows.size();
                }
                if (accessionId.equals(queryAccessionString)) {
                  queryAccessionTaxid = taxId;
                }
              }

            } else {
              System.out.println("Failed to get a base value");
              return null;
            }

            Matcher matcherHsps = patternHsps.matcher(oneHit);
            while (matcherHsps.find()) {
              ArrayList<String> hitRowTemplate = new ArrayList<String>();
              hitRowTemplate.addAll(baseValues);
              for (int i = 1; i < matcherHsps.groupCount() + 1; i++) {
                hitRowTemplate.add((matcherHsps.group(i)));
              }
              boolean firstRow = true;
              for (String dupAccession : dupAccessions) {
                if (!reachedIdentity || !taxidsSeenSoFar.contains(dupPairs.get(dupAccession))) {
                  if (reachedIdentity) {
                    taxidsSeenSoFar.add(dupPairs.get(dupAccession));
                  }

                  @SuppressWarnings("unchecked")
                  ArrayList<String> hitRowToAdd = (ArrayList<String>) hitRowTemplate.clone();
                  hitRowToAdd.set(0, dupAccession);
                  hitRowToAdd.set(1, dupPairs.get(dupAccession).toString());
                  if (firstRow) {
                    firstRow = false;
                  }
                  hitRowToAdd.set(1, dupPairs.get(dupAccession).toString());
                  hitRowToAdd.set(2, dupAccessions.get(0));

                  if (dupAccession.equals(queryAccessionString)) {
                    identityQueryIndex = hitRows.size();
                  }
                  hitRows.add(hitRowToAdd);
                }
              }

              if (!reachedIdentity && queryAccessionTaxid > -1 && canonicalAccessionTaxid > -1
                  && identityCanonicalIndex > -1 && identityQueryIndex > -1) {

                List<Integer> rowsToRemove = new ArrayList<Integer>();
                taxidsSeenSoFar.add(queryAccessionTaxid);
                reachedIdentity = true;

                int identityStartPoint = identityCanonicalIndex;
                if (queryAccessionTaxid == canonicalAccessionTaxid
                    && !(queryAccessionString.equals(canonicalAccessionString))) {

                  rowsToRemove.add(identityCanonicalIndex);
                  identityStartPoint++;
                } else {
                  taxidsSeenSoFar.add(canonicalAccessionTaxid);
                }
                for (int i = identityStartPoint; i < hitRows.size(); i++) {
                  ArrayList<String> hitRowToConsider = hitRows.get(i);
                  String queryAccession = hitRowToConsider.get(0);
                  Integer taxid = Integer.parseInt(hitRowToConsider.get(1));

                  if (taxidsSeenSoFar.contains(taxid) && !queryAccession.equals(queryAccessionString)
                      && !queryAccession.equals(canonicalAccessionString)) {
                    rowsToRemove.add(i);

                  } else {
                    taxidsSeenSoFar.add(taxid);
                  }
                }
                for (int i = 0; i < identityCanonicalIndex; i++) {
                  ArrayList<String> hitRowToConsider = hitRows.get(i);
                  String queryAccession = hitRowToConsider.get(0);
                  Integer taxid = Integer.parseInt(hitRowToConsider.get(1));
                  if (taxidsSeenSoFar.contains(taxid)) {
                    rowsToRemove.add(i);

                    if (taxid == queryAccessionTaxid) {
                      queryTaxidAccessionsAboveIdentity.add(queryAccession);
                    }
                  } else {
                    taxidsSeenSoFar.add(taxid);
                  }
                }
                for (int i = hitRows.size() - 1; i >= 0; i--) {
                  if (rowsToRemove.contains(i)) {

                    hitRows.remove(i);
                  }
                }
              }
            }
          }

        }
      }

      if (hitRows.size() > 0) {

        return hitRows;
      } else {
        System.out.println("There are no hit rows");
        return null;
      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Could not read the input stream");
      return null;
    }

  }

  private void printAnswers(List<ArrayList<String>> hitRows) {
    for (ArrayList<String> row : hitRows) {
      System.out.println(row);
    }
  }

  public List<String> getBLASTpXMLTypeNames() {
    List<String> result = new ArrayList<String>();
    for (String name : blastPxmlTypes.keySet()) {
      result.add(name);
    }
    return result;
  }

  private void initializeBlastTypes() {
    blastPxmlTypes.put("Hit_num", "int");
    blastPxmlTypes.put("Hit_id", "String");
    blastPxmlTypes.put("Hit_def", "String");
    blastPxmlTypes.put("Hit_accession", "String");
    blastPxmlTypes.put("Hit_len", "int");
    blastPxmlTypes.put("Hsp_num", "int");
    blastPxmlTypes.put("Hsp_bit-score", "double");
    blastPxmlTypes.put("Hsp_score", "int");
    blastPxmlTypes.put("Hsp_evalue", "double");
    blastPxmlTypes.put("Hsp_query-from", "int");
    blastPxmlTypes.put("Hsp_query-to", "int");
    blastPxmlTypes.put("Hsp_hit-from", "int");
    blastPxmlTypes.put("Hsp_hit-to", "int");
    blastPxmlTypes.put("Hsp_query-frame", "int");
    blastPxmlTypes.put("Hsp_hit-frame", "int");
    blastPxmlTypes.put("Hsp_identity", "int");
    blastPxmlTypes.put("Hsp_positive", "int");
    blastPxmlTypes.put("Hsp_gaps", "int");
    blastPxmlTypes.put("Hsp_align-len", "int");
    blastPxmlTypes.put("Hsp_qseq", "String");
    blastPxmlTypes.put("Hsp_hseq", "String");
    blastPxmlTypes.put("Hsp_midline", "String");
  }

}
