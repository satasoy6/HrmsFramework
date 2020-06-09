package com.hrms.testbase;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.hrms.utils.CommonMethods;

public class Listener implements ITestListener{

	@Override
	public void onStart(ITestContext context) {//This will only run one time
		//This listener executes based on <test> from xml file
		System.out.println("Functionality Testing Start");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Functionality Testing Finished");
	}
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test Started "+result.getName());
		BaseClass.test=BaseClass.report.createTest(result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed "+result.getName());
		BaseClass.test.pass("Test Case pass "+result.getName());
		try {
			BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("passed/"+result.getName()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void onTestFailure(ITestResult result) {
	    System.out.println("Test Failed "+result.getName());
	    BaseClass.test.fail("Test case failed "+result.getName());
	    try {
			BaseClass.test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("failed/"+result.getName()));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	   //screenshot code
	    //response if API is failed
	  }
	
}
