package com.automation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.commonfunctions.BaseSetup;
import com.automation.pageobjects.AuthenticationPage;
import com.automation.pageobjects.CreateBranchPage;
import com.automation.pageobjects.CreateStaffPage;
import com.automation.pageobjects.HomePage;
import com.automation.pageobjects.LandingPage;

public class AddStaff extends BaseSetup {

	@BeforeTest
	public void initializeBrowser() throws IOException
	{
		driver = setBrowser();
	}
	
	Login loginObj = new Login();
	
	@Test
	public void selectBranch() throws IOException, InterruptedException
	{
		loginObj.navigatetoLoginPage();
		HomePage homePageObj = new HomePage(driver);
		homePageObj.getEntities().click();
		homePageObj.getStaff().click();
		CreateStaffPage newStaff = new CreateStaffPage(driver);
		newStaff.getCreateStaff().click();
		newStaff.loadPropertyFile();
		Thread.sleep(1000);
		String staffName = prop.getProperty("staffName");
		newStaff.getstaffName().sendKeys(staffName);
		System.out.println("test");
		Select selBranch = new Select(newStaff.selectBranch());
		selBranch.selectByIndex(2);
		newStaff.getsaveButton().click();
		
	} 
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver=null;
	}
}