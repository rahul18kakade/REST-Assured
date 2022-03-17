package tests;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.net.http.HttpResponse.BodyHandler;

public class GET_Request {
	
	@Test
	public void singleUser() {
		given().
			get("/users/2").
		then().
			statusCode(200).
			body("data.id", equalTo(2)).
			log().all();	
	}
	
	@Test
	public void listuser() {
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[2].id", equalTo(9)).
			log().all();		
	}
	
	@Test
	public void notFound() {
		given().
			get("/users/23").
		then().	
			statusCode(404).
			log().all();
	}
	
	@Test
	public void listResources() {
		
		given().
			get("/unknown").
		then().
			statusCode(200).
			body("data[0].name", equalTo("cerulean")).
			log().all();
	}
	
	@Test
	public void singleResources() {
		given().
			get("/unknown/2").
		then().
			statusCode(200).
			body("data.name", equalTo("fuchsia rose")).
			body("data.year",equalTo(2001)).
			log().all();
	}

	@Test
	public void notFoundSingleResource() {
		given().
			get("/unknown/23").
		then().
			statusCode(404).
			log().all();
	}

	@Test
	public void delayedResponce() {
		baseURI= "https://reqres.in/api";
		given().
			get("/users?delay=3").
		then().
			statusCode(200).
			body("data[0].first_name",equalTo("George")).
			log().all();	
	}

}
