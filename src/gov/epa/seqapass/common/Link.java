package gov.epa.seqapass.common;

public class Link {

  public Link() {
  }

  public Link(String url, String label, String infoHeader, String infoText) {
    this.url = url;
    this.label = label;
    this.infoHeader = infoHeader;
    this.infoText = infoText;
  }

  private String url;
  private String label;
  private String infoHeader;
  private String infoText;

  @Override
  public String toString() {
    return "Link [URL=" + url + ", label=" + label + ", infoText=" + infoText + "]";
  }

  // public static AminoAcid newInstance(AminoAcid orig) {
  // if (orig==null){
  // try {
  // throw new Exception("orig cannot be null");
  // } catch (Exception e) {
  // e.printStackTrace();
  // }
  // }
  //
  // AminoAcid copy = new AminoAcid();
  // copy.setId(orig.getId());
  // copy.setName(orig.getName());
  // copy.setSideChain(orig.getSideChain());
  // copy.setSize(orig.getSize());
  // return copy;
  //
  // }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((url == null) ? 0 : url.hashCode());
    result = prime * result + ((label == null) ? 0 : label.hashCode());
    result = prime * result + ((infoText == null) ? 0 : infoText.hashCode());
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
    Link other = (Link) obj;
    if (url == null) {
      if (other.url != null)
        return false;
    } else if (!url.equals(other.url))
      return false;
    if (label == null) {
      if (other.label != null)
        return false;
    } else if (!label.equals(other.label))
      return false;
    if (infoText == null) {
      if (other.infoText != null)
        return false;
    } else if (!infoText.equals(other.infoText))
      return false;
    return true;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public String getInfoHeader() {
    return infoHeader;
  }

  public void setInfoHeader(String infoHeader) {
    this.infoHeader = infoHeader;
  }

  public String getInfoText() {
    return infoText;
  }

  public void setInfoText(String infoText) {
    this.infoText = infoText;
  }

}
