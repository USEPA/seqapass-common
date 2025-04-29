package gov.epa.seqapass.common;

public class DensityRow {

  private String ortholog;
  private double percSim;

  public DensityRow() {
  }

  public DensityRow(double percSim, String ortholog) {
    this.ortholog = ortholog;
    this.percSim = percSim;
  }

  @Override
  public String toString() {
    return "DensityRow [percSim=" + percSim + "ortholog=" + ortholog + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((ortholog == null) ? 0 : ortholog.hashCode());;
    result = prime * result + Double.toString(percSim).hashCode();
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
    DensityRow other = (DensityRow) obj;
    if (ortholog == null) {
      if (other.ortholog != null)
        return false;
    } else if (!ortholog.equals(other.ortholog))
      return false;
    if (percSim != other.percSim)
      return false;
    return true;
  }

  public String getOrtholog() {
    return ortholog;
  }

  public void setOrtholog(String ortholog) {
    this.ortholog = ortholog;
  }

  public double getPercSim() {
    return percSim;
  }

  public void setPercSim(double percSim) {
    this.percSim = percSim;
  }

}
