package au.edu.rmit.its.rpt_checker;

import static org.junit.Assert.*;

import java.util.ResourceBundle;

import org.junit.Test;

/**
 * Unit test for rpt-checker main App.
 */
public class AppTest {
	ResourceBundle myResources = ResourceBundle.getBundle("ResourceBundle");

	@Test
	public void testApp() {
		System.out.println(myResources.getString("property.key"));
		assertTrue(true);
	}
}
