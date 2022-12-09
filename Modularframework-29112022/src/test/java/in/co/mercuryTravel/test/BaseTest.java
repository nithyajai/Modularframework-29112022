package in.co.mercuryTravel.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonlibs.implementation.CommonDriver;
import commonlibs.implementation.screenshotcontrol;
import commonlibs.utils.ConfigFileUtils;
import commonlibs.utils.DateUtils;
import in.co.mercuryTravel.pages.HomePage;

public class BaseTest {

CommonDriver cmndriver;	

String browsertype="chrome";

String baseUrl;

HomePage homepage;

private WebDriver driver;

static String configFileName;

//within whole directory we will use
static Properties configProperties;

static String currentWorkingDirectory;
static String ExecutionStartDate;
int PageLoadTimeout;
int elementDetectionTimeout;

//Reports
static ExtentHtmlReporter htmlReporter;
static ExtentReports extent;
static ExtentTest extenttest;

String Reportfileneme;

String Screenshotfilename;
screenshotcontrol screenshotcontrol;


static{
	try {
	currentWorkingDirectory=System.getProperty("user.dir");
	
	ExecutionStartDate=DateUtils.getcurrentdatetime();
		
//Also write like this read it became easy to read
//%s -place holder will replace current working dir later on change anythingeasy from here   
	configFileName=String.format("%s/config/config.properties",currentWorkingDirectory);
	
//configFileName=currentWorkingDirectory+"/config/config.properties";
	configProperties=ConfigFileUtils.readproperties(configFileName);

} catch (Exception e) {
e.printStackTrace();}	
}

//Reports
@BeforeSuite
public void presetup()
{
	initializeReports();	
}


@BeforeClass
public void setup()throws Exception
{
invokebrowser()	;

getdriverInstance();

initializeApplicationpages();

initializescreenshotvariable();

}
@AfterClass
public void cleanup()throws Exception
{	
	closeALlBrowserInstances();

}
@AfterSuite
public void postcleanup()
{	
extent.flush();
}

@AfterMethod
public void aftermethod(ITestResult Result)throws Exception
{
String testcasename=Result.getName();

String Screenshotfilename=String.format("%s/screenshot/%s-%s.jpeg",currentWorkingDirectory,
		testcasename,ExecutionStartDate);

if(Result.getStatus()==ITestResult.SUCCESS)
{
	extenttest.log(Status.PASS,"Test Case Pass-"+testcasename);
}
else if(Result.getStatus()==ITestResult.FAILURE)
{	
	extenttest.log(Status.FAIL,"Test Case Fail-"+testcasename);	
		
	screenshotcontrol.captureAndSaveScreenshot(Screenshotfilename);
	//Attach screenshot to the report
    extenttest.addScreenCaptureFromPath(Screenshotfilename);
}
else 
{	
	extenttest.log(Status.SKIP,"Test Case Skipped-"+testcasename);	

}	
	
          }

private void initializeReports() {
	//.html - will be overrided for that %s.html-time where execution start
		Reportfileneme=String.format("%s/reports/MercuryTravelTestReports-%s.html",currentWorkingDirectory,
				ExecutionStartDate);

		htmlReporter=new ExtentHtmlReporter(Reportfileneme)	;

	     extent=new ExtentReports();

	     extent.attachReporter(htmlReporter);	
}
private void invokebrowser()throws Exception {
	extenttest=extent.createTest("Setup - setup the pre-requisit to run automated test cases");
	//It will read the property browsertype
	browsertype=configProperties.getProperty("browserType")	;

	extenttest.log(Status.INFO,"Browser INvoked Is"+browsertype);

	cmndriver=new CommonDriver(browsertype)	;
	
	PageLoadTimeout=Integer.parseInt(configProperties.getProperty("PageLoadTimeout"));

	extenttest.log(Status.INFO,"Pageload timeout set Is"+PageLoadTimeout);

	elementDetectionTimeout=Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));

	extenttest.log(Status.INFO,"Implicit wait timeout set Is"+elementDetectionTimeout);

	cmndriver.setPageloadTimeout(PageLoadTimeout);

	cmndriver.setElementDetectionTimeout(elementDetectionTimeout);

	baseUrl=configProperties.getProperty("baseurl");

	extenttest.log(Status.INFO,"BaseUrl where the browser navigate to"+baseUrl);
	
	cmndriver.navigateToFirstUrl(baseUrl);

}
private void getdriverInstance() {

	driver=cmndriver.getDriver();
	
}
private void initializeApplicationpages() {

	extenttest.log(Status.INFO,"Initialising All Pages");
	
	homepage=new HomePage(driver);

}
private void initializescreenshotvariable() {

	screenshotcontrol=new screenshotcontrol(driver);

}



//private void closeinitialmodalhomepage() {
	//homepage.closeinitialmodal();}


private void closeALlBrowserInstances()throws Exception {
	cmndriver.closeAllBrowser();

	extenttest=extent.createTest("Clean Up -Clean Process");

	extenttest.log(Status.INFO,"Closing ALl Browser Instance"+baseUrl);	
}


   }






