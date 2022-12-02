package commonlibs.utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitutils {

	public static void waitForSeconds(int timeoutInseconds) throws Exception
	{
	Thread.sleep(timeoutInseconds*1000);	
	}
	public static void waitTillAlertIsPresent(WebDriver driver,Duration timeoutInseconds)throws Exception 
	{
		
	
		WebDriverWait wait=new WebDriverWait(driver,timeoutInseconds);
		
		wait.until(ExpectedConditions.alertIsPresent());
	}
	public static void waitTillElementIsVisible(WebDriver driver,WebElement element,Duration timeoutInseconds)throws Exception 
		{
			WebDriverWait wait=new WebDriverWait(driver,timeoutInseconds);

			wait.until(ExpectedConditions.visibilityOf(element));
		
		}
		public static void waitTillElementIsClickable(WebDriver driver,WebElement element,Duration timeoutInseconds)throws Exception 
			{
				WebDriverWait wait=new WebDriverWait(driver,timeoutInseconds);

				wait.until(ExpectedConditions.elementToBeClickable(element));
			}
		public static void waitTillElementIsSelectable(WebDriver driver,WebElement element,Duration timeoutInseconds)throws Exception 
		{
			WebDriverWait wait=new WebDriverWait(driver,timeoutInseconds);

			wait.until(ExpectedConditions.elementToBeSelected(element));
		}
			
}
