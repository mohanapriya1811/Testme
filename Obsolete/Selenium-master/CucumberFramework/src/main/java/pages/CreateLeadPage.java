package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CreateLeadPage extends BaseClass {
	
	@Given("Enter the companyname as {string}")
	public CreateLeadPage enterCompanyName(String cName) {
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		return this;
	}
	@Given("Enter the firstname as {string}")
	public CreateLeadPage enterFirstName(String fName) {
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		return this;

	}
	@Given("Enter the lastname as {string}")
	public CreateLeadPage enterLastName(String lName) {
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		return this;

	}
	@When("Click on Create Lead button")
	public ViewLeadPage clickCreatelead() {
		driver.findElement(By.name("submitButton")).click();
		return new ViewLeadPage();
	}
}
