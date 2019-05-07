package com.automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.commonfunctions.BaseSetup;
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
	public void BranchDelete () throws IOException, InterruptedException {

		try {
			loginObj.navigatetoLoginPage();
			HomePage homePageObj = new HomePage(driver);
			homePageObj.getEntities().click();
			homePageObj.getBranch().click();
			CreateStaffPage searchBranch = new CreateStaffPage(driver);
			WebElement branchName = searchBranch.searchStaff(driver);
			SearchResultPage searchresultObj = new SearchResultPage(driver);
			((SearchResultPage) branchName).getDeleteButton().click();
			searchresultObj.confirmDeletion().click();
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