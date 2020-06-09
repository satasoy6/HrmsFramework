package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class HW extends CommonMethods {

	@Test(dataProvider = "userDataFromExcel")
	public void test(String firstName, String lastName, String username, String password) {
		// System.out.println(firstName + " " + lastName + " " + username + " " +
		// password);

		// login into HRMS
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));

		// navigate to Add Employee page
		dash.navigateToAddEmployee();
		wait(1);

		// add employee information
		sendText(emp.firstName, firstName);
		sendText(emp.lastName, lastName);
		// get EmployeeID
		String expectedEmpId = emp.empId.getAttribute("value");

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

		// take screeshot
		takeScreenshot(firstName + "_" + lastName);
	}

	@DataProvider(name = "userData")
	public Object[][] getData() {
		Object[][] data = { { "Raj", "Capoor", "raj123", "AmirKhan_@123" },
				{ "John", "Smith", "john123", "AmirKhan_@123" }, { "Mary", "Ann", "mary123", "AmirKhan_@123" },
				{ "Rohani", "Sakhi", "rohani123", "AmirKhan_@123" }, { "Ali", "Tarlaci", "ali123", "AmirKhan_@123" }, };
		return data;
	}

	@DataProvider(name = "userDataFromExcel")
	public Object[][] getData2() {
		return ExcelUtility.excelintoArray(Constants.TESTDATA_FILEPATH, "Employee");
	}

}
