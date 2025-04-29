package gov.epa.seqapass.common;

import java.util.ArrayList;
import java.util.List;

public class LevelFourAccessionRow {
	
	//private boolean include;
		private String priority; //allows for high, low, low(auto-included), low(user-included), etc
		private String status;
		private String autoPriority; // true = high, false = low
		private int dataVersion;
		private String ncbiAccession;
		private int proteinCount;
		private int speciesTaxId;
		private String taxonomyName;
		private String filteredTaxName;
		private String scientificName;
		private String commonName;
		private String proteinName;
		private double blastPBitScore;
		private String ortholog;
		private double cutoff;
		private double percentSimilarity;
		private String susceptible;
		private long endDate;
		private boolean eukaryote;
		private String ecotoxDate;
		private String directory;
		private String fasta;
		private String formattedFasta;
		private double cscore;
		private double tm_score;
		private double tm_score_error;
		private double rmsd;
		private double rmsd_error;
		private double density;
		private double hitLength;
		private double absLength;
		private String lengthCutOff;
		private String quality;
		private String pdb;
		private String pdbSource;
		private String uniprot_acc;
		private List<ProteinDataBankRow> pdbRows;
		private long itasserStart;
		private long itasserEnd;
		private long itasserDuration;
		private int level4RunId;
		private String template;  //strictly for convenience, duplicates property in LevelFourRequestableRow
		private String domainId;  //for L2 I-TASSER only

		
		public LevelFourAccessionRow() {
		}
	//Not used
//	public LevelFourAccessionRow(String priority, String status, String autoPriority, int dataVersion,
//			String ncbiAccession, int proteinCount, int speciesTaxId, String taxonomyName, String filteredTaxName,
//			String scientificName, String commonName, String proteinName, double blastPBitScore, String ortholog,
//			double cutoff, double percentSimilarity, String susceptible, long endDate, boolean eukaryote,
//			String ecotoxDate, String directory, String fasta) {
//
//		this.priority = priority;
//		this.status = status;
//		this.autoPriority = autoPriority;
//		this.dataVersion = dataVersion;
//		this.ncbiAccession = ncbiAccession;
//		this.proteinCount = proteinCount;
//		this.speciesTaxId = speciesTaxId;
//		this.taxonomyName = taxonomyName;
//		this.filteredTaxName = filteredTaxName;
//		this.scientificName = scientificName;
//		this.commonName = commonName;
//		this.proteinName = proteinName;
//		this.blastPBitScore = blastPBitScore;
//		this.ortholog = ortholog;
//		this.cutoff = cutoff;
//		this.percentSimilarity = percentSimilarity;
//		this.susceptible = susceptible;
//		this.endDate = endDate;
//		this.eukaryote = eukaryote;
//		this.directory = directory;
//		this.fasta = fasta;
//		this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n";
//		if (fasta != null) {;
//			this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n" + fasta;
//		}
//	}
	
	//Not used
//	public LevelFourAccessionRow(String status, String autoPriority, int dataVersion,
//			String ncbiAccession, int proteinCount, int speciesTaxId, String taxonomyName, String filteredTaxName,
//			String scientificName, String commonName, String proteinName, double blastPBitScore, String ortholog,
//			double cutoff, double percentSimilarity, String susceptible, long endDate, boolean eukaryote,
//			String ecotoxDate, String directory, String fasta) {
//		
//		this.priority = autoPriority;
//		this.status = status;
//		this.autoPriority = autoPriority;
//		this.dataVersion = dataVersion;
//		this.ncbiAccession = ncbiAccession;
//		this.proteinCount = proteinCount;
//		this.speciesTaxId = speciesTaxId;
//		this.taxonomyName = taxonomyName;
//		this.filteredTaxName = filteredTaxName;
//		this.scientificName = scientificName;
//		this.commonName = commonName;
//		this.proteinName = proteinName;
//		this.blastPBitScore = blastPBitScore;
//		this.ortholog = ortholog;
//		this.cutoff = cutoff;
//		this.percentSimilarity = percentSimilarity;
//		this.susceptible = susceptible;
//		this.endDate = endDate;
//		this.eukaryote = eukaryote;
//		this.directory = directory;
//		this.fasta = fasta;
//		this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n";
//		if (fasta != null) {;
//			this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n" + fasta;
//		}
//	}
	
