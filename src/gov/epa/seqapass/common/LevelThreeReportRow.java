package gov.epa.seqapass.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LevelThreeReportRow {

  private String accession;
  private int proteinCount;
  private int speciesTaxId;
  private String taxonomyName;
  private String scientificName;
  private String commonName;
  private String proteinName;
  // private List<Residue> residues;
  private long endDate;
  private List<LevelThreeResidueResult> residueResultList;
  private Map<String, String> flatResidues;
  private Map<String, String> primaryFlatResidues;
  private int updateVersion;
  private String susceptible;
  private String jobName;
  private boolean endangered;
  private boolean threatened;
  private boolean model;
  private boolean ecotox;

  public LevelThreeReportRow() {
  }

  public LevelThreeReportRow(String jobName, String accession, int proteinCount, int speciesTaxId, String taxonomyName,
      String scientificName, String commonName, String proteinName, long endDate, int updateVersion,
      List<LevelThreeResidueResult> residueResultList) {
    this.jobName = jobName;
    this.accession = accession;
    this.proteinCount = proteinCount;
    this.speciesTaxId = speciesTaxId;
    this.taxonomyName = taxonomyName;
    this.scientificName = scientificName;
    this.commonName = commonName;
    this.proteinName = proteinName;
    this.endDate = endDate;
    this.updateVersion = updateVersion;
    this.residueResultList = residueResultList;
    this.flatResidues = new LinkedHashMap<String, String>();
    this.primaryFlatResidues = new LinkedHashMap<String, String>();
    this.susceptible = "TBD";
    this.endangered = false;
    this.threatened = false;
    this.model = false;
    this.ecotox = false;
  }

  @Override
  public String toString() {
    return "LevelThreeReportRow [jobName=" + jobName + ", accession=" + accession + ", proteinCount=" + proteinCount
        + ", speciesTaxId=" + speciesTaxId + ", taxonomyName=" + taxonomyName + "scientificName=" + scientificName
        + ", commonName=" + commonName + ", proteinName=" + proteinName + "," + ", endDate=" + endDate
        + ", updateVersion=" + updateVersion + ", residueResultList=" + residueResultList.toString() + ", susceptible="
        + susceptible + "]";
  }

  public static LevelThreeReportRow newInstance(LevelThreeReportRow orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    LevelThreeReportRow copy = new LevelThreeReportRow();
    copy.setJobName(orig.getJobName());
    copy.setAccession(orig.getAccession());
    copy.setProteinCount(orig.getProteinCount());
    copy.setSpeciesTaxId(orig.getSpeciesTaxId());
    copy.setTaxonomyName(orig.getTaxonomyName());
    copy.setScientificName(orig.getScientificName());
    copy.setCommonName(orig.getCommonName());
    copy.setProteinName(orig.getProteinName());
    copy.setEndDate(orig.getEndDate());
    copy.setUpdateVersion(orig.getUpdateVersion());
    List<LevelThreeResidueResult> newResList = new ArrayList<LevelThreeResidueResult>();
    for (LevelThreeResidueResult res : orig.getResidueResultList()) {
      newResList.add(LevelThreeResidueResult.newInstance(res));
    }
    copy.setResidueResultList(newResList);
    Map<String, String> newFlatMap = new LinkedHashMap<String, String>();
    for (Map.Entry<String, String> entry : orig.getFlatResidues().entrySet()) {
      newFlatMap.put(entry.getKey(), entry.getValue());
    }
    copy.setFlatResidues(newFlatMap);
    Map<String, String> newPrimaryFlatMap = new LinkedHashMap<String, String>();
    for (Map.Entry<String, String> entry : orig.getPrimaryFlatResidues().entrySet()) {
      newPrimaryFlatMap.put(entry.getKey(), entry.getValue());
    }
    copy.setPrimaryFlatResidues(newPrimaryFlatMap);
    copy.setSusceptible(orig.getSusceptible());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
    result = prime * result + ((accession == null) ? 0 : accession.hashCode());
    result = prime * result + proteinCount;
    result = prime * result + speciesTaxId;
    result = prime * result + ((taxonomyName == null) ? 0 : taxonomyName.hashCode());
    result = prime * result + ((scientificName == null) ? 0 : scientificName.hashCode());
    result = prime * result + ((commonName == null) ? 0 : commonName.hashCode());
    result = prime * result + ((proteinName == null) ? 0 : proteinName.hashCode());
    result = prime * result + Long.toString(endDate).hashCode();
    result = prime * result + updateVersion;
    result = prime * result + residueResultList.toString().hashCode();
    result = prime * result + susceptible.hashCode();
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
    LevelThreeReportRow other = (LevelThreeReportRow) obj;
    if (jobName == null) {
      if (other.jobName != null)
        return false;
    } else if (!jobName.equals(other.jobName))
      return false;
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
    if (proteinName == null) {
      if (other.proteinName != null)
        return false;
    } else if (!proteinName.equals(other.proteinName))
      return false;
    if (endDate != other.endDate)
      return false;
    if (updateVersion != other.updateVersion)
      return false;
    if (residueResultList == null) {
      if (other.residueResultList != null)
        return false;
    } else if (!residueResultList.equals(other.residueResultList))
      return false;
    if (susceptible == null) {
      if (other.susceptible != null)
        return false;
    } else if (!susceptible.equals(other.susceptible))
      return false;
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

  public String getTaxonomyName() {
    return taxonomyName;
  }

  public void setTaxonomyName(String taxonomyName) {
    this.taxonomyName = taxonomyName;
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

  public long getEndDate() {
    return endDate;
  }

  public void setEndDate(long endDate) {
    this.endDate = endDate;
  }

  public List<LevelThreeResidueResult> getResidueResultList() {
    return residueResultList;
  }

  public void setResidueResultList(List<LevelThreeResidueResult> residueResultList) {
    this.residueResultList = residueResultList;
  }

  public Map<String, String> getFlatResidues() {
    return flatResidues;
  }

  public void setFlatResidues(Map<String, String> flatResidues) {
    this.flatResidues = flatResidues;
  }

  public int getUpdateVersion() {
    return updateVersion;
  }

  public void setUpdateVersion(int updateVersion) {
    this.updateVersion = updateVersion;
  }

  public Map<String, String> getPrimaryFlatResidues() {
    return primaryFlatResidues;
  }

  public void setPrimaryFlatResidues(Map<String, String> primaryFlatResidues) {
    this.primaryFlatResidues = primaryFlatResidues;
  }

  public String getSusceptible() {
    return susceptible;
  }

  public void setSusceptible(String susceptible) {
    this.susceptible = susceptible;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
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

}
