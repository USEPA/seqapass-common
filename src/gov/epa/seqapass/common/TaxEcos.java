package gov.epa.seqapass.common;

public class TaxEcos {

  private int taxid;
  private int ecosId;

  public TaxEcos() {
  }

  public TaxEcos(int taxid, int ecosId) {
    this.taxid = taxid;
    this.ecosId = ecosId;
  }

  public static TaxEcos newInstance(TaxEcos orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    TaxEcos copy = new TaxEcos();
    copy.setTaxid(orig.getTaxid());
    copy.setEcosId(orig.getEcosId());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + taxid;
    result = prime * result + ecosId;
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
    TaxEcos other = (TaxEcos) obj;

    if (taxid != other.taxid)
      return false;
    if (ecosId != other.ecosId)
      return false;
    return true;
  }

  public int getTaxid() {
    return taxid;
  }

  public void setTaxid(int taxid) {
    this.taxid = taxid;
  }

  public int getEcosId() {
    return ecosId;
  }

  public void setEcosId(int ecosId) {
    this.ecosId = ecosId;
  }

}
