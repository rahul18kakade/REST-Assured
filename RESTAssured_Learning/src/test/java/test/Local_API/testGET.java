package test.Local_API;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class testGET {

	@Test
	public void GET() {
		baseURI= "http://localhost:3000";
		
		given().
			get("/users").
		then().
			statusCode(200).
			body("[0].LastName", equalTo("Kakade")).
			log().all();
		
	}
	
	@Test
	public void GETusers() {
		baseURI= "http://localhost:3000";
		
		given().
			get("/users").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void GETsubjects() {
		baseURI= "http://localhost:3000";
		
		given().
			get("/subjects").
		then().
			statusCode(200).
			log().all();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
