package commonlibs.implementation;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import commonlibs.contracts.IwindowHandle;

public class windowControl implements IwindowHandle{

	private WebDriver driver;
	public windowControl(WebDriver driver)
	{
		this.driver=driver;
	}
	@Override
	public void switchToAnyWindow(String windowhandle) throws Exception {

		driver.switchTo().window(windowhandle);
	}

	@Override
	public void switchToAnyWindow(int childWindowIndex) throws Exception {

		String childWindowHandle=driver.getWindowHandles().toArray()[childWindowIndex].toString();
		
		driver.switchTo().window(childWindowHandle);
	}

	@Override
	public String getwindowHandle() throws Exception {

		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getwindowHandles() throws Exception {

		return driver.getWindowHandles();
	}

}
