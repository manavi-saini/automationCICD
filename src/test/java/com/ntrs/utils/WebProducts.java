package com.ntrs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import junit.framework.Assert;

public class WebProducts {
	
	private RemoteWebDriver driver;
	
	public WebProducts(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public void openUrl(String Url) {
		driver.get(Url);
	}
	
	public void verifyTitle(String title) {
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	public void closeBrowser() {
		driver.close();
	}

}
