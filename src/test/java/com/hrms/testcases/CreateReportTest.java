package com.hrms.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;
import com.hrms.utils.ExcelUtility;

public class CreateReportTest extends CommonMethods {

	@Test(groups = "regression", dataProvider = "getDataExcel")

	public void addReport(String reportName, String selection, String selected, String fieldGroup,
			String displayFields) {
		test.info("Entering valid admin credentials");
		login.loginToHRMS();
		dash.navigateToAddEmployee();
		test.info("Navigating to Reports");
		dash.navigateToAddReports();
		
		test.info("Defining reports");
		report.addButton.click();// click to add Button

		report.reportName.sendKeys(reportName);
		report.selectionCriteria.sendKeys(selection);
		wait(2);
		Select select = new Select(report.inclusion);
		select.selectByVisibleText(selected);

		report.dispFieldGroups.sendKeys(fieldGroup);

		report.dispField.sendKeys(displayFields);
		wait(2);

		report.saveBtn.click();

	}

	@DataProvider

	public Object[][] getDataExcel() {

		return ExcelUtility.excelintoArray(Constants.TESTDATA_FILEPATH, "CreateReports");

	}

}
