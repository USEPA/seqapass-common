package gov.epa.seqapass.hpcParsers;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class RPSXMLParser {

	private int preferredNcbiProviderId;
	private List<ArrayList<LinkedHashMap<String, String>>> oneFileRPSResults = null;
	private final Map<String, String> blastPxmlTypes = new LinkedHashMap<String, String>();

	private static File tempOutFile = new File("/work/SEQAPASS/backend_test/input_scripts_output/rps_save/tempOutFile.txt");
	private static PrintWriter printWriter;

	public static void main (String [] args) throws IOException, InterruptedException,FileNotFoundException {
		
		printWriter = new PrintWriter(tempOutFile);
		int preferredNcbiProviderId = Integer.parseInt(args[0]);
		
		RPSXMLParser rpsXMLParser = new RPSXMLParser(preferredNcbiProviderId);
		rpsXMLParser.initializeBlastTypes();

	//	InputStreamReader inputStreamReader = new InputStreamReader(System.in);

	//	while (!inputStreamReader.ready()) {
	//		Thread.sleep(3000);
	//	}
		
	//	BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	//	Stream<String> stream = bufferedReader.lines();

		Scanner scanner = new Scanner(System.in);
		rpsXMLParser.parseRPSHPC(scanner);	

	}

	public RPSXMLParser(int preferredNcbiProviderId){
		this.preferredNcbiProviderId = preferredNcbiProviderId;
	
	}




	private void parseRPSHPC(Scanner s) {

	oneFileRPSResults = new ArrayList<ArrayList<LinkedHashMap<String, String>>>();	
	
	//	Stream<String> stream = s;
		StringBuilder linesToParse = new StringBuilder();
		int numLines =0;
	//	Iterator<String> iterator = stream.iterator();
	//	Iterable<String> st = convertIterableFromIterator(iterator);
	//	for (String line : st) {
		while(s.hasNextLine()){
			String line = s.nextLine();	
			linesToParse.append(line);
			numLines++;
			if(numLines == 9000) {
				String remainder = parseChunk(linesToParse.toString());
				linesToParse = new StringBuilder();
				linesToParse.append(remainder);
				numLines = 0;
			}

		}
		printWriter.println("finished reading lines: " + numLines);
		if (linesToParse.length() > 0) {
			parseChunk(linesToParse.toString());
		}

	//	stream.close();
		printAnswers();	



	}


	private String parseChunk(String linesToParse) {

	
		String iterationString = "<Iteration>(.*?)</Iteration>";
		Pattern iterationPattern = Pattern.compile(iterationString);

		String iterationDefString = "<Iteration_query-def>(.*?)</Iteration_query-def>(.*)";
		Pattern iterationDefPattern = Pattern.compile(iterationDefString);

		String iterationHitsString = "<Iteration_hits>(.*?)</Iteration_hits>(.*)";
		Pattern iterationHitsPattern = Pattern.compile(iterationHitsString);

		// For parsing pdb entries like: pdb|1JLY|A Chain A, Cryst...
		String pdbAccessionIdString = "^pdb\\|([A-Z0-9]{4})\\|([A-Z0-9]+)";
		Pattern pdbAccessionIdPattern = Pattern.compile(pdbAccessionIdString);
		
		// NEW (2016-12) SETUP: accession_id is at start followed by space if not a pdb
		String nonPDBAccessionIdString = "^(\\S+)\\s";
		Pattern nonPDBAccessionIdPattern = Pattern.compile(nonPDBAccessionIdString);

		Matcher iterationMatcher = iterationPattern.matcher(linesToParse);
		int endOfLastHit = -1;
		
		while (iterationMatcher.find()) {

			String oneIteration = iterationMatcher.group(1);
			endOfLastHit = iterationMatcher.end(1);
			
			Matcher iterationDefMatcher = iterationDefPattern.matcher(oneIteration);
			String rpsIterationAccession = null;

			if (iterationDefMatcher.find()) {
			
				String iterationDef = iterationDefMatcher.group(1);
				String iterationContent = iterationDefMatcher.group(2);
				
				Matcher pdbAccessionIdMatcher = pdbAccessionIdPattern.matcher(iterationDef);
				if (pdbAccessionIdMatcher.find()) {
					rpsIterationAccession = pdbAccessionIdMatcher.group(1) + "_" + pdbAccessionIdMatcher.group(2);
				} else {
					
					Matcher nonPDBAccessionIdMatcher = nonPDBAccessionIdPattern.matcher(iterationDef);
	
				if (nonPDBAccessionIdMatcher.find()) {
						String rpsIterationAccessionCandidate = nonPDBAccessionIdMatcher.group(1);
							if (rpsIterationAccessionCandidate.matches("p..\\|\\|.*")) {
								rpsIterationAccession = rpsIterationAccessionCandidate.substring(5);
							} else {
								rpsIterationAccession = rpsIterationAccessionCandidate;
							}	
					}
				}			
				
				if (rpsIterationAccession == null) {
					continue;
				}
				
				if (rpsIterationAccession.matches(".*\\|.*")) {

				}

				Matcher iterationHitsMatcher = iterationHitsPattern.matcher(iterationContent);
				if (iterationHitsMatcher.find()) {
					
					String iterationHits = iterationHitsMatcher.group(1);
					if (!iterationHits.equals("")) {		
						String hitString = "<Hit>(.*?)</Hit>";
						Pattern hitPattern = Pattern.compile(hitString);

						Matcher hitMatcher = hitPattern.matcher(iterationContent);
						while (hitMatcher.find()) {
							String oneHit = hitMatcher.group(1);
							ArrayList<LinkedHashMap<String, String>> oneHitList = processOneHit(rpsIterationAccession, oneHit);
							if (oneHitList != null && oneHitList.size() > 0) {
								oneFileRPSResults.add(oneHitList);
							}
						}
					} else {
						ArrayList<LinkedHashMap<String, String>> oneHitList = processNoHits(rpsIterationAccession);
						if (oneHitList != null && oneHitList.size() > 0 && (oneHitList.get(0).get("Hit_num") != null)) {
							oneFileRPSResults.add(oneHitList);
						}	
					}	
				}
			}
			
		}

		if(endOfLastHit == -1) {
			return linesToParse;
		}

		return linesToParse.substring(endOfLastHit);
	}

	private LinkedHashMap<String, String> getHitInformation(String rpsQueryAccession, String oneHit){
		if (oneHit == null) {
			return null;
		}
		LinkedHashMap<String, String> oneHitResults = new LinkedHashMap<String, String>();
		oneHitResults.put("ncbi_version_id", String.valueOf(preferredNcbiProviderId));
		oneHitResults.put("accession_id", rpsQueryAccession);
		for (String name : getBLASTpXMLTypeNames()) {
			StringBuilder pattern1Builder = new StringBuilder();
			if (name.startsWith("Hit_")) {
				pattern1Builder = new StringBuilder();
				pattern1Builder.append("<" + name + ">(.*?)</" + name + ">.*?");
			} 
			
			Pattern patternHit = Pattern.compile(pattern1Builder.toString());
			Matcher hitMatcher = patternHit.matcher(oneHit);
			if (hitMatcher.find()) {
				for (int i = 1; i < hitMatcher.groupCount() + 1; i++) {
					String value = (hitMatcher.group(i));
					oneHitResults.put("xml_" + name, value);
				}
			}
		}
		return oneHitResults;
	}
		
	
	private ArrayList<LinkedHashMap<String, String>> processNoHits(String rpsQueryAccession) {
		printWriter.println("Processing NO HITS for rpsQueryAccession = " + rpsQueryAccession);
		ArrayList<LinkedHashMap<String, String>> oneHitAllHSP = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> oneHitResults = new LinkedHashMap<String, String>();
		
		oneHitResults.put("ncbi_version_id", String.valueOf(preferredNcbiProviderId));
		oneHitResults.put("accession_id", rpsQueryAccession);

		for (String name : getBLASTpXMLTypeNames()) {
			StringBuilder pattern1Builder = new StringBuilder();
			StringBuilder pattern2Builder = new StringBuilder();

			if (name.startsWith("Hit_")) {
				pattern1Builder = new StringBuilder();
				pattern1Builder.append("<" + name + ">(.*?)</" + name + ">.*?");
			} else if (name.startsWith("Hsp_")) {
				pattern2Builder = new StringBuilder();
				pattern2Builder.append("<" + name + ">(.*?)</" + name + ">.*?");
			}
			
			if (name.equals("Hit_num")) {
				oneHitResults.put("xml_" + name, "-1");
			} else {
				oneHitResults.put("xml_" + name, null);
			}

		}

		oneHitAllHSP.add(oneHitResults);

		return oneHitAllHSP;
	}



	private ArrayList<LinkedHashMap<String, String>> processOneHit(String rpsQueryAccession, String oneHit) {

		if (oneHit == null) {
			return null;
		}

		ArrayList<LinkedHashMap<String, String>> oneHitAllHSP = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> oneHitInfo = getHitInformation(rpsQueryAccession, oneHit);
		if (oneHitInfo != null) {
			Pattern hspPattern = Pattern.compile("(\\<Hsp\\>.*?\\<\\/Hsp\\>)");
			Matcher hspMatcher = hspPattern.matcher(oneHit);
			while (hspMatcher.find()) {
				for (String name : getBLASTpXMLTypeNames()) {
					StringBuilder pattern2Builder = new StringBuilder();
					if (name.startsWith("Hsp_")) {
						pattern2Builder = new StringBuilder();
						pattern2Builder.append("<" + name + ">(.*?)</" + name + ">.*?");
					}
					Pattern patternHsp = Pattern.compile(pattern2Builder.toString());
					Matcher hspMatcher2 = patternHsp.matcher(hspMatcher.group());
					while (hspMatcher2.find()) {
						for (int i = 1; i < hspMatcher2.groupCount() + 1; i++) {
							String value = (hspMatcher2.group(i));
							oneHitInfo.put("xml_" + name, value);
						}
					}
				}
				LinkedHashMap<String, String> oneHSPInfo = new LinkedHashMap<String, String>();
				oneHSPInfo.putAll(oneHitInfo);
				oneHitAllHSP.add(oneHSPInfo);
			}
		}
		return oneHitAllHSP;
	}


	private void printAnswers(){
		for (ArrayList<LinkedHashMap<String, String>> oneHitAllHSP : oneFileRPSResults) {
			for (HashMap<String, String> oneHSP : oneHitAllHSP) {
				for (String key : oneHSP.keySet()) {
					System.out.println(key + " = " + oneHSP.get(key));
				}
			}
		}
	
	}

	
	private List<String> getBLASTpXMLTypeNames() {
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


