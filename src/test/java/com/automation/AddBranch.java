package com.automation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.automation.commonfunctions.BaseSetup;
import com.automation.pageobjects.CreateBranchPage;
import com.automation.pageobjects.HomePage;

public class AddBranch extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException {
		driver = setBrowser();
	}

	Login loginObj = new Login();

	@Test 
	public void selectBranch() throws IOException, InterruptedException {
		try {
			loginObj.navigatetoLoginPage();
			HomePage homePageObj = new HomePage(driver);
			homePageObj.getEntities().click();
			homePageObj.getBranch().click();
			CreateBranchPage newBranch = new CreateBranchPage(driver);
			newBranch.getCreateBranch().click();
			Thread.sleep(1000);
			newBranch.addBranch(driver);
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