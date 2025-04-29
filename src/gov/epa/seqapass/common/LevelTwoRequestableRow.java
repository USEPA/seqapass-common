package gov.epa.seqapass.common;

public class LevelTwoRequestableRow {

  private int runId;
  private String accession;
  private int domainNumber;
  private String key;
  private int startPosition;
  private String displayText;
  private int level2RunId;

  public LevelTwoRequestableRow() {
  }

  public LevelTwoRequestableRow(int runId, String accession, int domainNumber, String key, int startPosition,
      String displayText) {
    this.runId = runId;
    this.accession = accession;
    this.domainNumber = domainNumber;
    this.key = key;
    this.startPosition = startPosition;
    this.displayText = displayText;
    this.level2RunId = 0;
  }

  public LevelTwoRequestableRow(int runId, String accession, int domainNumber, String key, int startPosition,
      String displayText, int level2RunId) {
    this.runId = runId;
    this.accession = accession;
    this.domainNumber = domainNumber;
    this.key = key;
    this.startPosition = startPosition;
    this.displayText = displayText;
    this.level2RunId = level2RunId;
  }

  @Override
  public String toString() {
    return "LevelTwoRequestableRow [runId=" + runId + ", accession=" + accession + ", domainNumber=" + domainNumber
        + ", key=" + key + ", startPosition=" + startPosition + ", displayText=" + displayText + "level2RunId="
        + level2RunId + "]";
  }

  public static LevelTwoRequestableRow newInstance(LevelTwoRequestableRow orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    LevelTwoRequestableRow copy = new LevelTwoRequestableRow();
    copy.setRunId(orig.getRunId());
    copy.setAccession(orig.getAccession());
    copy.setDomainNumber(orig.getDomainNumber());
    copy.setKey(orig.getKey());
    copy.setStartPosition(orig.getStartPosition());
    copy.setDisplayText(orig.getDisplayText());
    copy.setLevel2RunId(orig.getLevel2RunId());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + runId;
    result = prime * result + ((accession == null) ? 0 : accession.hashCode());
    result = prime * result + domainNumber;
    result = prime * result + ((key == null) ? 0 : key.hashCode());
    result = prime * result + startPosition;
    result = prime * result + ((displayText == null) ? 0 : displayText.hashCode());
    result = prime * result + level2RunId;
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
    LevelTwoRequestableRow other = (LevelTwoRequestableRow) obj;
    if (runId != other.runId)
      return false;
    if (accession == null) {
      if (other.accession != null)
        return false;
    } else if (!accession.equals(other.accession))
      return false;
    if (domainNumber != other.domainNumber)
      return false;
    if (key == null) {
      if (other.key != null)
        return false;
    } else if (!key.equals(other.key))
      return false;
    if (startPosition != other.startPosition)
      return false;
    if (displayText == null) {
      if (other.displayText != null)
        return false;
    } else if (!displayText.equals(other.displayText))
      return false;
    if (level2RunId != other.level2RunId)
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

  public int getDomainNumber() {
    return domainNumber;
  }

  public void setDomainNumber(int domainNumber) {
    this.domainNumber = domainNumber;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getDisplayText() {
    return displayText;
  }

  public void setDisplayText(String displayText) {
    this.displayText = displayText;
  }

  public int getLevel2RunId() {
    return level2RunId;
  }

  public void setLevel2RunId(int level2RunId) {
    this.level2RunId = level2RunId;
  }

  public int getStartPosition() {
    return startPosition;
  }

  public void setStartPosition(int startPosition) {
    this.startPosition = startPosition;
  }
}