	public LevelFourAccessionRow(LevelOneReportRow row, String status, 
			String autoPriority, int dataVersion, String directory, String fasta, String uniprot) {
		
		this.priority = autoPriority;
		this.status = status;
		this.autoPriority = autoPriority;
		this.dataVersion = dataVersion;
		this.ncbiAccession = row.getAccession();
		this.proteinCount = row.getProteinCount();
		this.speciesTaxId = row.getSpeciesTaxId();
		this.taxonomyName = row.getDefaultTaxonomyName();
		this.filteredTaxName = row.getTaxonomyName();
		this.scientificName = row.getScientificName();
		this.commonName = row.getCommonName();
		this.proteinName = row.getProteinName();
		this.blastPBitScore = row.getBlastPBitScore();
		this.ortholog = row.getOrtholog();
		this.cutoff = row.getCutoff();
		this.percentSimilarity = row.getPercentSimilarity();
		this.susceptible = row.getSusceptible();
		this.endDate = row.getEndDate();
		this.eukaryote = row.isEukaryote();
		this.directory = directory;
		this.fasta = fasta;
		this.hitLength = row.getHitLength();
		this.absLength=-9999;
		this.lengthCutOff = "TBD";
		this.uniprot_acc = uniprot;
		this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n";
		if (fasta != null) {;
			this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n" + fasta;
		}
		this.quality = "TBD";
	}

	public LevelFourAccessionRow(LevelTwoReportRow row, String status, 
			String autoPriority, int dataVersion, String directory, String uniprot) {
		
		this.priority = autoPriority;
		this.status = status;
		this.autoPriority = autoPriority;
		this.dataVersion = dataVersion;
		this.ncbiAccession = row.getAccession();
		this.proteinCount = row.getProteinCount();
		this.speciesTaxId = row.getSpeciesTaxId();
		this.taxonomyName = row.getDefaultTaxonomyName();
		this.filteredTaxName = row.getTaxonomyName();
		this.scientificName = row.getScientificName();
		this.commonName = row.getCommonName();
		this.proteinName = row.getProteinName();
		this.blastPBitScore = row.getBlastPBitScore();
		this.ortholog = row.getOrtholog();
		this.cutoff = row.getCutoff();
		this.percentSimilarity = row.getPercentSimilarity();
		this.susceptible = row.getSusceptible();
		this.endDate = row.getEndDate();
		this.eukaryote = row.isEukaryote();
		this.directory = directory;
		this.fasta = row.getFasta();
		this.hitLength = row.getHitLength();
		this.absLength=-9999;
		this.lengthCutOff = "TBD";
		this.uniprot_acc = uniprot;
		this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n";
		if (fasta != null) {
			this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n" + fasta;
		}
		this.quality = "TBD";
		this.domainId = row.getDomainId();
	}
	
