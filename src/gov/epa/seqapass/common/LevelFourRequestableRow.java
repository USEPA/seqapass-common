package gov.epa.seqapass.common;

import java.util.List;

public class LevelFourRequestableRow {
	private int accessionRunId;
	private int userId;
	private int level4RunId;
	private String jobName;
	private String template;
	private String templatePDB;
	private String status;
	private String displayName;
	private List<LevelFourAccessionRow> accessionData;

	// TM-Align only fields
//	private String queryAcc; // query accession to be used for TM-Align comparisons
	// for cases of combined level 4 runs where query accession is not available in
	// the above
	// level4RunId/jobName, the queryRunId and queryJobName fields can be used to
	// determine
	// where to find the query pdb
//	private int queryRunId; // level4RunId associated with query accession
//	private String queryTemplate;  //template associated with tm-align query

	private LevelFourAccessionRow queryAccessionData;
	private String queryJobName; // jobName associated with query accession
	private String queryDisplayName; // display name associated with tm-align
	private int tmAlignRunId;
	private int sourceLevel;  //distinguishes between level 1 and 2 data source for I-TASSER
	private int level2RunId;  //only used if sourceLevel=2
	private int startPos;    //only used if sourceLevel=2
	private String domain;    //only used if sourceLevel=2
	private boolean disable;  //only used for enabling/disabling selection when sourceLevel=2

	public LevelFourRequestableRow() {
	}

	public LevelFourRequestableRow(int accessionRunId, int userId, String jobName, int sourceLevel, int level2RunId, int startPos, String domain) {
		this.accessionRunId = accessionRunId;
		this.userId = userId;
		this.jobName = jobName;
		this.level4RunId = -1;
		this.status = "new";
		this.sourceLevel = sourceLevel;
		this.level2RunId = level2RunId;
		this.startPos = startPos;
		this.domain = domain;
		this.disable = false;
		constructDisplayName();
	}
	
	public LevelFourRequestableRow(int accessionRunId, int userId, String jobName, int sourceLevel, int level2RunId, String displayName) {
		this.accessionRunId = accessionRunId;
		this.userId = userId;
		this.jobName = jobName;
		this.level4RunId = -1;
		this.status = "new";
		this.sourceLevel = sourceLevel;
		this.level2RunId = level2RunId;
		this.displayName = displayName;
		this.disable = false;
	}

//  public LevelFourRequestableRow(int accessionRunId, int userId, String jobName, String template) {
//    this.accessionRunId = accessionRunId;
//    this.userId = userId;
//    this.jobName = jobName;
//    this.template = template;
//    this.level4RunId = -1;
//  }

	public LevelFourRequestableRow(int accessionRunId, int userId, int level4RunId, String jobName, String template,
			String status, int sourceLevel, int level2RunId, int startPos, String domain) {
		this.accessionRunId = accessionRunId;
		this.userId = userId;
		this.level4RunId = level4RunId;
		this.jobName = jobName;
		this.template = template;
		this.status = status;
		this.sourceLevel = sourceLevel;
		this.level2RunId = level2RunId;
		this.startPos = startPos;
		this.domain = domain;
		this.disable = false;
		constructDisplayName();
		constructQueryDisplayName();
	}

//  public LevelFourRequestableRow(int accessionRunId, int userId, int level4RunId, String jobName, String template, List<LevelFourAccessionRow> accessionData) {
//	    this.accessionRunId = accessionRunId;
//	    this.userId = userId;
//	    this.level4RunId = level4RunId;
//	    this.jobName = jobName;
//	    this.template = template;
//	    this.accessionData = accessionData;
//	  }

