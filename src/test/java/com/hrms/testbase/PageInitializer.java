package com.hrms.testbase;

import com.hrms.pages.AddemployeeElements;
import com.hrms.pages.DashBoardPageElements;
import com.hrms.pages.LoginPageElements;
import com.hrms.pages.PersonalDetailsElements;


//initializes all pages class and stores references in static variables
//that will called / used in test classes

public class PageInitializer extends BaseClass{

	public static LoginPageElements login;
	public static AddemployeeElements emp;
	public static DashBoardPageElements dash;
	public static PersonalDetailsElements pdetails;
	
	
	public static void initialize() {
		login=new LoginPageElements();
		emp=new AddemployeeElements();
		dash=new DashBoardPageElements();
		pdetails=new PersonalDetailsElements();
		
	}
}
