package com.anu.framework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.anu.framework.base.BaseTest;
import com.anu.framework.base.DriverFactory;
import com.anu.framework.utilities.ConfigReader;

public class LaunchBrowserTest extends BaseTest {
	
	@Test
	public void launchBrowserTest() {
		
		System.out.println("Title of the page: " + driver.getTitle());
		
	}
	

}
