package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PUT_request {
	@Test
	public void testPUTrequest() {
		JSONObject obj= new JSONObject();
		
		obj.put("name","Rahul");
		obj.put("job","Tester");
		
		baseURI="https://reqres.in";
		
		given().
			header("ContentType","application/json").
			contentType(ContentType.JSON).accept(ContentType.JSON).
		when().
			put("/api/users/2").
		then().
			statusCode(200).
			log().all();
		
	}
	
	
	
}
