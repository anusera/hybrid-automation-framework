package com.anu.framework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.anu.framework.base.DriverFactory;
import com.anu.framework.utilities.ConfigReader;

public class LaunchBrowserTest {
	
	@Test
	public void launchBrowserTest() {
		ConfigReader configReader = new ConfigReader();
		WebDriver driver =DriverFactory.initializeDriver(configReader.getBrowser());
		driver.get(configReader.getUrl());
		System.out.println("Title of the page: " + driver.getTitle());
		driver.quit();
	}
	

}
