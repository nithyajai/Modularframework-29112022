package Designpattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonlibs.implementation.CommonElement;
import commonlibs.implementation.Dropdowncontrol;

public class Amazonhomepage {

	private WebElement searchbox;
	
	private WebElement searchcategory;
	
	private WebElement searchbutton;
	
	private WebElement searchResults;
	
	private CommonElement elementcontrol;
	
	private Dropdowncontrol dropdowncontrol;
	
	public Amazonhomepage(WebDriver driver) {
		
		searchbox=driver.findElement(By.id("twotabsearchtextbox"));
		
		searchcategory=driver.findElement(By.id("searchDropdownBox"));
		
		searchbutton=driver.findElement(By.xpath("//input[@value='Go']"));
		
	   searchResults=driver.findElement(By.xpath("//span[contains(text(),'results for')]"));
		
		elementcontrol=new CommonElement();
		
		dropdowncontrol=new Dropdowncontrol();
		}

public void searchproduct(String product,String category)throws Exception
{
	elementcontrol.setText( searchbox,product);
	
	dropdowncontrol.selectViaVisibleText(searchcategory,category);
	
	elementcontrol.clickElement(searchbutton);
	
	System.out.println(elementcontrol.getText(searchResults));
}

}
