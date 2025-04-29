package gov.epa.seqapass.common;

import java.util.HashMap;

public class SpeciesTaxGrouping {

  private String requestedRank;
  private HashMap<Integer, TaxGroup> groupMap; // Integer => species tax id

  public SpeciesTaxGrouping() {
  }

  public SpeciesTaxGrouping(String rank, HashMap<Integer, TaxGroup> map) {
    this.requestedRank = rank;
    this.groupMap = map;
  }

  public static SpeciesTaxGrouping newInstance(SpeciesTaxGrouping orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    SpeciesTaxGrouping copy = new SpeciesTaxGrouping();
    copy.setRequestedRank(orig.getRequestedRank());
    copy.setGroupMap(orig.getGroupMap());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((requestedRank == null) ? 0 : requestedRank.hashCode());
    result = prime * result + ((groupMap == null) ? 0 : groupMap.hashCode());
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
    SpeciesTaxGrouping other = (SpeciesTaxGrouping) obj;
    if (requestedRank == null) {
      if (other.requestedRank != null)
        return false;
    } else if (!requestedRank.equals(other.requestedRank))
      return false;
    if (groupMap == null) {
      if (other.groupMap != null)
        return false;
    } else if (!groupMap.equals(other.groupMap))
      return false;
    return true;
  }

  public String getRequestedRank() {
    return requestedRank;
  }

  public void setRequestedRank(String requestedRank) {
    this.requestedRank = requestedRank;
  }

  public HashMap<Integer, TaxGroup> getGroupMap() {
    return groupMap;
  }

  public void setGroupMap(HashMap<Integer, TaxGroup> groupMap) {
    this.groupMap = groupMap;
  }

}
