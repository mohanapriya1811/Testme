package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Optional;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.But;

import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

import base.BaseClass;
import utils.ExtentReport;

public class LoginPage extends BaseClass {

	@Given("Enter the username as {string}")
	public LoginPage enterUsername(String uName) throws IOException {
		try {
		if (prop == null) {

			driver.findElement(By.id("username")).sendKeys(uName);
			reportStep("Username is entered successfully", "pass");

		} else {

			driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
			reportStep("Username is entered successfully", "pass");
		}
		}
		catch (Exception e) {
			reportStep("Username is not entered successfully", "fail");
		}
			 

		return this;
	}

	@Given("Enter the password as {string}")
	public LoginPage enterPassword(String pName) throws IOException {
		try {
			if (prop == null) {

				driver.findElement(By.id("password")).sendKeys(pName);
				reportStep("Password is entered successfully", "pass");
			} else {

				driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
				reportStep("Password is entered successfully", "pass");

			}
		} catch (Exception e) {
			reportStep("Password is not entered successfully", "pass");
		}

		return this;

	}

	@Given("Click on Login button")
	public HomePage clickLogin() throws IOException {
			try {
			driver.findElement(By.className("decorativeSubmit")).click();
			reportStep("Loggedin successfully", "pass");
			}
			catch (Exception e) {
			reportStep("Loggedin not successfully", "fail");
			}
		
		return new HomePage();
	}

	@But("User should not be logged in successfully")
	public LoginPage verifyLoginpage() {
		boolean loginLink = driver.findElement(By.xpath("//h2[text()='Leaftaps Login']")).isDisplayed();
		if (loginLink) {
			System.out.println("Loginpage is verified");
		} else {
			System.out.println("Loginpage is not verified");
		}
		return this;
	}

	@Given("^Enter the login details as below$")
	public LoginPage loginUsingDatatable(DataTable datatable) {
		/*
		 * List<Map<String, String>> map = datatable.entries();
		 * 
		 * for(Map<String, String> mapList : map) {
		 * driver.findElement(By.id("username")).sendKeys(mapList.get("username"));
		 * driver.findElement(By.id("password")).sendKeys(mapList.get("password"));
		 * driver.findElement(By.className("decorativeSubmit")).click(); new
		 * HomePage().clickLogOutButton();
		 * 
		 * }
		 */

		List<List<String>> list = datatable.asLists();
		for (int i = 1; i < list.size(); i++) {
			List<String> listInner = list.get(i);
			ListIterator iterate = listInner.listIterator();
			while (iterate.hasNext()) {
				driver.findElement(By.id("username")).sendKeys(iterate.next().toString());
				driver.findElement(By.id("password")).sendKeys(iterate.next().toString());
				driver.findElement(By.className("decorativeSubmit")).click();
				new HomePage().clickLogOutButton();
			}
		}
		return this;
	}
}
