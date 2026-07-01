package com.anu.framework.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	public static String captureScreenshot(WebDriver driver,String testName)
	//WebDriver driver Needed to take the screenshot.
	//String testName Used in the screenshot filename.
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		//(TakesScreenshot) driver casts WebDriver to TakesScreenshot.
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		//getScreenshotAs(OutputType.FILE) returns a temporary screenshot file.
		
		String destination=System.getProperty("user.dir")+"/Screenshots/"+testName+"+"+System.currentTimeMillis()+".png";
		//Create destination path
		
			File destinationFile = new File(destination);
			try {
				FileUtils.copyFile(source, destinationFile);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		return destination;
		
	}

}
