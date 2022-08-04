package com.ntrs.utils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ntrs.dia.TestContext;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks {
	
	public TestContext testContext;
	public static String scenarioName;
	
	public Hooks(TestContext context) {
		testContext = context;
	}
		
	@Before
	public static String beforeScenario(Scenario scenario) {
		System.out.println("-----------Scenario Start-----------------");
		System.out.println("Scenario Name - "+scenario.getName());
		scenarioName = scenario.getName();
		System.out.println("Printing inside Before Scenario - "+scenarioName);
		return scenarioName;
	}
	
	@After
	public void afterScenario() {
		System.out.println("-----------Scenario End-----------------");
		testContext.getWebDriverManager().closeDriver();
	}

}
