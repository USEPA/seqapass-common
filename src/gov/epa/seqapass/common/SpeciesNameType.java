package gov.epa.seqapass.common;

public enum SpeciesNameType {

  COMMON(
      0
  ), SCIENTIFIC(
      1
  );
  private int value;

  public int getValue() {
    return value;
  }

  private SpeciesNameType(int value) {
    this.value = value;
  }

}
