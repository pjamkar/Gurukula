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

public class DeleteStaff extends BaseSetup {
	
	Login loginObj = new Login();
	
	@BeforeTest
	public void initializeBrowser() throws IOException {
		// Initialize browser
		driver = setBrowser();
	}

	@Test
	public void StaffDelete() throws IOException, InterruptedException {

		try {
			loginObj.navigatetoLoginPage();
			HomePage homePageObj = new HomePage(driver);
			homePageObj.getEntities().click();
			homePageObj.getStaff().click();
			CreateStaffPage searchStaff = new CreateStaffPage(driver);
			WebElement staffName = searchStaff.searchStaff(driver);
			SearchResultPage searchresultObj = new SearchResultPage(driver);
			((SearchResultPage) staffName).getDeleteButton().click();
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