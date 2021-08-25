package files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	public static JsonPath rawToJason(String resp) {
		
		return new JsonPath(resp);
		
	}
	
}
