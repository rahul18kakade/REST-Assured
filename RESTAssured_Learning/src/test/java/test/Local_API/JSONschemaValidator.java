package test.Local_API;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JSONschemaValidator {

	@Test
	public void schemaValidator() {
		baseURI= "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
			statusCode(200);
				
	}
	
	

	@Test
	public void newSchemaValidator() {
		baseURI= "https://reqres.in/api";
		given().
			get("/users/2").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("newSchema.json")).
			statusCode(200);
				
	}
	
}
