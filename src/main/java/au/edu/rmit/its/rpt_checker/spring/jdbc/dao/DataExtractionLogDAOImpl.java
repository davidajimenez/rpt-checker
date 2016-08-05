package au.edu.rmit.its.rpt_checker.spring.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import au.edu.rmit.its.rpt_checker.model.DataExtractionLog;

public class DataExtractionLogDAOImpl implements DataExtractionLogDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<DataExtractionLog> getAll() {
		String query = "select * from [DZ].[DATA_EXTRACTION_LOG]";
		List<DataExtractionLog> logList = new ArrayList<DataExtractionLog>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				DataExtractionLog data = new DataExtractionLog();
				data.setLogId(rs.getInt("LOG_ID"));
				data.setSourceLogId(rs.getInt("SOURCE_LOG_ID"));
				data.setSourceRunId(rs.getInt("SOURCE_RUN_ID"));
				data.setProcessName(rs.getString("PROCESS_NAME"));
				data.setProcessStartDt(rs.getString("PROCESS_START_DT"));
				data.setProcessEndDt(rs.getString("PROCESS_END_DT"));
				data.setProcessStatus(rs.getString("PROCESS_STATUS"));
				data.setRowCnt(rs.getInt("ROW_CNT"));
				data.setErrorMsg(rs.getString("ERROR_MSG"));
				logList.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return logList;
	}

}
