package gov.epa.seqapass.common;

import java.io.Serializable;

public class ReportInfo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 4661236791458148763L;
  private Long ncbiDate;
  private Long uniprotDate;
  private String blastVersion;
  private Long cddDate;
  private String cobaltVersion;
  private Long cobaltDate;
  private String itasserVersion;
  private String tmalignVersion;
  private Long installDate;
  private String javaVersion;
  private String primefacesVersion;
  private String tomcatVersion;
  private String mysqlVersion;
  private String rVersion;
  private int updateVersion;
  private String seqapassVersion;
  private String notes;

  public ReportInfo() {
  }

  public ReportInfo(Long ncbiDate, Long uniprotDate, String blastVersion, Long cddDate, String cobaltVersion, Long cobaltDate, String itasserVersion,
      String tmalignVersion, Long installDate, String javaVersion, String primefacesVersion, String tomcatVersion, String mysqlVersion,
      String rVersion, int updateVersion, String seqapassVersion, String notes) {
    this.ncbiDate = ncbiDate;
    this.uniprotDate = uniprotDate;
    this.blastVersion = blastVersion;
    this.cddDate = cddDate;
    this.cobaltVersion = cobaltVersion;
    this.cobaltDate = cobaltDate;
    this.itasserVersion = itasserVersion;
    this.tmalignVersion = tmalignVersion;
    this.installDate = installDate;
    this.javaVersion = javaVersion;
    this.primefacesVersion = primefacesVersion;
    this.tomcatVersion = tomcatVersion;
    this.mysqlVersion = mysqlVersion;
    this.rVersion = rVersion;
    this.updateVersion = updateVersion;
    this.seqapassVersion = seqapassVersion;
    this.notes = notes;
  }

  @Override
  public String toString() {
    return "ReportInfo [ncbiDate=" + ncbiDate.toString() + ", uniprotDate=" + uniprotDate.toString() + ", blastVersion=" + blastVersion + ", cddDate="
        + cddDate.toString() + ", cobaltVersion=" + cobaltVersion + ", cobaltDate=" + cobaltDate 
        + ", itasserVersion=" + itasserVersion + ", tmalignVersion=" + tmalignVersion + ", installDate="
        + installDate + ", javaVersion=" + javaVersion + ", primefacesVersion=" + primefacesVersion + ", tomcatVersion="
        + tomcatVersion + ", mysqlVersion=" + mysqlVersion + ", rVersion=" + rVersion + ", updateVersion="
        + updateVersion + ", seqapassVersion=" + seqapassVersion + ", notes=" + notes + "]";
  }

  public static ReportInfo newInstance(ReportInfo orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    ReportInfo copy = new ReportInfo();
    copy.setNcbiDate(orig.getNcbiDate());
    copy.setUniprotDate(orig.getUniprotDate());
    copy.setBlastVersion(orig.getBlastVersion());
    copy.setCddDate(orig.getCddDate());
    copy.setCobaltVersion(orig.getCobaltVersion());
    copy.setCobaltDate(orig.getCobaltDate());
    copy.setItasserVersion(orig.getItasserVersion());
    copy.setTmalignVersion(orig.getTmalignVersion());
    copy.setInstallDate(orig.getInstallDate());
    copy.setJavaVersion(orig.getJavaVersion());
    copy.setPrimefacesVersion(orig.getPrimefacesVersion());
    copy.setTomcatVersion(orig.getTomcatVersion());
    copy.setMysqlVersion(orig.getMysqlVersion());
    copy.setrVersion(orig.getrVersion());
    copy.setUpdateVersion(orig.getUpdateVersion());
    copy.setSeqapassVersion(orig.getSeqapassVersion());
    copy.setNotes(orig.getNotes());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ncbiDate.hashCode();
    result = prime * result + uniprotDate.hashCode();
    result = prime * result + blastVersion.hashCode();
    result = prime * result + cddDate.hashCode();
    result = prime * result + cobaltVersion.hashCode();
    result = prime * result + cobaltDate.hashCode();
    result = prime * result + itasserVersion.hashCode();
    result = prime * result + tmalignVersion.hashCode();
    result = prime * result + installDate.hashCode();
    result = prime * result + javaVersion.hashCode();
    result = prime * result + primefacesVersion.hashCode();
    result = prime * result + tomcatVersion.hashCode();
    result = prime * result + mysqlVersion.hashCode();
    result = prime * result + rVersion.hashCode();
    result = prime * result + updateVersion;
    result = prime * result + seqapassVersion.hashCode();
    result = prime * result + notes.hashCode();
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
    ReportInfo other = (ReportInfo) obj;
    if (ncbiDate != other.ncbiDate)
      return false;
    if (uniprotDate != other.uniprotDate)
        return false;
    if (blastVersion == null) {
      if (other.blastVersion != null)
        return false;
    } else if (!blastVersion.equals(other.blastVersion))
      return false;
    if (cddDate != other.cddDate)
      return false;
    if (cobaltVersion == null) {
      if (other.cobaltVersion != null)
        return false;
    } else if (!cobaltVersion.equals(other.cobaltVersion))
      return false;
    if (cobaltDate != other.cobaltDate)
      return false;
    if (itasserVersion == null) {
        if (other.itasserVersion != null)
          return false;
      } else if (!itasserVersion.equals(other.itasserVersion))
        return false;
    if (tmalignVersion == null) {
        if (other.tmalignVersion != null)
          return false;
      } else if (!tmalignVersion.equals(other.tmalignVersion))
        return false;
    if (installDate != other.installDate)
      return false;
    if (javaVersion == null) {
      if (other.javaVersion != null)
        return false;
    } else if (!javaVersion.equals(other.javaVersion))
      return false;
    if (primefacesVersion == null) {
      if (other.primefacesVersion != null)
        return false;
    } else if (!primefacesVersion.equals(other.primefacesVersion))
      return false;
    if (tomcatVersion == null) {
      if (other.tomcatVersion != null)
        return false;
    } else if (!tomcatVersion.equals(other.tomcatVersion))
      return false;
    if (mysqlVersion == null) {
      if (other.mysqlVersion != null)
        return false;
    } else if (!mysqlVersion.equals(other.mysqlVersion))
      return false;
    if (rVersion == null) {
      if (other.rVersion != null)
        return false;
    } else if (!rVersion.equals(other.rVersion))
      return false;
    if (updateVersion != other.updateVersion)
      return false;
    if (seqapassVersion == null) {
      if (other.seqapassVersion != null)
        return false;
    } else if (!seqapassVersion.equals(other.seqapassVersion))
      return false;
    if (notes == null) {
      if (other.notes != null)
        return false;
    } else if (!notes.equals(other.notes))
      return false;
    return true;
  }

  public Long getNcbiDate() {
    return ncbiDate;
  }

  public void setNcbiDate(Long ncbiDate) {
    this.ncbiDate = ncbiDate;
  }

  public String getBlastVersion() {
    return blastVersion;
  }

  public void setBlastVersion(String blastVersion) {
    this.blastVersion = blastVersion;
  }

  public Long getCddDate() {
    return cddDate;
  }

  public void setCddDate(Long cddDate) {
    this.cddDate = cddDate;
  }

  public String getCobaltVersion() {
    return cobaltVersion;
  }

  public void setCobaltVersion(String cobaltVersion) {
    this.cobaltVersion = cobaltVersion;
  }

  public Long getCobaltDate() {
    return cobaltDate;
  }

  public void setCobaltDate(Long cobaltDate) {
    this.cobaltDate = cobaltDate;
  }

  public Long getInstallDate() {
    return installDate;
  }

  public void setInstallDate(Long installDate) {
    this.installDate = installDate;
  }

  public String getJavaVersion() {
    return javaVersion;
  }

  public void setJavaVersion(String javaVersion) {
    this.javaVersion = javaVersion;
  }

  public String getPrimefacesVersion() {
    return primefacesVersion;
  }

  public void setPrimefacesVersion(String primefacesVersion) {
    this.primefacesVersion = primefacesVersion;
  }

  public String getTomcatVersion() {
    return tomcatVersion;
  }

  public void setTomcatVersion(String tomcatVersion) {
    this.tomcatVersion = tomcatVersion;
  }

  public String getMysqlVersion() {
    return mysqlVersion;
  }

  public void setMysqlVersion(String mysqlVersion) {
    this.mysqlVersion = mysqlVersion;
  }

  public String getrVersion() {
    return rVersion;
  }

  public void setrVersion(String rVersion) {
    this.rVersion = rVersion;
  }

  public int getUpdateVersion() {
    return updateVersion;
  }

  public void setUpdateVersion(int updateVersion) {
    this.updateVersion = updateVersion;
  }

  public String getSeqapassVersion() {
    return seqapassVersion;
  }

  public void setSeqapassVersion(String seqapassVersion) {
    this.seqapassVersion = seqapassVersion;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

public String getItasserVersion() {
	return itasserVersion;
}

public void setItasserVersion(String itasserVersion) {
	this.itasserVersion = itasserVersion;
}

public Long getUniprotDate() {
	return uniprotDate;
}

public void setUniprotDate(Long uniprotDate) {
	this.uniprotDate = uniprotDate;
}

public String getTmalignVersion() {
	return tmalignVersion;
}

public void setTmalignVersion(String tmalignVersion) {
	this.tmalignVersion = tmalignVersion;
}

}
