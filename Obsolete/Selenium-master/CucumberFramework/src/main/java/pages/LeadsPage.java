package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LeadsPage extends BaseClass {
	
	@When("Click on Create Lead link")
	public CreateLeadPage clickCreateLead() {
		if(prop == null) {
		driver.findElement(By.linkText("Create Lead")).click();
		}
		else {
		driver.findElement(By.linkText(prop.getProperty("LeadsPage.CreateLead.LinkText"))).click();
		}
		return new CreateLeadPage();
	}
}
