package com.anu.framework.tests;

import org.testng.annotations.Test;

import com.anu.framework.utilities.ConfigReader;

public class ConfigReaderTest {
	
	@Test
	public void testConfigReader() {
		ConfigReader configReader = new ConfigReader();
		
		String browser = configReader.getBrowser();
		System.out.println("Browser: " + browser);
		
		String url = configReader.getUrl();
		System.out.println("URL: " + url);
		
		String username = configReader.getUsername();
		System.out.println("Username: " + username);
		
		String password = configReader.getPassword();
		System.out.println("Password: " + password);
	}
	

}
