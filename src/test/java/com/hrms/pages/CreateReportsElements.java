package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class CreateReportsElements extends CommonMethods{

	//As an admin i should be able to create a report
	@FindBy(xpath = "//a[@id='menu_pim_viewPimModule']")
	public WebElement PIM;
	
	@FindBy(id="btnAdd")//click method
	public WebElement addButton;
	
	//Create method
	@FindBy(xpath="//input[@id='report_report_name']")
	public WebElement reportName;
	
	@FindBy(name="report[criteria_list]")
	public WebElement selectionCriteria;
	
//	Select select=new Select(selectionCriteria);
	@FindBy(id="report_include_comparision")
	public WebElement inclusion;
	
	@FindBy(id="report_education")
	public WebElement education;
	
	@FindBy(id="employee_name_empName")
	public WebElement empName;
	
	@FindBy(id="report_pay_grade")
	public WebElement payGrade;
	
	@FindBy(id="report_employment_status")
	public WebElement empStatus;
	
	@FindBy(id="service_period_comparision")
	public WebElement servicePeriod;
	
	@FindBy(id="joined_date_comparision")
	public WebElement joinDate;
	
	@FindBy(id="report_job_title")
	public WebElement jobTitle;
	
	@FindBy(id="report_language")
	public WebElement language;
	
	@FindBy(id="report_skill")
	public WebElement skill;
	
	@FindBy(id="age_group_comparision")
	public WebElement ageGroup;
	
	@FindBy(id="report_sub_unit")
	public WebElement subUnit;
	
	@FindBy(id="report_display_groups")
	public WebElement dispFieldGroups;
	
	@FindBy(id="report_display_field_list")
	public WebElement dispField;
	
	@FindBy(id="btnSave")
	public WebElement saveBtn;
	
	
	public CreateReportsElements(){
		PageFactory.initElements(BaseClass.driver, this);
	}
	
	
}
