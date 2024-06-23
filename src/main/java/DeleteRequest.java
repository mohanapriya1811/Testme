import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest {

	@Test
	public void deleteRequest() {
		
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		Response response = RestAssured.delete("17ce4db49301021036287a718bba10f2");
		response.prettyPrint();
	}
}
