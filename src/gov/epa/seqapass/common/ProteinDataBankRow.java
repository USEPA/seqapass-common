package gov.epa.seqapass.common;

import java.util.ArrayList;

public class ProteinDataBankRow {

	// example row
	// ATOM 15 CB ASN 2 29.263 15.325 16.945 1.00 0.00
	// Column description example value
	String recordType; // Cols 1-4 record type "ATOM" in example
	int serialNum; // Cols 7-11 atom serial number "15" in example
	String atomName; // Cols 13-16 atom name "CB" in example
	// String altLocInd; //Cols 17 alt location indicator
	String resName; // Cols 18-20 residue name "ASN" in example
	// String chainId; //Cols 22 chain identifier
	int resSeqNum; // Cols 23-26 residue sequence number "2" in example
	// String insertCode;//Cols 27 code insertions of residues
	double xCoord; // cols 31-38 X orthogonal coordinate "29.263" in example
	double yCoord; // cols 39-46 Y orthogonal coordinate "15.325" in example
	double zCoord; // cols 47-54 Z orthogonal coordinate "16.945" in example
	double occupancy; // cols 55-60 Occupancy "1.00" in example
	double tempFactor; // cols 61-66 temperature factor "0.00" in example
	// String segId; //cols 73-76 segment identifier
	// String eleSym; //cols 77-78 element symbol
	// String charge; //cols 79-80 charge

	public ProteinDataBankRow() {

	}

	public ProteinDataBankRow(String recordType, int serialNum, String atomName, String resName, int resSeqNum,
			double xCoord, double yCoord, double zCoord, double occupancy, double tempFactor) {

		this.recordType = recordType;
		this.serialNum = serialNum;
		this.atomName = atomName;
		this.resName = resName;
		this.resSeqNum = resSeqNum;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
		this.occupancy = occupancy;
		this.tempFactor = tempFactor;
	}

	@Override
	public String toString() {
		return "ProteinDataBankRow [recordType=" + recordType + ", serialNum=" + serialNum + ", atomName=" + atomName
				+ ", resName=" + resName + ", resSeqNum=" + resSeqNum + ", xCoord=" + xCoord + ", yCoord=" + yCoord
				+ ", zCoord=" + zCoord + ", occupancy=" + occupancy + ", tempFactor=" + tempFactor + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result + ((recordType == null) ? 0 : recordType.hashCode());
		result = prime * result + serialNum;
		result = prime * result + ((atomName == null) ? 0 : atomName.hashCode());
		result = prime * result + ((resName == null) ? 0 : resName.hashCode());
		result = prime * result + resSeqNum;
		result = prime * result + Double.toString(xCoord).hashCode();
		result = prime * result + Double.toString(yCoord).hashCode();
		result = prime * result + Double.toString(zCoord).hashCode();
		result = prime * result + Double.toString(occupancy).hashCode();
		result = prime * result + Double.toString(tempFactor).hashCode();

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
		ProteinDataBankRow other = (ProteinDataBankRow) obj;
		if (recordType == null) {
			if (other.recordType != null)
				return false;
		} else if (!recordType.equals(other.recordType))
			return false;
		if (serialNum != other.serialNum) {
			return false;
		}
		if (atomName == null) {
			if (other.atomName != null)
				return false;
		} else if (!atomName.equals(other.atomName))
			return false;
		if (resName == null) {
			if (other.resName != null)
				return false;
		} else if (!resName.equals(other.resName))
			return false;
		if (resSeqNum != other.resSeqNum) {
			return false;
		}
		if (xCoord != other.xCoord)
		      return false;
		if (yCoord != other.yCoord)
		      return false;
		if (zCoord != other.zCoord)
		      return false;
		if (occupancy != other.occupancy)
		      return false;
		if (tempFactor != other.tempFactor)
		      return false;
		
		return true;
	}
	
