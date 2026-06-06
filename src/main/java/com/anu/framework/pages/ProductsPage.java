package com.anu.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
	
	private WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By productTitle = By.cssSelector("[data-test='title']");
	private By addToCatBackpack = By.id("add-to-cart-sauce-labs-backpack");
	private By cartBadge = By.className("shopping_cart_badge");
	
	public String getProductTitle() {
		return driver.findElement(productTitle).getText();
	}
	
	public void addBackpackToCart() {
		driver.findElement(addToCatBackpack).click();
	}
	
	public String getCartBadgeCount() {
		return driver.findElement(cartBadge).getText();
	}
	
	public void navigateToCart() {
		driver.findElement(cartBadge).click();
	}



}
