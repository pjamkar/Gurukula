package com.automation.pageobjects;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.commonfunctions.BaseSetup;

public class CreateBranchPage extends BaseSetup {

	public WebDriver driver;
	BaseSetup baseObj = new BaseSetup();
	
	public CreateBranchPage(WebDriver driver) {
		this.driver = driver;
	}

	/*By createBranch = By.cssSelector(".btn.btn-primary"); 
	By branchName = By.xpath("//*[@id='saveBranchModal']//form/div[2]/div[2]/input");
	By branchCode = By.xpath("//*[@id='saveBranchModal']//form/div[2]/div[3]/input");
	By saveButton = By.xpath("//*[@id='saveBranchModal']//form/div[3]/button[2]/span");
	By form = By.xpath(".modal-dialog"); */
	
	By createBranch = By.xpath("//span[contains(text(),'new Branch')]");
	By branchName = By.xpath("//input[@name='name']"); 
	By branchCode = By.xpath("//input[@name='code']");
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
	
	public WebElement getCreateBranch()
	{
		baseObj.waitForElement(driver, createBranch, 10);
		return driver.findElement(createBranch) ;
		
	}
	
	public WebElement getbranchName()
	{
		//driver.switchTo().activeElement();
		baseObj.waitForElement(driver, branchName, 10);
		return driver.findElement(branchName);
	}
	public WebElement getbranchCode()
	{
		baseObj.waitForElement(driver, branchCode, 10);
		return driver.findElement(branchCode);
	}
	
	public WebElement getsaveButton()
	{
		baseObj.waitForElement(driver, saveButton, 10);
		return driver.findElement(saveButton);
	}
	
}