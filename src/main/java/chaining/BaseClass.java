package chaining;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	
	  public static RequestSpecification inputFields =
	  RestAssured.given().log().all(); public static Response response = null;
	  public static String sys_id = null;
	  
	  @BeforeMethod public void preCondition(){ RestAssured.baseURI =
	  "https://dev210493.service-now.com/8080/api/now/table/incident";
	  RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
	  inputFields = RestAssured.given().log().all();
	  }
	  //System.out.println(inputFields); //System.out.println(response); }
	 
	/*
	 * @AfterMethod public void postCondition() {
	 * 
	 * System.out.println(response.getStatusCode()); response.prettyPrint();
	 * System.out.println(inputFields); System.out.println(response); }
	 */
}
