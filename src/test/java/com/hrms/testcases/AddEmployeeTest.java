package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class AddEmployeeTest extends CommonMethods {

//	@BeforeMethod
//	public void openBrowser() {
//		setUp();
//		initialize();
//	}
//
//	@AfterMethod
//	public void closeBrowser() {
//		tearDown();
//	}

	/*
	 * Automate user stories below: US 12678 As an Admin I should be able to create
	 * login credentials while adding employee
	 */
	@Test(dataProvider = "userDataFromExcel", groups = { "homework", "addEmp", "regression" })
	public void addEmployee(String firstName, String lastName, String username, String password) {

		// System.out.println(firstName + " " + lastName + " " + username + " " +
		// password);

		// login into HRMS
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dash.navigateToAddEmployee();

		// add employee information
		sendText(emp.firstName, ConfigsReader.getProperty("firstName"));
		sendText(emp.lastName, ConfigsReader.getProperty("lastName"));
		// get EmployeeID
		String expectedEmpId = emp.empId.getAttribute("value");
		// sendText(emp.empId, ConfigsReader.getProperty("empId"));

		// click on Create Login Details
		click(emp.checkboxLoginDetails);
		wait(1);
		sendText(emp.username, username);
		sendText(emp.password, password);
		sendText(emp.confirmPassword, password);
		wait(1);
		jsClick(emp.saveBtn);
		wait(1);

		// validation
		waitForVisibility(pdetails.lblPersonalDetails);
		String actualEmpId = pdetails.employeeId.getAttribute("value");
		Assert.assertEquals(actualEmpId, expectedEmpId, "Employee ID did not match!");

		// take screenshot
		takeScreenshot(firstName + "_" + lastName);
	}

	@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] data = { { "Rajma", "Capoora", "raj123435345", "AmirKhan_@123" },
				{ "John", "Smith", "john123", "AmirKhan_@123" }, { "Mary", "Ann", "mary123", "AmirKhan_@123" },
				{ "Rohani", "Sakhi", "rohani123", "AmirKhan_@123" }, { "Ali", "Tarlaci", "ali123", "AmirKhan_@123" }, };
		return data;
	}
	
	@DataProvider(name = "userDataFromExcel")
	public Object[][] getData2() {
		return ExcelUtility.excelintoArray(Constants.TESTDATA_FILEPATH, "EmployeeLoginCredentials");
	}
	
	@Test
	public void requiredFields() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dash.navigateToAddEmployee();
		emp.saveBtn.click();

		String expected = "Required";
		String requiredFirstName = emp.reqFirstName.getText();
		String requiredLastName = emp.reqLastName.getText();

		Assert.assertEquals(requiredFirstName, expected, "First name not entered");
		Assert.assertEquals(requiredLastName, expected, "Last name not entered");

	}
}
