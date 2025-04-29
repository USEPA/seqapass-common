package gov.epa.seqapass.common;

public class LevelFourResultRow {

	public LevelFourResultRow() {
	}
	
	public LevelFourResultRow(String queryAcc, String acc2, int length1, int length2, 
			double tmscore1, double tmscore2, int level4RunId, String template, String pdbSource,
			String protName, int taxId, String taxGrp, String sciName, String commonName,
			String pdb) {
		this.acc1 = queryAcc;
		this.acc2 = acc2;
		this.length1 = length1;
		this.length2 = length2;
		this.val1 = tmscore1;
		this.val2 = tmscore2;
		this.avgVal = (val1 + val2)/2.0;
		this.level4RunId = level4RunId;  //of acc2
		this.template = template;  //of acc2
		this.pdbSource = pdbSource; //of acc2
		this.proteinName = protName;
		this.speciesTaxId = taxId;
		this.taxonomyName = taxGrp;
		this.scientificName = sciName;
		this.commonName = commonName;
		this.pdb = pdb;
		this.domainId = "TODO";
	}

	public LevelFourResultRow(LevelFourResultRow l4res, LevelFourAccessionRow l4data) {
		if (l4res.pdbSource == null) {
			this.pdbSource = l4data.getPdbSource();
		} else {
			this.pdbSource = l4res.pdbSource;
		}
		this.acc1 = l4res.acc1;
		this.acc2 = l4res.acc2;
		this.length1 = l4res.length1;
		this.length2 = l4res.length2;
		this.val1 = l4res.val1;
		this.val2 = l4res.val2;
		this.avgVal = l4res.avgVal;
		this.quality = l4data.getQuality();
		this.proteinName = l4data.getProteinName();
		this.speciesTaxId = l4data.getSpeciesTaxId();
		this.taxonomyName = l4data.getTaxonomyName();
		this.filteredTaxName = l4data.getFilteredTaxName();
		this.scientificName = l4data.getScientificName();
		this.commonName = l4data.getCommonName();
		this.susceptible = l4data.getSusceptible();
		this.absLength = l4data.getAbsLength();
		this.lengthCutOff = l4data.getLengthCutOff();
		this.cscore = l4data.getCscore();
		this.tm_score = l4data.getTm_score();
		this.rmsd = l4data.getRmsd();
		this.density = l4data.getDensity();
		this.template = l4data.getTemplate();
		this.level4RunId = l4data.getLevel4RunId();
		this.pdb = l4data.getPdb();
		this.domainId = l4data.getDomainId();
				
	}
	
	//This constructor is used for creating query row 
	//for first row in TM-Align Report
	public LevelFourResultRow(LevelFourAccessionRow row, String pdbSource) {
		this.pdbSource = pdbSource;
		this.acc1 = null;
		this.acc2 = row.getNcbiAccession();
		this.length1 = row.getFasta().length();
		this.length2 = length1;
		this.val1 = 1.0;
		this.val2 = 1.0;
		this.avgVal = 1.0;
		this.quality = "High";
		this.proteinName = row.getProteinName();
		this.speciesTaxId = row.getSpeciesTaxId();
		this.taxonomyName = row.getTaxonomyName();
		this.filteredTaxName = row.getFilteredTaxName();
		this.scientificName = row.getScientificName();
		this.commonName = row.getCommonName();
		this.susceptible = row.getSusceptible();
		this.absLength = 0.0;
		this.lengthCutOff = "Okay";
		this.cscore = -9999;
		this.tm_score = -9999;
		this.rmsd = -9999;
		this.density = -9999;
		this.template = "-";
		this.level4RunId = row.getLevel4RunId();
		this.absLength = row.getAbsLength();
		this.domainId = row.getDomainId();
				
	}

	//private boolean include;
	private String pdbSource; //Either I-TASSER or AlphaFold
	private String pdb; //PDB for AlphaFold only.  Null for I-TASSER
	private String acc1;
	private String acc2;
	private String quality;
	private String proteinName;
	private int speciesTaxId;
	private String taxonomyName;
	private String filteredTaxName;
	private String scientificName;
	private String commonName;
	private double avgVal;
	private String susceptible;
	private double absLength;
	private String lengthCutOff;
	private double cscore;
	private double tm_score;
	private double rmsd;
	private double density;
	private int length1;
	private int length2;
	private double val1;
	private double val2;
	private int level4RunId;  //of acc2
	private String template;  //of acc2
	private String domainId;  //for L2 I-TASSER only


