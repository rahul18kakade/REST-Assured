package test.Local_API;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class testPATCH {

	@Test
	public void PATCH() {
		
		JSONObject obj= new JSONObject();
		obj.put("FistName", "Abhinav");
		
		baseURI= "http://localhost:3000";
		
		given().
			header("ContentType","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(obj.toJSONString()).
		when().
			patch("/users/1").
		then().
			statusCode(200).
			log().all();
		
	}
	
	
	
	
	
}
