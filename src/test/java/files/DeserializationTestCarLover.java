package files;

import static io.restassured.RestAssured.given;

import java.nio.file.Paths;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;

import org.openqa.selenium.json.Json;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.getCarLover;


public class DeserializationTestCarLover {

	/***
	 * The Desrialization is done on the Weather.java program
	 * ***/
	
	
	@Test
	public void getWeatherDetails() {
		
		
		
		String resp1 = "{\r\n" + 
				"  \"name\":\"John\",\r\n" + 
				"  \"age\":30,\r\n" + 
				"  \"City\": \"Edmonton\",\r\n" + 
				"  \"cars\": {\r\n" + 
				"    \"car1\":[\r\n" + 
				"            {\r\n" + 
				"              \"ford\":\"Gita\",\r\n" + 
				"              \"bmw\":\"Sita\"\r\n" + 
				"            }\r\n" + 
				"           ],\r\n" + 
				"    \"car2\":[\r\n" + 
				"            {\r\n" + 
				"              \"ford\":\"Jadu\",\r\n" + 
				"              \"bmw\":\"Madhu\"\r\n" + 
				"            }\r\n" + 
				"           ],\r\n" + 
				"    \"car3\":[\r\n" + 
				"            {\r\n" + 
				"              \"ford\":\"Ram\",\r\n" + 
				"              \"bmw\":\"Shyam\"\r\n" + 
				"            }\r\n" + 
				"           ]\r\n" + 
				"  },\r\n" + 
				"  \r\n" + 
				"  \"Humidity\": \"58 Percent\",\r\n" + 
				"  \"WeatherDescription\": \"broken clouds\"\r\n" + 
				" }";
		
		
		//Response resp2 = resp1.defaultParser(Parser.JSON);
				
			
		//getCarLover gc = resp1.as(getCarLover.class);
		
		
		//System.out.println(responseBody);
		System.out.println(resp1);
		
		
		
		
	}
	
}
