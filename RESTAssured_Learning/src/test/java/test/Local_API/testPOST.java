package test.Local_API;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class testPOST {

	@Test
	public void POST() {
		
		JSONObject obj= new JSONObject();
		obj.put("FistName", "Abhinav");
		obj.put("LastName", "Sharma");
		obj.put("SubjectId", 1);
		
		
		baseURI= "http://localhost:3000";
		
		given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(obj.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
	
		
	}
	
	
}
