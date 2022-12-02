package commonlibs.contracts;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface IDropDown {
	
public void selectViaVisibleText(WebElement element,String visibleText)throws Exception;

public void selectViaValue(WebElement element,String value)throws Exception;

public void selectViaVisibleIndex(WebElement element,int index)throws Exception;

public List<WebElement> getAllOptions(WebElement element);

}
