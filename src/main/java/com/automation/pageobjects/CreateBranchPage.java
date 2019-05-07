package com.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automation.commonfunctions.BaseSetup;

public class CreateBranchPage extends BaseSetup {

	public WebDriver driver;
	SearchResultPage searchresultObj = new SearchResultPage(driver);

	public CreateBranchPage(WebDriver driver) {
		this.driver = driver;
	}

	By createBranch = By.xpath("//span[contains(text(),'new Branch')]");
	By branchName = By.xpath("//input[@name='name']");
	By branchCode = By.xpath("//input[@name='code']");
	By saveButton = By.xpath("//span[contains(text(),'Save')]");
	By searchBox = By.xpath("//form[@name='searchForm']//input");
	By selectBranchSearchButton = By.xpath("//form[@name='searchForm']//button");

	public WebElement getSearchBox() {
		waitForElement(driver, searchBox, 10);
		return driver.findElement(searchBox);
	}

	public WebElement getSearchButton() {
		waitForElement(driver, selectBranchSearchButton, 10);
		return driver.findElement(selectBranchSearchButton);
	}

	public WebElement getCreateBranch() {
		waitForElement(driver, createBranch, 10);
		return driver.findElement(createBranch);

	}

	public WebElement getbranchName() {
		waitForElement(driver, branchName, 10);
		return driver.findElement(branchName);
	}

	public WebElement getbranchCode() {
		waitForElement(driver, branchCode, 10);
		return driver.findElement(branchCode);
	}

	public WebElement getsaveButton() {
		waitForElement(driver, saveButton, 10);
		return driver.findElement(saveButton);
	}

	public void addBranch(WebDriver driver) {
		String branchName = prop.getProperty("branchName");
		String branchCode = prop.getProperty("branchCode");
		getbranchName().sendKeys(branchName);
		getbranchCode().sendKeys(branchCode);
		getsaveButton().click();
	}

	public WebElement searchBranch(WebDriver driver) {
		String searchTerm = prop.getProperty("branchName");
		getSearchBox().sendKeys(searchTerm);
		getSearchButton().click();
		return searchresultObj.getTableRow();
	}
}