package com.anu.framework.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.anu.framework.utilities.ConfigReader;

public class BaseTest {
	protected ConfigReader configReader;
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		configReader = new ConfigReader();
		driver =DriverFactory.initializeDriver(configReader.getBrowser());
		driver.get(configReader.getUrl());
	}
	
	@AfterMethod
	public void tearDown() {
		if (driver != null) {
		driver.quit();
	}
	}

}
