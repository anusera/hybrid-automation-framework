package com.anu.framework.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.anu.framework.base.BaseTest;
import com.anu.framework.pages.LoginPage;
import com.anu.framework.pages.ProductsPage;

public class LoginTest extends BaseTest {
	
	public static final Logger logger = LogManager.getLogger(LoginTest.class);
	
	@Test(dataProvider = "loginData", dataProviderClass = com.anu.framework.dataproviders.ValidLoginDataProvider.class)
	public void testValidLogin(String username, String password) {
		logger.info("Starting test: testValidLogin with username: " + username);
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Attempting to login with username: " + username);
		loginPage.login(username,password);
		ProductsPage productsPage = new ProductsPage(driver);
		Assert.assertEquals(productsPage.getProductTitle(), "Products", "Login failed or Products page not displayed");	
		logger.info("Login successful, Products page displayed with title: " + productsPage.getProductTitle());
	}
	
	@Test(dataProvider = "invalidLoginData", dataProviderClass = com.anu.framework.dataproviders.InvalidLoginDataProvider.class)
	public void testInvalidLogin(String username, String password) {
		logger.info("Starting test: testInvalidLogin with username: " + username);
		LoginPage loginPage = new LoginPage(driver);
		logger.info("Attempting to login with invalid credentials: " + username);
		loginPage.login(username,password);
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid login");
		logger.info("Invalid login attempt correctly displayed error message for username: " + username);
	}
}
