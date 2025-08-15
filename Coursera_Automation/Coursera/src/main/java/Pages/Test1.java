package Pages;

 

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

 

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

 

import com.google.common.io.Files;

 

import Base.Base;

 

public class Test1 extends Base{

	//locators for webelements(Page Object Model)
	By sofanseat=By.xpath("//a[@name=\"Sofas & Seating\"]");
	By ofcchair=By.xpath("(//a)[56]");
	By more=By.xpath("(//span)[43]");
	By brand=By.xpath("(//h4)[1]");
	By godrej=By.xpath("//label[@for=\"Godrej Interio\"]");
	By price=By.xpath("(//h4)[2]");
	By priceplace=By.xpath("//input[@formcontrolname=\"inputMax\"]");
	By apply=By.xpath("(//button)[8]");
	By chairone=By.xpath("/html/body/app-root/main/app-category/pf-clip/div/div[2]/pf-clip-product-listing/div[1]/pf-scroller/div/div/div[1]/div/pf-clip-product-card/div/div[1]/div[1]/a");
	By cname1=By.xpath("//h1");
	By cprice1=By.xpath("(//span)[46]");
	By buynow=By.xpath("(//button[@type='undefined'])[6]");
	By login=By.xpath("/html/body/app-root/section/main/pf-cart/section/div/div/div[2]/section/div[2]/section/div/pf-button/button");
	By email=By.xpath("(//input)[2]");
	By submit=By.xpath("(//button)[3]");	
	By otp=By.xpath("(//input)[3]");
	By submit1=By.xpath("(//button)[3]");
	By errmsg=By.xpath("(//error-message)[2]");
	By chairtwo=By.xpath("/html/body/app-root/main/app-category/pf-clip/div/div[2]/pf-clip-product-listing/div[1]/pf-scroller/div/div/div[2]/div/pf-clip-product-card/div/div[1]/div[1]/a");
	By cname2=By.xpath("//h1");
	By cprice2=By.xpath("(//span)[46]");
	By cart=By.xpath("(//button[@type='undefined'])[5]");

public void launch() throws InterruptedException, IOException {

	WebDriverWait wait=new WebDriverWait(driver,30);
	JavascriptExecutor jse=(JavascriptExecutor)driver;

	//using apache poi to read data from excel sheet
	FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Data.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fs);
	XSSFSheet sheet=workbook.getSheetAt(0);
	Row row=sheet.getRow(0);
	Cell cell=row.getCell(0);
	cell.setCellType(Cell.CELL_TYPE_STRING);
	String cellval=cell.getStringCellValue();

	//closing popup
	Thread.sleep(6000);
	new Actions(driver).moveByOffset(1, 1).click().build().perform();

	//getting title of the webpage and using assert to verify it
	String actualtitle=driver.getTitle();
	String expectedtitle="Online Furniture Shopping Store: Shop Online in India for Furniture, Home Decor, Homeware Products @ Pepperfry";
	Assert.assertEquals(expectedtitle,actualtitle);

	//clicking on sofa -> office chairs and applying filters
	driver.findElement(sofanseat).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(ofcchair));
	driver.findElement(ofcchair).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(more));
	WebElement more1=driver.findElement(more);
	jse.executeScript("arguments[0].click()", more1);
	wait.until(ExpectedConditions.visibilityOfElementLocated(brand));
	driver.findElement(brand).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(godrej));
	WebElement godrej1=driver.findElement(godrej);
	jse.executeScript("arguments[0].click()", godrej1);
	wait.until(ExpectedConditions.visibilityOfElementLocated(price));
	//implemented explicit wait
	WebElement price1=driver.findElement(price);
	jse.executeScript("arguments[0].click()", price1);
	driver.findElement(priceplace).clear();
	driver.findElement(priceplace).sendKeys(cellval);
	driver.findElement(apply).click();
	jse.executeScript("window.scrollBy(0,650)", "");
	workbook.close();
}

 

public void chair1() throws InterruptedException, IOException {

	//using apache poi to read data from excel sheet
	WebDriverWait wait=new WebDriverWait(driver,30);
	JavascriptExecutor jse=(JavascriptExecutor)driver;
	FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Data.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fs);
	XSSFSheet sheet=workbook.getSheetAt(0);
	Row row=sheet.getRow(0);
	Row row1=sheet.getRow(1);
	Row row2=sheet.getRow(2);
	Cell cell=row.getCell(0);
	Cell cell1=row1.getCell(0);
	Cell cell2=row2.getCell(0);
	cell.setCellType(Cell.CELL_TYPE_STRING);
	cell1.setCellType(Cell.CELL_TYPE_STRING);
	cell2.setCellType(Cell.CELL_TYPE_STRING);
	String cellval=cell.getStringCellValue();
	String cellval1=cell1.getStringCellValue();
	String cellval2=cell2.getStringCellValue();
	String mainwindow=driver.getWindowHandle();
	//implementing fluent wait
	Wait<WebDriver> fluent=new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5));

	//clicking on the first chair and printing name and price
	String l = Keys.chord(Keys.CONTROL,Keys.ENTER);
	driver.findElement(chairone).sendKeys(l);
	Set<String> handles;
	handles=driver.getWindowHandles();
	for(String handle:handles) {
	driver.switchTo().window(handle);
	}
	WebElement abc=fluent.until(driver->driver.findElement(cname1));
	String chname=driver.findElement(cname1).getText();
	System.out.println("Chair-1 Name: "+chname);
	String chprice=driver.findElement(cprice1).getText();
	System.out.println("Chair-1 Price: "+chprice);

	//clicking on buy now and filling details to verify the error message
	driver.findElement(buynow).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(login));
	WebElement log=driver.findElement(login);
	jse.executeScript("arguments[0].click()", log);
	wait.until(ExpectedConditions.visibilityOfElementLocated(email));
	driver.findElement(email).sendKeys(cellval1);
	driver.findElement(submit).click();
	driver.findElement(otp).sendKeys(cellval2);
	driver.findElement(submit1).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(errmsg));
	String ermsg=driver.findElement(errmsg).getText();
	String expectedmsg="OTP Verification Failed. Please Try Again";
	Assert.assertEquals(expectedmsg,ermsg);
	driver.switchTo().window(mainwindow);
	workbook.close();
	System.out.println("==========================================================\n");
}

 

public void chair2() throws InterruptedException, IOException {
	//clicking on a different chair and printing name and price
	String l = Keys.chord(Keys.CONTROL,Keys.ENTER);
	driver.findElement(chairtwo).sendKeys(l);
	Set<String> handles;
	handles=driver.getWindowHandles();
	for(String handle:handles) {
		driver.switchTo().window(handle);
		}
	String chname2=driver.findElement(cname2).getText();
	System.out.println("Chair-2 Name: "+chname2);
	String chprice2=driver.findElement(cprice2).getText();
	System.out.println("Chair-2 Price: "+chprice2);
	WebElement cp2=driver.findElement(cprice2);
	Assert.assertTrue(cp2.isDisplayed());
	//verifying whether the price is displayed and adding it to the cart
	driver.findElement(cart).click();
	String ss="ss";
	//taking a screenshot of the webpage
	TakesScreenshot capture=(TakesScreenshot)driver;
	File srcFile=capture.getScreenshotAs(OutputType.FILE);
	File destfile=new File(System.getProperty("user.dir") + "/Screenshot/"+ ss + ".png");
	Files.copy(srcFile, destfile);
	System.out.println("==========================================================\n");
	}
}