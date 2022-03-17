/**
 * 
 */
package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
/**
 * @author User
 *
 */
public class POST_request {

	@Test
	public void testGET() {
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
				body("data[4].first_name",equalTo("George")).
				body("data.first_name",hasItems("Michael","Tobias","Lindsay","Rachel"));
		
	}
	
	@Test
	public void testPOST() {
		
		Map<String,Object > map= new HashMap<String, Object>();
		map.put("name", "Rahul");
		map.put("job", "Testing");	
		System.out.println(map);
		
		JSONObject request= new JSONObject(map);
		System.out.println(request.toJSONString());
	
	}
	
	@Test
	public void testGETAndPOST() {
		
		JSONObject obj= new JSONObject();
		obj.put("name", "Rahul");
		obj.put("job", "AutomationTester");
		//System.out.println(obj.toJSONString());
		
		baseURI= "https://reqres.in/api";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
			body(obj.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();	
	}
	
	@Test
	public void testPOSTRegisterSuccessful() {
		JSONObject register= new JSONObject();
		register.put("email","rahul@gmail.com");
		register.put("password", "rahul123");
		register.put("email", "rohit@gmail.com");
		register.put("password", "rohit123");
		register.put("email", "eve.holt@reqres.in");
		register.put("password", "pistol");
		System.out.println(register);
		
		baseURI= "https://reqres.in/api";
		
		given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(register.toJSONString()).
		when().
			post("/register").
		then().
			statusCode(200).
			log().all();	
	}
	
	
	@Test
	public void testPOSTRegisterUnsuccessful() {
		
		JSONObject reg= new JSONObject();
		reg.put("email", "sydney@fife");
		
		baseURI="https://reqres.in/api";
		
		given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(reg.toJSONString()).
		when().
			post("/register").
		then().
			statusCode(400).
			log().all();
	}
	
	@Test
	public void testPOSTLoginSuccessful() {
		
		JSONObject log= new JSONObject();
		log.put("email","eve.holt@reqres.in");
		log.put("password","cityslicka");
		baseURI="https://reqres.in/api";
		given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(log.toJSONString()).
		when().
			post("/login").
		then().
			statusCode(200).
			log().all();		
	}
	
	@Test
	public void testPOSTLoginUnsuccessful() {
		JSONObject login= new JSONObject();
		login.put("email", "peter@klaven");
		baseURI="https://reqres.in/api";
		given().
			contentType(ContentType.JSON).accept(ContentType.JSON).
			body(login.toJSONString()).
		when().
			post("/login").
		then().
		 	statusCode(400).
		 	log().all();
		
	}
}
