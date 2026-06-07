package com.anu.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anu.framework.base.BaseTest;
import com.anu.framework.pages.CartPage;
import com.anu.framework.pages.CheckoutCompletePage;
import com.anu.framework.pages.CheckoutOverviewPage;
import com.anu.framework.pages.CheckoutPage;
import com.anu.framework.pages.LoginPage;
import com.anu.framework.pages.ProductsPage;

public class CheckoutOverviewTest extends BaseTest {
	@Test
	public void testCheckoutOverview() {
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
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutOverviewPage.clickFinish();
		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
		Assert.assertEquals(checkoutCompletePage.getCheckoutCompleteTitle(), "Checkout: Complete!", "Checkout complete page not displayed");
		
		
	}

}
