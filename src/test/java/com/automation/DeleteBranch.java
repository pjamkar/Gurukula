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
import com.automation.pageobjects.CreateStaffPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.SearchResultPage;

public class DeleteBranch extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException {
		// Initialize browser
		driver = setBrowser();
	}

	Login loginObj = new Login();

	@Test
	public void BranchDelete() throws IOException, InterruptedException {

		loginObj.navigatetoLoginPage();
		HomePage homePageObj = new HomePage(driver);
		homePageObj.getEntities().click();
		homePageObj.getBranch().click();
		CreateBranchPage searchBranch = new CreateBranchPage(driver);
		SearchResultPage searchresultObj = new SearchResultPage(driver);
/*		WebElement branchName = searchBranch.searchBranch(driver);
		((SearchResultPage) branchName).getDeleteButton().click();*/
		searchBranch.getSearchBox().sendKeys(prop.getProperty("branchName"));
		searchBranch.getSearchButton().click();
		SearchResultPage result = new SearchResultPage(driver);
		result.getDeleteButton().click();
		result.confirmDeletion().click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}