import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {

	
	@Test
	public void postIncident() {
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		Response response = RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "number, sys_id")
		.when()
		.post();
		
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		//System.out.println(response.prettyPrint());
		
	}
}
