package commonlibs.contracts;

import org.openqa.selenium.WebElement;

public interface IMouseActions {

public void dragandDrop(WebElement source,WebElement target)throws Exception;

public void moveToElement(WebElement element)throws Exception;

public void rightClick(WebElement element)throws Exception;
	
public void doubleClick(WebElement element)throws Exception;
	
public void moveToElementAndClick(WebElement element)throws Exception;
	
	
	
	
}
