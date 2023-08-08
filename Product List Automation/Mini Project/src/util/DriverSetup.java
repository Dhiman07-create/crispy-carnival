package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverSetup {
	
	static WebDriver driver;
	
	//invoke browser
	public static WebDriver invokeBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("Chrome Browser launched!");
		}
		else if(browserName.equals("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "Drivers//msedgedriver.exe");
			driver=new EdgeDriver();
			System.out.println("Edge Browser launched!");
		}
		else
		{
			System.out.println("Invalid Browser!");
		}
		return driver;
	}
}