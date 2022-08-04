package com.ntrs.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ntrs.utils.WebProducts;

public class UtilsManager {
	
	private RemoteWebDriver driver;
	private WebProducts webProducts;

	public UtilsManager(RemoteWebDriver driver) {
		this.driver = driver;
	}
	
	public WebProducts getWebProductsClass(){
		return (webProducts == null) ? webProducts = new WebProducts(driver) : webProducts;
	}


}
