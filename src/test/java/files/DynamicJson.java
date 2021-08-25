package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;


public class DynamicJson {
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle) {
		
		RestAssured.baseURI = "http://216.10.245.166";
		
		String response = given().log().all().header("Content-Type", "application/json").body(Payload.addBook(isbn,aisle))
		.when().post("Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println(response);
		
		
		JsonPath js = ReusableMethods.rawToJason(response);
		
		System.out.println("The book id is : "+js.get("ID"));
	}
	
	@DataProvider(name="BooksData")
	public Object[][] getData(){
		
		// array -> collection of element
		// multidimensional array -> collection of element
		return new Object[][] {{"hsd67","hds7h"},{"jhsd7h","xsjh7"},{"ccvv4e","54asf"}};
		
	}

}
