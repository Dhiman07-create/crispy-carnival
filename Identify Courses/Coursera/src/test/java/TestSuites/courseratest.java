package TestSuites;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.Base;
import Pages.Test1;

public class courseratest extends Base{
	Test1 t1= new Test1();
	
	@BeforeTest
	public void invokeBrowser() {
		logger = report.createTest("Executing Test Cases");

		t1.invokeBrowser();
		reportPass("Browser is Invoked");
	}

	@Test(priority = 1, description="Opening coursera website")
	public void testCase1() throws Exception {

		t1.openURL();
		reportPass("All steps passed successfully");
	}
	@Test(priority=2, description="Course check")
	public void testcase2() throws InterruptedException {
		t1.Method1();
		reportPass("All steps passed successfully");
	}
	@Test(priority=2, description="Enterprise testing")
	public void testcase3() throws InterruptedException {
		t1.enterprise();
		reportPass("All steps passed successfully");
	}

	@AfterTest
	public void closeBrowser() {
		reportPass("Browser is closed successfully");
		t1.endReport();
		t1.closeBrowser();
	}

}