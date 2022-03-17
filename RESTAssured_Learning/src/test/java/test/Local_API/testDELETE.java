package test.Local_API;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class testDELETE {
	@Test
	public void DELETE() {
		baseURI= "http://localhost:3000";
		
		when().delete("/users/4").then().statusCode(404);
	}
	
}
