package in.co.mercuryTravel.pages;

import org.openqa.selenium.WebDriver;

import commonlibs.implementation.AlertControl;
import commonlibs.implementation.CommonElement;
import commonlibs.implementation.Dropdowncontrol;
import commonlibs.implementation.Framecontrol;
import commonlibs.implementation.MouseOperation;

public class BasePage {

	protected AlertControl alertcontrol;
	
	protected CommonElement elementcontrol;
	
	protected Dropdowncontrol dropdowncontrol;
	
	protected Framecontrol framecontrol;
	
	protected MouseOperation mousecontrol;
	
	public BasePage(WebDriver driver)
	{
	alertcontrol=new AlertControl(driver);
	
	elementcontrol=new CommonElement();
	
	dropdowncontrol=new Dropdowncontrol();
	
	framecontrol=new Framecontrol(driver);
		
	mousecontrol=new MouseOperation(driver);	
		
	}
	
	
}
