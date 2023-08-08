package util;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ReusableMethod {
	WebDriver driver;
	public ReusableMethod(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//getting the website URL
	public void getTheURL()
	{
		//get the url of given application
		driver.get("https://www.pepperfry.com/");
		//maximize the browser window
		driver.manage().window().maximize();
	}
	
	//closing the notification
	public void closePopup() throws InterruptedException
	{	
		//Waiting for the element to be visible
		Thread.sleep(7000);
		new Actions(driver).moveByOffset(1,1).click().build().perform();
	}
	
	//validating the website title
	public void validateTitle()
	{
		//declaring the expected title
		String expectedTitle = "Online Furniture Shopping Store: Shop Online in India for Furniture, Home Decor, Homeware Products @ Pepperfry";
        
		//finding the actual title
		String actualTitle = driver.getTitle();
		
		//Checking if both titles are same or not
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Title validated: " + actualTitle);
        } else {
            System.out.println("Title validation failed: " + actualTitle);
        }
	}
	
	//selecting furnitures and benches
	public void select()
	{	
		//Finding element "Furniture" using linkText locator and clicking on it
		WebElement furnitureLink = driver.findElement(By.linkText("Furniture"));
        furnitureLink.click();
        System.out.println("Selected Furniture!");
        
        //Waiting explicitly for the element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Settees & Benches")));
        
		//Finding element "Settees & Benches" using linkText locator and clicking on it
		WebElement setbenchesLink = driver.findElement(By.linkText("Settees & Benches"));
        setbenchesLink.click();
        
        //Waiting explicitly for the element
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"clip-heder-desktop\"]/div/owl-carousel-o/div/div[1]/owl-stage/div/div/div[3]/pf-clip-category-list/div/a/div/div[1]")));
        
        //Finding element "Benches" using xpath locator and clicking on it
        WebElement benchesLink = driver.findElement(By.xpath("//*[@id=\"clip-heder-desktop\"]/div/owl-carousel-o/div/div[1]/owl-stage/div/div/div[3]/pf-clip-category-list/div/a/div/div[1]"));
        benchesLink.click();
        System.out.println("Selected Benches!");
	}
	
	//Displaying the total number of benches
    public void displayTotalBenches() throws ParseException, InterruptedException
    {
        Thread.sleep(3000);
    	//Finding the text containing total number of benches using xpath
        String totbenches=driver.findElement(By.xpath("//*[@id=\"clip-heder-desktop\"]/div/owl-carousel-o/div/div[1]/owl-stage/div/div/div[2]/pf-clip-category-list/div/a/div/div[2]")).getText();
        
        //Extracting integer out of the above string
        int numberofbecnhes =((Number)NumberFormat.getInstance().parse(totbenches)).intValue();
        System.out.println("Total number of benches are: "+numberofbecnhes);
     }
        
     //checking whether the number of metal benches is more than one or not
     public void metalBenchescount() throws ParseException
     {
        //Finding element "Material" using id locator and clicking on it
        WebElement material = driver.findElement(By.id("Material"));
        material.click();
        
        //Waiting explicitly for the element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/main/app-category/pf-clip/div/div[1]/div[3]/pf-clip-filter/div[2]/pf-clip-filter-drawer/div/pf-drawer/div/div[2]/div/div[1]/div[2]/pf-accordion/div/div/accordion/div/accordion-group[1]/div/div[2]/div/div/div/div[3]/span[2]")));
        
        //Finding the text containing total number of metal benches using xpath
        String metal=driver.findElement(By.xpath("/html/body/app-root/main/app-category/pf-clip/div/div[1]/div[3]/pf-clip-filter/div[2]/pf-clip-filter-drawer/div/pf-drawer/div/div[2]/div/div[1]/div[2]/pf-accordion/div/div/accordion/div/accordion-group[1]/div/div[2]/div/div/div/div[3]/span[2]")).getText();
        
        //Extracting integer out of the above string
        int numberofmetal = Integer.parseInt(metal.replaceAll("[^0-9]",""));
        
        //checking if the number of benches is more than 1 or not
        if(numberofmetal>1)
        {
        	System.out.println("Number of metal benches is more than 1!");
        }
        else
        {
        	System.out.println("There are no or only one metal bench!");
        }
	}
        
    //closing the browser
	public void close()
	{
		driver.quit();
	}
}