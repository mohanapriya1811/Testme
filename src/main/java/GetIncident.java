import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetIncident {

	@Test
	public void getIncident() {
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		Response response = RestAssured.get();
		
		
		System.out.println(response.getStatusCode());
		System.out.println(response.contentType());
		System.out.println(response.prettyPrint());
	}
	
}
