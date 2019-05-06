package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.commonfunctions.BaseSetup;

public class CreateStaffPage extends BaseSetup {

	public WebDriver driver;
	BaseSetup baseObj = new BaseSetup();
	
	public CreateStaffPage(WebDriver driver) {
		this.driver = driver;
	}

	By createStaff = By.xpath("//span[contains(text(),'new Staff')]");
	By staffName = By.xpath("//input[@name='name']");
	By staffBranch = By.xpath("//*[@name='related_branch']");
	By saveButton = By.xpath("//span[contains(text(),'Save')]");
	By searchBox = By.xpath("//form[@name='searchForm']//input");
	By selectBranchSearchButton = By.xpath("//form[@name='searchForm']//button");
	
	public WebElement getSearchBox()
	{
		baseObj.waitForElement(driver, searchBox, 10);
		return driver.findElement(searchBox);
	}
	
	public WebElement getSearchButton()
	{
		baseObj.waitForElement(driver, selectBranchSearchButton, 10);
		return driver.findElement(selectBranchSearchButton);
	}
	
	public WebElement getCreateStaff()
	{
		baseObj.waitForElement(driver, createStaff, 10);
		return driver.findElement(createStaff) ;
		
	}
	
	public WebElement getstaffName()
	{
		//driver.switchTo().activeElement();
		baseObj.waitForElement(driver, staffName, 10);
		return driver.findElement(staffName);
	}
	public WebElement selectBranch()
	{
		baseObj.waitForElement(driver, staffBranch, 10);
		return driver.findElement(staffBranch);
	}
	
	public WebElement getsaveButton()
	{
		baseObj.waitForElement(driver, saveButton, 10);
		return driver.findElement(saveButton);
	}
	
}