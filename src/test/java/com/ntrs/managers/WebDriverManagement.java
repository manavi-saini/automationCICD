package com.ntrs.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagement {
	
	private static String driverType;
	private static WebDriverManagement webdriverManager = null;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriverManagement() {
		driverType = "Chrome";
	}
	
	public static WebDriverManagement getWebDriverManagerInstance() {
		if(webdriverManager == null) webdriverManager = new WebDriverManagement();
		return webdriverManager;
	}
	
	public WebDriver setBrowserDriver() {
		
		if(driverType.equalsIgnoreCase("Firefox")) {
			
		}
		else if(driverType.equalsIgnoreCase("Chrome")) {
			// Adding WebdriverManager code
			WebDriverManager.chromedriver().setup();
			
//			WebDriverManager webDriver = WebDriverManager.chromedriver();
//			webDriver.proxy("http-proxy.ntrs.com:80");
//			webDriver.proxy("https-proxy.ntrs.com:443");
//			webDriver.setup();
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.setAcceptInsecureCerts(true);
			driver.set(new ChromeDriver(options));
		}
		
		driver.get().manage().window().maximize();
		return driver.get();
	}
	
	public WebDriver getBrowserDriver() {
		return driver.get();
	}
	
	public void closeDriver() {
		driver.get().close();
	}

}