	public static LevelFourResultRow newInstance(LevelFourResultRow orig) {
		if (orig == null) {
		      try {
		        throw new Exception("orig cannot be null");
		      } catch (Exception e) {
		        e.printStackTrace();
		      }
		    }
		LevelFourResultRow copy = new LevelFourResultRow();
		copy.setPdbSource(orig.getPdbSource());
		copy.setAcc1(orig.getAcc1());
		copy.setAcc2(orig.getAcc2());
		copy.setQuality(orig.getQuality());
		copy.setProteinName(orig.getProteinName());
		copy.setSpeciesTaxId(orig.getSpeciesTaxId());
		copy.setTaxonomyName(orig.getTaxonomyName());
		copy.setFilteredTaxName(orig.getFilteredTaxName());
		copy.setScientificName(orig.getScientificName());
		copy.setCommonName(orig.getCommonName());
		copy.setAvgVal(orig.getAvgVal());
		copy.setSusceptible(orig.getSusceptible());
		copy.setAbsLength(orig.getAbsLength());
		copy.setLengthCutOff(orig.getLengthCutOff());
		copy.setCscore(orig.getCscore());
		copy.setTm_score(orig.getTm_score());
		copy.setRmsd(orig.getRmsd());
		copy.setDensity(orig.getDensity());
		copy.setLength1(orig.getLength1());
		copy.setLength2(orig.getLength2());
		copy.setVal1(orig.getVal1());
		copy.setVal2(orig.getVal2());
		copy.setLevel4RunId(orig.getLevel4RunId());
		copy.setTemplate(orig.getTemplate());
		copy.setDomainId(orig.getDomainId());
		
		return copy;
	}
		
