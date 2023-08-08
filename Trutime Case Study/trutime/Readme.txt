*****************************************************PROJECT DESCRIPTION*****************************************************************
                                                    [QEA23QE004-Trutime]
                                                 
Team members
Dhiman Dasgupta - 2272789
Sriram S - 2272783
Indra Kumar M  - 2272779
Srivatsa Datta C - 2272791
Dhriti Nishad - 2272792


Problem Statement : To check the present week dates in Truetime
1.Login into Be.cognizant
2.Verify the user name
3.Search for Trutime in Be Cognizant Home page
4.Open Trutime App home page  

Detailed Description: Main Project

1.Login into Be.cognizant using valid credentials
2.Verify that the user name is correct
3.Take a screenshot of our profile page
4.Print the name of account in Be Cognizant Home Page
5.Search for Trutime in search box
6.Click on Trutime Application
7.Navigate to the Trutime page
8.Print today's date from trutime
9.Print the dates of present week from Trutime
10.Print starting and Ending dates of the week
11.Compare the dates of system calender with trutime
12.Print the Legend details
13.Month verification in Trutime
14.Close the Browser


Key Automation Scope:

Navigate to Be Cognizant.com page
Navigate to Trutime application
Printing all the dates of present week


**********************************************************STEPS TO EXECUTE*************************************************************

-unzip the folder
-On eclipse, goto file->open file->select the directory->click on directory-> click on finish
-Copy the same version of chrome.exe driver present in the PC in the Driver folder.
-Copy the same version of microsoftedge.exe driver present in the PC in the Driver folder.
-Copy the same version of geckodriver.exe driver present in the PC in the Driver folder. 
-Now go to the TestNG.xml file and run as TestNGSuite.
-Now the file will Execute and we get the expected output as shown below.

*******************************************************FILES DESCRIPTION**************************************************************

1.src/main/java - There are three packages present in this folder.
     ->Property:In this package we have config.properties. In this File we have to give from user to use which browser chrome/firefox/microsoftedge etc. 
     ->Base:In this package we have Base.java is our main project file in which we Firstly invoke the selected browser and 
          Open the Be.cognizant page (https://be.cognizant.com/),reusable method for list & count and closing the browser
     ->Pages:In this package we have 1 Class Trutime.java which extends base.java where the methods are present which will login to the 
           page by scanning the otp in the console and then print all the dates of the present week in the console.
     ->Utils:In this package we have class ExtentReportManager which is used for extent reports.
2.src/test/java- There are two files are there in this folder.
     ->TestSuites:In this package there is one class trutime.java which extends base.java class in this all the methods are under testng annotations.
     ->test.xml - In this file, the test classes are defined
3.JRE System Library: In this File we have all dependencies of JAR.files.         
4.Maven Dependencies: In this File we have all the directory on the local machine, where all the project artifacts are stored. when a Maven build is executed,
  Maven automatically downloads all the dependency jars into the local repository. Usually, this directory is named.
5.Drivers- In this folder, the chorme driver,microsoftedge and gecko driver are present
6.src/test/resources: It contains an Excel file Data.xlsx
7.ScreenShot:There are two images- Account.png,Trutime.png.
8.Report:In this folder reports.html is present.
9.test-output:In this folder 3 files are there
10.pom.xml: The pom.xml file contains information of project and configuration information for the maven to build the project such as dependencies,
   build directory, source directory, test source directory, plugin, goals etc. Maven reads the pom.xml file, then executes the goal.

 
***************************************************************************************************************************************

                                                        OUTPUT ON CONSOLE

***************************************************************************************************************************************

Driver is Setup
Name: Dasgupta, Dhiman (Contractor)
Email: 2272789@cognizant.com
****************
Today's Date is: Thu Jul 13 09:31:42 IST 2023
****************
The Dates for this week are:
****************
Sun, 09 Jul
This Weeks Sunday is: Sun, 09 Jul
Mon, 10 Jul
Tue, 11 Jul
Wed, 12 Jul
Thu, 13 Jul
Fri, 14 Jul
Sat, 15 Jul
This Weeks Saturday is: Sat, 15 Jul
================================
System Format	TruTime Format
================================
Sun, 09 Jul	Sun, 09 Jul
Mon, 10 Jul	Mon, 10 Jul
Tue, 11 Jul	Tue, 11 Jul
Wed, 12 Jul	Wed, 12 Jul
Thu, 13 Jul	Thu, 13 Jul
Fri, 14 Jul	Fri, 14 Jul
Sat, 15 Jul	Sat, 15 Jul
Legends are:
 Data Porting   10+Hrs   9-10Hrs   7-9Hrs   <7Hrs   NoTimeLog   Holiday   Leave   HalfDayLeave   Travel   ClientHoliday   ClientLocation   Approved   Rejected   Pending
Month and year displayed on Screen :July 2023	
Current Date = Thu Jul 13 09:31:42 IST 2023
You can apply for backdated TopUp only until: Wed, 28 Jun
Current Month: July
Current month from system and app matched : Month = July
PASSED: testCase3
PASSED: testCase1
PASSED: testCase2

===============================================
    Default test
    Tests run: 3, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 3, Passes: 3, Failures: 0, Skips: 0
===============================================
