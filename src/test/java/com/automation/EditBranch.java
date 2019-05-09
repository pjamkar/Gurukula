package com.automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.commonfunctions.BaseSetup;
import com.automation.pageobjects.CreateBranchPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.SearchResultPage;

public class EditBranch extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException {
		// Initialize browser
		driver = setBrowser();
	}

	Login loginObj = new Login();

	@Test
	public void EditBranchDetails () throws IOException, InterruptedException {
			loginObj.navigatetoLoginPage();
			HomePage homePageObj = new HomePage(driver);
			homePageObj.getEntities().click();
			homePageObj.getBranch().click();
			CreateBranchPage searchBranch  = new CreateBranchPage(driver);
			String searchTerm = prop.getProperty("branchName");
			searchBranch.getSearchBox().sendKeys(searchTerm);
			searchBranch.getSearchButton().click();
			SearchResultPage result = new SearchResultPage(driver);
			result.getEditButton().click();
			searchBranch.addBranch(driver);
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}