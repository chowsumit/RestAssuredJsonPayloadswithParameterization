package files;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.PojoGooglePlace;
import pojo.PojoLocation;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

public class SerializationTest {
	
	@Test
	public void SerializationGoogleMap(){
		
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
		RestAssured.baseURI ="https://rahulshettyacademy.com";
		
		Response resp =given().log().all().queryParam("key", "qaclick123").body(gp)
		.when().post("maps/api/place/add/json").
		then().assertThat().statusCode(200).extract().response();
		
		String responseString = resp.asString();
		
		System.out.println(responseString); 
		
	}

}
