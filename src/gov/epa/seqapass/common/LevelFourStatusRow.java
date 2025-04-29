package gov.epa.seqapass.common;

public class LevelFourStatusRow {

  private int runId;
  private int updateVersion;
  private String accession;
  private String email;
  private String jobName;
  private String template;
  private String status;
  private int fastasCompleted; //FASTAs generated
  private long fastaEnd;
  private long itasserStart;
  private long itasserEnd;
  private int itasserFastas;  //FASTAs currently running or completed I-TASSER
  private long itasserDuration;
  private long tmalignStart;
  private long tmalignEnd;
  private long tmalignDuration;
  private int otherRunId;  // stores L4 run id for TM-Align
  private String otherRunIdsLabel;  //to be used for multiple L4 run id(s) in TM-Align status
  private int queryLevel4RunId;  //level4 run id of the query accession
  

  public LevelFourStatusRow() {
  }

  public LevelFourStatusRow(int runId, int updateVersion, String accession, String email, String jobName,
      String template, String status, int fastasCompleted, long fastaEnd, long itasserStart, long itasserEnd, 
      long tmalignStart, long tmalignEnd) {
    this.runId = runId;
    this.updateVersion = updateVersion;
    this.accession = accession;
    this.email = email;
    this.jobName = jobName;
    this.template = template;
    this.status = status;
    this.fastasCompleted = fastasCompleted;
    this.fastaEnd = fastaEnd;
    this.itasserStart = itasserStart;
    this.itasserEnd = itasserEnd;
    this.itasserDuration = itasserEnd - itasserStart;
    this.tmalignStart = tmalignStart;
    this.tmalignEnd = tmalignEnd;
    this.tmalignDuration = tmalignEnd - tmalignStart;
    this.itasserFastas = 0;
    
  }
  
  public LevelFourStatusRow(int tmalignRunId, int level4RunId, int updateVersion, String queryAccession, 
		  int queryAccLevel4RunId, String email, String jobName, String status, long tmalignStart, 
		  long tmalignEnd, int numJobs) {
	  this.runId = tmalignRunId;
	  this.otherRunId = level4RunId;
	  this.updateVersion = updateVersion;
	  this.accession = queryAccession;
	  this.queryLevel4RunId = queryAccLevel4RunId;
	  this.email = email;
	  this.jobName = jobName;
	  this.status = status;
	  this.tmalignStart = tmalignStart;
	  this.tmalignEnd = tmalignEnd;
	  this.tmalignDuration = tmalignEnd - tmalignStart;
	  this.fastasCompleted = numJobs;  //temporary holder for numJobs
	  
  }
  


  @Override
  public String toString() {
    return "LevelFourStatusRow [runId=" + runId + ", updateVersion=" + updateVersion + ", accession=" + accession
        + ", email=" + email + ", jobName=" + jobName + ", template=" + template + "fastasCompleted=" + fastasCompleted
        + ", fastaEnd=" + fastaEnd + ", itasserFastas=" + itasserFastas + ", itasserStart=" + itasserStart + ", itasserEnd=" + itasserEnd
        + ", itasserDuration=" + itasserDuration + ", tmalignStart=" + tmalignStart + ", tmalignDuration=" + tmalignDuration
        + ", status=" + status + "]";
  }

  public static LevelFourStatusRow newInstance(LevelFourStatusRow orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    LevelFourStatusRow copy = new LevelFourStatusRow();
    copy.setRunId(orig.getRunId());
    copy.setUpdateVersion(orig.getUpdateVersion());
    copy.setAccession(orig.getAccession());
    copy.setEmail(orig.getEmail());
    copy.setJobName(orig.getJobName());
    copy.setTemplate(orig.getTemplate());
    copy.setFastasCompleted(orig.getFastasCompleted());
    copy.setFastaEnd(orig.getFastaEnd());
    copy.setItasserFastas(orig.getItasserFastas());
    copy.setItasserStart(orig.getItasserStart());
    copy.setItasserEnd(orig.getItasserEnd());
    copy.setItasserDuration(orig.getItasserDuration());
    copy.setTmalignStart(orig.getTmalignStart());
    copy.setTmalignEnd(orig.getTmalignEnd());
    copy.setTmalignDuration(orig.getTmalignDuration());
    copy.setStatus(orig.getStatus());
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
    result = prime * result + ((template == null) ? 0 : template.hashCode());
    result = prime * result + fastasCompleted;
    result = prime * result + itasserFastas;
    result = prime * result + Long.toString(fastaEnd).hashCode();
    result = prime * result + Long.toString(itasserStart).hashCode();
    result = prime * result + Long.toString(itasserEnd).hashCode();
    result = prime * result + Long.toString(itasserDuration).hashCode();
    result = prime * result + Long.toString(tmalignStart).hashCode();
    result = prime * result + Long.toString(tmalignEnd).hashCode();
    result = prime * result + Long.toString(tmalignDuration).hashCode();
    result = prime * result + ((status == null) ? 0 : status.hashCode());
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
    LevelFourStatusRow other = (LevelFourStatusRow) obj;
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
    if (template == null) {
      if (other.template != null)
        return false;
    } else if (!template.equals(other.template))
      return false;
    if (fastasCompleted != other.fastasCompleted)
        return false;
    if (fastaEnd != other.fastaEnd)
    	return false;
    if (itasserFastas != other.itasserFastas)
        return false;
    if (itasserFastas != other.itasserFastas)
    	return false;
    if (itasserStart != other.itasserStart)
        return false;
    if (itasserEnd != other.itasserEnd)
        return false;
    if (itasserDuration != other.itasserDuration)
        return false;
    if (tmalignStart != other.tmalignStart)
        return false;
    if (tmalignEnd != other.tmalignEnd)
        return false;
    if (tmalignDuration != other.tmalignDuration)
        return false;
    if (status == null) {
      if (other.status != null)
        return false;
    } else if (!status.equals(other.status))
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

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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

public int getFastasCompleted() {
	return fastasCompleted;
}

public void setFastasCompleted(int fastasCompleted) {
	this.fastasCompleted = fastasCompleted;
}

public long getFastaEnd() {
	return fastaEnd;
}

public void setFastaEnd(long fastaEnd) {
	this.fastaEnd = fastaEnd;
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

public long getTmalignStart() {
	return tmalignStart;
}

public void setTmalignStart(long tmalignStart) {
	this.tmalignStart = tmalignStart;
}

public long getTmalignEnd() {
	return tmalignEnd;
}

public void setTmalignEnd(long tmalignEnd) {
	this.tmalignEnd = tmalignEnd;
}

public long getTmalignDuration() {
	return tmalignDuration;
}

public void setTmalignDuration(long tmalignDuration) {
	this.tmalignDuration = tmalignDuration;
}

public int getItasserFastas() {
	return itasserFastas;
}

public void setItasserFastas(int itasserFastas) {
	this.itasserFastas = itasserFastas;
}

public int getOtherRunId() {
	return otherRunId;
}

public void setOtherRunId(int otherRunId) {
	this.otherRunId = otherRunId;
}

public String getOtherRunIdsLabel() {
	return otherRunIdsLabel;
}

public void setOtherRunIdsLabel(String otherRunIdsLabel) {
	this.otherRunIdsLabel = otherRunIdsLabel;
}

public int getQueryLevel4RunId() {
	return queryLevel4RunId;
}

public void setQueryLevel4RunId(int queryLevel4RunId) {
	this.queryLevel4RunId = queryLevel4RunId;
}

}
