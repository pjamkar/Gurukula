package com.automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.commonfunctions.BaseSetup;
import com.automation.pageobjects.AuthenticationPage;
import com.automation.pageobjects.CreateBranchPage;
import com.automation.pageobjects.CreateStaffPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.LandingPage;
import com.automation.pageobjects.SearchResultPage;

public class SearchBranch extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException
	{
		//Initialize browser
		driver = setBrowser();
	}
	
	Login loginObj = new Login();
	
	@Test
	public void searchingBranch () throws IOException, InterruptedException
	{
		loginObj.navigatetoLoginPage();
		HomePage homePageObj = new HomePage(driver);
		homePageObj.getEntities().click();
		homePageObj.getBranch().click();
		CreateBranchPage searchBranch  = new CreateBranchPage(driver);
		searchBranch.loadPropertyFile();
		String searchTerm = prop.getProperty("branchName");
		System.out.println(searchTerm);
		searchBranch.getSearchBox().sendKeys(searchTerm);
		searchBranch.getSearchButton().click();
		SearchResultPage searchresultObj = new SearchResultPage(driver);
		System.out.println("Search term found on the search resuls page: " + searchresultObj.getTableRow().getText());
		Assert.assertEquals(searchresultObj.getTableRow().getText(), searchTerm);
	} 
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}