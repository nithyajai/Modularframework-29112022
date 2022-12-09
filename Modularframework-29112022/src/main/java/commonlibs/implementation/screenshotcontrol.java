package commonlibs.implementation;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonlibs.contracts.Iscreenshot;

public class screenshotcontrol implements Iscreenshot {

	private TakesScreenshot camera;
	
	public screenshotcontrol(WebDriver driver)
	{
	 camera=(TakesScreenshot)driver;	
	
	}
		
	@Override
	public void captureAndSaveScreenshot(String pathfile) throws Exception {

		pathfile =pathfile.trim();
		
		File imgFile,tmpFile;
		
		imgFile=new File(pathfile);
		
		if(imgFile.exists()) {
			
			throw new Exception("Image with this file name already exist.");
		}
		tmpFile=camera.getScreenshotAs(OutputType.FILE);
		
		FileUtils.moveFile(tmpFile,imgFile);
	}
}
