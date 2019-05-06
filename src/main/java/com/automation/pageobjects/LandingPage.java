package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.commonfunctions.BaseSetup;

public class LandingPage {

	public WebDriver driver;
	BaseSetup baseObj = new BaseSetup();
	
	By loginLink = By.xpath("//a[contains(text(),'login')]");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLoginLink() {
		baseObj.waitForElement(driver, loginLink, 10);
		return driver.findElement(loginLink);

	}
}