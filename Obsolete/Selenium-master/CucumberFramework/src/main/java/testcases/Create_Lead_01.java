package testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import base.ProjectSpecificMethods;
import io.cucumber.testng.CucumberOptions;
import pages.LoginPage;
import utils.ReadExcelData;

@CucumberOptions(features = "src/main/java/feature", glue = {"pages"}, 
monochrome = true,
tags="@Login"

)
public class Create_Lead_01 extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValue() {

		excelFileName = "Data_Sheet";
		sheetName = "Create_Lead";
		testcaseName = "CreateLead";
		testDescription = "Verify Lead functionality with positive data";
		testAuthor = "Hari";
		testCategory = "Smoke";

	}
	
	
	@Test(dataProvider = "fetchData")
	public void runCreateLead(Map<String, String> map) throws IOException {
		
		System.out.println(map);
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		new LoginPage()
		.enterUsername(map.get("username"))
		.enterPassword(map.get("password"))	
		.clickLogin()
		.clickCRMSFA()
		.clickLeads()
		.clickCreateLead()
		.enterCompanyName(map.get("company name"))
		.enterFirstName(map.get("first name"))
		.enterLastName(map.get("last name"))
		.clickCreatelead();
	}
}
