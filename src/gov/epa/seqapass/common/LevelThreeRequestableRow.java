package gov.epa.seqapass.common;

import java.util.List;

public class LevelThreeRequestableRow {
  private int accessionRunId;
  private int userId;
  private String displayText;
  private int level3RunId;
  private String jobName;
  private String template;
  private String additionalComparisons;
  private List<String> accessionTargets;

  public LevelThreeRequestableRow() {
  }

  public LevelThreeRequestableRow(int accessionRunId, int userId, String jobName, String template,
      List<String> accessionTargets, String additionalComparisons) {
    this.accessionRunId = accessionRunId;
    this.userId = userId;
    this.jobName = jobName;
    this.template = template;
    this.accessionTargets = accessionTargets;
    this.level3RunId = -1;
    this.displayText = template + "-" + accessionTargets.toString();
    this.additionalComparisons = additionalComparisons;
  }

  public LevelThreeRequestableRow(int accessionRunId, int userId, int level3RunId, String jobName, String template,
      List<String> accessionTargets, String additionalComparisons) {
    this.accessionRunId = accessionRunId;
    this.userId = userId;
    this.level3RunId = level3RunId;
    this.jobName = jobName;
    this.template = template;
    this.accessionTargets = accessionTargets;
    this.displayText = template + "-" + accessionTargets.toString();
    this.additionalComparisons = additionalComparisons;
  }

  @Override
  public String toString() {
    return "LevelThreeRequestableRow [runId=" + accessionRunId + ", userId=" + userId + ", displayText=" + displayText
        + ", level3RunId=" + level3RunId + ", jobName =" + jobName + ", template=" + template + ", accessionTargets="
        + accessionTargets.toString() + ", additionalComparisons=" + additionalComparisons + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + accessionRunId;
    result = prime * result + userId;
    result = prime * result + ((displayText == null) ? 0 : displayText.hashCode());
    result = prime * result + level3RunId;
    result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
    result = prime * result + ((template == null) ? 0 : template.hashCode());
    result = prime * result + ((accessionTargets == null) ? 0 : accessionTargets.toString().hashCode());
    result = prime * result + ((additionalComparisons == null) ? 0 : additionalComparisons.hashCode());
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
    LevelThreeRequestableRow other = (LevelThreeRequestableRow) obj;
    if (accessionRunId != other.accessionRunId)
      return false;
    if (userId != other.userId)
      return false;
    if (displayText == null) {
      if (other.displayText != null)
        return false;
    } else if (!displayText.equals(other.displayText))
      return false;
    if (level3RunId != other.level3RunId)
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
    if (accessionTargets == null) {
      if (other.accessionTargets != null)
        return false;
    } else if (!accessionTargets.equals(other.accessionTargets))
      return false;
    if (additionalComparisons == null) {
      if (other.additionalComparisons != null)
        return false;
    } else if (!additionalComparisons.equals(other.additionalComparisons))
      return false;
    return true;
  }

  public int getAccessionRunId() {
    return accessionRunId;
  }

  public void setAccessionRunId(int runId) {
    this.accessionRunId = runId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getDisplayText() {
    return displayText;
  }

  public void setDisplayText(String displayText) {
    this.displayText = displayText;
  }

  public int getLevel3RunId() {
    return level3RunId;
  }

  public void setLevel3RunId(int level3RunId) {
    this.level3RunId = level3RunId;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }

  public String getAdditionalComparisons() {
    return additionalComparisons;
  }

  public void setAdditionalComparisons(String additionalComparisons) {
    this.additionalComparisons = additionalComparisons;
  }

  public List<String> getAccessionTargets() {
    return accessionTargets;
  }

  public void setAccessionTargets(List<String> accessionTargets) {
    this.accessionTargets = accessionTargets;
  }
}
