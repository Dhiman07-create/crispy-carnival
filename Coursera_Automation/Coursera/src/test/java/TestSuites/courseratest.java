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
		logger = report.createTest("Invoking browser");

 

		t1.invokeBrowser();
		reportPass("Browser is Invoked");
	}

 

	@Test(priority = 1, description="Opening pepperfry website")
	public void testCase1() throws Exception {
		logger = report.createTest("Opening Website");
		t1.openURL();
		reportPass("Website opened successfully");
	}
	@Test(priority=2, description="Selecting filters and products")
	public void testcase2() throws InterruptedException, IOException {
		logger = report.createTest("Selecting filters and products");
		t1.launch();
		reportPass("Filters selected successfully");
	}
	@Test(priority=3, description="Testing Buy Now functionality")
	public void testcase3() throws InterruptedException, IOException {
		logger = report.createTest("Testing Buy Now functionality");
		t1.chair1();
		reportPass("Buy now functionality working successfully");
	}

 

	@Test(priority=4, description="Testing add to cart functionality")
	public void testcase4() throws InterruptedException, IOException {
		logger = report.createTest("Testing add to cart functionality");
		t1.chair2();
		reportPass("Add to cart functionality working successfully");
	}

	@AfterTest
	public void closeBrowser() throws IOException {
		logger = report.createTest("Checking whether browser is closed");
		t1.endReport();
		t1.closeBrowser();
		reportPass("Browser is closed successfully");
	}
}