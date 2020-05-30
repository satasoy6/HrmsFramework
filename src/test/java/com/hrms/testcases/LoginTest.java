package com.hrms.testcases;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods{

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
	 * As an admin I should be able to login to HRMS
	 * As  an ESS user I should be able to login to HRMS
	 * As an Invalid user I should see error message
	 * 		Acceptance criteria:
	 * 
	 * 1.When user enters valid username and invalid password "invalid credentials"should be displayed
	 * 
	 * 2.When user enters valid username and empty password "Password cannot be empty" should be displayed
	 * 
	 * 3.When user enters empty username and valid password "Username cannot be empty" should be displayed
	 */
	
	@Test(groups="smoke")
	public void validAdminLogin() {
//	LoginPageElements login=new LoginPageElements();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
//		DashBoardPageElements dash=new DashBoardPageElements();
		
		String expectedUser="Welcome Admin";
		String actualUser=dash.welcome.getText();
		Assert.assertEquals(actualUser,expectedUser,"Admin is not Logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}
	@Test
	public void invalidPasswordLogin() {
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password,"an invalid password");
		click(login.loginBtn);
		
		String expected="Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected,"Error message text doesn't match");
	
		
	}
	
	@Test(enabled=true)
	public void emptyUsernameLogin() {
		sendText(login.password,ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		String expected="Username cannot be empty";
		
		AssertJUnit.assertEquals(login.errorMsg.getText(), expected,"Error message text doesn't match");
	}
}
