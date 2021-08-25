package files;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.PojoGooglePlace;
import pojo.PojoLocation;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class SpecBuilderSerializationTest {
	
	@Test
	public void SerializationGoogleMap() throws FileNotFoundException{
		
		PojoGooglePlace gp = new PojoGooglePlace(); 
		
		gp.setAccuracy(50);
		gp.setName("Frontline house");
		gp.setPhone_number("(+91) 983 893 3937");
		gp.setAddress("29, side layout, cohen 09");
		gp.setWebsite("http://google.com");
		gp.setLanguage("French-IN");
		
		List<String> mList = new ArrayList<String>();
		mList.add("Shoe park");
		mList.add("shop");
		gp.setTypes(mList);
		
		PojoLocation pl = new PojoLocation();
		pl.setLat(-38.383494);
		pl.setLng(33.427362);
		
		gp.setLocation(pl);
		//RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		PrintStream logRequest = new PrintStream(new FileOutputStream("RequestBody.txt"));
		PrintStream logResponse = new PrintStream(new FileOutputStream("ResponeBody.txt"));
		
		RequestSpecification reqSpecBuilder = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(logRequest))
				.addFilter(ResponseLoggingFilter.logResponseTo(logResponse))
				.setContentType(ContentType.JSON).build();
		
		RequestSpecification req = given().spec(reqSpecBuilder).body(gp);
		
		
		ResponseSpecification resSpecBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		Response resp = req.when().post("maps/api/place/add/json").then().spec(resSpecBuilder).extract().response();
		
		String responseString = resp.asString();
		
		System.out.println(responseString); 
		
	}

}
