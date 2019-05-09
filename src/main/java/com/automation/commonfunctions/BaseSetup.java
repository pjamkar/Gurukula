package com.automation.commonfunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;


public class BaseSetup {
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static String errorMessage;
	//Accept mvn command line argument for browser
	//String browser = System.getProperty("browser");
	
	public WebDriver setBrowser() throws FileNotFoundException, IOException
	{	
		loadPropertyFile();
		String browser = prop.getProperty("Browser");
		
		if (browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe"));
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", (System.getProperty("user.dir") + "/src/main/resources/geckodriver.exe"));
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", (System.getProperty("user.dir") + "/src/main/resources/msedgedriver.exe"));
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
	
	public WebDriver navigateToURL(WebDriver driver) throws IOException
	{
		loadPropertyFile();
		driver.get(prop.getProperty("InternalURL"));
		driver.manage().window().maximize();
		return driver;
	}
	
	public void loadPropertyFile() throws IOException
	{
		FileInputStream configFile = new FileInputStream("F:\\workspace2\\Gurukula\\propertyFiles\\config.properties");
		prop.load(configFile);
	}
	
	public boolean waitForElement(WebDriver driver, By elementToWaitFor, Integer waitTimeInSeconds)
	{
		boolean flag=true;
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTimeInSeconds);
			wait.until(ExpectedConditions.presenceOfElementLocated(elementToWaitFor));
			flag = true;	
		} catch (Exception e)
		{
			flag = false;
		}
		return flag;
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileSuffix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		FileUtils.copyFile(src, new File("F:\\workspace2\\Gurukula\\Screenshots\\method_" + result + "_fileSuffix" + ".png"));	
	}
}