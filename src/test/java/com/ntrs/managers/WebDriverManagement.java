package com.ntrs.managers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagement {
	
	private static String driverType;
	private static WebDriverManagement webdriverManager = null;
	private static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	String SAUCE_USERNAME="mzs4";
	String SAUCE_ACCESSKEY="4e822ae6-cd0a-4ffb-950c-8cbcea72f392";
	
	public WebDriverManagement() {
		driverType = "Chrome";
	}
	
	public static WebDriverManagement getWebDriverManagerInstance() {
		if(webdriverManager == null) webdriverManager = new WebDriverManagement();
		return webdriverManager;
	}
	
	public RemoteWebDriver setBrowserDriver() {
		
		MutableCapabilities sauceOpts = new MutableCapabilities();
		sauceOpts.setCapability("username", SAUCE_USERNAME);
		sauceOpts.setCapability("accessKey", SAUCE_ACCESSKEY);
		//sauceOpts.setCapability("name", "");
		
		if(driverType.equalsIgnoreCase("Firefox")) {
			
		}
		else if(driverType.equalsIgnoreCase("Chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.setCapability("sauce:options", sauceOpts);
			options.setCapability("browserVersion", "latest");
			options.setCapability("browserName", "chrome");
			options.setCapability("platformName", "windows 10");

			options.addArguments("--start-maximized");
			options.setAcceptInsecureCerts(true);
			driver.set(new ChromeDriver(options));
			
			// Adding WebdriverManager code
			WebDriverManager.chromedriver().setup();
						
			URL url = null;
			
			try {
				url = new URL("https://ondemand.apac-southeast-1.saucelabs.com:443/wd/hub");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.set(new RemoteWebDriver(url, options));
			
//			WebDriverManager webDriver = WebDriverManager.chromedriver();
//			webDriver.proxy("http-proxy.ntrs.com:80");
//			webDriver.proxy("https-proxy.ntrs.com:443");
//			webDriver.setup();
			
		}
		
		driver.get().manage().window().maximize();
		return driver.get();
	}
	
	public RemoteWebDriver getBrowserDriver() {
		return driver.get();
	}
	
	public void closeDriver() {
		driver.get().close();
	}

}
