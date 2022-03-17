package test.Local_API;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

public class SoapXMLRequest {

	@Test
	public void validateSoapXML() throws IOException {
		
		File file= new File("./SOAPrequest/Add.xml");
		if(file.exists())
			System.out.println("  >> FileExist ");
		FileInputStream fis= new FileInputStream(file);
		
		String requestBody= IOUtils.toString(fis, "UTF-8");
		
		baseURI= "http://www.dneonline.com/";
		
		given().
			contentType("text/xml").accept(ContentType.XML).
			body(requestBody).
		when().
			post("/calculator.asmx").
		then().
			statusCode(200).
			log().all().
		and().
			body("/AddResult.text()",equalTo("8"));
	}
	
}
