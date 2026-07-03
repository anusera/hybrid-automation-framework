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
	public WebDriver getDriver() {
	    return driver;
	}
	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		logger.info("Setting up the test environment");
		configReader = new ConfigReader();
		DriverFactory.initializeDriver(configReader.getBrowser());
		driver = DriverFactory.getDriver();
		driver.get(configReader.getUrl());
		System.out.println("Thread ID : "+ Thread.currentThread().getId());
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		System.out.println("Closing Thread : " + Thread.currentThread().getId());
		if (DriverFactory.getDriver() != null) {
			DriverFactory.getDriver().quit();
			DriverFactory.unLoad();
	}
	}

}
