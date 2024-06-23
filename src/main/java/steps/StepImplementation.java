package steps;
import java.io.File;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepImplementation {

	public static RequestSpecification inputFields = null;
	public static Response response = null;
	public static Logger log = LogManager.getLogger();
	
	
	@Given("Set the End Point for the Service Now Application")
	public void setEndPoint() {
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		log.info("BaseURI");
	}
	
	@Given("Set the Authentication for the Service Now Application")
	public void setAuthentication() {
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		inputFields = RestAssured.given().log().all();
		log.info("Authentication");
	
	}
	@Given("Set the Content Type for the Create Incident Request")
	public void setContentType() {
		inputFields.contentType(ContentType.JSON);
		log.info("Content_Type");
	}
	@Given("Set the Accept Type for the Create Incident Response")
	public void setAcceptType() {
		inputFields.accept(ContentType.JSON);
	}	

	/*
	 * @Given("Set the Query Params for the Create Incident Request") public void
	 * setQueryParams() { inputFields.queryParam("sysparm_fields",
	 * "number, sys_id, category, short_description, description"); }
	 */
	
	@Given("Set the Query Params for the Create Incident Request")
	public void setQueryParm(DataTable table) {
		Map<String, String> map = table.asMap();
		inputFields.queryParams(map);
	}
	@Given("Set the Request Body for the {string} Request")
	public void setRequestBody(String fileName) {
		File file = new File("./src/main/resources/"+fileName);
		inputFields.body(file);  
	}
	@When("Send the Post Request to Create an Incident")
	public void sendPost() {
		response = inputFields.when().post();
	}
	
	@When("Send the Get Request to get all Incident")
	public void sendGet() {
		response = inputFields.when().get();
	}
	
	@Then("Validate the Status Code of the Post Request as {int}")
	public void validateResponseCode(int expCode) {
		int code = response.getStatusCode();
		System.out.println(code);
		if(code == expCode) {
			System.out.println("Passed");
		}
	}
	@Then("Validate the number field starts with INC")
	public void validateInc() {
		response.prettyPrint();
		response.then().assertThat().body("result[1].number", Matchers.containsString("INC"));
	}
	
	
}
