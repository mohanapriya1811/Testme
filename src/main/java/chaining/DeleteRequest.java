package chaining;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteRequest extends BaseClass {

	@Test
	public void deleteRequest() {
	
		response = inputFields.delete(sys_id);
		
	}
}
