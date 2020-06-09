package com.hrms.utils;

public class Constants {
	
	/*To store path to prop file,
	 * to hold the variables we don't want to change during programming
	 */

	public static final String CHROME_DRIVER_PATH=System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver";
	
	public static final String GECKO_DRIVER_PATH=System.getProperty("user.dir")+"/src/test/resources/drivers/geckodriver";
	
	public static final String CONFIGURATION_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/configs/configuration.properties";
	
	public static final String TASK_FILEPATH="/Users/seymaatasoy/eclipse-workspace/Selenium/src/test/resources/configs/selenium.properties";
	
	public static final int IMPLICIT_WAIT_TIME=5;
	
	public static final int EXPLICIT_WAIT_TIME=30;
	
	public static final String TESTDATA_FILEPATH=System.getProperty("user.dir")+"/src/test/resources/testdata/HrmsTestData.xlsx";
	
	public static final String REPORT_FILEPATH=System.getProperty("user.dir")+"/target/html-report/HRMS.html";
	
	public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"/screenshot/";
	
	
	}

