package gov.epa.seqapass.common;

import java.util.List;

public class LevelOneRequestable {

  private List<String> accessionList;
  private int userID;

  public LevelOneRequestable() {
  };

  public LevelOneRequestable(List<String> accessions, int userID) {
    this.accessionList = accessions;
    this.userID = userID;
  }

  @Override
  public String toString() {
    return "LevelOneRequestable [userID=" + userID + ", accessionList=" + accessionList.toString() + "]";
  }

  public static LevelOneRequestable newInstance(LevelOneRequestable orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    LevelOneRequestable copy = new LevelOneRequestable();
    copy.setAccessionList(orig.getAccessionList());
    copy.setUserID(orig.getUserID());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + userID;
    result = prime * result + ((accessionList == null) ? 0 : accessionList.toString().hashCode());
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
    LevelOneRequestable other = (LevelOneRequestable) obj;
    if (userID != other.userID)
      return false;
    if (accessionList == null) {
      if (other.accessionList != null)
        return false;
    } else if (!accessionList.equals(other.accessionList))
      return false;
    return true;
  }

  public List<String> getAccessionList() {
    return accessionList;
  }

  public void setAccessionList(List<String> accessionList) {
    this.accessionList = accessionList;
  }

  public int getUserID() {
    return userID;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

}
