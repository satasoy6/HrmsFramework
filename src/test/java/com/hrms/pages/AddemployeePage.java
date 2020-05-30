package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddemployeePage extends CommonMethods{
	
	@FindBy(xpath="//input[@id='firstName']")
	public WebElement firstName;

	@FindBy(xpath="//b[contains(text(),'PIM')]")
	public WebElement lastName;

	@FindBy(id="employeeId")
	public WebElement id;

	@FindBy(id="photofile")
	public WebElement chooseFile;
	
	@FindBy(id="chkLogin")
	public WebElement createDetails;
	
	@FindBy(id="btnSave")
	public WebElement saveBtn;
	
	public AddemployeePage() {
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
	public void addPhoto(String filePath) {
		chooseFile.sendKeys(ConfigsReader.getProperty("filePath"));
		
	}

	
	
	
}
