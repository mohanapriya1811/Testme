package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;
import base.ProjectSpecificMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.ExtentReport;

public class LeadsPage extends ProjectSpecificMethods {
	
	@When("Click on Create Lead link")
	public CreateLeadPage clickCreateLead() throws IOException {
		if(getProperty() == null) {
		getDriver().findElement(By.linkText("Create Lead")).click();
		}
		else {
		getDriver().findElement(By.linkText(getProperty().getProperty("LeadsPage.CreateLead.LinkText"))).click();
		}
		reportStep("Clicked Create Lead link Successfully", "Pass");
		return new CreateLeadPage();
	}
}
