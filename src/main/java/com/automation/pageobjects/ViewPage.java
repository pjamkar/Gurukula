package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.commonfunctions.BaseSetup;

public class ViewPage extends BaseSetup {

	public WebDriver driver;

	By viewName = By.xpath("//table/tbody/tr[1]/td[2]/input");

	public ViewPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getViewName() {
		waitForElement(driver, viewName, 10);
		return driver.findElement(viewName);
	}
}