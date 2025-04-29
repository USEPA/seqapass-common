package gov.epa.seqapass.common;

public class LevelTwoReportRow {

  private String accession;
  private int proteinCount;
  private int speciesTaxId;
  private String taxonomyName;
  private String defaultTaxonomyName;
  private String taxonomyLevel;
  private int taxonomyTaxid;
  private String scientificName;
  private String commonName;
  private String commonNameClass;
  private String proteinName;
  private String pssmId;
  private String domainId;
  private String domainName;
  private int hitLength;
  private int identity;
  private int positive;
  private double evalue;
  private double blastPBitScore;
  private String ortholog;
  private double percentSimilarity;
  private double cutoff;
  private String susceptible;
  private long endDate;
  private int updateVersion;
  private int isDup;
  private boolean eukaryote;
  @SuppressWarnings("unused")
  private boolean partialProtein; // This supports highlighting the queryProtein cell
  @SuppressWarnings("unused")
  private boolean percSimOver; // This supports highlighting the percent similarity cell
  private boolean endangered;
  private boolean threatened;
  private boolean model;
  private boolean ecotox;
  private String fasta;

  public LevelTwoReportRow() {
  }

  public LevelTwoReportRow(String accession, int proteinCount, int speciesTaxId, String taxonomyName,
      String taxonomyLevel, int taxonomyTaxid, String scientificName, String commonName, String commonNameClass,
      String proteinName, String pssmId, String domainId, String domainName, int hitLength, int identity, int positive,
      double evalue, double blastPBitScore, String ortholog, double percentSimilarity, double cutoff,
      String susceptible, Long endDate, int updateVersion, int isDup, boolean eukaryote) {
    this.accession = accession;
    this.proteinCount = proteinCount;
    this.speciesTaxId = speciesTaxId;
    this.taxonomyName = taxonomyName;
    this.defaultTaxonomyName = taxonomyName;
    this.taxonomyLevel = taxonomyLevel;
    this.taxonomyTaxid = taxonomyTaxid;
    this.scientificName = scientificName;
    this.commonName = commonName;
    this.commonNameClass = commonNameClass;
    this.proteinName = proteinName;
    this.pssmId = pssmId;
    this.domainId = domainId;
    this.domainName = domainName;
    this.hitLength = hitLength;
    this.identity = identity;
    this.positive = positive;
    this.evalue = evalue;
    this.blastPBitScore = blastPBitScore;
    this.ortholog = ortholog;
    this.percentSimilarity = percentSimilarity;
    this.cutoff = cutoff;
    this.susceptible = susceptible;
    if (endDate != null) {
      this.endDate = endDate;
    } else {
      this.endDate = new Long(0);
    }
    this.updateVersion = updateVersion;
    this.setIsDup(isDup);
    this.setEukaryote(eukaryote);
    this.endangered = false;
    this.threatened = false;
    this.model = false;
    this.ecotox = false;
  }

  public LevelTwoReportRow(String accession, int proteinCount, int speciesTaxId, String taxonomyName,
      String taxonomyLevel, int taxonomyTaxid, String scientificName, String commonName, String commonNameClass,
      String proteinName, String pssmId, String domainId, String domainName, int hitLength, int identity, int positive,
      double evalue, double blastPBitScore, String ortholog, double percentSimilarity, double cutoff,
      String susceptible, Long endDate, int updateVersion, int isDup, boolean eukaryote, boolean endangered,
      boolean threatened, boolean model, boolean ecotox, String fasta) {
    this.accession = accession;
    this.proteinCount = proteinCount;
    this.speciesTaxId = speciesTaxId;
    this.taxonomyName = taxonomyName;
    this.defaultTaxonomyName = taxonomyName;
    this.taxonomyLevel = taxonomyLevel;
    this.taxonomyTaxid = taxonomyTaxid;
    this.scientificName = scientificName;
    this.commonName = commonName;
    this.commonNameClass = commonNameClass;
    this.proteinName = proteinName;
    this.pssmId = pssmId;
    this.domainId = domainId;
    this.domainName = domainName;
    this.hitLength = hitLength;
    this.identity = identity;
    this.positive = positive;
    this.evalue = evalue;
    this.blastPBitScore = blastPBitScore;
    this.ortholog = ortholog;
    this.percentSimilarity = percentSimilarity;
    this.cutoff = cutoff;
    this.susceptible = susceptible;
    if (endDate != null) {
      this.endDate = endDate;
    } else {
      this.endDate = new Long(0);
    }
    this.updateVersion = updateVersion;
    this.setIsDup(isDup);
    this.setEukaryote(eukaryote);
    this.endangered = endangered;
    this.threatened = threatened;
    this.model = model;
    this.ecotox = ecotox;
    this.fasta = fasta;
  }

