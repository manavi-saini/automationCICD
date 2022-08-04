package com.ntrs.utils;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class WebProducts {
	
	private WebDriver driver;
	
	public WebProducts(WebDriver driver) {
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