	public LevelFourAccessionRow(LevelOneReportRow l1Row, LevelFourAccessionRow l4Row) {
		
		this.priority = l4Row.priority;
		this.status = l4Row.status;
		this.autoPriority = l4Row.autoPriority;
		this.dataVersion = l4Row.dataVersion;
		this.ncbiAccession = l1Row.getAccession();
		this.proteinCount = l1Row.getProteinCount();
		this.speciesTaxId = l1Row.getSpeciesTaxId();
		this.taxonomyName = l1Row.getDefaultTaxonomyName();
		this.filteredTaxName = l1Row.getTaxonomyName();
		this.scientificName = l1Row.getScientificName();
		this.commonName = l1Row.getCommonName();
		this.proteinName = l1Row.getProteinName();
		this.blastPBitScore = l1Row.getBlastPBitScore();
		this.ortholog = l1Row.getOrtholog();
		this.cutoff = l1Row.getCutoff();
		this.percentSimilarity = l1Row.getPercentSimilarity();
		this.susceptible = l1Row.getSusceptible();
		this.endDate = l1Row.getEndDate();
		this.eukaryote = l1Row.isEukaryote();
		this.directory = l4Row.directory;
		this.fasta = l4Row.fasta;
		this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n";
		if (fasta != null) {;
			this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n" + fasta;
		}
		this.cscore = l4Row.cscore;
		this.tm_score = l4Row.tm_score;
		this.tm_score_error = l4Row.tm_score_error;
		this.rmsd = l4Row.rmsd;
		this.rmsd_error = l4Row.rmsd_error;
		this.density = l4Row.density;
		this.hitLength = l1Row.getHitLength();
		this.absLength = -9999;
		this.lengthCutOff = "TBD";
		this.quality = "TBD";
		this.pdb = l4Row.getPdb();
		this.pdbSource = l4Row.getPdbSource();
		this.itasserStart = l4Row.getItasserStart();
		this.itasserEnd = l4Row.getItasserEnd();
		this.itasserDuration = l4Row.getItasserDuration();
		this.level4RunId = l4Row.getLevel4RunId();
		this.template = l4Row.getTemplate();
	}
	
public LevelFourAccessionRow(LevelTwoReportRow l2Row, LevelFourAccessionRow l4Row) {
		
		this.priority = l4Row.priority;
		this.status = l4Row.status;
		this.autoPriority = l4Row.autoPriority;
		this.dataVersion = l4Row.dataVersion;
		this.ncbiAccession = l2Row.getAccession();
		this.proteinCount = l2Row.getProteinCount();
		this.speciesTaxId = l2Row.getSpeciesTaxId();
		this.taxonomyName = l2Row.getDefaultTaxonomyName();
		this.filteredTaxName = l2Row.getTaxonomyName();
		this.scientificName = l2Row.getScientificName();
		this.commonName = l2Row.getCommonName();
		this.proteinName = l2Row.getProteinName();
		this.blastPBitScore = l2Row.getBlastPBitScore();
		this.ortholog = l2Row.getOrtholog();
		this.cutoff = l2Row.getCutoff();
		this.percentSimilarity = l2Row.getPercentSimilarity();
		this.susceptible = l2Row.getSusceptible();
		this.endDate = l2Row.getEndDate();
		this.eukaryote = l2Row.isEukaryote();
		this.directory = l4Row.directory;
		this.fasta = l4Row.fasta;
		this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n";
		if (fasta != null) {;
			this.formattedFasta = ">" + proteinName + "[" + taxonomyName + "]\n" + fasta;
		}
		this.cscore = l4Row.cscore;
		this.tm_score = l4Row.tm_score;
		this.tm_score_error = l4Row.tm_score_error;
		this.rmsd = l4Row.rmsd;
		this.rmsd_error = l4Row.rmsd_error;
		this.density = l4Row.density;
		this.hitLength = l2Row.getHitLength();
		this.absLength = -9999;
		this.lengthCutOff = "TBD";
		this.quality = "TBD";
		this.pdb = l4Row.getPdb();
		this.pdbSource = l4Row.getPdbSource();
		this.itasserStart = l4Row.getItasserStart();
		this.itasserEnd = l4Row.getItasserEnd();
		this.itasserDuration = l4Row.getItasserDuration();
		this.level4RunId = l4Row.getLevel4RunId();
		this.template = l4Row.getTemplate();
		this.domainId = l2Row.getDomainId();
	}
	
	//used with level4_data table
	public LevelFourAccessionRow(String status, String priority,
			String autoPriority, String accession, String fasta, 
			double cscore, double tm_score, double tm_score_error,
			double rmsd, double rmsd_error, double density, String pdb,
			long itasserStart, long itasserEnd, int level4RunId) {
		
		this.priority = autoPriority;
		this.status = status;
		this.autoPriority = autoPriority;
		this.ncbiAccession = accession;
		this.fasta = fasta;
		this.cscore = cscore;
		this.tm_score = tm_score;
		this.tm_score_error = tm_score_error;
		this.rmsd = rmsd;
		this.rmsd = rmsd_error;
		this.density = density;
		this.lengthCutOff = "TBD";
		this.quality = "TBD";
		this.pdb = pdb;
		this.itasserStart = itasserStart;
	    this.itasserEnd = itasserEnd;
	    this.itasserDuration = itasserEnd - itasserStart;
	    this.level4RunId = level4RunId;
	    this.pdbSource = "I-TASSER";
	}
	
	public LevelFourAccessionRow(LevelFourResultRow row) {
		this.ncbiAccession = row.getAcc2();
		this.quality = row.getQuality();
		this.proteinName = row.getProteinName();
		this.speciesTaxId = row.getSpeciesTaxId();
		this.taxonomyName = row.getTaxonomyName();
		this.filteredTaxName = row.getFilteredTaxName();
		this.scientificName = row.getScientificName();
		this.commonName = row.getCommonName();
		this.level4RunId = row.getLevel4RunId();
		this.template = row.getTemplate();
	}

	

