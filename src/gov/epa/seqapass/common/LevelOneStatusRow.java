package gov.epa.seqapass.common;

public class LevelOneStatusRow {

  private int runId;
  private int updateVersion;
  private String accession;
  private String email;
  private double maxBitScore;
  private String blastp;
  private String commonDomains;
  private String ortholog;
  private long startDate;
  private long endDate;
  private long runDuration;
  private String key;

  public LevelOneStatusRow() {
  }

  public LevelOneStatusRow(int runId, int updateVersion, String accession, String email, double maxBitScore,
      String blastp, String commonDomains, String ortholog, long startDate, long endDate, long runDuration) {
    this.runId = runId;
    this.updateVersion = updateVersion;
    this.accession = accession;
    this.email = email;
    this.maxBitScore = maxBitScore;
    this.blastp = blastp;
    this.commonDomains = commonDomains;
    this.ortholog = ortholog;
    this.startDate = startDate;
    this.endDate = endDate;
    this.runDuration = runDuration;
    this.key = runId + "." + accession;
  }

  @Override
  public String toString() {
    return "LevelOneStatusRow [runId=" + runId + ", updateVersion=" + updateVersion + ", accession=" + accession
        + ", email=" + email + ", maxBitScore=" + maxBitScore + ", blastp=" + blastp + "commonDomains=" + commonDomains
        + ", ortholog=" + ortholog + ", startDate=" + startDate + ", endDate=" + endDate + ", runDuration="
        + runDuration + ", key=" + key + "]";
  }

  public static LevelOneStatusRow newInstance(LevelOneStatusRow orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    LevelOneStatusRow copy = new LevelOneStatusRow();
    copy.setRunId(orig.getRunId());
    copy.setUpdateVersion(orig.getUpdateVersion());
    copy.setAccession(orig.getAccession());
    copy.setEmail(orig.getEmail());
    copy.setMaxBitScore(orig.getMaxBitScore());
    copy.setBlastp(orig.getBlastp());
    copy.setCommonDomains(orig.getCommonDomains());
    copy.setOrtholog(orig.getOrtholog());
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
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    result = prime * result + (int) maxBitScore;
    result = prime * result + ((blastp == null) ? 0 : blastp.hashCode());
    result = prime * result + ((commonDomains == null) ? 0 : commonDomains.hashCode());
    result = prime * result + ((ortholog == null) ? 0 : ortholog.hashCode());
    result = prime * result + Long.toString(startDate).hashCode();
    result = prime * result + Long.toString(endDate).hashCode();
    result = prime * result + Long.toString(runDuration).hashCode();
    // result = prime * result + ((runDuration == null) ? 0 : runDuration.hashCode());
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
    LevelOneStatusRow other = (LevelOneStatusRow) obj;
    if (runId != other.runId)
      return false;
    if (updateVersion != other.updateVersion)
      return false;
    if (accession == null) {
      if (other.accession != null)
        return false;
    } else if (!accession.equals(other.accession))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;
    if (maxBitScore != other.maxBitScore)
      return false;
    if (blastp == null) {
      if (other.blastp != null)
        return false;
    } else if (!blastp.equals(other.blastp))
      return false;
    if (commonDomains == null) {
      if (other.commonDomains != null)
        return false;
    } else if (!commonDomains.equals(other.commonDomains))
      return false;
    if (ortholog == null) {
      if (other.ortholog != null)
        return false;
    } else if (!ortholog.equals(other.ortholog))
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

  public String getCommonDomains() {
    return commonDomains;
  }

  public void setCommonDomains(String commonDomains) {
    this.commonDomains = commonDomains;
  }

  public String getOrtholog() {
    return ortholog;
  }

  public void setOrtholog(String ortholog) {
    this.ortholog = ortholog;
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getUpdateVersion() {
    return updateVersion;
  }

  public void setUpdateVersion(int updateVersion) {
    this.updateVersion = updateVersion;
  }

}
