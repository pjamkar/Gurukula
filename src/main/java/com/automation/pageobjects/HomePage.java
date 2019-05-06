package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.commonfunctions.BaseSetup;

public class HomePage {
	
	public WebDriver driver;
	BaseSetup baseObj = new BaseSetup();
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By entities = By.xpath("//span[contains(text(),'Entities')]");
	By branch = By.xpath(" //span[contains(text(),'Branch')]");
	By staff = By.xpath("//span[contains(text(),'Staff')]");
	
	public WebElement getEntities()
	{
		baseObj.waitForElement(driver, entities, 10);
		return driver.findElement(entities);
	}
	
	public WebElement getBranch()
	{
		baseObj.waitForElement(driver, branch, 10);
		return driver.findElement(branch);
	}
	public WebElement getStaff()
	{
		baseObj.waitForElement(driver, staff, 10);
		return driver.findElement(staff);
	}
}
