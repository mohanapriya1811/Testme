import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class JsonValidator {

	
	@Test
	public void postIncident() {
		RestAssured.baseURI = "https://dev210493.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "ec2WIvC@L7j=");
		
		Response response = RestAssured.given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.when()
		.body(new File("./src/main/resources/CreateIncident.json"))
		.post();
		
		
		System.out.println(response.getStatusCode());
		///response.prettyPrint();
		//System.out.println(response.prettyPrint());
		//response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File("./src/main/resources/SchemaFile.json")));
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("SchemaFile.json"));
				

	}
}