	public LevelFourRequestableRow(LevelFourAccessionRow row, String queryJobName, int sourceLevel, int level2RunId) {
//	  this.accessionRunId = accessionRunId;
//	  this.userId = userId;
//		this.template = template;
//		this.displayName = (template == null || template.isEmpty()) ? queryAcc + ":" + jobName
//				: queryAcc + "(w/restraint " + template + "):" + jobName;
//		this.queryAcc = queryAcc;
//		this.queryRunId = queryRunId;
		this.queryAccessionData = row;
		this.queryJobName = queryJobName;
//		this.queryTemplate = queryTemplate;
		this.queryDisplayName = row.getNcbiAccession() + " (" + row.getLevel4RunId() + ":" + queryJobName;
		this.sourceLevel = sourceLevel;
		this.level2RunId = level2RunId;
		this.disable = false;
		constructQueryDisplayName();
	}

	public LevelFourRequestableRow(String query_accession, int queryLevel4RunId, String queryPdbSource, String template, String jobName, int tmAlignRunId, int sourceLevel) {
		this.queryAccessionData = new LevelFourAccessionRow();
		this.queryAccessionData.setNcbiAccession(query_accession);
		this.queryAccessionData.setTemplate(template);
		this.queryAccessionData.setLevel4RunId(queryLevel4RunId);
		this.queryAccessionData.setPdbSource(queryPdbSource);
		this.queryJobName = jobName;
		this.tmAlignRunId = tmAlignRunId;
		this.sourceLevel = sourceLevel;
		this.disable = false;
		constructQueryDisplayNameWithTMAlignRunId();
	}

	public void constructQueryDisplayName() {
		if (queryAccessionData != null) {
			this.queryDisplayName = queryAccessionData.getNcbiAccession() + " (" + queryAccessionData.getLevel4RunId()
					+ ":" + queryJobName;
			if (queryAccessionData.getTemplate() != null && !queryAccessionData.getTemplate().trim().isEmpty()) {
				this.queryDisplayName = this.queryDisplayName + "(w/restraint " + queryAccessionData.getTemplate()
						+ ")";
			} else {
				this.queryDisplayName = this.queryDisplayName + ")";
			}
		}
	}
	
	public void constructDisplayName() {
		if (sourceLevel == 1) {
			if (template == null || template.isEmpty()) {
				this.displayName = jobName;
			} else {
				this.displayName = jobName + "(w/restraint " + template + ")";
			}
		} else if(sourceLevel == 2) {
			
			if (template == null || template.isEmpty()) {
				this.displayName = jobName + "[(" + startPos + ") " + domain + "]";
			} else {
				this.displayName = jobName + "[(" + startPos + ") " + domain + "(w/restraint " + template + ")]";
			}
		}
	}
	
	public void constructQueryDisplayNameWithTMAlignRunId() {
		if (queryAccessionData != null) {
			this.queryDisplayName = queryAccessionData.getNcbiAccession() + " (" + tmAlignRunId + ":" + queryAccessionData.getLevel4RunId()
					+ ":" + queryJobName;
			if (queryAccessionData.getTemplate() != null && !queryAccessionData.getTemplate().trim().isEmpty()) {
				this.queryDisplayName = this.queryDisplayName + "(w/restraint " + queryAccessionData.getTemplate()
						+ ")";
			} else {
				this.queryDisplayName = this.queryDisplayName + ")";
			}
		}
	}

	@Override
	public String toString() {
		return "LevelFourRequestableRow [runId=" + accessionRunId + ", userId=" + userId + ", level4RunId="
				+ level4RunId + ", jobName =" + jobName + ", template=" + template + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accessionRunId;
		result = prime * result + userId;
		result = prime * result + level4RunId;
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		result = prime * result + ((template == null) ? 0 : template.hashCode());
		result = prime * result + ((accessionData == null) ? 0 : accessionData.hashCode());
		result = prime * result + ((queryJobName == null) ? 0 : queryJobName.hashCode());
		result = prime * result + ((queryDisplayName == null) ? 0 : queryDisplayName.hashCode());
		result = prime * result + ((queryAccessionData == null) ? 0 : queryAccessionData.hashCode());
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + startPos;
		result = prime * result + level2RunId;

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
		LevelFourRequestableRow other = (LevelFourRequestableRow) obj;
		if (accessionRunId != other.accessionRunId)
			return false;
		if (userId != other.userId)
			return false;
		if (level4RunId != other.level4RunId)
			return false;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		if (template == null) {
			if (other.template != null)
				return false;
		} else if (!template.equals(other.template))
			return false;
//    if (accessionData == null) {
//    	if (other.accessionData != null)
//    		return false;
//    } else if (!accessionData.equals(other.accessionData))
//    	return false;

		if (queryJobName == null) {
			if (other.queryJobName != null)
				return false;
		} else if (!queryJobName.equals(other.queryJobName))
			return false;

		if (queryDisplayName == null) {
			if (other.queryDisplayName != null)
				return false;
		} else if (!queryDisplayName.equals(other.queryDisplayName))
			return false;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (level2RunId != other.level2RunId)
			return false;
		if (startPos != other.startPos)
			return false;
		return true;
	}