	public static LevelFourAccessionRow newInstance(LevelFourAccessionRow orig) {
		if (orig == null) {
		      try {
		        throw new Exception("orig cannot be null");
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		    }
		LevelFourAccessionRow copy = new LevelFourAccessionRow();
		
		copy.setPriority(orig.getPriority());
		copy.setStatus(orig.getStatus());
		copy.setAutoPriority(orig.getAutoPriority());
		copy.setDataVersion(orig.getDataVersion());
		copy.setNcbiAccession(orig.getNcbiAccession());
		copy.setProteinCount(orig.getProteinCount());
		copy.setSpeciesTaxId(orig.getSpeciesTaxId());
		copy.setTaxonomyName(orig.getTaxonomyName());
		copy.setFilteredTaxName(orig.getFilteredTaxName());
		copy.setScientificName(orig.getScientificName());
		copy.setCommonName(orig.getCommonName());
		copy.setProteinName(orig.getProteinName());
		copy.setBlastPBitScore(orig.getBlastPBitScore());
		copy.setOrtholog(orig.getOrtholog());
		copy.setCutoff(orig.getCutoff());
		copy.setPercentSimilarity(orig.getPercentSimilarity());
		copy.setSusceptible(orig.getSusceptible());
		copy.setEndDate(orig.getEndDate());
		copy.setEukaryote(orig.isEukaryote());
		copy.setEcotoxDate(orig.getEcotoxDate());
		copy.setDirectory(orig.getDirectory());
		copy.setFasta(orig.getFasta());
		copy.setFormattedFasta(orig.getFormattedFasta());
		copy.setCscore(orig.getCscore());
		copy.setTm_score(orig.getTm_score());
		copy.setTm_score_error(orig.getTm_score_error());
		copy.setRmsd(orig.getRmsd());
		copy.setRmsd_error(orig.getRmsd_error());
		copy.setDensity(orig.getDensity());
		copy.setHitLength(orig.getHitLength());
		copy.setAbsLength(orig.getAbsLength());
		copy.setLengthCutOff(orig.getLengthCutOff());
		copy.setQuality(orig.getQuality());
		copy.setPdb(orig.getPdb());
		copy.setPdbSource(orig.getPdbSource());
		copy.setUniprot_acc(orig.getUniprot_acc());
		if (orig.getPdbRows() == null) {
			copy.setPdbRows(null);
		} else {
			List<ProteinDataBankRow> pdbList = new ArrayList<ProteinDataBankRow>();
			for (ProteinDataBankRow row: orig.getPdbRows()) {
				pdbList.add(ProteinDataBankRow.newInstance(row));
			}
		}
		copy.setItasserStart(orig.getItasserStart());
		copy.setItasserEnd(orig.getItasserEnd());
		copy.setItasserDuration(orig.getItasserDuration());
		copy.setLevel4RunId(orig.getLevel4RunId());
		copy.setTemplate(orig.getTemplate());
		copy.setDomainId(orig.getDomainId());
		
		return copy;
	}
		
	@Override
	public String toString() {
		return "LevelFourAccessionRow [priority=" + priority + ",status=" + status + ", autoPriority=" + autoPriority
				+ ", dataVersion=" + dataVersion + ", speciesTaxId=" + speciesTaxId + ", taxonomyName=" + taxonomyName
				+ ", filteredTaxName=" + filteredTaxName + ", scientificName=" + scientificName + ", commonName="
				+ commonName + ", proteinName=" + proteinName + ", blastPBitScore=" + blastPBitScore + ", ortholog="
				+ ortholog + ", cutoff" + cutoff + ", percentSimilarity=" + percentSimilarity + ", susceptible="
				+ susceptible + ", endDate=" + endDate + ", eukaryote=" + eukaryote + ", directory=" + directory
				+ ", fasta=" + fasta + ", cscore=" + cscore + ", TM-score=" + tm_score + "+-" + tm_score_error 
				+ ", RMSDD=" + rmsd + "+-" + rmsd_error + ", density=" + density + ", hitLength=" + hitLength
				+ ", absLength=" + absLength + ", lengthCutOff=" + lengthCutOff + ", quality=" + quality
				+ ", uniprot_acc=" + uniprot_acc
				+ ", itasserStart=" + itasserStart + ", itasserEnd=" + itasserEnd + ", level4RunId=" + level4RunId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((autoPriority == null) ? 0 : autoPriority.hashCode());
		result = prime * result + dataVersion;
		result = prime * result + ((ncbiAccession == null) ? 0 : ncbiAccession.hashCode());
		result = prime * result + proteinCount;
		result = prime * result + speciesTaxId;
		result = prime * result + ((taxonomyName == null) ? 0 : taxonomyName.hashCode());
		result = prime * result + ((filteredTaxName == null) ? 0 : filteredTaxName.hashCode());
		result = prime * result + ((scientificName == null) ? 0 : scientificName.hashCode());
		result = prime * result + ((commonName == null) ? 0 : commonName.hashCode());
		result = prime * result + ((proteinName == null) ? 0 : proteinName.hashCode());
		result = prime * result + (int) blastPBitScore;
		result = prime * result + ((ortholog == null) ? 0 : ortholog.hashCode());
		result = prime * result + (int) cutoff;
		result = prime * result + (int) percentSimilarity;
		result = prime * result + ((susceptible == null) ? 0 : susceptible.hashCode());
		result = prime * result + Long.toString(endDate).hashCode();
		result = prime * result + (eukaryote ? 1 : 0);
		result = prime * result + ((ecotoxDate == null) ? 0 : ecotoxDate.hashCode());
		result = prime * result + ((directory == null) ? 0 : directory.hashCode());
		result = prime * result + ((fasta == null) ? 0 : fasta.hashCode());
		result = prime * result + (int) cscore;
		result = prime * result + (int) tm_score *100;
		result = prime * result + (int) tm_score_error * 100;
		result = prime * result + (int) rmsd;
		result = prime * result + (int) hitLength;
		result = prime * result + (int) absLength;
		result = prime * result + ((lengthCutOff == null) ? 0 : lengthCutOff.hashCode());
		result = prime * result + ((quality == null) ? 0 : quality.hashCode());
		result = prime * result + Long.toString(itasserStart).hashCode();
		result = prime * result + Long.toString(itasserEnd).hashCode();
		result = prime * result + level4RunId;
		result = prime * result + ((uniprot_acc == null) ? 0 : uniprot_acc.hashCode());
//		result = prime * result + ((pdb == null) ? 0 : pdb.hashCode());
		result = prime * result + ((domainId == null) ? 0 : domainId.hashCode());
		
		return result;
	}

	@Override
	public boolean equals(Object obj){
		if (this == obj)
			return true;
		if (obj == null) {
			// System.out.println("obj is null");
			return false;
		}
		if (getClass() != obj.getClass()) {
			// System.out.println("obj is different class");
			return false;
		}
		
		LevelFourAccessionRow other = (LevelFourAccessionRow) obj;
		if (priority == null) {
			if (other.priority != null) {
				return false;
			}
		} else if (!priority.equals(other.priority)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (autoPriority == null) {
			if (other.autoPriority != null) {
				return false;
			}
		} else if (!autoPriority.equals(other.autoPriority)) {
			return false;
		}
		if (dataVersion != other.dataVersion) {
			return false;
		}
		if (ncbiAccession == null) {
			if (other.ncbiAccession != null) {
				return false;
			}
		} else if (!ncbiAccession.equals(other.ncbiAccession)) {
			return false;
		}
		if (proteinCount != other.proteinCount) {
			return false;
		}
		if (speciesTaxId != other.speciesTaxId) {
			return false;
		}
		if (taxonomyName == null) {
			if (other.taxonomyName != null) {
				return false;
			}
		} else if (!taxonomyName.equals(other.taxonomyName)) {
			return false;
		}
		if (filteredTaxName == null) {
			if (other.filteredTaxName != null) {
				return false;
			}
		} else if (!filteredTaxName.equals(other.filteredTaxName)) {
			return false;
		}
		if (scientificName == null) {
			if (other.scientificName != null) {
				return false;
			}
		} else if (!scientificName.equals(other.scientificName)) {
			return false;
		}
		if (commonName == null) {
			if (other.commonName != null) {
				return false;
			}
		} else if (!commonName.equals(other.commonName)) {
			return false;
		}
		if (proteinName == null) {
			if (other.proteinName != null) {
				return false;
			}
		} else if (!proteinName.equals(other.proteinName)) {
			return false;
		}
		if (blastPBitScore != other.blastPBitScore) {
			return false;
		}
		if (ortholog == null) {
			if (other.ortholog != null) {
				return false;
			}
		} else if (!ortholog.equals(other.ortholog)) {
			return false;
		}
		if (cutoff != other.cutoff) {
			return false;
		}
		if (percentSimilarity != other.percentSimilarity) {
			return false;
		}
		if (susceptible == null) {
			if (other.susceptible != null) {
				return false;
			}
		} else if (!susceptible.equals(other.susceptible)) {
			return false;
		}
		if (endDate != other.endDate) {
			return false;
		}
		if (eukaryote != other.isEukaryote()) {
			return false;
		}
		if (ecotoxDate == null) {
			if (other.ecotoxDate != null) {
				return false;
			}
		} else if (!ecotoxDate.equals(ecotoxDate)) {
			return false;
		}
		if (directory == null) {
			if (other.directory != null) {
				return false;
			}
		} else if (!directory.equals(other.directory)) {
			return false;
		}
		if (fasta == null) {
			if (other.fasta != null) {
				return false;
			}
		} else if (!fasta.equals(other.fasta)) {
			return false;
		}
		if (cscore != other.cscore) {
			return false;
		}
		if (tm_score != other.tm_score) {
			return false;
		}

		if (tm_score_error != other.tm_score_error) {
			return false;
		}

		if (rmsd != other.rmsd) {
			return false;
		}

		if (rmsd_error != other.rmsd_error) {
			return false;
		}
		if (hitLength != other.hitLength) {
			return false;
		}
		if (absLength != other.absLength) {
			return false;
		}
		if (lengthCutOff == null) {
			if (other.lengthCutOff != null) {
				return false;
			}
		} else if (!lengthCutOff.equals(other.lengthCutOff)) {
			return false;
		}
		if (quality == null) {
			if (other.quality != null) {
				return false;
			}
		} else if (!quality.equals(other.quality)) {
			return false;
		}
		if (pdb == null) {
			if (other.pdb != null) {
				return false;
			}
		} else if (!pdb.equals(other.pdb)) {
			return false;
		}
		if (level4RunId != other.level4RunId) {
			return false;
		}
//		if (itasserStart != other.itasserStart)
//	        return false;
//	    if (itasserEnd != other.itasserEnd)
//	        return false;
//	    if (itasserDuration != other.itasserDuration)
//	        return false;
		if (domainId == null) {
			if (other.domainId != null) {
				return false;
			}
		} else if (!domainId.equals(other.domainId)) {
			return false;
		}

		return true;
	}
	
	
	public String getTmScoreStr() {
		return tm_score + "+-" + tm_score_error;
	}
	
	public String getRmsdStr() {
		return rmsd + "+-" + rmsd_error;
	}
	
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDataVersion() {
		return dataVersion;
	}

	public void setDataVersion(int dataVersion) {
		this.dataVersion = dataVersion;
	}

	public int getSpeciesTaxId() {
		return speciesTaxId;
	}

	public void setSpeciesTaxId(int speciesTaxId) {
		this.speciesTaxId = speciesTaxId;
	}

	public String getTaxonomyName() {
		return taxonomyName;
	}

	public void setTaxonomyName(String taxonomyName) {
		this.taxonomyName = taxonomyName;
	}

	public String getFilteredTaxName() {
		return filteredTaxName;
	}

	public void setFilteredTaxName(String filteredTaxName) {
		this.filteredTaxName = filteredTaxName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	public String getProteinName() {
		return proteinName;
	}

	public void setProteinName(String proteinName) {
		this.proteinName = proteinName;
	}

	public double getBlastPBitScore() {
		return blastPBitScore;
	}

	public void setBlastPBitScore(double blastPBitScore) {
		this.blastPBitScore = blastPBitScore;
	}

	public String getOrtholog() {
		return ortholog;
	}

	public void setOrtholog(String ortholog) {
		this.ortholog = ortholog;
	}

	public double getCutoff() {
		return cutoff;
	}

	public void setCutoff(double cutoff) {
		this.cutoff = cutoff;
	}

	public double getPercentSimilarity() {
		return percentSimilarity;
	}

	public void setPercentSimilarity(double percentSimilarity) {
		this.percentSimilarity = percentSimilarity;
	}

	public String getSusceptible() {
		return susceptible;
	}

	public void setSusceptible(String susceptible) {
		this.susceptible = susceptible;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}

	public boolean isEukaryote() {
		return eukaryote;
	}

	public void setEukaryote(boolean eukaryote) {
		this.eukaryote = eukaryote;
	}

	public String getEcotoxDate() {
		return ecotoxDate;
	}

	public void setEcotoxDate(String ecotoxDate) {
		this.ecotoxDate = ecotoxDate;
	}

	public String getDirectory() {
		return directory;
	}

	public void setDirectory(String directory) {
		this.directory = directory;
	}

	public String getFasta() {
		return fasta;
	}

	public void setFasta(String fasta) {
		this.fasta = fasta;
	}

	public String getFormattedFasta() {
		return formattedFasta;
	}

	public void setFormattedFasta(String formattedFasta) {
		this.formattedFasta = formattedFasta;
	}

	public String getNcbiAccession() {
		return ncbiAccession;
	}

	public void setNcbiAccession(String ncbiAccession) {
		this.ncbiAccession = ncbiAccession;
	}

	public int getProteinCount() {
		return proteinCount;
	}

	public void setProteinCount(int proteinCount) {
		this.proteinCount = proteinCount;
	}

//	public boolean isInclude() {
//		return include;
//	}
//
//	public void setInclude(boolean include) {
//		this.include = include;
//	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAutoPriority() {
		return autoPriority;
	}

	public void setAutoPriority(String autoPriority) {
		this.autoPriority = autoPriority;
	}

	public double getCscore() {
		return cscore;
	}

	public void setCscore(double cscore) {
		this.cscore = cscore;
	}

	public double getTm_score() {
		return tm_score;
	}

	public void setTm_score(double tm_score) {
		this.tm_score = tm_score;
	}

	public double getTm_score_error() {
		return tm_score_error;
	}

	public void setTm_score_error(double tm_score_error) {
		this.tm_score_error = tm_score_error;
	}

	public double getRmsd() {
		return rmsd;
	}

	public void setRmsd(double rmsd) {
		this.rmsd = rmsd;
	}

	public double getRmsd_error() {
		return rmsd_error;
	}

	public void setRmsd_error(double rmsd_error) {
		this.rmsd_error = rmsd_error;
	}

	public double getDensity() {
		return density;
	}

	public void setDensity(double density) {
		this.density = density;
	}

	public double getHitLength() {
		return hitLength;
	}

	public void setHitLength(double hitLength) {
		this.hitLength = hitLength;
	}

	public double getAbsLength() {
		return absLength;
	}

	public void setAbsLength(double absLength) {
		this.absLength = absLength;
	}

	public String getLengthCutOff() {
		return lengthCutOff;
	}

	public void setLengthCutOff(String lengthCutOff) {
		this.lengthCutOff = lengthCutOff;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getPdb() {
		return pdb;
	}

	public void setPdb(String pdb) {
		this.pdb = pdb;
	}

	public List<ProteinDataBankRow> getPdbRows() {
		return pdbRows;
	}

	public void setPdbRows(List<ProteinDataBankRow> pdbRows) {
		this.pdbRows = pdbRows;
	}

	public long getItasserStart() {
		return itasserStart;
	}

	public void setItasserStart(long itasserStart) {
		this.itasserStart = itasserStart;
	}

	public long getItasserEnd() {
		return itasserEnd;
	}

	public void setItasserEnd(long itasserEnd) {
		this.itasserEnd = itasserEnd;
	}

	public long getItasserDuration() {
		return itasserDuration;
	}

	public void setItasserDuration(long itasserDuration) {
		this.itasserDuration = itasserDuration;
	}

	public int getLevel4RunId() {
		return level4RunId;
	}

	public void setLevel4RunId(int level4RunId) {
		this.level4RunId = level4RunId;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getUniprot_acc() {
		return uniprot_acc;
	}

	public void setUniprot_acc(String uniprot_acc) {
		this.uniprot_acc = uniprot_acc;
	}

	public String getPdbSource() {
		return pdbSource;
	}

	public void setPdbSource(String pdbSource) {
		this.pdbSource = pdbSource;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}




}
