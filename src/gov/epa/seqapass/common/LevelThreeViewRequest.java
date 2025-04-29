package gov.epa.seqapass.common;

import java.util.ArrayList;
import java.util.List;

public class LevelThreeViewRequest {

  private int levelThreeRunId;
  private List<Integer> positionList;

  public LevelThreeViewRequest() {
  }

  public LevelThreeViewRequest(int levelThreeRunId, List<Integer> positionList) {
    this.levelThreeRunId = levelThreeRunId;
    this.positionList = positionList;
  }

  @Override
  public String toString() {
    return "LevelThreeViewRequest [levelThreeRunId=" + levelThreeRunId + ", positionList=" + positionList.toString()
        + "]";
  }

  public static LevelThreeViewRequest newInstance(LevelThreeViewRequest orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    LevelThreeViewRequest copy = new LevelThreeViewRequest();
    copy.setLevelThreeRunId(orig.getLevelThreeRunId());
    copy.setPositionList(new ArrayList<Integer>(orig.getPositionList())); // integer is immutable
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + levelThreeRunId;
    result = prime * result + ((positionList == null) ? 0 : positionList.toString().hashCode());
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
    LevelThreeViewRequest other = (LevelThreeViewRequest) obj;
    if (levelThreeRunId != other.levelThreeRunId)
      return false;
    if (positionList == null) {
      if (other.positionList != null)
        return false;
    } else if (!positionList.equals(other.positionList))
      return false;
    return true;
  }

  public List<Integer> getPositionList() {
    return positionList;
  }
  public void setPositionList(List<Integer> positionList) {
    this.positionList = positionList;
  }

  public int getLevelThreeRunId() {
    return levelThreeRunId;
  }

  public void setLevelThreeRunId(int levelThreeRunId) {
    this.levelThreeRunId = levelThreeRunId;
  }

}
