package com.anu.framework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static final Logger logger = LogManager.getLogger(DriverFactory.class);
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public static WebDriver initializeDriver(String browser) {
			if (browser.equalsIgnoreCase("chrome")) {
				//WebDriver driver =null;
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			logger.info("Launching Chrome browser in incognito mode");
			//driver = new ChromeDriver(options);
			driver.set(new ChromeDriver(options));
			driver.get().manage().window().maximize();
			
			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver= new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
		
		return driver.get();
		}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void unLoad() {
		driver.remove();
	}
	
		
	}


