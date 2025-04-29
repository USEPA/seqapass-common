package gov.epa.seqapass.common;

public class AminoAcid {

  public AminoAcid() {
  }

  public AminoAcid(char id, String name, String sideChain, float size) {
    this.id = id;
    this.name = name;
    this.sideChain = sideChain;
    this.size = size;

  }

  private char id;
  private String name;
  private String sideChain;
  private float size;

  @Override
  public String toString() {
    return "AminoAcid [Id=" + id + ", name=" + name + ", sideChain=" + sideChain + ", size=" + size + "]";
  }

  public static AminoAcid newInstance(AminoAcid orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    AminoAcid copy = new AminoAcid();
    copy.setId(orig.getId());
    copy.setName(orig.getName());
    copy.setSideChain(orig.getSideChain());
    copy.setSize(orig.getSize());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) id;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((sideChain == null) ? 0 : sideChain.hashCode());
    result = prime * result + (int) (size * 100);
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
    AminoAcid other = (AminoAcid) obj;
    if (id != other.id)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (sideChain == null) {
      if (other.sideChain != null)
        return false;
    } else if (!sideChain.equals(other.sideChain))
      return false;
    if (size != other.size) {
      return false;
    }

    return true;
  }

  public char getId() {
    return id;
  }

  public void setId(char id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSideChain() {
    return sideChain;
  }

  public void setSideChain(String sideChain) {
    this.sideChain = sideChain;
  }

  public float getSize() {
    return size;
  }

  public void setSize(float size) {
    this.size = size;
  }

}
