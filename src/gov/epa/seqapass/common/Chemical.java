package gov.epa.seqapass.common;

public class Chemical implements Comparable<Chemical> {
	
	public Chemical() {
		
	}
	
	public Chemical(String preferredName, String primaryName, int casNum, String dtxsId) {
		this.preferredName = preferredName;
		this.primaryName = primaryName;
		this.casNum = casNum;
		this.dtxsId = dtxsId;
		this.displayName = preferredName + " (CASRN:" + casNum + ")";
	}
	
	private String preferredName;
	private String primaryName;
	private int casNum;
	private String displayName;
	private String dtxsId;
	
	@Override
	public String toString() {
		return "CASRN = " + casNum;
	}
	
	@Override 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((preferredName == null) ? 0 : preferredName.hashCode());
		result = prime * result + ((primaryName == null) ? 0 : primaryName.hashCode());
		result = prime * result + casNum;
		result = prime * result + ((dtxsId == null) ? 0 : dtxsId.hashCode());
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
		
		Chemical other = (Chemical) obj;
		if (preferredName == null) {
			if (other.preferredName != null)
				return false;
		} else if (!preferredName.equals(other.preferredName))
			return false;
		if (primaryName == null) {
			if (other.primaryName != null)
				return false;
		} else if (!primaryName.equals(other.primaryName))
			return false;
		if (casNum != other.casNum) {
			return false;
		}
		if (dtxsId == null) {
			if (other.dtxsId != null)
				return false;
		} else if (!dtxsId.equals(other.dtxsId))
			return false;
		
		return true;
	}


	
	@Override
	public int compareTo(Chemical o) {
	  if (o == null) {
	    throw new IllegalArgumentException("o cannot be null");
	  }
	  String name = getPreferredName();
	  String otherName = o.getPreferredName();
	  int val;
	  try {
	    val = name.compareTo(otherName);
	  } catch (Exception e) {
	    val = Integer.MIN_VALUE;
	  }
	  return val;
	}
	

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public String getPrimaryName() {
		return primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}

	public int getCasNum() {
		return casNum;
	}

	public void setCasNum(int casNum) {
		this.casNum = casNum;
	}

	public String getDtxsId() {
		return dtxsId;
	}

	public void setDtxsId(String dtxsId) {
		this.dtxsId = dtxsId;
	}

}
