package demodesignpattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Designpattern.AmazonhomepagePageFactory;
import commonlibs.implementation.CommonDriver;

public class AmazonHomepagePageFactorytest {

CommonDriver cmndriver;

AmazonhomepagePageFactory homepage;

String url="https://www.amazon.in/";

WebDriver driver;

@BeforeClass
public void invokebrowser()throws Exception
{
cmndriver=new CommonDriver("chrome");	

cmndriver.setPageloadTimeout(60);

cmndriver.setElementDetectionTimeout(10);

cmndriver.navigateToFirstUrl(url);

driver=cmndriver.getDriver();

homepage=new AmazonhomepagePageFactory(driver);
}
@Test
public void searchproduct()throws Exception
{
String product="iPhone"	;
String category="Electronics";

homepage.searchproduct(product, category);

}

@AfterClass
public void closebrowser()throws Exception
{
	cmndriver.closeAllBrowser();
}
	
			
}
