package gov.epa.seqapass.common;

import java.util.HashMap;
import java.util.Map;

public class ReportRow {

  public ReportRow() {
  }

  public ReportRow(int runId, int accessionRunId, String accession, int orthologCnt, String queryProtein, int taxID,
      String querySpeciesName, String queryCommonName, String commonNameClass, String taxonomy, String taxonomyType,
      long endDate, ReportInfo reportInfo) {
    this.runId = runId;
    this.accessionRunId = accessionRunId;
    this.accession = accession;
    this.orthologCnt = orthologCnt;
    this.queryProtein = queryProtein;
    this.taxID = taxID;
    this.querySpeciesName = querySpeciesName;
    this.queryCommonName = queryCommonName;
    this.commonNameClass = commonNameClass;
    this.taxonomy = taxonomy;
    this.taxonomyType = taxonomyType;
    this.endDate = endDate;
    this.reportInfo = reportInfo;
    this.lev1ChkBox = false;
    this.lev2ChkBox = false;
    this.lev3ChkBox = false;
    this.key = runId + "." + accession;
  }

  private int runId;
  private int accessionRunId;
  private String accession;
  private String queryProtein;
  private int taxID;
  private String querySpeciesName;
  private String queryCommonName;
  private String commonNameClass;
  private String taxonomy;
  private String taxonomyType;
  private int orthologCnt;
  private long endDate;
  @SuppressWarnings("unused")
  private boolean partialProtein; // This is used for controlling highlighting of queryProtein cell in datatable

  private boolean lev1ChkBox;
  private boolean lev2ChkBox;
  private boolean lev3ChkBox;

  private String key;
  private ReportInfo reportInfo;

  @Override
  public String toString() {
    return "ReportRow [RunId=" + runId + ", accessionRunId=" + accessionRunId + ", accession=" + accession
        + ", orthologCnt=" + orthologCnt + ", queryProtein=" + queryProtein + ", taxID=" + taxID + ", querySpeciesName="
        + querySpeciesName + ", queryCommonName=" + queryCommonName + ", taxonomy=" + taxonomy + ", taxonomyType="
        + taxonomyType + ", endDate=" + endDate + ", key=" + key + ", reportInfo=" + reportInfo.toString() + "]";
  }

  public static ReportRow newInstance(ReportRow orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    ReportRow copy = new ReportRow();
    copy.setRunId(orig.getRunId());
    copy.setAccessionRunId(orig.getAccessionRunId());
    copy.setAccession(orig.getAccession());
    copy.setOrthologCnt(orig.getOrthologCnt());
    copy.setQueryProtein(orig.getQueryProtein());
    copy.setTaxID(orig.getTaxID());
    copy.setQuerySpeciesName(orig.getQuerySpeciesName());
    copy.setQueryCommonName(orig.getQueryCommonName());
    copy.setCommonNameClass(orig.getCommonNameClass());
    copy.setTaxonomy(orig.getTaxonomy());
    copy.setTaxonomyType(orig.getTaxonomyType());
    copy.setEndDate(orig.getEndDate());
    copy.setPartialProtein(orig.isPartialProtein());
    copy.setLev1ChkBox(orig.isLev1ChkBox());
    copy.setLev2ChkBox(orig.isLev2ChkBox());
    copy.setLev3ChkBox(orig.isLev3ChkBox());
    copy.setReportInfo(orig.getReportInfo());
    copy.setKey(orig.getKey());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + runId;
    result = prime * result + accessionRunId;
    result = prime * result + ((accession == null) ? 0 : accession.hashCode());
    result = prime * result + orthologCnt;
    result = prime * result + ((queryProtein == null) ? 0 : queryProtein.hashCode());
    result = prime * result + taxID;
    result = prime * result + ((querySpeciesName == null) ? 0 : querySpeciesName.hashCode());
    result = prime * result + ((queryCommonName == null) ? 0 : queryCommonName.hashCode());
    result = prime * result + ((taxonomy == null) ? 0 : taxonomy.hashCode());
    result = prime * result + ((taxonomyType == null) ? 0 : taxonomy.hashCode());
    result = prime * result + Long.toString(endDate).hashCode();
    result = prime * result + ((reportInfo == null) ? 0 : reportInfo.hashCode());
    result = prime * result + ((key == null) ? 0 : key.hashCode());
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
    ReportRow other = (ReportRow) obj;
    if (runId != other.runId)
      return false;
    if (accessionRunId != other.accessionRunId)
      return false;
    if (accession == null) {
      if (other.accession != null)
        return false;
    } else if (!accession.equals(other.accession))
      return false;
    if (orthologCnt != other.orthologCnt)
      return false;
    if (queryProtein == null) {
      if (other.queryProtein != null)
        return false;
    } else if (!queryProtein.equals(other.queryProtein))
      return false;
    if (taxID != other.taxID)
      return false;
    if (querySpeciesName == null) {
      if (other.querySpeciesName != null)
        return false;
    } else if (!querySpeciesName.equals(other.querySpeciesName))
      return false;
    if (queryCommonName == null) {
      if (other.queryCommonName != null)
        return false;
    } else if (!queryCommonName.equals(other.queryCommonName))
      return false;
    if (taxonomy == null) {
      if (other.taxonomy != null)
        return false;
    } else if (!taxonomy.equals(other.taxonomy))
      return false;
    if (taxonomyType == null) {
      if (other.taxonomyType != null)
        return false;
    } else if (!taxonomyType.equals(other.taxonomyType))
      return false;
    if (endDate != other.endDate)
      return false;
    if (key == null) {
      if (other.key != null)
        return false;
    } else if (!key.equals(other.key))
      return false;
    if (reportInfo == null) {
      if (other.reportInfo != null)
        return false;
    } else if (!reportInfo.equals(other.reportInfo))
      return false;
    return true;
  }

