package commonlibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonlibs.contracts.IJavascriptOperations;

public class JavascriptControl implements IJavascriptOperations {

	private JavascriptExecutor jsEngine;
	
	public JavascriptControl(WebDriver driver)
	{
		jsEngine=(JavascriptExecutor)driver;
		
	}
	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {
     
		jsEngine.executeScript(scriptToExecute);
		
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {

		String jscommand=String.format("window.scrollBy(%d,%d)",x,y);
				
		jsEngine.executeScript(jscommand);
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {

		return jsEngine.executeScript(scriptToExecute).toString();
	}

}