	@Override
	public String toString() {
		return "LevelFourResultRow [pdbSource=" + pdbSource + ", acc1=" + acc1 + ", acc2=" + acc2 + ", quality=" + quality +
				", proteinName=" + proteinName + ", speciesTaxId=" + speciesTaxId + ", taxonomyName=" + taxonomyName +
				", filteredTaxName=" + filteredTaxName + ", scientificName=" + scientificName + ", commonName=" + commonName +
				", avgVal=" + avgVal + ", susceptible=" + susceptible + ", absLength=" + absLength +
				", lengthCutOff=" + lengthCutOff + ", cscore=" + cscore + ", tm_score=" + tm_score + 
				", rmsd=" + rmsd + ", density=" + density + ", length1=" + length1 + ", length2=" + length2 +
				", val1=" + val1 + ", val2=" + val2;
				
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pdbSource == null) ? 0 : pdbSource.hashCode());
		result = prime * result + ((acc1 == null) ? 0 : acc1.hashCode());
		result = prime * result + ((acc2 == null) ? 0 : acc2.hashCode());
		result = prime * result + ((quality == null) ? 0 : quality.hashCode());
		result = prime * result + ((proteinName == null) ? 0 : proteinName.hashCode());
		result = prime * result + speciesTaxId;
		result = prime * result + ((taxonomyName == null) ? 0 : taxonomyName.hashCode());
		result = prime * result + ((filteredTaxName == null) ? 0 : filteredTaxName.hashCode());
		result = prime * result + ((scientificName == null) ? 0 : scientificName.hashCode());
		result = prime * result + ((commonName == null) ? 0 : commonName.hashCode());
		result = prime * result + (int) avgVal;
		result = prime * result + ((susceptible == null) ? 0 : susceptible.hashCode());
		result = prime * result + (int) absLength;
		result = prime * result + ((lengthCutOff == null) ? 0 : lengthCutOff.hashCode());
		result = prime * result + (int) cscore;
		result = prime * result + (int) tm_score;
		result = prime * result + (int) rmsd;
		result = prime * result + (int) density;
		result = prime * result + length1;
		result = prime * result + length2;
		result = prime * result + (int) val1;
		result = prime * result + (int) val2;
		result = prime * result + level4RunId;
		result = prime * result + ((template == null) ? 0 : template.hashCode());
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
		
		LevelFourResultRow other = (LevelFourResultRow) obj;
		if (pdbSource == null) {
			if (other.pdbSource != null) {
				return false;
			}
		} else if (!pdbSource.equals(other.pdbSource)) {
			return false;
		}
		if (acc1 == null) {
			if (other.acc1 != null) {
				return false;
			}
		} else if (!acc1.equals(other.acc1)) {
			return false;
		}
		if (acc2 == null) {
			if (other.acc2 != null) {
				return false;
			}
		} else if (!acc2.equals(other.acc2)) {
			return false;
		}
		if (quality == null) {
			if (other.quality != null) {
				return false;
			}
		} else if (!quality.equals(other.quality)) {
			return false;
		}
		if (proteinName == null) {
			if (other.proteinName != null) {
				return false;
			}
		} else if (!proteinName.equals(other.proteinName)) {
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
		if (avgVal != other.avgVal) {
			return false;
		}
		if (susceptible == null) {
			if (other.susceptible != null) {
				return false;
			}
		} else if (!susceptible.equals(other.susceptible)) {
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
		if (cscore != other.cscore) {
			return false;
		}
		if (tm_score != other.tm_score) {
			return false;
		}
		if (rmsd != other.rmsd) {
			return false;
		}
		if (density != other.density) {
			return false;
		}
		if (length1 != other.length1) {
			return false;
		}
		if (length2 != other.length2) {
			return false;
		}
		if (val1 != other.val1) {
			return false;
		}
		if (val2 != other.val2) {
			return false;
		}
		if (level4RunId != other.level4RunId) {
			return false;
		}
		if (template == null) {
			if (other.template != null) {
				return false;
			}
		} else if (!template.equals(other.template)) {
			return false;
		}
		if (domainId == null) {
			if (other.domainId != null) {
				return false;
			}
		} else if (!domainId.equals(other.domainId)) {
			return false;
		}
		
		return true;
	}
	
	//Getters and Setters

	public String getPdbSource() {
		return pdbSource;
	}

	public void setPdbSource(String pdbSource) {
		this.pdbSource = pdbSource;
	}

	public String getAcc1() {
		return acc1;
	}

	public void setAcc1(String acc1) {
		this.acc1 = acc1;
	}

	public String getAcc2() {
		return acc2;
	}

	public void setAcc2(String acc2) {
		this.acc2 = acc2;
	}

	public String getQuality() {
		return quality;
	}

	public void setQuality(String quality) {
		this.quality = quality;
	}

	public String getProteinName() {
		return proteinName;
	}

	public void setProteinName(String proteinName) {
		this.proteinName = proteinName;
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

	public double getAvgVal() {
		return avgVal;
	}

	public void setAvgVal(double avgVal) {
		this.avgVal = avgVal;
	}

	public String getSusceptible() {
		return susceptible;
	}

	public void setSusceptible(String susceptible) {
		this.susceptible = susceptible;
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

	public double getRmsd() {
		return rmsd;
	}

	public void setRmsd(double rmsd) {
		this.rmsd = rmsd;
	}

	public double getDensity() {
		return density;
	}

	public void setDensity(double density) {
		this.density = density;
	}


	public double getVal1() {
		return val1;
	}

	public void setVal1(double val1) {
		this.val1 = val1;
	}

	public double getVal2() {
		return val2;
	}

	public void setVal2(double val2) {
		this.val2 = val2;
	}

	public int getLength1() {
		return length1;
	}

	public void setLength1(int length1) {
		this.length1 = length1;
	}

	public int getLength2() {
		return length2;
	}

	public void setLength2(int length2) {
		this.length2 = length2;
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

	public String getPdb() {
		return pdb;
	}

	public void setPdb(String pdb) {
		this.pdb = pdb;
	}

	public String getDomainId() {
		return domainId;
	}

	public void setDomainId(String domainId) {
		this.domainId = domainId;
	}
	
	
	




}
