package gov.epa.seqapass.common;

public enum ReportChoiceEnum {

  View(
      0
  ), Save(
      1
  );
  private int value;

  public int getValue() {
    return value;
  }

  private ReportChoiceEnum(int value) {
    this.value = value;
  }

}
