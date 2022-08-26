package com.ntrs.managers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
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
	String PERFECTO_ACCESSKEY="eyJhbGciOiJIUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICI2ZDM2NmJiNS01NDAyLTQ4MmMtYTVhOC1kODZhODk4MDYyZjIifQ.eyJpYXQiOjE2NTk3NzQ1NDcsImp0aSI6ImQ2MmIwNzE0LTliZjUtNGYyMy1iNTZkLTQ4MTMxMGEyYWIwOCIsImlzcyI6Imh0dHBzOi8vYXV0aDMucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3RyaWFsLXBlcmZlY3RvbW9iaWxlLWNvbSIsImF1ZCI6Imh0dHBzOi8vYXV0aDMucGVyZmVjdG9tb2JpbGUuY29tL2F1dGgvcmVhbG1zL3RyaWFsLXBlcmZlY3RvbW9iaWxlLWNvbSIsInN1YiI6ImM2ODkxMjZhLTlmMzgtNGZkZi1iMTA2LTg4OWFhMDg1ZDc2MyIsInR5cCI6Ik9mZmxpbmUiLCJhenAiOiJvZmZsaW5lLXRva2VuLWdlbmVyYXRvciIsIm5vbmNlIjoiYjBmODE0NGYtNTQwMy00MjU3LThmY2QtM2IxNDRiOWZhYWE1Iiwic2Vzc2lvbl9zdGF0ZSI6ImQ0YmZkY2VmLTY4N2MtNGNlYS05MTJiLTZlYjQ0NzBlMDhiZiIsInNjb3BlIjoib3BlbmlkIG9mZmxpbmVfYWNjZXNzIHByb2ZpbGUgZW1haWwifQ.RQDAcR8imZqauW37cvWc1hkqul8KXuMQ2M6xhO559mQ";
	
	public WebDriverManagement() {
		driverType = "Chrome";
	}
	
	public static WebDriverManagement getWebDriverManagerInstance() {
		if(webdriverManager == null) webdriverManager = new WebDriverManagement();
		return webdriverManager;
	}
	
	public RemoteWebDriver setBrowserDriver(String name) {

		System.out.println("Inside Webdriver = "+name);

		// 		SauceLabs Code		
		Map<String, Object> sauceOptions = new HashMap<>();
		sauceOptions.put("username", SAUCE_USERNAME);
		sauceOptions.put("accessKey", SAUCE_ACCESSKEY);
		sauceOptions.put("build", "Test Build");
		sauceOptions.put("name", name);




		if(driverType.equalsIgnoreCase("Firefox")) {

		}
		else if(driverType.equalsIgnoreCase("Chrome")) {

			//	 		SauceLabs Code			
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
