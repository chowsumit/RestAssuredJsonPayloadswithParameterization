package files;

import static io.restassured.RestAssured.given;

import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.GetWeather;


public class DeserializationTest {

	/***
	 * The Desrialization is done on the Weather.java program
	 * ***/
	
	
	@Test
	public void getWeatherDetails() {
		
		
		
		
		
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/Edmonton";
		
		GetWeather response = given()
		.when().get()
		.then()
		.extract().response().as(GetWeather.class);
		
		//System.out.println(response);
		
		
		System.out.println("The city is : "+response.getCity());
		System.out.println("The humidity is : "+response.getHumidity());
		System.out.println("The temperature is : "+response.getTemperature());
		System.out.println("The weather description is : "+response.getWeatherDescription());
		System.out.println("The wind direction degree is : "+response.getWindDirectionDegree());
		System.out.println("The wind speed is : "+response.getWindSpeed());
		
		
				
			
		
		//System.out.println(responseBody);
		
		
		
		
		
	}
	
}
