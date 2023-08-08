package Pages;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class Test1 extends Base{
	
	//locators for webelements on main page
	By search=By.xpath("//*[@id='rendered-content']/div/header/div/div/div/div[1]/div[3]/div/form/div/div/div[1]/div[1]/input");
	By levelcheckbox=By.xpath("/html/body/div[2]/div/div/main/div[2]/div/div/div/div/div[1]/div/div/div/div[4]/div/div/div[1]/label/span/span/input");
	By languagecheckbox=By.xpath("/html/body/div[2]/div/div/main/div[2]/div/div/div/div/div[1]/div/div/div/div[8]/div[1]/div[2]/div[3]/label/span/span/input");	
	By courseno=By.xpath("/html/body/div[2]/div/div/main/div[2]/div/div/div/div/div[2]/div[1]/div/div/h2/div/span");
	By courseone=By.xpath("/html/body/div[2]/div/div/main/div[2]/div/div/div/div/div[2]/ul/li[1]/div/a");
	By name1=By.xpath("/html/body/div[2]/div/main/section[2]/div/div/div[1]/div[1]/section/h1");
	By hour1=By.xpath("//*[@id='courses']/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/span[3]/span");
	By rat1=By.xpath("/html/body/div[2]/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]");
	By coursetwo=By.xpath("/html/body/div[2]/div/div/main/div[2]/div/div/div/div/div[2]/ul/li[2]/div/a");
	By name2=By.xpath("/html/body/div[2]/div/main/section[2]/div/div/div[1]/div[1]/section/h1");
	By hour2=By.xpath("//*[@id=\"courses\"]/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/span[3]/span");
	By rat2=By.xpath("/html/body/div[2]/div/main/section[2]/div/div/div[2]/div/div/section/div[2]/div[1]/div[1]");
	By extend=By.xpath("/html/body/div[2]/div/div/main/div[2]/div/div/div/div/div[1]/div/div/div/div[8]/div[2]/button/span");
	By lang=By.xpath("//*[@id=\"checkbox-group\"]/div");
	By lev=By.xpath("//*[@id=\"rendered-content\"]/div/div/main/div[2]/div/div/div/div/div[1]/div/div[4]/div/div/div");
	//locators for webelements on enterprise section
	By ent1=By.xpath("//*[@id=\"ComponentLink~cf45c40898de596c6f68d1ba32cd81b9\"]");
	By ent2=By.xpath("//*[@id=\"rendered-content\"]/div/div/div[2]/footer/div/div/div/div[5]/ul/li[10]/a");
	By sales=By.xpath("//*[@id=\"rendered-content\"]/div/div/div[1]/div/header/div[2]/div[1]/div/div/div/div[3]/div/a");
	By fname=By.id("FirstName");
	By lname=By.id("LastName");
	By emailid=By.id("Email");
	By cname=By.id("db_company_name__c");
	By jrole=By.id("jobRole");
	By jtitle=By.id("C4C_Job_Title__c");
	By ph=By.id("Phone");
	By erange=By.id("Employee_Range__c");
	By selfrep=By.id("Self_reported_employees_to_buy_for__c");
	By nat=By.id("Country");
	By sub=By.xpath("//*[@id=\"mktoForm_2666\"]/div[53]/span/button");
	By err=By.id("ValidMsgEmail");
	
	//method to search web development and fetch name, rating and hours of first two courses
	public void Method1() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,60);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String mainwindow=driver.getWindowHandle();
		
		//Searching for "Web Development" courses
		WebElement wb=driver.findElement(search);
		wb.sendKeys("Web Development");
		wb.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		Set<String> handles;
	
		//Number of "Web Development" courses available
		WebElement text=driver.findElement(courseno);
		String texts[]=text.getText().split(" ");
		System.out.println("Available Web development courses are "+texts[0]);
	
		//Clicking on the checkbox of Beginner
		Thread.sleep(2000);
		WebElement checkbox=driver.findElement(levelcheckbox);
		checkbox.click();
		
		//Clicking on the checkbox of English
		Thread.sleep(2000);
		WebElement checkbox2=driver.findElement(languagecheckbox);
		checkbox2.click();
		Thread.sleep(5000);
		System.out.println("===========================================================\n");
		Thread.sleep(1000);
		//waiting for the courses to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(courseone));

		//Click on the first course to get the course name, course hours and rating
		WebElement link1=driver.findElement(courseone);
		jse.executeScript("arguments[0].click()", link1);
		handles=driver.getWindowHandles();
		for(String handle:handles){
		driver.switchTo().window(handle);
		}
		
		//printing name of the first course
		String course1=driver.findElement(name1).getText();
		System.out.println("Course1 name : "+course1);
		
		//calculating total number of hours of the first course
		List<WebElement> hours;
		hours=driver.findElements(hour1);
		int i=0,sum=0;
		int s=hours.size();
		int[] hourInNum=new int[s];
		for(WebElement hour:hours) {
		String hoursplits[]=hour.getText().split(" ");
		hourInNum[i]=Integer.parseInt(hoursplits[0]);
		sum=sum+hourInNum[i];
		i++;
		}
		System.out.println("Total hours for "+course1+ ": "+sum+" hours");
		
		//printing rating of the first course
		String rating1=driver.findElement(rat1).getText();
		System.out.println(course1+" rating is "+rating1);
		System.out.println("=========================================================\n");
		driver.switchTo().window(mainwindow);
		Thread.sleep(4000);
		
		//Click on the second course to get the course name, course hours and rating
		WebElement link2=driver.findElement(coursetwo);
		jse.executeScript("arguments[0].click()",link2);
		handles=driver.getWindowHandles();
		for(String handle:handles){
		driver.switchTo().window(handle);
		}
		Thread.sleep(4000);
		//printing name of the second course
		String course2=driver.findElement(name2).getText();
		System.out.println("Course2 name : "+course2);
		
		//calculating total number of hours of the second course
		hours=driver.findElements(hour2);
		sum=0;
		i=0;
		for(WebElement hour:hours) {
		String hoursplits[]=hour.getText().split(" ");
		hourInNum[i]=Integer.parseInt(hoursplits[0]);
		sum=sum+hourInNum[i];
		i++;
		}
		System.out.println("Total hours for "+course2+ ": "+sum+" hours");
		
		//printing rating of the second course
		String rating2=driver.findElement(rat2).getText();
		System.out.println(course2+" rating is "+rating2);
		System.out.println("=========================================================\n");
		driver.switchTo().window(mainwindow);
		Thread.sleep(1000);
		
		//printing all available languages
		WebElement showmore=driver.findElement(extend);
		showmore.click();
		List<WebElement> languages=driver.findElements(lang);
		System.out.println("Number of available languages : "+languages.size());
		System.out.println("Available languages are : ");
		for(WebElement language:languages) {
			System.out.println(language.getText());
		}
		//closing the language frame
		new Actions(driver).moveByOffset(1,1).click().build().perform();
		System.out.println("==========================================================\n");
	
		//printing all available levels
		List<WebElement>levels=driver.findElements(lev);
		System.out.println("Number of available levels : "+levels.size());
		System.out.println("Available levels are : ");
		for(WebElement level:levels) {
			System.out.println(level.getText());
		}
		System.out.println("==========================================================\n");
		}

	//method to navigate to enterprise section, send required values and fetch the error message
	public void enterprise() throws InterruptedException {
		driver.findElement(ent1).click();
		Thread.sleep(2000);
		driver.findElement(ent2).click();
		Thread.sleep(2000);
		driver.findElement(sales).click();
		Thread.sleep(1000);
		//finding the input elements and sending the rquired values
		driver.findElement(fname).sendKeys("Dhiman");
		driver.findElement(lname).sendKeys("Dasgupta");
		driver.findElement(emailid).sendKeys("abc123");
		WebElement cn=driver.findElement(cname);
		cn.clear();
		cn.sendKeys("Cognizant");
		//selecting required values from the dropdown menu
		Select jr=new Select(driver.findElement(jrole));
		jr.selectByVisibleText("Manager");
		Select jf=new Select(driver.findElement(jtitle));
		jf.selectByVisibleText("Analytics");
		driver.findElement(ph).sendKeys("+919999000012");
		Select cs=new Select(driver.findElement(erange));
		cs.selectByVisibleText("501-1000");
		Select enl=new Select(driver.findElement(selfrep));
		enl.selectByVisibleText("5001+");
		Select country=new Select(driver.findElement(nat));
		country.selectByVisibleText("India");
		driver.findElement(sub).click();
		//finding and printing the error message
		String errorMsg=driver.findElement(err).getText();
		System.out.println("Error message is : "+errorMsg);
		System.out.println("==========================================================\n");
	}
}
