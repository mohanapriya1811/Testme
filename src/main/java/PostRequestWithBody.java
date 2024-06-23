import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestWithBody {

	
	@Test
	public void postIncident() {
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		
		File file = new File("./src/main/resources/CreateIncident.json");
		Response response = RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "number, sys_id, category, short_description, description")
		//.body("{\"description\":\"Laptop is not working\",\"short_description\":\"TBA\",\"category\":\"Technology\"}")
		.body(file)	
		.when()
		.post();
		
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		//System.out.println(response.prettyPrint());
		
	}
}
