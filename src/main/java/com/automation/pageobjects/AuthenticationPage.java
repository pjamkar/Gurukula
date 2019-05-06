package com.automation.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.commonfunctions.BaseSetup;

public class AuthenticationPage {

	public WebDriver driver;
	BaseSetup baseObj = new BaseSetup();
	
	public AuthenticationPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	By username = By.id("username");
	By password = By.id("password");
	By submitButton = By.xpath("//button[@type='submit']");
	
		public WebElement getUsername()
	{
		baseObj.waitForElement(driver, username, 10);
		return driver.findElement(username);
	}
	public WebElement getPassword()
	{
		baseObj.waitForElement(driver, password, 10);
		return driver.findElement(password);
	}
	public WebElement getsubmitButton()
	{
		baseObj.waitForElement(driver, submitButton, 10);
		return driver.findElement(submitButton);
	}
	
}