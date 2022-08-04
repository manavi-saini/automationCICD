package com.ntrs.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ntrs.dia.TestContext;
import com.ntrs.utils.WebProducts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStepDefinition {
	
	TestContext testContext;
	WebProducts webProducts;
	
	public LoginStepDefinition(TestContext context) {
		testContext = context;
		webProducts = testContext.getUtilsManager().getWebProductsClass();
	}
		
	@Given("I navigate to Google URL")
	public void i_navigate_to_google_url() {
		webProducts.openUrl("https://www.google.com");
	}
	
	@Given("I navigate to SwagLabs URL")
	public void i_navigate_to_swaglabs_url() {
		webProducts.openUrl("https://www.saucedemo.com/");
	}
	
	@Given("I navigate to Ultimate URL")
	public void i_navigate_to_ultimate_url() {
		webProducts.openUrl("https://ultimateqa.com/automation");
	}
	
	@Given("I navigate to Telerik URL")
	public void i_navigate_to_telerik_url() {
		webProducts.openUrl("https://www.telerik.com/support/demos");
	}
	
	@Given("I navigate to Heroku app URL")
	public void i_navigate_to_heroku_url() {
		webProducts.openUrl("http://the-internet.herokuapp.com/");
	}
	
	@Given("I navigate to Cypress URL")
	public void i_navigate_to_cypress_url() {
		webProducts.openUrl("https://github.com/cypress-io/cypress-realworld-app");
	}
	
	@Given("I navigate to Webdriver URL")
	public void i_navigate_to_webdriver_url() {
		webProducts.openUrl("http://webdriveruniversity.com/index.html");
	}
	
	@Given("I close browser")
	public void i_close_browser() {
		webProducts.closeBrowser();
	}
	
	@Given("I verify title {string} is displayed")
	public void i_verify_title(String title) {
		webProducts.verifyTitle(title);
	}

}