  public boolean isThisCommonNameTypePreferrred(String proposedNewName) {
    return isFirstCommonNameTypePreferrred(proposedNewName, this.commonNameClass);
  }

  public boolean isFirstCommonNameTypePreferrred(String firstNameType, String secondNameType) {
    Map<String, Integer> order = new HashMap<String, Integer>();
    order.put("genbank common name", 0);
    order.put("common name", 1);
    order.put("includes", 2);
    order.put("blast name", 3);
    order.put("equivalent name", 4);
    order.put("genbank synonym", 5);
    order.put("synonym", 6);
    // order.put("genbank acronym", 7);
    // order.put("acronym", 8);
    // order.put("anamorph", 9);
    // order.put("genbank anamorph", 10);
    // order.put("in-part", 11);
    // order.put("scientific name", 12);
    // order.put("misnomer", 13);
    // order.put("misspelling", 14);
    // order.put("teleomorph", 16);
    // order.put("type material", 17);
    // order.put("authority", 18);
    if (order.get(firstNameType) == null) {
      return false;
    }
    if (order.get(secondNameType) == null) {
      return true;
    }
    if (order.get(firstNameType) < order.get(secondNameType)) {
      return true;
    }
    return false;
  }

  public boolean isPartialProtein() {
    if (queryProtein.toLowerCase().contains("partial")) {
      return true;
    } else {
      return false;
    }
  }

  public void setPartialProtein(boolean partialProtein) {
    this.partialProtein = partialProtein;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public int getAccessionRunId() {
    return accessionRunId;
  }

  public void setAccessionRunId(int accessionRunId) {
    this.accessionRunId = accessionRunId;
  }

  public int getRunId() {
    return runId;
  }

  public void setRunId(int runId) {
    this.runId = runId;
  }

  public String getAccession() {
    return accession;
  }

  public void setAccession(String accession) {
    this.accession = accession;
  }

  public String getQueryProtein() {
    return queryProtein;
  }

  public void setQueryProtein(String queryProtein) {
    this.queryProtein = queryProtein;
  }

  public int getTaxID() {
    return taxID;
  }

  public void setTaxID(int taxID) {
    this.taxID = taxID;
  }

  public String getQuerySpeciesName() {
    return querySpeciesName;
  }

  public void setQuerySpeciesName(String querySpeciesName) {
    this.querySpeciesName = querySpeciesName;
  }

  public String getQueryCommonName() {
    return queryCommonName;
  }

  public void setQueryCommonName(String queryCommonName) {
    this.queryCommonName = queryCommonName;
  }

  public String getCommonNameClass() {
    return commonNameClass;
  }

  public void setCommonNameClass(String commonNameClass) {
    this.commonNameClass = commonNameClass;
  }

  public String getTaxonomy() {
    return taxonomy;
  }

  public void setTaxonomy(String taxonomy) {
    this.taxonomy = taxonomy;
  }

  public String getTaxonomyType() {
    return taxonomyType;
  }

  public void setTaxonomyType(String taxonomyType) {
    this.taxonomyType = taxonomyType;
  }

  public long getEndDate() {
    return endDate;
  }

  public void setEndDate(long endDate) {
    this.endDate = endDate;
  }

  public ReportInfo getReportInfo() {
    return reportInfo;
  }

  public void setReportInfo(ReportInfo reportInfo) {
    this.reportInfo = reportInfo;
  }

  public boolean isLev1ChkBox() {
    return lev1ChkBox;
  }

  public void setLev1ChkBox(boolean lev1ChkBox) {
    this.lev1ChkBox = lev1ChkBox;
  }

  public boolean isLev2ChkBox() {
    return lev2ChkBox;
  }

  public void setLev2ChkBox(boolean lev2ChkBox) {
    this.lev2ChkBox = lev2ChkBox;
  }

  public boolean isLev3ChkBox() {
    return lev3ChkBox;
  }

  public void setLev3ChkBox(boolean lev3ChkBox) {
    this.lev3ChkBox = lev3ChkBox;
  }

  public int getOrthologCnt() {
    return orthologCnt;
  }

  public void setOrthologCnt(int orthologCnt) {
    this.orthologCnt = orthologCnt;
  }

}
