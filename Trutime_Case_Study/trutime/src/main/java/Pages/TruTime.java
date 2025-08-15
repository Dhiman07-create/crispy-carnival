package Pages;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Base.Base;

public class TruTime extends Base {
	
	// xpaths for webelements
	By acc = By.xpath("//*[@id=\"O365_MainLink_Me\"]/div/div[2]");
	By userName = By.xpath("//*[@id=\"mectrl_currentAccount_primary\"]");
	By userEmail = By.xpath("//*[@id=\"mectrl_currentAccount_secondary\"]");
	By oneC = By.xpath("//div[@title='OneCognizant']");
	By onecBlock = By.xpath("//*[@id='spPageCanvasContent']/div/div/div/div/div/div[2]/div/div");
	By truTime = By.xpath("(//div[@class='appsResultText'])[1]");
	By searchBtn = By.xpath("//input[@id='oneC_searchAutoComplete']");
	By legends = By.xpath("//div[@class='legendsList ng-scope']");
	By date = By.xpath("//div[@class='dayDetail ng-scope']/div[1]");
	By dateBlock = By.xpath("//div[@class='ui-datepicker-title']");
	By valMonth = By.xpath("//span[@class='ui-datepicker-month']");

	// method for login
	public void login() {
		// creating a test in extentreport
		logger = report.createTest("Verify login into Be.Cognizant.");
		try {
			// Thread.sleep(1000);
			reportPass("Email and Password verified successfully");
			System.out.println("Driver is Setup");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			Thread.sleep(6000);
			driver.findElement(acc).click();

			// Geting the username
			String name = driver.findElement(userName).getText();

			// Getting the useremail
			String email = driver.findElement(userEmail).getText();
			System.out.println("Name: " + name);
			System.out.println("Email: " + email);
			System.out.println("-----------------------------------------------");
			Thread.sleep(2000);

			// capturing screenshot of account
			Screenshot("Account");
			reportPass("Be.Cognizant Page is reached successfully");

		} catch (Exception e) {
			reportFail(e.getMessage());
		}
	}

	// navigating to OneCognizant page
	public void getData() throws ParseException {
		logger = report.createTest("Verify obtaining the week from Trutime");
		List<WebElement> dates = new ArrayList<WebElement>();
		try {
			driver.findElement(onecBlock).click();
			driver.findElement(oneC).click();

			// handiling multiple windows
			Set<String> handles = driver.getWindowHandles();
			Iterator<String> itr = handles.iterator();
			String parentWindow = driver.getWindowHandle();
			while (itr.hasNext()) {
				String childWindow = itr.next();
				if (!parentWindow.equals(childWindow)) {
					driver.switchTo().window(childWindow);
				}
			}
			Thread.sleep(5000);
			
			// Navigating to trutime
			WebElement search = driver.findElement(searchBtn);
			search.click();
			search.sendKeys(prop.getProperty("search2"));
			// Thread.sleep(2000);
			driver.findElement(truTime).click();
			driver.switchTo().frame("appFrame");
			
			// creating a excel file and storing dates in excel file
			file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Data.xlsx");
			workbook = new XSSFWorkbook();
			sh = workbook.createSheet("Dates");
			// Thread.sleep(2000);
			Screenshot("Trutime");
			dates = driver.findElements(date);
			Date date = new Date();
			// printing todays date
			System.out.println("Today's Date is: " + date.toString());
			System.out.println("-----------------------------------------------");
			// printing dates of the week
			System.out.println("The Dates for this week are: ");
			System.out.println("-----------------------------------------------");
			for (int i = 0; i < dates.size(); i++) {
				sh.createRow(i).createCell(1).setCellValue(dates.get(i).getText());
				System.out.println(dates.get(i).getText());

				if (dates.get(i).getText().contains("Sun")) {
					System.out.println("This Weeks Sunday is: " + dates.get(i).getText());
				}
				if (dates.get(i).getText().contains("Sat")) {
					System.out.println("This Weeks Saturday is: " + dates.get(i).getText());
				}
			}
			reportPass("The dates are obtained successfully");
		} catch (Exception e) {
			reportFail(e.getMessage());
		}
		
		// comparing the dates of system calendar with trutime
		logger = report.createTest("Verify validating the system calendar and Trutime");
		Calendar now = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM");
		List<String> days = new ArrayList<String>();
		int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 1; // add 2 if your week start on Monday
		now.add(Calendar.DAY_OF_MONTH, delta);
		for (int i = 0; i < 7; i++) {
			days.add(format.format(now.getTime()));
			now.add(Calendar.DAY_OF_MONTH, 1);
		}
		System.out.println("================================");
		System.out.println("System Format\tTruTime Format");
		System.out.println("================================");
		for (int i = 0; i < 7; i++) {
			System.out.println(days.get(i) + "\t" + dates.get(i).getText());
			reportPass("The system dates are obtained sucessfully");
		}

		// Printing the legends information
		logger = report.createTest("Verify obtaining legends and month");
		List<WebElement> legend = driver.findElements(legends);
		System.out.println("Legends are: ");
		for (WebElement l : legend) {
			System.out.println(l.getText());
			reportPass("The legends are obtained successfully");
		}

		// displaying the month and calendar present on trutime
		List<WebElement> system_date = driver.findElements(dateBlock);
		System.out.print("Month and year displayed on Screen : ");
		for (WebElement date : system_date) {
			System.out.print(date.getText() + "\t");
			reportPass("month obtained successfully");
		}
		System.out.println();

		// Validating the topup date
		logger = report.createTest("Verify validating the Topup date");
		Calendar cal = Calendar.getInstance();
		System.out.println("Current Date = " + cal.getTime());
		// decrementing days by 15
		cal.add(Calendar.DATE, -15);
		String truTimeValidity = cal.getTime().toString();
		String[] split = truTimeValidity.split(" ");
		System.out.println("You can apply for backdated TopUp only until: " + split[0] + ", " + split[2] + " " + split[1]);
		reportPass("topup date validated");

		logger = report.createTest("Verify validating the month with system calendar");
		String value = driver.findElement(valMonth).getText();

		// validating the month in system calendar with trutime
		LocalDate currentDate = LocalDate.now();
		String MonthName = currentDate.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());

		// Print the current month name
		System.out.println("Current Month: " + MonthName);
		if (value.contains(MonthName)) {
			System.out.println("Current month from system and app matched : Month = " + MonthName);
			reportPass("Month validated with system calendar");
		}
	}
}
