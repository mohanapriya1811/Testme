package testcases;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import base.BaseClass;
import base.ProjectSpecificMethods;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/feature", glue = {"pages"}, 
monochrome = true,
tags="@Login"
)
public class Login_TC_01 extends ProjectSpecificMethods {
	
	@BeforeTest
	public void setValue() {
		testcaseName = "VerifyLogin";
		testDescription = "Verify Login functionality with positive data";
		testAuthor = "Hari";
		testCategory = "Smoke";
		excelFileName = "Data_Sheet";
		sheetName = "Login";
	}
	 
	@Test(dataProvider = "fetchData")
	public void runLogin(Map<String, String>map) throws IOException {
		System.out.println(map.get("username"));
		System.out.println(map.get("password")); 
		new LoginPage()
		.enterUsername(map.get("username"))
		.enterPassword(map.get("password"))
		.clickLogin()
		.verifyHomepage();
	}
}
