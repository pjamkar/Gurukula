package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.commonfunctions.BaseSetup;

public class LandingPage extends BaseSetup {

	public WebDriver driver;
	
	By loginLink = By.xpath("//a[contains(text(),'login')]");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLoginLink() {
		waitForElement(driver, loginLink, 10);
		return driver.findElement(loginLink);

	}
}