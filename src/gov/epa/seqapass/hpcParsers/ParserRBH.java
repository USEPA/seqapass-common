package gov.epa.seqapass.hpcParsers;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.stream.Stream;

public class ParserRBH {
  private int accessionRunId;
  private int originalSubjectTaxId;
  private String originalCanonicalAccessionId;

  public static void main(String[] args) throws IOException, InterruptedException {

    String originalCanonicalaccession = args[0];
    int taxId = Integer.parseInt(args[1]);
    int accessionRun = Integer.parseInt(args[2]);

    ParserRBH parserRBH = new ParserRBH(originalCanonicalaccession, taxId, accessionRun);
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);

    while (!inputStreamReader.ready()) {
      Thread.sleep(3000);
    }

    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    Stream<String> stream = bufferedReader.lines();

    parserRBH.parseRBHOnly(stream);
  }

  public ParserRBH(String originalCanonicalAccessionId, int originalSubjectTaxId, int accessionRunId) {

    this.originalSubjectTaxId = originalSubjectTaxId;
    this.originalCanonicalAccessionId = originalCanonicalAccessionId;
    this.accessionRunId = accessionRunId;

  }

  private void parseRBHOnly(Stream<String> s) {
    System.out.println(originalSubjectTaxId+"");

    Stream<String> stream = s;

    Iterable<String> st = stream::iterator;
    String canonical_accession_id = null;
    String subject_top_canonical_id = null;
    String bitscore = null;
    String evalue = null;
    int lineCount =0;
    boolean endOfFileFound = false;
    for (String line : st) {
      if (line.startsWith("  <Iteration_query-def>")){
        String[] spaceSplits = line.substring(23).split(" ");
        canonical_accession_id = spaceSplits[0];
        
      } else if (canonical_accession_id != null && line.startsWith("  <Hit_id>")){
        subject_top_canonical_id = parseAccession(line.substring(10));
        
      } else if (canonical_accession_id != null && line.startsWith("      <Hsp_bit-score>")) {
        String[] spaceSplits = line.substring(21).split("<");
        bitscore =spaceSplits[0];

      } else if (canonical_accession_id != null && line.startsWith("      <Hsp_evalue>")) {
        String[] spaceSplits = line.substring(18).split("<");
        evalue = spaceSplits[0];
        System.out.println(canonical_accession_id+"\t"+subject_top_canonical_id+"\t"+bitscore+"\t"+evalue);
        canonical_accession_id = null;
      } else if (line.startsWith("</BlastOutput>")){
	endOfFileFound = true;
      }

	lineCount++;
    }
    if(endOfFileFound){
	 System.out.println("completed"+"\t"+"completed"+"\t"+"0.0"+"\t"+"0.0");
    } else{
	System.out.println("failed"+"\t"+"failed"+"\t"+"1.0"+"\t"+"1.0");
    }
    stream.close();
  }
  
  private String parseAccession(String postGTString) {
    String[] spaceSplits = postGTString.split(" ");
    String firstFrag = spaceSplits[0];
    String[] ltSplits = firstFrag.split("<");
    String firstPart = ltSplits[0];
    if(firstPart.startsWith("pdb|")) {
      return firstPart.substring(4).replaceAll("\\|", "_");
    } else     if(firstPart.startsWith("prf||")) {
      return firstPart;
    } else     if(firstPart.startsWith("pir|")) {
      return firstPart;
    } else {
      String[] pipeSplits = firstPart.split("\\|");
      return pipeSplits[1];
    }
  }
}
