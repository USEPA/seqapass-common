package gov.epa.seqapass.common;

public enum ReportTypeEnum {

  Primary(
      0
  ), Full(
      1
  );
  private int value;

  public int getValue() {
    return value;
  }

  private ReportTypeEnum(int value) {
    this.value = value;
  }

}
