package gov.epa.seqapass.common;

import java.util.List;

public class UniprotMap {

  public UniprotMap() {
  }

  public UniprotMap(String ncbiAcc, List<String> uniprotAccs) {
    this.ncbiAcc = ncbiAcc;
    this.uniprotAccs = uniprotAccs;

  }

  private String ncbiAcc;
  private List<String> uniprotAccs;

  @Override
  public String toString() {
    return "Uniprot Map [ncbiAcc=" + ncbiAcc + ", uniprotAccs=" + uniprotAccs.toString()+ "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ncbiAcc == null) ? 0 : ncbiAcc.hashCode());
    result = prime * result + ((uniprotAccs == null) ? 0 : uniprotAccs.hashCode());
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
    UniprotMap other = (UniprotMap) obj;
    if (ncbiAcc == null) {
      if (other.ncbiAcc != null)
        return false;
    } else if (!ncbiAcc.equals(other.ncbiAcc))
      return false;
    if (uniprotAccs == null) {
    	if (other.uniprotAccs != null)
    		return false;
    } else if (!uniprotAccs.equals(other.uniprotAccs))
    	return false;

    return true;
  }

public String getNcbiAcc() {
	return ncbiAcc;
}

public void setNcbiAcc(String ncbiAcc) {
	this.ncbiAcc = ncbiAcc;
}

public List<String> getUniprotAccs() {
	return uniprotAccs;
}

public void setUniprotAccs(List<String> uniprotAccs) {
	this.uniprotAccs = uniprotAccs;
}


}
