package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage extends BaseClass {
	
	@Then("Homepage should be displayed")
	public HomePage verifyHomepage() {
		boolean crmsfaLink = driver.findElement(By.linkText("CRM/SFA")).isDisplayed();
		if(crmsfaLink) {
			System.out.println("Homepage is verified");
		}
		else {
			System.out.println("Homepage is not verified");
		}
		return this;
	}
	@Given("Click on CRM\\/SFA link")
	public MyHomePage clickCRMSFA() {
		driver.findElement(By.linkText("CRM/SFA")).click();
		return new MyHomePage();
	}
	
	@When("{string} page should be displayed")
	public String verifyPage(String pageName) {
		String text = driver.findElement(By.linkText(pageName)).getText();
		return text;
	}
	@When("Click on Logout button")
	public LoginPage clickLogOutButton() {
		driver.findElement(By.className("decorativeSubmit")).click();
	return new LoginPage();	
	}
	
	
}
