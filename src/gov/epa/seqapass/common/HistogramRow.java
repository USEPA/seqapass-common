package gov.epa.seqapass.common;

public class HistogramRow {

  private String bin;
  private int binCount;

  public HistogramRow() {
  }

  // FIXME - CHANGE MOST OF THIS!
  public HistogramRow(String bin, int binCount) {
    this.bin = bin;
    this.binCount = binCount;
  }

  @Override
  public String toString() {
    return "HistogramRow [bin=" + bin + ", binCount=" + binCount + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bin == null) ? 0 : bin.hashCode());;
    result = prime * result + binCount;
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
    HistogramRow other = (HistogramRow) obj;
    if (bin == null) {
      if (other.bin != null)
        return false;
    } else if (!bin.equals(other.bin))
      return false;
    if (binCount != other.binCount)
      return false;
    return true;
  }

  public String getBin() {
    return bin;
  }

  public void setBin(String bin) {
    this.bin = bin;
  }

  public int getBinCount() {
    return binCount;
  }

  public void setBinCount(int binCount) {
    this.binCount = binCount;
  }

}
