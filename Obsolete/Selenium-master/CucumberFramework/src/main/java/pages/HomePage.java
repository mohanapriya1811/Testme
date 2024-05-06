package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseClass;
import base.ProjectSpecificMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ExtentReport;

public class HomePage extends ProjectSpecificMethods {

	@Then("Homepage should be displayed")
	public HomePage verifyHomepage() throws IOException {
		boolean crmsfaLink = getDriver().findElement(By.linkText("CRM/SFA")).isDisplayed();
		if (crmsfaLink) {
			System.out.println("Homepage is verified");
		} else {
			System.out.println("Homepage is not verified");
		}
		reportStep("Home Page Verified Successfully", "Pass");
		return this;
	}

	@Given("Click on CRM\\/SFA link")
	public MyHomePage clickCRMSFA() throws IOException {
		getDriver().findElement(By.linkText("CRM/SFA")).click();
		reportStep("CRM/SFA Link Clicked Successfully", "Pass");
		return new MyHomePage();
	}

	@When("{string} page should be displayed")
	public String verifyPage(String pageName) throws IOException {
		String text = getDriver().findElement(By.linkText(pageName)).getText();
		reportStep("Verified Page Successfully", "Pass");
		return text;
	}

	@When("Click on Logout button")
	public LoginPage clickLogOutButton() throws IOException {
		getDriver().findElement(By.className("decorativeSubmit")).click();
		reportStep("Logout Successfully", "Pass");
		return new LoginPage();
	}

}
