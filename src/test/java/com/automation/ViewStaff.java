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
import com.automation.pageobjects.ViewPage;

public class ViewStaff extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException
	{
		//Initialize browser
		driver = setBrowser();
	}
	
	Login loginObj = new Login();
	
	@Test
	public void ViewBranch () throws IOException, InterruptedException
	{
		loginObj.navigatetoLoginPage();
		HomePage homePageObj = new HomePage(driver);
		homePageObj.getEntities().click();
		homePageObj.getStaff().click();
		CreateStaffPage searchStaff  = new CreateStaffPage(driver);
		searchStaff.loadPropertyFile();
		String searchTerm = prop.getProperty("staffName");
		System.out.println(searchTerm);
		searchStaff.getSearchBox().sendKeys(searchTerm);
		searchStaff.getSearchButton().click();
		SearchResultPage searchresultObj = new SearchResultPage(driver);
		searchresultObj.getviewButton().click();
		ViewPage viewResult = new ViewPage(driver);
	} 
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}