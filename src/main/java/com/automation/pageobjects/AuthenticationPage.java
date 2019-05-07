package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.commonfunctions.BaseSetup;

public class AuthenticationPage extends BaseSetup {

	public WebDriver driver;
	
	public AuthenticationPage (WebDriver driver)
	{
		this.driver = driver;
	}
	
	By username = By.id("username");
	By password = By.id("password");
	By submitButton = By.xpath("//button[@type='submit']");
	
	public WebElement getUsername()
	{
		waitForElement(driver, username, 10);
		return driver.findElement(username);
	}
	public WebElement getPassword()
	{
		waitForElement(driver, password, 10);
		return driver.findElement(password);
	}
	public WebElement getsubmitButton()
	{
		waitForElement(driver, submitButton, 10);
		return driver.findElement(submitButton);
	}	
}