import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIncidentWithFilters {

	@Test
	public void getIncident() {
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("sysparm_fields", "number, sys_id, category");
		//map.put("sysparm_limit", "1");
		map.put("category", "software");
		/*
		Response response = RestAssured.given().queryParam("sysparm_fields", "number, sys_id")
		.when()
		.get();
		*/
		Response response = RestAssured.given()
		.queryParams(map)
		.accept(ContentType.JSON)
		.when()
		.get();
		
		//System.out.println(response.prettyPrint());
		//List<String> allList = response.jsonPath().getList("result.sys_id");
		//System.out.println(allList);
		//System.out.println(response.getStatusCode());
		//System.out.println(response.contentType());
		//System.out.println(response.prettyPrint());
		//System.out.println(response.contentType());
		System.out.println(response.jsonPath().getList("result.number"));
	}
	
}
