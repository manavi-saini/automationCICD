package com.ntrs.runner;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestListener implements ISuiteListener{
	
	public static String suiteName;

	@Override
	public void onStart(ISuite suite) {
		// not implemented
		System.out.println("Test Suite Name - "+suite.getName());
		suiteName = suite.getName();
		System.out.println("Bla Bla - "+suiteName);
	}
	
	public String getSuiteName() {
		return suiteName;
	}
	
	

}
