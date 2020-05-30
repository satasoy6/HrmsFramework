package com.hrms.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener{

	@Override
	public void onStart(ITestContext context) {//This will only run one time
		System.out.println("Functionality Testing Start");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Functionality Testing Finished");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
	    System.out.println("Test Failed "+result.getName());
	   //screenshot code
	    //response if API is failed
	  }
	
}
