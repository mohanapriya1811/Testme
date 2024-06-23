import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GivenLogAll {

	
	@Test
	public void getIncident() {
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("sysparm_fields", "number, sys_id, category");
		map.put("category", "software");
		
		
		//given().log().all() -- log all the preconditions show it in the console
		Response response = RestAssured.given()
				.log()
				.all()
				.queryParams(map)
				.accept(ContentType.XML)
				.when()
				.get();
	
		response.prettyPrint();
	}
}
