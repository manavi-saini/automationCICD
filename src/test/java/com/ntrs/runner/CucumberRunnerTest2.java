package com.ntrs.runner;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@Test2", features = "src/test/resources/features", 
glue = "com.ntrs",plugin= {"json:target/cucumber-reports/cucumber.json","html:target/cucumber-reports/cucumber.html",
		"html:target/cucumber-html-report","html:target/site/cucumber-pretty","json:target/cucumber-report/cucumber.json",
		"json:target/cucumber.json","json:target/cucumber.json","rerun:target/rerun.txt","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true)

@Test
public class CucumberRunnerTest2 extends AbstractTestNGCucumberTests {
	
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}
 
}