  @Override
  public String toString() {
    return "LevelTwoReportRow [accession=" + accession + ", proteinCount=" + proteinCount + ", speciesTaxId="
        + speciesTaxId + ", taxonomyName=" + taxonomyName + ", defaultTaxonomyName=" + defaultTaxonomyName
        + ", taxonomyLevel=" + taxonomyLevel + ", taxonomyTaxid=" + taxonomyTaxid + "scientificName=" + scientificName
        + ", commonName=" + commonName + ", commonNameClass=" + commonNameClass + ", proteinName=" + proteinName + ","
        + ", pssmId=" + pssmId + ", domainId=" + domainId + ", domainName=" + domainName + ", hitLength=" + hitLength
        + ", identity=" + identity + ", positive=" + positive + ", evalue=" + evalue + ", blastPBitScore="
        + blastPBitScore + ", ortholog=" + ortholog + ", percentSimilarity=" + percentSimilarity + ", cutoff=" + cutoff
        + ", susceptible=" + susceptible + ", endDate=" + endDate + ", updateVersion=" + updateVersion + "]";
  }

  public static LevelTwoReportRow newInstance(LevelTwoReportRow orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    LevelTwoReportRow copy = new LevelTwoReportRow();
    copy.setAccession(orig.getAccession());
    copy.setProteinCount(orig.getProteinCount());
    copy.setSpeciesTaxId(orig.getSpeciesTaxId());
    copy.setTaxonomyName(orig.getTaxonomyName());
    copy.setDefaultTaxonomyName(orig.getDefaultTaxonomyName());
    copy.setTaxonomyLevel(orig.getTaxonomyLevel());
    copy.setTaxonomyTaxid(orig.getTaxonomyTaxid());
    copy.setScientificName(orig.getScientificName());
    copy.setCommonName(orig.getCommonName());
    copy.setCommonNameClass(orig.getCommonNameClass());
    copy.setProteinName(orig.getProteinName());
    copy.setPssmId(orig.getPssmId());
    copy.setDomainId(orig.getDomainId());
    copy.setDomainName(orig.getDomainName());
    copy.setHitLength(orig.getHitLength());
    copy.setIdentity(orig.getIdentity());
    copy.setPositive(orig.getPositive());
    copy.setEvalue(orig.getEvalue());
    copy.setBlastPBitScore(orig.getBlastPBitScore());
    copy.setOrtholog(orig.getOrtholog());
    copy.setPercentSimilarity(orig.getPercentSimilarity());
    copy.setCutoff(orig.getCutoff());
    copy.setSusceptible(orig.getSusceptible());
    copy.setEndDate(orig.getEndDate());
    copy.setPartialProtein(orig.isPartialProtein());
    copy.setPercSimOver(orig.isPercSimOver());
    copy.setUpdateVersion(orig.getUpdateVersion());
    copy.setIsDup(orig.getIsDup());
    copy.setEukaryote(orig.isEukaryote());
    copy.setEndangered(orig.isEndangered());
    copy.setThreatened(orig.isThreatened());
    copy.setModel(orig.isModel());
    copy.setEcotox(orig.isEcotox());
    copy.setFASTA(orig.getFasta());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((accession == null) ? 0 : accession.hashCode());
    result = prime * result + proteinCount;
    result = prime * result + speciesTaxId;
    result = prime * result + ((taxonomyName == null) ? 0 : taxonomyName.hashCode());
    result = prime * result + ((defaultTaxonomyName == null) ? 0 : defaultTaxonomyName.hashCode());
    result = prime * result + ((taxonomyLevel == null) ? 0 : taxonomyLevel.hashCode());
    result = prime * result + taxonomyTaxid;
    result = prime * result + ((scientificName == null) ? 0 : scientificName.hashCode());
    result = prime * result + ((commonName == null) ? 0 : commonName.hashCode());
    result = prime * result + ((commonNameClass == null) ? 0 : commonNameClass.hashCode());
    result = prime * result + ((proteinName == null) ? 0 : proteinName.hashCode());
    result = prime * result + ((pssmId == null) ? 0 : pssmId.hashCode());
    result = prime * result + ((domainId == null) ? 0 : domainId.hashCode());
    result = prime * result + ((domainName == null) ? 0 : domainName.hashCode());
    result = prime * result + hitLength;
    result = prime * result + identity;
    result = prime * result + positive;
    result = prime * result + (int) evalue;
    result = prime * result + (int) blastPBitScore;
    result = prime * result + ((ortholog == null) ? 0 : ortholog.hashCode());
    result = prime * result + (int) percentSimilarity;
    result = prime * result + (int) cutoff;
    result = prime * result + ((susceptible == null) ? 0 : susceptible.hashCode());
    result = prime * result + Long.toString(endDate).hashCode();
    result = prime * result + updateVersion;
    result = prime * result + isDup;
    result = prime * result + (endangered ? 1 : 0);
    result = prime * result + (threatened ? 1 : 0);
    result = prime * result + (model ? 1 : 0);
    result = prime * result + (ecotox ? 1 : 0);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    LevelTwoReportRow other = (LevelTwoReportRow) obj;
    if (accession == null) {
      if (other.accession != null)
        return false;
    } else if (!accession.equals(other.accession))
      return false;
    if (proteinCount != other.proteinCount)
      return false;
    if (speciesTaxId != other.speciesTaxId)
      return false;
    if (taxonomyName == null) {
      if (other.taxonomyName != null)
        return false;
    } else if (!taxonomyName.equals(other.taxonomyName))
      return false;
    if (taxonomyLevel == null) {
      if (other.taxonomyLevel != null)
        return false;
    } else if (!taxonomyLevel.equals(other.taxonomyLevel))
      return false;
    if (taxonomyTaxid != other.taxonomyTaxid)
      return false;
    if (scientificName == null) {
      if (other.scientificName != null)
        return false;
    } else if (!scientificName.equals(other.scientificName))
      return false;
    if (commonName == null) {
      if (other.commonName != null)
        return false;
    } else if (!commonName.equals(other.commonName))
      return false;
    if (commonNameClass == null) {
      if (other.commonNameClass != null)
        return false;
    } else if (!commonNameClass.equals(other.commonNameClass))
      return false;
    if (proteinName == null) {
      if (other.proteinName != null)
        return false;
    } else if (!proteinName.equals(other.proteinName))
      return false;
    if (pssmId == null) {
      if (other.pssmId != null)
        return false;
    } else if (!pssmId.equals(other.pssmId))
      return false;
    if (domainId == null) {
      if (other.domainId != null)
        return false;
    } else if (!domainId.equals(other.domainId))
      return false;
    if (domainName == null) {
      if (other.domainName != null)
        return false;
    } else if (!domainName.equals(other.domainName))
      return false;
    if (hitLength != other.hitLength)
      return false;
    if (identity != other.identity)
      return false;
    if (positive != other.positive)
      return false;
    if (evalue != other.evalue)
      return false;
    if (blastPBitScore != other.blastPBitScore)
      return false;
    if (ortholog == null) {
      if (other.ortholog != null)
        return false;
    } else if (!ortholog.equals(other.ortholog))
      return false;
    if (percentSimilarity != other.percentSimilarity)
      return false;
    if (cutoff != other.cutoff)
      return false;
    if (susceptible == null) {
      if (other.susceptible != null)
        return false;
    } else if (!susceptible.equals(other.susceptible))
      return false;
    if (endDate != other.endDate)
      return false;
    if (updateVersion != other.updateVersion)
      return false;
    if (eukaryote != other.isEukaryote())
      return false;
    return true;
  }

