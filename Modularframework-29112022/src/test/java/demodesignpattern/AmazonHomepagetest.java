package demodesignpattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Designpattern.Amazonhomepage;
import commonlibs.implementation.CommonDriver;

public class AmazonHomepagetest {

CommonDriver cmndriver;

Amazonhomepage homepage;

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

homepage=new Amazonhomepage(driver);
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
