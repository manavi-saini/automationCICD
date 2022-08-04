package com.ntrs.managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.Scenario;

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
	
	public RemoteWebDriver setBrowserDriver(String name) {
		
		System.out.println("Inside Webdriver = "+name);
		
		
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", SAUCE_USERNAME);
		sauceOptions.put("accessKey", SAUCE_ACCESSKEY);
		sauceOptions.put("build", "Test Build");
		sauceOptions.put("name", name);
		
		if(driverType.equalsIgnoreCase("Firefox")) {
			
		}
		else if(driverType.equalsIgnoreCase("Chrome")) {
			
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("Windows 10");
			browserOptions.setBrowserVersion("latest");
			browserOptions.setCapability("sauce:options", sauceOptions);

			try {
				URL url = new URL("https://ondemand.apac-southeast-1.saucelabs.com:443/wd/hub");
				RemoteWebDriver remoteDriver = new RemoteWebDriver(url, browserOptions);
				driver.set(remoteDriver);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
						
//			DesiredCapabilities cap = new DesiredCapabilities();
//			cap.setCapability("sauce:options", sauceOpts);
//			cap.setCapability("browserVersion", "latest");
//			cap.setCapability("platformName", "Windows 10");
//			
//			// Adding WebdriverManager code
//			WebDriverManager.chromedriver().setup();
//
//			cap.setCapability("browserName", "chrome");


//			options.addArguments("--start-maximized");
//			options.setAcceptInsecureCerts(true);
						
//			
//			try {
//				URL url = new URL("http://ondemand.apac-southeast-1.saucelabs.com:443/wd/hub");
//				driver.set(new RemoteWebDriver(url, cap));
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
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
