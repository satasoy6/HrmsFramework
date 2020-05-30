package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddemployeeElements extends CommonMethods{

//	@FindBy(xpath="//input[@id='firstName']")
//	public WebElement Pim;
//	
//	@FindBy(id = "menu_pim_addEmployee")
//	public WebElement addEmpList;
	
	@FindBy(id = "firstName")
	public WebElement firstName;
	
	@FindBy(id = "lastName")
	public WebElement lastName;
	
	@FindBy(id = "employeeId")
	public WebElement empId;
	
	@FindBy(id="photofile")
	public WebElement chooseFile;
	
	@FindBy(id = "chkLogin")
	public WebElement checkboxLoginDetails;
	
	
	@FindBy(id = "user_name")
	public WebElement username;

	@FindBy(id = "user_password")
	public WebElement password;

	@FindBy(id = "re_password")
	public WebElement confirmPassword;

	@FindBy(id = "btnSave")
	public WebElement saveBtn;
	
	@FindBy(id="status")
	public WebElement dropDown;
	
	@FindBy(xpath="//span[@for='firstName']")
	public WebElement reqFirstName;
	
	@FindBy(xpath="//span[@for='lastName']")
	public WebElement reqLastName;
	
	
	
	
	

	
	public AddemployeeElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
//	public void addPhoto(String filePath) {
//		chooseFile.sendKeys(ConfigsReader.getProperty("filePath"));
//		
//	}

	public void empDetails(String fname,String lname) {
		sendText(firstName,fname);
		sendText(lastName,lname);
		sendText(chooseFile,ConfigsReader.getProperty("filePath"));
	}
	
	public void createLoginDetails() {
		click(checkboxLoginDetails);
		sendText(username, ConfigsReader.getProperty("userName"));
		sendText(password, ConfigsReader.getProperty("userPassword"));
		sendText(confirmPassword,ConfigsReader.getProperty("userPassword"));
		Select select=new Select(dropDown);
		select.selectByVisibleText("Enabled");
		saveBtn.click();
	}
}
	