	public static LevelFourRequestableRow newInstance(LevelFourRequestableRow orig) {
		if (orig == null) {
			try {
				throw new Exception("orig cannot be null");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		LevelFourRequestableRow copy = new LevelFourRequestableRow();
		copy.setAccessionRunId(orig.getAccessionRunId());
		copy.setUserId(orig.getUserId());
		copy.setLevel4RunId(orig.getLevel4RunId());
		copy.setJobName(orig.getJobName());
		copy.setTemplate(orig.getTemplate());
		copy.setDisplayName(orig.getDisplayName());
		List<LevelFourAccessionRow> accData = copy.getAccessionData();
		if (orig.getAccessionData() != null) {
			for (LevelFourAccessionRow row : orig.getAccessionData()) {
				accData.add(LevelFourAccessionRow.newInstance(row));
			}
		}
		if (orig.getQueryAccessionData() != null) {
			copy.setQueryAccessionData(LevelFourAccessionRow.newInstance(orig.getQueryAccessionData()));
		}
		copy.setQueryJobName(orig.getQueryJobName());
		copy.setQueryDisplayName(orig.getQueryDisplayName());

		return copy;

	}

	public int getAccessionRunId() {
		return accessionRunId;
	}

	public void setAccessionRunId(int runId) {
		this.accessionRunId = runId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getLevel4RunId() {
		return level4RunId;
	}

	public void setLevel4RunId(int level4RunId) {
		this.level4RunId = level4RunId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public List<LevelFourAccessionRow> getAccessionData() {
		return accessionData;
	}

	public void setAccessionData(List<LevelFourAccessionRow> accessionData) {
		this.accessionData = accessionData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getQueryJobName() {
		return queryJobName;
	}

	public void setQueryJobName(String queryJobName) {
		this.queryJobName = queryJobName;
	}

	public String getQueryDisplayName() {
		return queryDisplayName;
	}

	public void setQueryDisplayName(String queryDisplayName) {
		this.queryDisplayName = queryDisplayName;
	}

	public LevelFourAccessionRow getQueryAccessionData() {
		return queryAccessionData;
	}

	public void setQueryAccessionData(LevelFourAccessionRow queryAccessionData) {
		this.queryAccessionData = queryAccessionData;
	}

	public int getTmAlignRunId() {
		return tmAlignRunId;
	}

	public void setTmAlignRunId(int tmAlignRunId) {
		this.tmAlignRunId = tmAlignRunId;
	}

	public int getSourceLevel() {
		return sourceLevel;
	}

	public void setSourceLevel(int sourceLevel) {
		this.sourceLevel = sourceLevel;
	}

	public int getLevel2RunId() {
		return level2RunId;
	}

	public void setLevel2Id(int level2RunId) {
		this.level2RunId = level2RunId;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public void setLevel2RunId(int level2RunId) {
		this.level2RunId = level2RunId;
	}

	public int getStartPos() {
		return startPos;
	}

	public void setStartPos(int startPos) {
		this.startPos = startPos;
	}

	public boolean isDisable() {
		return disable;
	}

	public void setDisable(boolean disable) {
		this.disable = disable;
	}

	public String getTemplatePDB() {
		return templatePDB;
	}

	public void setTemplatePDB(String templatePDB) {
		this.templatePDB = templatePDB;
	}

}
