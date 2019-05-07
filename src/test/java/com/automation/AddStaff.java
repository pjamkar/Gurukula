package com.automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.commonfunctions.BaseSetup;
import com.automation.pageobjects.CreateStaffPage;
import com.automation.pageobjects.HomePage;

public class AddStaff extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = setBrowser();
	}

	Login loginObj = new Login();

	// This method is to add a new staff
	@Test
	public void selectStaff() throws IOException, InterruptedException {
		try {
			loginObj.navigatetoLoginPage();
			HomePage homePageObj = new HomePage(driver);
			homePageObj.getEntities().click();
			homePageObj.getStaff().click();
			CreateStaffPage newStaff = new CreateStaffPage(driver);
			newStaff.getCreateStaff().click();
			Thread.sleep(1000);
			newStaff.addStaff(driver);
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