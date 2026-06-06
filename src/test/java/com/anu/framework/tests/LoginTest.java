package com.anu.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anu.framework.base.BaseTest;
import com.anu.framework.pages.LoginPage;
import com.anu.framework.pages.ProductsPage;

public class LoginTest extends BaseTest {
	
	@Test
	public void testValidLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(configReader.getUsername(), configReader.getPassword());
		ProductsPage productsPage = new ProductsPage(driver);
		Assert.assertEquals(productsPage.getProductTitle(), "Products", "Login failed or Products page not displayed");
		
		
	}

}
