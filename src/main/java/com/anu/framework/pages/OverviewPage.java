package com.anu.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewPage {
	
	private WebDriver driver;
	
	public OverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By overviewTitle = By.cssSelector("[data-test='title']");
	private By finishButton = By.id("finish");
	
	public String getOverviewTitle() {
		return driver.findElement(overviewTitle).getText();
	}
	
	public void clickFinish() {
		driver.findElement(finishButton).click();
	}

}
