package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;
import base.ProjectSpecificMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utils.ExtentReport;

public class MyHomePage extends ProjectSpecificMethods {

	@When("Click on Leads link")
	public LeadsPage clickLeads() throws IOException {
		if(getProperty() == null) {
		System.out.println(getProperty());
		getDriver().findElement(By.linkText("Leads")).click();
		}
		else {
		String text = getProperty().getProperty("MyHomePage.Leads.LinkText");
		System.out.println(getProperty());
		getDriver().findElement(By.linkText(getProperty().getProperty("MyHomePage.Leads.LinkText"))).click();
		}
		reportStep("Clicked on Leads Link Succesfully", "Pass");
		return new LeadsPage();
	}
}
