package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.commonfunctions.BaseSetup;

public class HomePage extends BaseSetup {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By entities = By.xpath("//span[contains(text(),'Entities')]");
	By branch = By.xpath(" //span[contains(text(),'Branch')]");
	By staff = By.xpath("//span[contains(text(),'Staff')]");
	By account = By.xpath("//span[contains(text(),'Account')]");
	By logout = By.xpath("//li/a/span[contains(text(), 'Log out')]");
	By titleHomePage = By.xpath("//h1");
	
	public WebElement getEntities() {
		waitForElement(driver, entities, 10);
		return driver.findElement(entities);
	}

	public WebElement getBranch() {
		waitForElement(driver, branch, 10);
		return driver.findElement(branch);
	}

	public WebElement getStaff() {
		waitForElement(driver, staff, 10);
		return driver.findElement(staff);
	}
	public WebElement getAccount () {
		waitForElement(driver, account, 10);
		return driver.findElement(account);
	}
	
	public WebElement getLogout () {
		waitForElement(driver, logout, 10);
		return driver.findElement(logout);
	}
	public WebElement getHomePageTitle () {
		waitForElement(driver, titleHomePage, 10);
		return driver.findElement(titleHomePage);
	}
}