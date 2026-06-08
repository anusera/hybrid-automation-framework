package com.anu.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anu.framework.base.BaseTest;
import com.anu.framework.pages.LoginPage;
import com.anu.framework.pages.ProductsPage;

public class LoginTest extends BaseTest {
	
	@Test(dataProvider = "loginData", dataProviderClass = com.anu.framework.dataproviders.ValidLoginDataProvider.class)
	public void testValidLogin(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username,password);
		ProductsPage productsPage = new ProductsPage(driver);
		Assert.assertEquals(productsPage.getProductTitle(), "Products", "Login failed or Products page not displayed");			
	}
	
	@Test(dataProvider = "invalidLoginData", dataProviderClass = com.anu.framework.dataproviders.InvalidLoginDataProvider.class)
	public void testInvalidLogin(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(username,password);
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message not displayed for invalid login");
	}
}
