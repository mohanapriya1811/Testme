import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PatchRequest {

	@Test
	public void patchRequest() {
		
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		Response response = RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.queryParam("sysparm_fields", "category, sys_id, number, short_description")
		.body("{\"category\":\"inquiry\",\"short_description\":\"Laptop is broken\"}")
		.when()
		.patch("17ce4db49301021036287a718bba10f2");
		
		
		response.prettyPrint();
	}
}
