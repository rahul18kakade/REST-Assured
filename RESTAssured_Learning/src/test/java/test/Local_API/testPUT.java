package test.Local_API;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import org.json.simple.JSONObject;

public class testPUT {

	@Test
	public void PUT() {
		
		JSONObject obj= new JSONObject();
		obj.put("FistName", "Abhinav");
		obj.put("LastName", "Sharma");
		obj.put("SubjectId", 4);
		
		
		baseURI= "http://localhost:3000";
		
		given().
			header("ContentType","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(obj.toJSONString()).
		when().
			put("/users/1").
		then().
			statusCode(200).
			log().all();
		
	}
	
	
	
	
	
	
	
}
