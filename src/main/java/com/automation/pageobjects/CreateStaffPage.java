package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.commonfunctions.BaseSetup;

public class CreateStaffPage extends BaseSetup {

	public WebDriver driver;
	SearchResultPage searchresultObj = new SearchResultPage(driver);
	
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
		waitForElement(driver, searchBox, 10);
		return driver.findElement(searchBox);
	}
	
	public WebElement getSearchButton()
	{
		waitForElement(driver, selectBranchSearchButton, 10);
		return driver.findElement(selectBranchSearchButton);
	}
	
	public WebElement getCreateStaff()
	{
		waitForElement(driver, createStaff, 10);
		return driver.findElement(createStaff) ;
		
	}
	
	public WebElement getstaffName()
	{
		//driver.switchTo().activeElement();
		waitForElement(driver, staffName, 10);
		return driver.findElement(staffName);
	}
	public WebElement selectBranch()
	{
		waitForElement(driver, staffBranch, 10);
		return driver.findElement(staffBranch);
	}
	
	public WebElement getsaveButton()
	{
		waitForElement(driver, saveButton, 10);
		return driver.findElement(saveButton);
	}
	
	public void addStaff(WebDriver driver)
	{
		String staffName = prop.getProperty("staffName");
		getstaffName().sendKeys(staffName);
		Select selBranch = new Select(selectBranch());
		selBranch.selectByIndex(1);
		getsaveButton().click();
	}
	
	public WebElement searchStaff(WebDriver driver)
	{
		String searchTerm = prop.getProperty("staffName");
		getSearchBox().sendKeys(searchTerm);
		getSearchButton().click();
		return searchresultObj.getTableRow();
	}
	
}