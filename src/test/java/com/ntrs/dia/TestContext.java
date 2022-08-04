package com.ntrs.dia;

import com.ntrs.managers.UtilsManager;
import com.ntrs.managers.WebDriverManagement;
import com.ntrs.utils.Hooks;

import io.cucumber.java.Scenario;

public class TestContext {
	
	private WebDriverManagement webDriverManager;
	private UtilsManager utilsManager;
	public static String scenarioName = null;
	
	public TestContext(){
		scenarioName = Hooks.scenarioName;
		System.out.println("Scenario name inside TestContext1 - "+scenarioName);
		webDriverManager = WebDriverManagement.getWebDriverManagerInstance();
		utilsManager = new UtilsManager(webDriverManager.setBrowserDriver(scenarioName));
	}
	
	public WebDriverManagement getWebDriverManager() {
		return webDriverManager;
	}
	public UtilsManager getUtilsManager() {
		return utilsManager;
	}

}
