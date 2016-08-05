package au.edu.rmit.its.rpt_checker.spring.jdbc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import au.edu.rmit.its.rpt_checker.model.DataExtractionLog;

public class DataExtractionLogDAOJDBCTemplateImpl implements DataExtractionLogDAO {
	
	private final static Logger logger = Logger.getLogger(DataExtractionLogDAOJDBCTemplateImpl.class);
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<DataExtractionLog> getAll() {
		String query = "select * from [DZ].[DATA_EXTRACTION_LOG]";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<DataExtractionLog> logList = new ArrayList<DataExtractionLog>();

		List<Map<String,Object>> logRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> logRow : logRows){
			DataExtractionLog data = new DataExtractionLog();
			data.setLogId(Integer.parseInt(String.valueOf(logRow.get("LOG_ID"))));
			data.setSourceLogId(Integer.parseInt(String.valueOf(logRow.get("SOURCE_LOG_ID"))));
			data.setSourceRunId(Integer.parseInt(String.valueOf(logRow.get("SOURCE_RUN_ID"))));
			data.setProcessName(String.valueOf(logRow.get("PROCESS_NAME")));
			data.setProcessStartDt(String.valueOf(logRow.get("PROCESS_START_DT")));
			data.setProcessEndDt(String.valueOf(logRow.get("PROCESS_END_DT")));
			data.setProcessStatus(String.valueOf(logRow.get("PROCESS_STATUS")));
			if (logRow.get("ROW_CNT") == null) {
				data.setRowCnt(0);
				logger.info("log id: " + data.getLogId() + " ROW_CNT field is null, therefore set to 0");
			} else {
				data.setRowCnt(Integer.parseInt(String.valueOf(logRow.get("ROW_CNT"))));
			}
			data.setErrorMsg(String.valueOf(logRow.get("ERROR_MSG")));
			logList.add(data);
		}
		return logList;
	}

}
