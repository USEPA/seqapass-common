package gov.epa.seqapass.common;

public class LevelThreeStatusRow {

  private int runId;
  private int updateVersion;
  private String accession;
  private String email;
  private String jobName;
  private String templateAccession;
  private String cobalt;
  private long startDate;
  private long endDate;
  private long runDuration;
  private String key;

  public LevelThreeStatusRow() {
  }

  public LevelThreeStatusRow(int runId, int updateVersion, String accession, String email, String jobName,
      String templateAccession, String cobalt, long startDate, long endDate, long runDuration) {
    this.runId = runId;
    this.updateVersion = updateVersion;
    this.accession = accession;
    this.setEmail(email);
    this.jobName = jobName;
    this.templateAccession = templateAccession;
    this.cobalt = cobalt;
    this.startDate = startDate;
    this.endDate = endDate;
    this.runDuration = runDuration;
  }

  @Override
  public String toString() {
    return "LevelThreeStatusRow [runId=" + runId + ", updateVersion=" + updateVersion + ", accession=" + accession
        + ", email=" + email + ", jobName=" + jobName + ", templateAccession=" + templateAccession + "cobalt=" + cobalt
        + ", startDate=" + startDate + ", endDate=" + endDate + ", runDuration=" + runDuration + ", key=" + key + "]";
  }

  public static LevelThreeStatusRow newInstance(LevelThreeStatusRow orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    LevelThreeStatusRow copy = new LevelThreeStatusRow();
    copy.setRunId(orig.getRunId());
    copy.setUpdateVersion(orig.getUpdateVersion());
    copy.setAccession(orig.getAccession());
    copy.setEmail(orig.getEmail());
    copy.setJobName(orig.getJobName());
    copy.setTemplateAccession(orig.getTemplateAccession());
    copy.setCobalt(orig.getCobalt());
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
    result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
    result = prime * result + ((templateAccession == null) ? 0 : templateAccession.hashCode());
    result = prime * result + ((cobalt == null) ? 0 : cobalt.hashCode());
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
    LevelThreeStatusRow other = (LevelThreeStatusRow) obj;
    if (runId != other.runId)
      return false;
    if (updateVersion != other.updateVersion)
      return false;
    if (accession == null) {
      if (other.accession != null)
        return false;
    } else if (!accession.equals(other.accession))
      return false;
    if (jobName == null) {
      if (other.jobName != null)
        return false;
    } else if (!jobName.equals(other.jobName))
      return false;
    if (templateAccession == null) {
      if (other.templateAccession != null)
        return false;
    } else if (!templateAccession.equals(other.templateAccession))
      return false;
    if (cobalt == null) {
      if (other.cobalt != null)
        return false;
    } else if (!cobalt.equals(other.cobalt))
      return false;
    if (startDate != other.startDate)
      return false;
    if (endDate != other.endDate)
      return true;
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

  public String getTemplateAccession() {
    return templateAccession;
  }

  public void setTemplateAccession(String templateAccession) {
    this.templateAccession = templateAccession;
  }

  public String getCobalt() {
    return cobalt;
  }

  public void setCobalt(String cobalt) {
    this.cobalt = cobalt;
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

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
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
