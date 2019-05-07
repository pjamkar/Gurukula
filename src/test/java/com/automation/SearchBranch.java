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
import com.automation.pageobjects.CreateBranchPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.SearchResultPage;

public class SearchBranch extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException {
		// Initialize browser
		driver = setBrowser();
	}

	Login loginObj = new Login();

	@Test
	public void searchingBranch() throws IOException, InterruptedException {
		try {
			loginObj.navigatetoLoginPage();
			HomePage homePageObj = new HomePage(driver);
			homePageObj.getEntities().click();
			homePageObj.getBranch().click();
			CreateBranchPage searchBranch = new CreateBranchPage(driver);
			WebElement foundBranchName = searchBranch.searchBranch(driver);
			AssertJUnit.assertEquals(foundBranchName.getText(), prop.getProperty("branchName"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
		//driver = null;
	}
}