package au.edu.rmit.its.rpt_checker;

import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import au.edu.rmit.its.rpt_checker.model.DataExtractionLog;
import au.edu.rmit.its.rpt_checker.spring.jdbc.dao.DataExtractionLogDAO;

/**
 * Basic app with bundle and logger.
 *
 */
public class App {
	private static final ResourceBundle myResources = ResourceBundle.getBundle("ResourceBundle");
	private final static Logger logger = Logger.getLogger(App.class);

	public static void main(String[] args) {
		System.out.println(myResources.getString("property.key"));
		logger.info("in main App");

		// Get the Spring Context
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

		DataExtractionLogDAO dataExtractionLogDAO = ctx.getBean("dataExtractionLogDAOJDBCTemplate", DataExtractionLogDAO.class);

		// Get All
		List<DataExtractionLog> logList = dataExtractionLogDAO.getAll();
		System.out.println(logList);
		
		logger.info("number of rows:" + logList.size());

		// Close Spring Context
		ctx.close();
	}
}
