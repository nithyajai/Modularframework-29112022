package commonlibs.implementation;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import commonlibs.contracts.IDropDown;

public class Dropdowncontrol implements IDropDown {

	private Select getSelect(WebElement element)
	{
		Select select=new Select(element);

		return select;
	}
	@Override
	public void selectViaVisibleText(WebElement element, String visibleText) throws Exception {
    
		getSelect(element).selectByVisibleText(visibleText);
	}

	@Override
	public void selectViaValue(WebElement element, String value) throws Exception {
     
		getSelect(element).selectByValue(value);		
	}

	@Override
	public void selectViaVisibleIndex(WebElement element, int index) throws Exception {

		getSelect(element).selectByIndex(index);
	}

	@Override
	public List<WebElement> getAllOptions(WebElement element) {
		// TODO Auto-generated method stub
		return getSelect(element).getOptions();
	}

}
