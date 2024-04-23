package pages;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class MyHomePage extends BaseClass {

	@When("Click on Leads link")
	public LeadsPage clickLeads() {
		if(prop == null) {
		System.out.println(prop);
		driver.findElement(By.linkText("Leads")).click();
		}
		else {
		String text = prop.getProperty("MyHomePage.Leads.LinkText");
		System.out.println(prop);
		driver.findElement(By.linkText(prop.getProperty("MyHomePage.Leads.LinkText"))).click();
		}
		return new LeadsPage();
	}
}
