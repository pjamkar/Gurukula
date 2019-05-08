package com.automation;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.commonfunctions.BaseSetup;
import com.automation.pageobjects.AuthenticationPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.LandingPage;

public class Logout extends BaseSetup {

	Login loginObj = new Login();
	BaseSetup baseObj = new BaseSetup();

	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = setBrowser();
	}

	@Test
	public void Signout() throws IOException {
		loginObj.navigatetoLoginPage();
		HomePage homePageObj = new HomePage(driver);
		homePageObj.getAccount().click();
		homePageObj.getLogout().click();
		Assert.assertFalse(homePageObj.getEntities().isDisplayed());
	}

	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}
}