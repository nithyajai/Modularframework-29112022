package commonlibs.implementation;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commonlibs.contracts.IAlert;
import commonlibs.utils.waitutils;

public class AlertControl implements IAlert {

	private WebDriver driver;
	
	public AlertControl(WebDriver driver)
	{
		this.driver=driver;		
	}
	private Alert getAlert()
	{
		return driver.switchTo().alert();
	}
	@Override
	public void acceptAlert() throws Exception
	{
     getAlert().accept();	
     }

	@Override
	public void rejectAlert() throws Exception 
	{
    getAlert().dismiss();		
	}

	@Override
	public String getMessageFromAlert() throws Exception {
		// TODO Auto-generated method stub
		return getAlert().getText();
	}

	@Override
	public boolean checkAlertPresent(Duration timeoutInseconds) throws Exception {
	try {
		
		waitutils.waitTillAlertIsPresent(driver, timeoutInseconds);
		
		return true;
	    }
	catch (Exception e)
	  {
		return false;	
	  }

	}
	@Override
	public boolean checkAlertPresent(int timeoutInseconds) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
