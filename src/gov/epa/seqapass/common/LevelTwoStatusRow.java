package gov.epa.seqapass.common;

public class LevelTwoStatusRow {

  private int runId;
  private int updateVersion;
  private String accession;
  private String domainAccession;
  private String email;
  private String domainType;
  private double maxBitScore;
  private String blastp;
  private long startDate;
  private long endDate;
  private long runDuration;
  private String key;

  public LevelTwoStatusRow() {
  }

  public LevelTwoStatusRow(int runId, int updateVersion, String accession, String domainAccession, String email,
      String domainType, double maxBitScore, String blastp, long startDate, long endDate, long runDuration) {
    this.runId = runId;
    this.updateVersion = updateVersion;
    this.accession = accession;
    this.domainAccession = domainAccession;
    this.email = email;
    this.domainType = domainType;
    this.maxBitScore = maxBitScore;
    this.blastp = blastp;
    this.startDate = startDate;
    this.endDate = endDate;
    this.runDuration = runDuration;
  }

  @Override
  public String toString() {
    return "LevelTwoStatusRow [runId=" + runId + ", updateVersion=" + updateVersion + ", accession=" + accession
        + ", domainAccession=" + domainAccession + ", email=" + email + ", domainType=" + domainType + ", maxBitScore="
        + maxBitScore + ", blastp=" + blastp + ", startDate=" + startDate + ", endDate=" + endDate + ", runDuration="
        + runDuration + ", key=" + key + "]";
  }

  public static LevelTwoStatusRow newInstance(LevelTwoStatusRow orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    LevelTwoStatusRow copy = new LevelTwoStatusRow();
    copy.setRunId(orig.getRunId());
    copy.setUpdateVersion(orig.getUpdateVersion());
    copy.setAccession(orig.getAccession());
    copy.setDomainAccession(orig.getDomainAccession());
    copy.setEmail(orig.getEmail());
    copy.setDomainType(orig.getDomainType());
    copy.setMaxBitScore(orig.getMaxBitScore());
    copy.setBlastp(orig.getBlastp());
    copy.setStartDate(orig.getStartDate());
    copy.setEndDate(orig.getEndDate());
    copy.setRunDuration(orig.getRunDuration());
    copy.setKey(orig.getKey());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + runId;
    result = prime * result + updateVersion;
    result = prime * result + ((accession == null) ? 0 : accession.hashCode());
    result = prime * result + ((domainAccession == null) ? 0 : domainAccession.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + ((domainType == null) ? 0 : domainType.hashCode());
    result = prime * result + (int) maxBitScore;
    result = prime * result + ((blastp == null) ? 0 : blastp.hashCode());
    result = prime * result + Long.toString(startDate).hashCode();
    result = prime * result + Long.toString(endDate).hashCode();
    result = prime * result + Long.toString(runDuration).hashCode();
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
    LevelTwoStatusRow other = (LevelTwoStatusRow) obj;
    if (runId != other.runId)
      return false;
    if (updateVersion != other.updateVersion)
      return false;
    if (accession == null) {
      if (other.accession != null)
        return false;
    } else if (!accession.equals(other.accession))
      return false;
    if (domainAccession == null) {
      if (other.domainAccession != null)
        return false;
    } else if (!domainAccession.equals(other.domainAccession))
      return false;
    if (domainType == null) {
      if (other.domainType != null)
        return false;
    } else if (!domainType.equals(other.domainType))
      return false;
    if (maxBitScore != other.maxBitScore)
      return false;
    if (blastp == null) {
      if (other.blastp != null)
        return false;
    } else if (!blastp.equals(other.blastp))
      return false;
    if (startDate != other.startDate)
      return false;
    if (endDate != other.endDate)
      return false;
    if (runDuration != other.runDuration)
      return false;
    if (key == null) {
      if (other.key != null)
        return false;
    } else if (!key.equals(other.key))
      return false;
    return true;
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

  public String getDomainType() {
    return domainType;
  }

  public void setDomainType(String domainType) {
    this.domainType = domainType;
  }

  public double getMaxBitScore() {
    return maxBitScore;
  }

  public void setMaxBitScore(double maxBitScore) {
    this.maxBitScore = maxBitScore;
  }

  public String getBlastp() {
    return blastp;
  }

  public void setBlastp(String blastp) {
    this.blastp = blastp;
  }

  public long getStartDate() {
    return startDate;
  }

  public void setStartDate(long startDate) {
    this.startDate = startDate;
  }

  public long getEndDate() {
    return endDate;
  }

  public void setEndDate(long endDate) {
    this.endDate = endDate;
  }

  public long getRunDuration() {
    return runDuration;
  }

  public void setRunDuration(long runDuration) {
    this.runDuration = runDuration;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDomainAccession() {
    return domainAccession;
  }

  public void setDomainAccession(String domainAccession) {
    this.domainAccession = domainAccession;
  }

  public int getUpdateVersion() {
    return updateVersion;
  }

  public void setUpdateVersion(int updateVersion) {
    this.updateVersion = updateVersion;
  }

}
