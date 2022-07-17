package com.ntrs.dia;

import com.ntrs.managers.UtilsManager;
import com.ntrs.managers.WebDriverManagement;

public class TestContext {
	
	private WebDriverManagement webDriverManager;
	private UtilsManager utilsManager;
	public TestContext(){
		webDriverManager = WebDriverManagement.getWebDriverManagerInstance();
		utilsManager = new UtilsManager(webDriverManager.setBrowserDriver());
	}
	
	public WebDriverManagement getWebDriverManager() {
		return webDriverManager;
	}
	public UtilsManager getUtilsManager() {
		return utilsManager;
	}

}
