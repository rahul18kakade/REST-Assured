package test.Local_API;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class XMLSchemaValidation {

	@Test
	public void schemaValidation() throws IOException {
		

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
			log().all().and().body("/AddResult.text()",equalTo("8")).
		and().
			assertThat().body(matchesXsdInClasspath("Document.xsd"));
		
	}
	
}
