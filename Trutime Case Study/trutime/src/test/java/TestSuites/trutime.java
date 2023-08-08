package TestSuites;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import Pages.TruTime;

public class trutime extends Base{
	TruTime ha= new TruTime();
	
	@BeforeTest
	public void invokeBrowser() {
		logger = report.createTest("Executing Test Cases");
		ha.invokeBrowser();
		reportPass("Browser is Invoked");
	}

	@Test(priority = 1)
	public void testCase1() throws Exception {
		ha.openURL();
		reportPass("Website opened successfully");
	}
	
	@Test(priority = 2)
	public void testCase2() throws Exception {
		ha.login();
		reportPass("Login done successfully");
	}
	
	@Test(priority = 3)
	public void testCase3() throws Exception {
		ha.getData();
		reportPass("Date and month are validated successfully");
	}

	@AfterTest
	public void closeBrowser() throws IOException {
		ha.endReport();
		ha.closeBrowser();
		reportPass("Browser is closed successfully");
	}
}
