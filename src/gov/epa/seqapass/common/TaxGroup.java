package gov.epa.seqapass.common;

public class TaxGroup {

  private String level;
  private String name;
  private int id;

  public TaxGroup() {
  }

  public TaxGroup(String level, String name, int id) {
    this.level = level;
    this.name = name;
    this.id = id;
  }

  public static TaxGroup newInstance(TaxGroup orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    TaxGroup copy = new TaxGroup();
    copy.setName(orig.getName());
    copy.setLevel(orig.getLevel());
    copy.setId(orig.getId());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((level == null) ? 0 : level.hashCode());
    result = prime * result + id;
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
    TaxGroup other = (TaxGroup) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (level == null) {
      if (other.level != null)
        return false;
    } else if (!level.equals(other.level))
      return false;
    if (id != other.id)
      return false;
    return true;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
