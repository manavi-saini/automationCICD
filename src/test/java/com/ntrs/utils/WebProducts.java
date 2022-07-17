package com.ntrs.utils;

import org.openqa.selenium.WebDriver;

public class WebProducts {
	
	private WebDriver driver;
	
	public WebProducts(WebDriver driver) {
		this.driver = driver;
	}
	
	public void openUrl(String Url) {
		driver.get(Url);
	}
	
	public void closeBrowser() {
		driver.close();
	}

}
