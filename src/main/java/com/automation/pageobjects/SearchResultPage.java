package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.commonfunctions.BaseSetup;

public class SearchResultPage {

	public WebDriver driver;
	BaseSetup baseObj = new BaseSetup();
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	By branchNameInTable = By.xpath("//table/tbody/tr[1]/td[2]");
	By viewButton = By.xpath("//table/tbody/tr[1]/td[4]/button/span[contains(text(),'View')]");
	By editButton = By.xpath("//table/tbody/tr[1]/td[4]/button/span[contains(text(),'Edit')]");
	By deleteButton = By.xpath("//table/tbody/tr[1]/td[4]/button/span[contains(text(),'Delete')]");
	
	public WebElement getTableRow()
	{
		baseObj.waitForElement(driver, branchNameInTable, 10);
		return driver.findElement(branchNameInTable);
	}
	public WebElement getviewButton()
	{
		baseObj.waitForElement(driver, viewButton, 10);
		return driver.findElement(viewButton);
	}
	
	public WebElement getEditButton()
	{
		baseObj.waitForElement(driver, editButton, 10);
		return driver.findElement(editButton);
	}
	
	public WebElement getDeleteButton()
	{
		baseObj.waitForElement(driver, deleteButton, 10);
		return driver.findElement(deleteButton);
	}
}
