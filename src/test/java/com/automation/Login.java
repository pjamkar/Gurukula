package com.automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.commonfunctions.BaseSetup;
import com.automation.pageobjects.AuthenticationPage;
import com.automation.pageobjects.LandingPage;

public class Login extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException
	{
		driver = setBrowser();
	}
	
	@Test
	public void navigatetoLoginPage() throws IOException
	{
		driver = navigateToURL(driver);
		LandingPage landingPageObj = new LandingPage(driver);
		landingPageObj.getLoginLink().click();
		AuthenticationPage authPage = new AuthenticationPage(driver);
		authPage.getUsername().sendKeys(prop.getProperty("username"));;
		authPage.getPassword().sendKeys(prop.getProperty("password"));
		authPage.getsubmitButton().click();
	}
	
	@AfterMethod
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}