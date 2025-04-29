package gov.epa.seqapass.common;

public class LevelThreeResidueResult {

  private int position;
  private Boolean directMatch;
  private Boolean sideChainMatch;
  private Boolean sizeMatch;
  private Boolean totalMatch;
  private AminoAcid aminoAcid;

  public LevelThreeResidueResult() {
  }

  public LevelThreeResidueResult(int position, AminoAcid aminoAcid, Boolean directMatch, Boolean sideChainMatch,
      Boolean sizeMatch) {
    this.position = position;
    this.aminoAcid = aminoAcid;
    this.directMatch = directMatch;
    this.sideChainMatch = sideChainMatch;
    this.sizeMatch = sizeMatch;
    if (directMatch != null && sideChainMatch != null && sizeMatch != null) {
      this.totalMatch = directMatch && sideChainMatch && sizeMatch;
    }

  }

  @Override
  public String toString() {
    return "LevelThreeResidueResult [position=" + position + ", aminoAcid=" + aminoAcid.toString() + ", directMatch="
        + directMatch == null
            ? "null"
            : directMatch + "sideChainMatch=" + sideChainMatch == null
                ? "null"
                : sideChainMatch + "sizeMatch=" + sizeMatch == null
                    ? "null"
                    : sizeMatch + "totalMatch=" + totalMatch == null ? "null" : totalMatch + "]";
  }

  public static LevelThreeResidueResult newInstance(LevelThreeResidueResult orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    LevelThreeResidueResult copy = new LevelThreeResidueResult();
    copy.setPosition(orig.getPosition());
    copy.setAminoAcid(orig.getAminoAcid());
    copy.setDirectMatch(orig.getDirectMatch());
    copy.setSideChainMatch(orig.getSideChainMatch());
    copy.setSizeMatch(orig.getSizeMatch());
    copy.setTotalMatch(orig.getTotalMatch());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + position;
    result = prime * result + ((aminoAcid == null) ? 0 : aminoAcid.hashCode());
    result = prime * result + ((directMatch == null) ? 0 : directMatch.hashCode());
    result = prime * result + ((sideChainMatch == null) ? 0 : sideChainMatch.hashCode());
    result = prime * result + ((sizeMatch == null) ? 0 : sizeMatch.hashCode());
    result = prime * result + ((totalMatch == null) ? 0 : totalMatch.hashCode());
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
    LevelThreeResidueResult other = (LevelThreeResidueResult) obj;
    if (position != other.position)
      return false;
    if (aminoAcid == null) {
      if (other.aminoAcid != null)
        return false;
    } else if (!aminoAcid.equals(other.aminoAcid))
      return false;
    if (directMatch == null) {
      if (other.directMatch != null)
        return false;
    } else if (directMatch != other.directMatch)
      return false;
    if (sideChainMatch == null) {
      if (other.sideChainMatch != null)
        return false;
    } else if (sideChainMatch != other.sideChainMatch)
      return false;
    if (sizeMatch == null) {
      if (other.sizeMatch != null)
        return false;
    } else if (sizeMatch != other.sizeMatch)
      return false;
    if (totalMatch == null) {
      if (other.totalMatch != null)
        return false;
    } else if (totalMatch != other.totalMatch)
      return false;
    return true;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public Boolean getDirectMatch() {
    return directMatch;
  }

  public void setDirectMatch(Boolean directMatch) {
    this.directMatch = directMatch;
  }

  public Boolean getSideChainMatch() {
    return sideChainMatch;
  }

  public void setSideChainMatch(Boolean sideChainMatch) {
    this.sideChainMatch = sideChainMatch;
  }

  public Boolean getSizeMatch() {
    return sizeMatch;
  }

  public void setSizeMatch(Boolean sizeMatch) {
    this.sizeMatch = sizeMatch;
  }

  public Boolean getTotalMatch() {
    return totalMatch;
  }

  public void setTotalMatch(Boolean totalMatch) {
    this.totalMatch = totalMatch;
  }

  public AminoAcid getAminoAcid() {
    return aminoAcid;
  }

  public void setAminoAcid(AminoAcid aminoAcid) {
    this.aminoAcid = aminoAcid;
  }

}
