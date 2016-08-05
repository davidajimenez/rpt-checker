package au.edu.rmit.its.rpt_checker.spring.jdbc.dao;

import java.util.List;

import au.edu.rmit.its.rpt_checker.model.DataExtractionLog;

public interface DataExtractionLogDAO {
	public List<DataExtractionLog> getAll();
}
