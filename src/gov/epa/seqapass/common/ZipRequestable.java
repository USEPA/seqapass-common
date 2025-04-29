package gov.epa.seqapass.common;

public class ZipRequestable {

  private int userId;
  private int accessionRunId;
  private String queryAccessionId;
  private Boolean lev1Report;
  private Boolean lev2Report;
  private Boolean lev3Report;

  public ZipRequestable() {
  };

  public ZipRequestable(int userId, int accessionRunId, String queryAccessionId, Boolean lev1Report, Boolean lev2Report,
      Boolean lev3Report) {
    this.userId = userId;
    this.accessionRunId = accessionRunId;
    this.queryAccessionId = queryAccessionId;
    this.lev1Report = lev1Report;
    this.lev2Report = lev2Report;
    this.lev3Report = lev3Report;
  }

  @Override
  public String toString() {
    return "ZipRequestable [userID=" + userId + ", accessionRunId=" + accessionRunId + ", queryAccessionId="
        + queryAccessionId + ", lev1Report=" + lev1Report.toString() + ", lev2Report=" + lev2Report.toString()
        + ", lev3Report=" + lev3Report.toString() + "]";
  }

  public static ZipRequestable newInstance(ZipRequestable orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    ZipRequestable copy = new ZipRequestable();
    copy.setUserId(orig.getUserId());
    copy.setAccessionRunId(orig.getAccessionRunId());
    copy.setQueryAccessionId(orig.getQueryAccessionId());
    copy.setLev1Report(orig.getLev1Report());
    copy.setLev2Report(orig.getLev2Report());
    copy.setLev3Report(orig.getLev3Report());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + userId;
    result = prime * result + accessionRunId;
    result = prime * result + ((queryAccessionId == null) ? 0 : queryAccessionId.hashCode());
    result = prime * result + lev1Report.hashCode();
    result = prime * result + lev2Report.hashCode();
    result = prime * result + lev3Report.hashCode();
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
    ZipRequestable other = (ZipRequestable) obj;
    if (userId != other.userId)
      return false;
    if (accessionRunId != other.accessionRunId)
      return false;
    if (queryAccessionId == null) {
      if (other.queryAccessionId != null)
        return false;
    } else if (!queryAccessionId.equals(other.queryAccessionId))
      return false;
    if (lev1Report != other.lev1Report)
      return false;
    if (lev2Report != other.lev2Report)
      return false;
    if (lev3Report != other.lev3Report)
      return false;
    return true;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getAccessionRunId() {
    return accessionRunId;
  }

  public void setAccessionRunId(int accessionRunId) {
    this.accessionRunId = accessionRunId;
  }

  public Boolean getLev1Report() {
    return lev1Report;
  }

  public void setLev1Report(Boolean lev1Report) {
    this.lev1Report = lev1Report;
  }

  public Boolean getLev2Report() {
    return lev2Report;
  }

  public void setLev2Report(Boolean lev2Report) {
    this.lev2Report = lev2Report;
  }

  public Boolean getLev3Report() {
    return lev3Report;
  }

  public void setLev3Report(Boolean lev3Report) {
    this.lev3Report = lev3Report;
  }

  public String getQueryAccessionId() {
    return queryAccessionId;
  }

  public void setQueryAccessionId(String queryAccessionId) {
    this.queryAccessionId = queryAccessionId;
  }

}
