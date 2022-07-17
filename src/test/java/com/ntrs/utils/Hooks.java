package com.ntrs.utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ntrs.dia.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
	
	TestContext testContext;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
		
	@Before
	public void beforeScenario() {
		System.out.println("-----------Scenario Start-----------------");
	}
	
	@After
	public void afterScenario() {
		System.out.println("-----------Scenario End-----------------");
		testContext.getWebDriverManager().closeDriver();
	}

}
