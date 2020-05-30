package com.hrms.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.hrms.pages.AddemployeeElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

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
	@Test
	public void addEmployee() {

//		LoginPageElements login = new LoginPageElements();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dash.navigateToAddEmployee();

		AddemployeeElements emp1 = new AddemployeeElements();

		sendText(emp1.firstName, ConfigsReader.getProperty("firstName"));
		sendText(emp1.lastName, ConfigsReader.getProperty("lastName"));
		sendText(emp1.empId, ConfigsReader.getProperty("empId"));

		emp1.empDetails("Bradley", "Cooper");
		emp1.createLoginDetails();

	}

	@Test
	public void requiredFields() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dash.navigateToAddEmployee();
		emp.saveBtn.click();
		
		String expected="Required";
		String requiredFirstName=emp.reqFirstName.getText();
		String requiredLastName=emp.reqLastName.getText();
		
		AssertJUnit.assertEquals(requiredFirstName, expected,"First name not entered");
		AssertJUnit.assertEquals(requiredLastName, expected,"Last name not entered");
		
	}
}
