package com.anu.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.anu.framework.base.BaseTest;
import com.anu.framework.pages.CartPage;
import com.anu.framework.pages.LoginPage;
import com.anu.framework.pages.ProductsPage;

public class CartTest extends BaseTest {

	@Test(groups = {"smoke", "regression"})
	public void testCartFunctionality() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login(configReader.getUsername(), configReader.getPassword());
		ProductsPage productsPage = new ProductsPage(driver);
		productsPage.addBackpackToCart();
		productsPage.navigateToCart();
		CartPage cartPage = new CartPage(driver);
		Assert.assertEquals(cartPage.getCartItemName(), "Sauce Labs Backpack", "Cart item name is incorrect");
	}
}
