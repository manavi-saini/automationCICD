package com.ntrs.managers;

import org.openqa.selenium.WebDriver;

import com.ntrs.utils.WebProducts;

public class UtilsManager {
	
	private WebDriver driver;
	private WebProducts webProducts;

	public UtilsManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebProducts getWebProductsClass(){
		return (webProducts == null) ? webProducts = new WebProducts(driver) : webProducts;
	}


}
