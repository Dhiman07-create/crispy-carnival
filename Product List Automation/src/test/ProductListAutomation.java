package test;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import util.ReusableMethod;
import util.DriverSetup;

public class ProductListAutomation {
	
	static WebDriver driver;
	
	public static void main(String[] args)throws InterruptedException, ParseException {
		// TODO Auto-generated method stub
		driver=DriverSetup.invokeBrowser("Chrome");
		ReusableMethod rMethod=new ReusableMethod(driver);
		System.out.println("---------------------------------------------");
		rMethod.getTheURL();
		rMethod.closePopup();
		rMethod.validateTitle();
		rMethod.select();
		rMethod.displayTotalBenches();
		rMethod.metalBenchescount();
		//rMethod.close();
		System.out.println("---------------------------------------------");
	}

}