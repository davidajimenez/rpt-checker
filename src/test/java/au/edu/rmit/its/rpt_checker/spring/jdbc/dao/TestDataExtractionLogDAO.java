package au.edu.rmit.its.rpt_checker.spring.jdbc.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.edu.rmit.its.rpt_checker.model.DataExtractionLog;

public class TestDataExtractionLogDAO {
	
	ClassPathXmlApplicationContext ctx;
	DataExtractionLogDAO dataExtractionLogDAO;
	
	@Before
	public void initContext() {
		// Get the Spring Context
		ctx = new ClassPathXmlApplicationContext("spring.xml");

		dataExtractionLogDAO = ctx.getBean("dataExtractionLogDAOJDBCTemplate",
				DataExtractionLogDAO.class);
	}	

	@Test
	public void testListAll() {
		List<DataExtractionLog> logList = dataExtractionLogDAO.getAll();
		assertTrue(logList.size() >0);
	}
		
	@After
	public void closeContext() {
		ctx.close();
	}
}
