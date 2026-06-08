package com.anu.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage{
	
	//WebDriver instance to interact with the browser
	private WebDriver driver;
	
	
	//Constructor that accepts WebDriver instance from test class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	//WebElements
	private By usernameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorMessage = By.cssSelector("[data-test='error']");
	
	
	//Actions (Page methods)
	public void enterUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
	
	//Combined action (Convenience method
	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}
	
	public boolean isErrorMessageDisplayed() {
		return driver.findElement(errorMessage).isDisplayed();
	}
	
}