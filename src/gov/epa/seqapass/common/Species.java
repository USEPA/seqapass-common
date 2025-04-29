package gov.epa.seqapass.common;

public class Species implements Comparable<Species> {

  private int taxId;
  private int proteinCount;
  private String name;
  private String displayName;

  public Species() {
  }

  public Species(int taxid, String name) {
    this.taxId = taxid;
    this.name = name;
    this.displayName = name + " (Taxid:" + taxid + ")";
  }

  public static Species newInstance(Species orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    Species copy = new Species();
    copy.setTaxId(orig.getTaxId());
    copy.setProteinCount(orig.getProteinCount());
    copy.setName(orig.getName());
    copy.setDisplayName(orig.getDisplayName());
    return copy;

  }

  public int getTaxId() {
    return taxId;
  }

  public void setTaxId(int taxid) {
    this.taxId = taxid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int compareTo(Species o) {
    if (o == null) {
      throw new IllegalArgumentException("o cannot be null");
    }
    String name = getName();
    String otherName = o.getName();
    int val;
    try {
      val = name.compareTo(otherName);
    } catch (Exception e) {
      val = Integer.MIN_VALUE;
    }
    return val;
  }

  public int getProteinCount() {
    return proteinCount;
  }

  public void setProteinCount(int proteinCount) {
    this.proteinCount = proteinCount;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
    result = prime * result + proteinCount;
    result = prime * result + taxId;
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
    Species other = (Species) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    // if (displayName == null) {
    // if (other.displayName != null)
    // return false;
    // } else if (!displayName.equals(other.displayName))
    // return false;
    if (proteinCount != other.proteinCount)
      return false;
    if (taxId != other.taxId)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return this.displayName;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

}
