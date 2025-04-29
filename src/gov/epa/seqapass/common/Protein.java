package gov.epa.seqapass.common;

public class Protein implements Comparable<Protein> {

  private int taxId;
  private int genbankId;
  private String name;
  private String accession;
  private String displayName;

  public Protein() {
  };

  public Protein(String name, String accession) {
    this.accession = accession;
    this.name = name;
    this.displayName = "[" + accession + "] " + name;
  }

  public Protein(String name, String accession, int taxId) {
    this.accession = accession;
    this.name = name;
    this.taxId = taxId;
    this.displayName = "[" + accession + "] " + name.replaceAll("\\[.+\\]", "");
  }

  public int getTaxId() {
    return taxId;
  }

  public void setTaxId(int taxId) {
    this.taxId = taxId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAccession() {
    return accession;
  }

  public void setAccession(String accession) {
    this.accession = accession;
  }

  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public int getGenbankId() {
    return genbankId;
  }

  public void setGenbankId(int genbankId) {
    this.genbankId = genbankId;
  }

  @Override
  public int compareTo(Protein o) {
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

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((accession == null) ? 0 : accession.hashCode());
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
    Protein other = (Protein) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (accession == null) {
      if (other.accession != null)
        return false;
    } else if (!accession.equals(other.accession))
      return false;
    // if (taxId != other.taxId)
    // return false;
    return true;
  }

  @Override
  public String toString() {
    return this.displayName;
  }

  public static Protein newInstance(Protein orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    Protein copy = new Protein();
    copy.setTaxId(orig.getTaxId());
    copy.setGenbankId(orig.getGenbankId());
    copy.setName(orig.getName());
    copy.setAccession(orig.getAccession());
    copy.setDisplayName(orig.getDisplayName());
    return copy;

  }

}
