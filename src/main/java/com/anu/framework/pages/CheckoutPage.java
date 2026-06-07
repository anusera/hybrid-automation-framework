package com.anu.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	private WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By firstNameField = By.id("first-name");
	private By lastNameField = By.id("last-name");
	private By postalCodeField = By.id("postal-code");
	private By continueButton = By.id("continue");
	
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameField).sendKeys(firstName);		
	}	
	
	public void enterLastName(String lastName) {
		driver.findElement(lastNameField).sendKeys(lastName);
	}	
	
	public void enterPostalCode(String postalCode) {
		driver.findElement(postalCodeField).sendKeys(postalCode);
	}
	
	public void clickContinue() {
		driver.findElement(continueButton).click();
	}

}