  public boolean fullEquals(Object obj) {
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
    LevelTwoReportRow other = (LevelTwoReportRow) obj;
    if (accession == null) {
      if (other.accession != null) {
        // System.out.println("accession is null");
        return false;
      }
    } else if (!accession.equals(other.accession)) {
      // System.out.println("accession differs");
      return false;
    }
    if (proteinCount != other.proteinCount) {
      // System.out.println("proteinCount differs");
      return false;
    }
    if (speciesTaxId != other.speciesTaxId) {
      // System.out.println("speciesTaxId differs");
      return false;
    }
    if (taxonomyName == null) {
      if (other.taxonomyName != null) {
        // System.out.println("taxonomyName is null");
        return false;
      }
    } else if (!taxonomyName.equals(other.taxonomyName)) {
      // System.out.println("taxonomyName differs");
      return false;
    }
    if (defaultTaxonomyName == null) {
      if (other.defaultTaxonomyName != null) {
        // System.out.println("defaultTaxonomyName is null");
        return false;
      }
    } else if (!defaultTaxonomyName.equals(other.defaultTaxonomyName)) {
      // System.out.println("defaultTaxonomyName differs");
      return false;
    }
    if (taxonomyLevel == null) {
      if (other.taxonomyLevel != null) {
        // System.out.println("taxonomyLevel is null");
        return false;
      }
    } else if (!taxonomyLevel.toLowerCase().equals(other.taxonomyLevel.toLowerCase())) {
      // System.out.println("taxonomyLevel differs");
      return false;
    }
    if (taxonomyTaxid != other.taxonomyTaxid) {
      // System.out.println("taxonomyTaxid differs");
      return false;
    }
    if (scientificName == null) {
      if (other.scientificName != null) {
        // System.out.println("scientificName is null");
        return false;
      }
    } else if (!scientificName.equals(other.scientificName)) {
      // System.out.println("scientificName differs");
      return false;
    }
    if (commonName == null) {
      if (other.commonName != null) {
        // System.out.println("commonName is null");
        return false;
      }
    } else if (!commonName.equals(other.commonName)) {
      // System.out.println("commonName differs");
      return false;
    }
    if (commonNameClass == null) {
      if (other.commonNameClass != null) {
        // System.out.println("commonNameClass is null");
        return false;
      }
    } else if (!commonNameClass.equals(other.commonNameClass)) {
      // System.out.println("commonNameClass differs");
      return false;
    }
    if (proteinName == null) {
      if (other.proteinName != null) {
        // System.out.println("proteinName is null");
        return false;
      }
    } else if (!proteinName.equals(other.proteinName)) {
      // System.out.println("proteinName differs");
      return false;
    }
    if (pssmId == null) {
      if (other.pssmId != null) {
        // System.out.println("pssmId is null");
        return false;
      }
    } else if (!pssmId.equals(other.pssmId)) {
      // System.out.println("pssmId differs");
      return false;
    }
    if (domainId == null) {
      if (other.domainId != null) {
        // System.out.println("domainId is null");
        return false;
      }
    } else if (!domainId.equals(other.domainId)) {
      // System.out.println("domainId differs");
      return false;
    }
    if (domainName == null) {
      if (other.domainName != null) {
        // System.out.println("domainName is null");
        return false;
      }
    } else if (!domainName.equals(other.domainName)) {
      // System.out.println("domainName differs");
      return false;
    }
    if (hitLength != other.hitLength) {
      // System.out.println("hitLength differs");
      return false;
    }
    if (identity != other.identity) {
      // System.out.println("identity differs");
      return false;
    }
    if (positive != other.positive) {
      // System.out.println("positives differs");
      return false;
    }
    if (evalue != other.evalue) {
      // System.out.println("evalue differs");
      return false;
    }
    if (blastPBitScore != other.blastPBitScore) {
      // System.out.println("blastPBitScore differs");
      return false;
    }
    if (ortholog == null) {
      if (other.ortholog != null) {
        // System.out.println("ortholog is null");
        return false;
      }
    } else if (!ortholog.equals(other.ortholog)) {
      // System.out.println("ortholog differs");
      return false;
    }
    if (percentSimilarity != other.percentSimilarity) {
      // System.out.println("percentSimilarity differs");
      return false;
    }
    if (cutoff != other.cutoff) {
      // System.out.println("cutoff differs");
      return false;
    }
    if (susceptible == null) {
      if (other.susceptible != null) {
        // System.out.println("susceptible is null");
        return false;
      }
    } else if (!susceptible.equals(other.susceptible)) {
      // System.out.println("susceptible differs");
      return false;
    }
    if (endDate != other.endDate) {
      // System.out.println("endDate differs");
      return false;
    }
    if (updateVersion != other.updateVersion) {
      // System.out.println("updateVersion differs");
      return false;
    }
    if (isDup != other.isDup) {
      // System.out.println("isDup differs");
      return false;
    }
    if (eukaryote != other.isEukaryote()) {
      // System.out.println("eukaryote differs");
      return false;
    }
    if (endangered != other.isEndangered()) {
      // System.out.println("endangered differs");
      return false;
    }
    if (threatened != other.isThreatened()) {
      // System.out.println("threatened differs");
      return false;
    }
    if (model != other.isModel()) {
      // System.out.println("model differs");
      return false;
    }
    if (ecotox != other.isEcotox()) {
      // System.out.println("ecotox differs");
      return false;
    }
    return true;
  }