	public static ProteinDataBankRow newInstance(ProteinDataBankRow orig) {
	    if (orig == null) {
	      try {
	        throw new Exception("orig cannot be null");
	      } catch (Exception e) {
	        e.printStackTrace();
	      }
	    }

	    ProteinDataBankRow copy = new ProteinDataBankRow();
//	    copy.setId(orig.getId());
//	    copy.setName(orig.getName());
//	    copy.setSideChain(orig.getSideChain());
//	    copy.setSize(orig.getSize());
	    return copy;

	  }
	
	public static ArrayList<ProteinDataBankRow> parsePDBIntoRows(String pdbFileAsString){
		ArrayList<ProteinDataBankRow> proteinDataBankRows = new ArrayList<ProteinDataBankRow>();
		String [] linesSplit = pdbFileAsString.split("\n");
		for(String line: linesSplit) {
//			String [] tabSplit = line.trim().split("\t");
//			if(tabSplit.length == 10) { //Has all values for protein data bank row
//				String recordType = tabSplit[0];
//				int serialNumber = Integer.parseInt(tabSplit[1]);
//				String atomName = tabSplit[2];
//				String resName = tabSplit[3];
//				int resSeqNum = Integer.parseInt(tabSplit[4]);
//				double xCoord = Double.parseDouble(tabSplit[5]);
//				double yCoord = Double.parseDouble(tabSplit[6]);
//				double zCoord = Double.parseDouble(tabSplit[7]);
//				double occupancy = Double.parseDouble(tabSplit[8]);
//				double tempFactor = Double.parseDouble(tabSplit[9]);
//				
//				ProteinDataBankRow proteinDataBankRow = new ProteinDataBankRow(recordType, serialNumber, atomName, resName, resSeqNum, xCoord, yCoord, zCoord, occupancy, tempFactor);
//				proteinDataBankRows.add(proteinDataBankRow);
//			}
			//uses https://www.cgl.ucsf.edu/chimera/docs/UsersGuide/tutorials/pdbintro.html
			String recordType = line.substring(0, 4);
			int serialNumber = Integer.parseInt(line.substring(6,11).trim());
			String atomName = line.substring(12,16);
			String resName = line.substring(17,20);
			int resSeqNum = Integer.parseInt(line.substring(22,26).trim());
			double xCoord = Double.parseDouble(line.substring(30,38).trim());
			double yCoord = Double.parseDouble(line.substring(38,46).trim());
			double zCoord = Double.parseDouble(line.substring(46,54).trim());
			double occupancy = Double.parseDouble(line.substring(54,60).trim());
			double tempFactor = Double.parseDouble(line.substring(60,66).trim());
			ProteinDataBankRow proteinDataBankRow = new ProteinDataBankRow(recordType, serialNumber, atomName, resName, resSeqNum, xCoord, yCoord, zCoord, occupancy, tempFactor);
			proteinDataBankRows.add(proteinDataBankRow);
		}
		return proteinDataBankRows;
	}

	public String getRecordType() {
		return recordType;
	}

	public void setRecordType(String recordType) {
		this.recordType = recordType;
	}

	public int getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(int serialNum) {
		this.serialNum = serialNum;
	}

	public String getAtomName() {
		return atomName;
	}

	public void setAtomName(String atomName) {
		this.atomName = atomName;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public int getResSeqNum() {
		return resSeqNum;
	}

	public void setResSeqNum(int resSeqNum) {
		this.resSeqNum = resSeqNum;
	}

	public double getxCoord() {
		return xCoord;
	}

	public void setxCoord(double xCoord) {
		this.xCoord = xCoord;
	}

	public double getyCoord() {
		return yCoord;
	}

	public void setyCoord(double yCoord) {
		this.yCoord = yCoord;
	}

	public double getzCoord() {
		return zCoord;
	}

	public void setzCoord(double zCoord) {
		this.zCoord = zCoord;
	}

	public double getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(double occupancy) {
		this.occupancy = occupancy;
	}

	public double getTempFactor() {
		return tempFactor;
	}

	public void setTempFactor(double tempFactor) {
		this.tempFactor = tempFactor;
	}

}
