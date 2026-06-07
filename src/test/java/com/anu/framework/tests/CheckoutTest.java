package com.anu.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anu.framework.base.BaseTest;
import com.anu.framework.pages.CartPage;
import com.anu.framework.pages.CheckoutPage;
import com.anu.framework.pages.LoginPage;
import com.anu.framework.pages.OverviewPage;
import com.anu.framework.pages.ProductsPage;

public class CheckoutTest extends BaseTest {
	@Test
	public void testCheckoutProcess() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(configReader.getUsername(), configReader.getPassword());
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addBackpackToCart();
		productsPage.navigateToCart();
		CartPage cartPage = new CartPage(driver);
		cartPage.clickCheckout();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.enterFirstName("John");
		checkoutPage.enterLastName("Doe");
		checkoutPage.enterPostalCode("12345");
		checkoutPage.clickContinue();
		OverviewPage overviewPage = new OverviewPage(driver);
		Assert.assertEquals(overviewPage.getOverviewTitle(), "Checkout: Overview", "Checkout overview page not displayed");
		
	}

}
