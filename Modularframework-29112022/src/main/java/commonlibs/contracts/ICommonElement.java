package commonlibs.contracts;

import org.openqa.selenium.WebElement;

public interface ICommonElement {

public String getText(WebElement element)throws Exception;

public void clickElement(WebElement element)throws Exception;

public String getAttribute(WebElement element,String Attribute)throws Exception;

public String getCssValue(WebElement element,String cssgetpropertyName)throws Exception;

public boolean isElementEnabled(WebElement element)throws Exception;

public boolean isElementVisible(WebElement element)throws Exception;
	
public boolean isElementSelected(WebElement element)throws Exception;
	
public void setText(WebElement element,String textToWrite)throws Exception;

public void clearText(WebElement element,String textToWrite)throws Exception;

public void changeCheckboxStatus(WebElement element,Boolean expectedStatus)throws Exception;

public int getXLocation(WebElement element)throws Exception;

public int getYLocation(WebElement element)throws Exception;
	
}
