import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PutRequest {

	@Test
	public void putRequest() {
		
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		Response response = RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "category, sys_id, number")
		.body("{\"category\":\"inquiry\",\"short_description\":\"Laptop is down\"}")
		.when()
		.put("17ce4db49301021036287a718bba10f2");
		
		
		response.prettyPrint();
	}
}
