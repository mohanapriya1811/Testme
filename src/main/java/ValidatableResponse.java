import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ValidatableResponse {

	@Test
	public void getIncident() {
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("sysparm_fields", "number, sys_id, category");
		map.put("category", "software");
		
		Response response = RestAssured.given()
				.queryParams(map)
				.accept(ContentType.JSON)
				.when()
				.get();
	
		response.then().assertThat().body("result[1].number", Matchers.containsString("INC"));
		response.then().assertThat().body("result.number", Matchers.hasItem("INC"));
		response.then().assertThat().body("result[2].number", Matchers.equalTo("INC"));
	}
}
