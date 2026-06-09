package com.anu.framework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.anu.framework.tests.LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static final Logger logger = LogManager.getLogger(LoginTest.class);
	public static WebDriver initializeDriver(String browser) {
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			logger.info("Launching Chrome browser in incognito mode");
			driver = new ChromeDriver(options);
			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		
		return driver;
		
	}

}
