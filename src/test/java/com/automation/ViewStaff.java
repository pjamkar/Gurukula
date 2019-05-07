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
import com.automation.pageobjects.ViewPage;

public class ViewStaff extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException {
		// Initialize browser
		driver = setBrowser();
	}

	Login loginObj = new Login();

	@Test
	public void ViewStaffDetails() throws IOException, InterruptedException {
		try {
			loginObj.navigatetoLoginPage();
			HomePage homePageObj = new HomePage(driver);
			homePageObj.getEntities().click();
			homePageObj.getStaff().click();
			CreateStaffPage searchStaff = new CreateStaffPage(driver);
			WebElement staffName = searchStaff.searchStaff(driver);
			((SearchResultPage) staffName).getviewButton().click();
			ViewPage viewResult = new ViewPage(driver);
			// viewResult.getViewName().getText();
			/*
			 * String searchTerm = prop.getProperty("staffName");
			 * searchStaff.getSearchBox().sendKeys(searchTerm);
			 * searchStaff.getSearchButton().click(); SearchResultPage
			 * searchresultObj = new SearchResultPage(driver);
			 * searchresultObj.getTableRow().getText();
			 * searchresultObj.getviewButton().click();
			 */
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