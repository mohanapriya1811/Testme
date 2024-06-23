package chaining;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIncidentWithFilters extends BaseClass {

	@Test
	public void getIncident() {
		
		
		 
		 
		Map<String, String> map = new HashMap<String, String>();
		map.put("sysparm_fields", "number, sys_id, category");
		map.put("category", "software");
		
		 response = inputFields
		.queryParams(map)
		.accept(ContentType.JSON)
		.when()
		.get();
		 
		// System.out.println("@Test " +inputFields);
		// System.out.println("@Test " +response);
		 
		 List<String> list = response.jsonPath().getList("result.sys_id");
		 sys_id = list.get(1);
	}
	
}
