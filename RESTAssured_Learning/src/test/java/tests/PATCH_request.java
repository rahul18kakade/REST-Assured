package tests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class PATCH_request {
 @Test
 public void testPATCH() {
	 
	 JSONObject obj1= new JSONObject();
	 obj1.put("name","rahul");
	 obj1.put("job","tester");
	 
	 baseURI= "https://reqres.in";
	 given().
	 	header("Contenttype","application/json").
	 	contentType(ContentType.JSON).accept(ContentType.JSON).
	 when().
	 	patch("/api/users/2").
	 then().
	 	statusCode(200).
	 	log().all();
 }
}