  public String getAccession() {
    return accession;
  }

  public void setAccession(String accession) {
    this.accession = accession;
  }

  public int getProteinCount() {
    return proteinCount;
  }

  public void setProteinCount(int proteinCount) {
    this.proteinCount = proteinCount;
  }

  public int getSpeciesTaxId() {
    return speciesTaxId;
  }

  public void setSpeciesTaxId(int speciesTaxId) {
    this.speciesTaxId = speciesTaxId;
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

  public String getCommonNameClass() {
    return commonNameClass;
  }

  public void setCommonNameClass(String commonNameClass) {
    this.commonNameClass = commonNameClass;
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

  public double getPercentSimilarity() {
    return percentSimilarity;
  }

  public void setPercentSimilarity(double percentSimilarity) {
    this.percentSimilarity = percentSimilarity;
  }

  public double getCutoff() {
    return cutoff;
  }

  public void setCutoff(double cutoff) {
    this.cutoff = cutoff;
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

  public String getDomainName() {
    return domainName;
  }

  public void setDomainName(String domainName) {
    this.domainName = domainName;
  }

  public String getDomainId() {
    return domainId;
  }

  public void setDomainId(String domainId) {
    this.domainId = domainId;
  }

  public boolean isPartialProtein() {
    if (proteinName.toLowerCase().contains("partial")) {
      return true;
    } else {
      return false;
    }
  }

  public void setPartialProtein(boolean partialProtein) {
    this.partialProtein = partialProtein;
  }

  public boolean isPercSimOver() {
    if (percentSimilarity > 1.0) {
      return true;
    } else {
      return false;
    }
  }

  public void setPercSimOver(boolean percSimOver) {
    this.percSimOver = percSimOver;
  }

  public String getTaxonomyName() {
    return taxonomyName;
  }

  public void setTaxonomyName(String taxonomyName) {
    this.taxonomyName = taxonomyName;
  }

  public String getTaxonomyLevel() {
    return taxonomyLevel;
  }

  public void setTaxonomyLevel(String taxonomyLevel) {
    this.taxonomyLevel = taxonomyLevel;
  }

  public int getTaxonomyTaxid() {
    return taxonomyTaxid;
  }

  public void setTaxonomyTaxid(int taxonomyTaxid) {
    this.taxonomyTaxid = taxonomyTaxid;
  }

  public String getPssmId() {
    return pssmId;
  }

  public void setPssmId(String pssmId) {
    this.pssmId = pssmId;
  }

  public int getHitLength() {
    return hitLength;
  }

  public void setHitLength(int hitLength) {
    this.hitLength = hitLength;
  }

  public int getIdentity() {
    return identity;
  }

  public void setIdentity(int identity) {
    this.identity = identity;
  }

  public int getPositive() {
    return positive;
  }

  public void setPositive(int positive) {
    this.positive = positive;
  }

  public double getEvalue() {
    return evalue;
  }

  public void setEvalue(double evalue) {
    this.evalue = evalue;
  }

  public int getUpdateVersion() {
    return updateVersion;
  }

  public void setUpdateVersion(int updateVersion) {
    this.updateVersion = updateVersion;
  }

  public int getIsDup() {
    return isDup;
  }

  public void setIsDup(int isDup) {
    this.isDup = isDup;
  }

  public String getDefaultTaxonomyName() {
    return defaultTaxonomyName;
  }

  public void setDefaultTaxonomyName(String defaultTaxonomyName) {
    this.defaultTaxonomyName = defaultTaxonomyName;
  }

  public boolean isEukaryote() {
    return eukaryote;
  }

  public void setEukaryote(boolean eukaryote) {
    this.eukaryote = eukaryote;
  }

  public boolean isEndangered() {
    return endangered;
  }

  public void setEndangered(boolean endangered) {
    this.endangered = endangered;
  }

  public boolean isThreatened() {
    return threatened;
  }

  public void setThreatened(boolean threatened) {
    this.threatened = threatened;
  }

  public boolean isModel() {
    return model;
  }

  public void setModel(boolean model) {
    this.model = model;
  }

  public boolean isEcotox() {
    return ecotox;
  }

  public void setEcotox(boolean ecotox) {
    this.ecotox = ecotox;
  }

public String getFasta() {
	return fasta;
}

public void setFASTA(String fasta) {
	this.fasta = fasta;
}

}
