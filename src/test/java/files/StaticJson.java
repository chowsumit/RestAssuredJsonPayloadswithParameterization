package files;

import static io.restassured.RestAssured.given;

import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


public class StaticJson {

	@Test
	public void addBook() throws Exception {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().log().all().header("Content-Type", "application/json").body(GenerateStringFromResource("E:\\Eclipse_workspace\\RestAssuredJsonPayloadswithParameterization\\Data\\Addbookdetails.json"))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
		
		JsonPath js = ReusableMethods.rawToJason(response);
		
		System.out.println("The book id is : "+js.get("ID"));
	}
	
	public static String GenerateStringFromResource(String path) throws IOException {
		
		return new String(Files.readAllBytes(Paths.get(path)));
		
	}
	
}
