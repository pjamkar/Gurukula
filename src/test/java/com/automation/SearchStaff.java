package com.automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.commonfunctions.BaseSetup;
import com.automation.pageobjects.CreateStaffPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.SearchResultPage;

public class SearchStaff extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException {
		// Initialize browser
		driver = setBrowser();
	}

	Login loginObj = new Login();

	@Test
	public void searchingStaff() throws IOException, InterruptedException {

		loginObj.navigatetoLoginPage();
		HomePage homePageObj = new HomePage(driver);
		homePageObj.getEntities().click();
		homePageObj.getStaff().click();
		CreateStaffPage searchStaff = new CreateStaffPage(driver);
		searchStaff.getSearchBox().sendKeys(prop.getProperty("staffName"));
		searchStaff.getSearchButton().click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}