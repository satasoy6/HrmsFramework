package com.hrms.testbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;

public class BaseClass {

	public static String browser;
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentHtmlReporter htmlReport;
	public static ExtentTest test;

	@BeforeTest(alwaysRun = true)
	public void generateReport() {

		System.out.println("---------Starting generating Report----------");

		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);// it is going to read our property file

		htmlReport = new ExtentHtmlReporter(Constants.REPORT_FILEPATH);
		htmlReport.config().setDocumentTitle(ConfigsReader.getProperty("documentTitle"));
		htmlReport.config().setReportName(ConfigsReader.getProperty("Hrms Execution Report"));
		htmlReport.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(htmlReport);

	}

	@AfterTest(alwaysRun = true)
	public void writeReport() {
		System.out.println("-----Writing the report-----");
		report.flush();
	}

	@BeforeMethod(alwaysRun = true) // to make this method run before every @Test method
	public static WebDriver setUp() {// if you inherit your class to here you don't need to return.
		// if you use inheritance you can just extends BaseClass
		// Otherwise public static WebDriver, and return type will be driver;

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported");

		}
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
//		driver.manage().deleteAllCookies();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsReader.getProperty("url"));
//		Initialize all page objects as part of setup		

		PageInitializer.initialize();
		return driver;

	}

	@AfterMethod(alwaysRun = true) // to make this method to run after every @Test method
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
