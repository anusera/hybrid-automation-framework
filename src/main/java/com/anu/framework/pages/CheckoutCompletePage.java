package com.anu.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
	private WebDriver driver;
	
	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By checkoutCompleteTitle = By.cssSelector("[data-test='title']");
	By orderConfirmationMessage = By.cssSelector("[data-test='complete-header']");
	
	public String getCheckoutCompleteTitle() {
		return driver.findElement(checkoutCompleteTitle).getText();
	}
	
	public String getOrderConfirmationMessage() {
		return driver.findElement(orderConfirmationMessage).getText();
	}

}