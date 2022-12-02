package commonlibs.implementation;

import org.openqa.selenium.WebElement;

import commonlibs.contracts.ICommonElement;

public class CommonElement implements ICommonElement {

	@Override
	public String getText(WebElement element) throws Exception 
	{
		return element.getText();
	}

	@Override
	public void clickElement(WebElement element) throws Exception
	{
     element.click();		
	}

	@Override
	public String getAttribute(WebElement element, String Attribute) throws Exception {
		// TODO Auto-generated method stub
		return element.getAttribute(Attribute);
	}

	@Override
	public String getCssValue(WebElement element, String cssgetpropertyName) throws Exception {
		// TODO Auto-generated method stub
		return element.getCssValue(cssgetpropertyName);
	}

	@Override
	public boolean isElementEnabled(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isEnabled();
	}

	@Override
	public boolean isElementVisible(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.isDisplayed();
	}

	@Override
	public boolean isElementSelected(WebElement element) throws Exception {
		return element.isSelected();
	}

	@Override
	public void setText(WebElement element, String textToWrite) throws Exception {
		element.sendKeys(textToWrite);
	}

	@Override
	public void clearText(WebElement element, String textToWrite) throws Exception {
		element.clear();
	}

	@Override
	public void changeCheckboxStatus(WebElement element, Boolean expectedStatus) throws Exception {
    boolean currentstatus=element.isSelected();	
    if
    (currentstatus!=expectedStatus) {
    	element.click();
    }
	}
	@Override
	public int getXLocation(WebElement element) throws Exception {
		return element.getLocation().x;
	}

	@Override
	public int getYLocation(WebElement element) throws Exception {
		return element.getLocation().y;
	}

}
