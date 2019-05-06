package com.automation.commonfunctions;

public class GlobalDataSet {

	//get mvn command line argument
	private String browser = System.getProperty("browser");

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}
	
}
