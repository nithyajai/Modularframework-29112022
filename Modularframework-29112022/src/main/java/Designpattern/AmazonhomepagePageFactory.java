package Designpattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonlibs.implementation.CommonElement;
import commonlibs.implementation.Dropdowncontrol;

public class AmazonhomepagePageFactory {

	@CacheLookup
	@FindBy(id="twotabsearchtextbox")	
	private WebElement searchbox;
	
	@CacheLookup
	@FindBy(id="searchDropdownBox")	
	private WebElement searchcategory;

	@CacheLookup	
	@FindBy(xpath="//input[@value='Go']")		
	private WebElement searchbutton;
	
	@FindBy(xpath="//span[contains(text(),'results for')]")	
	private WebElement searchResults;
	
	private CommonElement elementcontrol;
	private Dropdowncontrol dropdowncontrol;
		
	public AmazonhomepagePageFactory(WebDriver driver) {
		
	 PageFactory.initElements(driver,this);
		
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
