package com.hrms.testcases;

import java.sql.Date;
import java.text.SimpleDateFormat;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class LoginTest extends CommonMethods{


	@Test(groups="smoke")
	public void validAdminLogin() {
		test.info("Entering valid admin credentials");
//	LoginPageElements login=new LoginPageElements();
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
//		DashBoardPageElements dash=new DashBoardPageElements();
		test.info("Verifying valid username shows with login with welcome");
		String expectedUser="Welcome Admin";
		String actualUser=dash.welcome.getText();
		Assert.assertEquals(actualUser,expectedUser,"Admin is not Logged in");
		Assert.assertTrue(actualUser.contains(ConfigsReader.getProperty("username")));
	}
	@Test(groups="regression")
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
		
		Assert.assertEquals(login.errorMsg.getText(), expected,"Error message text doesn't match");
	}
	
	@Test
	public void timeStamp() {
		Date d=new Date(0);
		System.out.println(d.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		sdf.format(d.getTime());
		
		
		
	}
}
