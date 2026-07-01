package com.anu.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.anu.framework.base.BaseTest;
import com.anu.framework.pages.LoginPage;
import com.anu.framework.pages.ProductsPage;
import com.anu.framework.utilities.ScreenshotUtility;

//@Listeners(com.anu.framework.listeners.TestListeners.class)
public class ProductsTest extends BaseTest {
	
		
	@Test
	public void testAddToCart() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(configReader.getUsername(), configReader.getPassword());
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addBackpackToCart();
		//ScreenshotUtility.captureScreenshot(driver, "AddToCart");
		Assert.assertEquals(productsPage.getCartBadgeCount(), "1", "Product not added to cart or cart badge count incorrect");
		Assert.assertTrue(false);
}
}
