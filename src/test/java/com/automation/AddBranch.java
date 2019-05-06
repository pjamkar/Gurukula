package com.automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.commonfunctions.BaseSetup;
import com.automation.pageobjects.AuthenticationPage;
import com.automation.pageobjects.CreateBranchPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.LandingPage;

public class AddBranch extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException
	{
		driver = setBrowser();
		//driver = navigateToURL(driver);
	}
	
	Login loginObj = new Login();
	
	@Test
	public void selectBranch() throws IOException, InterruptedException
	{
		loginObj.navigatetoLoginPage();
		HomePage homePageObj = new HomePage(driver);
		homePageObj.getEntities().click();
		homePageObj.getBranch().click();
		CreateBranchPage newBranch = new CreateBranchPage(driver);
		newBranch.getCreateBranch().click();
		Thread.sleep(1000);
		newBranch.loadPropertyFile();
		String branchName = prop.getProperty("branchName");
		String branchCode = prop.getProperty("branchCode");
		newBranch.getbranchName().sendKeys(branchName);
		newBranch.getbranchCode().sendKeys(branchCode);
		newBranch.getsaveButton().click();
	} 
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}