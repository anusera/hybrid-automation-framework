package com.anu.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
	
	private WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By productTitle = By.cssSelector("[data-test='title']");
	
	public String getProductTitle() {
		return driver.findElement(productTitle).getText();
	}

}
