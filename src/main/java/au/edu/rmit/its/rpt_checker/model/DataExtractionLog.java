package au.edu.rmit.its.rpt_checker.model;

public class DataExtractionLog {

	/**
	 * example row with headers LOG_ID SOURCE_LOG_ID SOURCE_RUN_ID PROCESS_NAME
	 * PROCESS_START_DT PROCESS_END_DT PROCESS_STATUS ROW_CNT ERROR_MSG 3418
	 * 267942 2693 ECC_ZPRHI 2016-07-25 15:24:45.097 2016-07-25 15:24:47.193
	 * SUCCESS 37867 NULL
	 * 
	 */

	private int logId;
	private int sourceLogId;
	private int sourceRunId;
	private String processName;
	private String processStartDt;
	private String processEndDt;
	private String processStatus;
	private int rowCnt;
	private String errorMsg;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getSourceLogId() {
		return sourceLogId;
	}

	public void setSourceLogId(int sourceLogId) {
		this.sourceLogId = sourceLogId;
	}

	public int getSourceRunId() {
		return sourceRunId;
	}

	public void setSourceRunId(int sourceRunId) {
		this.sourceRunId = sourceRunId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataExtractionLog [logId=");
		builder.append(logId);
		builder.append(", sourceLogId=");
		builder.append(sourceLogId);
		builder.append(", sourceRunId=");
		builder.append(sourceRunId);
		builder.append(", processName=");
		builder.append(processName);
		builder.append(", processStartDt=");
		builder.append(processStartDt);
		builder.append(", processEndDt=");
		builder.append(processEndDt);
		builder.append(", processStatus=");
		builder.append(processStatus);
		builder.append(", rowCnt=");
		builder.append(rowCnt);
		builder.append(", errorMsg=");
		builder.append(errorMsg);
		builder.append("]");
		return builder.toString();
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessStartDt() {
		return processStartDt;
	}

	public void setProcessStartDt(String processStartDt) {
		this.processStartDt = processStartDt;
	}

	public String getProcessEndDt() {
		return processEndDt;
	}

	public void setProcessEndDt(String processEndDt) {
		this.processEndDt = processEndDt;
	}

	public String getProcessStatus() {
		return processStatus;
	}

	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}

	public int getRowCnt() {
		return rowCnt;
	}

	public void setRowCnt(int rowCnt) {
		this.rowCnt = rowCnt;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
