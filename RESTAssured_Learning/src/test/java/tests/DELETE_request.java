package tests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
	
public class DELETE_request {

	@Test
	public void testDELETE() {
		
		baseURI="https://reqres.in";
		 when().
		 	delete("/api/users/2").
		 then().
		 	statusCode(204).
		 	log().all();
	}
}
