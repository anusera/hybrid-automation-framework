package com.anu.framework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.anu.framework.utilities.ConfigReader;

public class BaseTest {
	protected ConfigReader configReader;
	protected WebDriver driver;
	private static final Logger logger = LogManager.getLogger(BaseTest.class);
	@BeforeMethod
	public void setUp() {
		logger.info("Setting up the test environment");
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
