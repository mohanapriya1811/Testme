package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;
import base.ProjectSpecificMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.ExtentReport;

public class CreateLeadPage extends  ProjectSpecificMethods{
	
	@Given("Enter the companyname as {string}")
	public CreateLeadPage enterCompanyName(String cName) throws IOException {
		getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		reportStep("Company Name Entered Successfully", "Pass");
		return this;
	}
	@Given("Enter the firstname as {string}")
	public CreateLeadPage enterFirstName(String fName) throws IOException{
		getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		reportStep("First Name Entered Successfully", "Pass");
		return this;

	}
	@Given("Enter the lastname as {string}")
	public CreateLeadPage enterLastName(String lName) throws IOException{
		getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		reportStep("Last Name Entered Successfully", "Pass");
		return this;

	}
	@When("Click on Create Lead button")
	public ViewLeadPage clickCreatelead() throws IOException {
		getDriver().findElement(By.name("submitButton")).click();
		reportStep("Create Lead Button Clicked Successfully", "Pass");
		return new ViewLeadPage();
	}
}
