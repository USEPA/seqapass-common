package gov.epa.seqapass.common;

import java.util.Date;

/**
 * @author tsb
 * 
 *         <pre>
 * 
 *     blast_run_id: 6
 *               id: 4
 *        user_name: ibalabin
 *        accession: CAE82649.1
 *       query_name: gi|45502029|emb|CAE82649.1| v-myb myeloblastosis viral oncogene homologue (avian)
 *       genbank_id: 45502029
 *           tax_id: 9606
 *     species_name: Homo sapiens
 * common_name_list: human
 *       class_name: Mammalia
 *       start_date: 2015-08-07 12:31:40
 *         end_date: 2015-08-07 21:29:59
 * 
 *         </pre>
 *
 */
public class ResultsRow {
  private int blastRunId;
  private int id;
  private String userName;
  private String accession;
  private String queryName;
  private int genbankId;
  private int taxId;
  private String speciesName;
  private String commonNameList;
  private String className;
  private Date startDate;
  private Date endDate;

  public int getBlastRunId() {
    return blastRunId;
  }

  public void setBlastRunId(int blastRunId) {
    this.blastRunId = blastRunId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getAccession() {
    return accession;
  }

  public void setAccession(String accession) {
    this.accession = accession;
  }

  public String getQueryName() {
    return queryName;
  }

  public void setQueryName(String queryName) {
    this.queryName = queryName;
  }

  public int getGenbankId() {
    return genbankId;
  }

  public void setGenbankId(int genbankId) {
    this.genbankId = genbankId;
  }

  public int getTaxId() {
    return taxId;
  }

  public void setTaxId(int taxId) {
    this.taxId = taxId;
  }

  public String getSpeciesName() {
    return speciesName;
  }

  public void setSpeciesName(String speciesName) {
    this.speciesName = speciesName;
  }

  public String getCommonNameList() {
    return commonNameList;
  }

  public void setCommonNameList(String commonNameList) {
    this.commonNameList = commonNameList;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public String toString() {
    return "ResultsRow [blastRunId=" + blastRunId + ", id=" + id + ", userName=" + userName + ", accession=" + accession
        + ", queryName=" + queryName + ", genbankId=" + genbankId + ", taxId=" + taxId + ", speciesName=" + speciesName
        + ", commonNameList=" + commonNameList + ", className=" + className + ", startDate=" + startDate + ", endDate="
        + endDate + "]";
  }

  public static ResultsRow newInstance(ResultsRow orig) {
    if (orig == null) {
      try {
        throw new Exception("orig cannot be null");
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    ResultsRow copy = new ResultsRow();
    copy.setBlastRunId(orig.getBlastRunId());
    copy.setId(orig.getId());
    copy.setUserName(orig.getUserName());
    copy.setAccession(orig.getAccession());
    copy.setQueryName(orig.getQueryName());
    copy.setGenbankId(orig.getGenbankId());
    copy.setTaxId(orig.getTaxId());
    copy.setSpeciesName(orig.getSpeciesName());
    copy.setCommonNameList(orig.getCommonNameList());
    copy.setClassName(orig.getClassName());
    copy.setStartDate(orig.getStartDate());
    copy.setEndDate(orig.getEndDate());
    return copy;

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((accession == null) ? 0 : accession.hashCode());
    result = prime * result + blastRunId;
    result = prime * result + ((className == null) ? 0 : className.hashCode());
    result = prime * result + ((commonNameList == null) ? 0 : commonNameList.hashCode());
    result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
    result = prime * result + genbankId;
    result = prime * result + id;
    result = prime * result + ((queryName == null) ? 0 : queryName.hashCode());
    result = prime * result + ((speciesName == null) ? 0 : speciesName.hashCode());
    result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
    result = prime * result + taxId;
    result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
    ResultsRow other = (ResultsRow) obj;
    if (accession == null) {
      if (other.accession != null)
        return false;
    } else if (!accession.equals(other.accession))
      return false;
    if (blastRunId != other.blastRunId)
      return false;
    if (className == null) {
      if (other.className != null)
        return false;
    } else if (!className.equals(other.className))
      return false;
    if (commonNameList == null) {
      if (other.commonNameList != null)
        return false;
    } else if (!commonNameList.equals(other.commonNameList))
      return false;
    if (endDate == null) {
      if (other.endDate != null)
        return false;
    } else if (!endDate.equals(other.endDate))
      return false;
    if (genbankId != other.genbankId)
      return false;
    if (id != other.id)
      return false;
    if (queryName == null) {
      if (other.queryName != null)
        return false;
    } else if (!queryName.equals(other.queryName))
      return false;
    if (speciesName == null) {
      if (other.speciesName != null)
        return false;
    } else if (!speciesName.equals(other.speciesName))
      return false;
    if (startDate == null) {
      if (other.startDate != null)
        return false;
    } else if (!startDate.equals(other.startDate))
      return false;
    if (taxId != other.taxId)
      return false;
    if (userName == null) {
      if (other.userName != null)
        return false;
    } else if (!userName.equals(other.userName))
      return false;
    return true;
  }

}
