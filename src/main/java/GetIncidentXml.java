import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIncidentXml {

	@Test
	public void getIncident() {
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("sysparm_fields", "number, sys_id, category");
		map.put("category", "software");
		
		Response response = RestAssured.given()
				.queryParams(map)
				.accept(ContentType.XML)
				.when()
				.get();
		
		System.out.println(response.getStatusCode());
		System.out.println(response.contentType());
		System.out.println(response.prettyPrint());
		
		System.out.println(response.xmlPath().getList("response.result.sys_id"));
	}
	
}
