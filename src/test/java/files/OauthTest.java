package files;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.util.Scanner;

public class OauthTest {

	@Test
	public void oAuthTest() throws InterruptedException {
		
		
		/*System.setProperty("webdriver.chrome.driver", "E:\\Eclipse_workspace\\RestAssuredJsonPayloadswithParameterization\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		String url1= "https://accounts.google.com/signin/oauth/identifier?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&state=verifyfjdss&o2v=2&as=hFTwwBiz73xH8c1cr-KNIA&flowName=GeneralOAuthFlow";
		driver.get(url1);
		driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("chowsumit@gmail.com");
		Thread.sleep(60000);
		
		
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/span/span")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("********");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String url = driver.getCurrentUrl();*/
		
		/********
		 * 1. Launch Browser
		 * 2. Put following in the url : "https://accounts.google.com/signin/oauth/identifier?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&state=verifyfjdss&o2v=2&as=hFTwwBiz73xH8c1cr-KNIA&flowName=GeneralOAuthFlow"
		 * 3. Login with gmail id and password
		 * 4. Capture the url of the newly open browser.
		 * 5. Give that url as the input of the program 
		 * *********/
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the url : ");
		String str =sc.nextLine();
		//System.out.println(str);
		String output=" ";
		String[] arr;
		arr = str.split("&code=");
		
		String str2 = arr[1];
		String[] arr1;
		
		arr1 = str2.split("&scope=");
		
		String codeValue = arr1[0];
		
		
		
		
		
		String acctessTokenResponse = given().urlEncodingEnabled(false)
		.queryParams("code", codeValue)
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redurect_uri", "https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type", "authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		 
		JsonPath js = new JsonPath(acctessTokenResponse);
		String accessToken = js.getString("access_token");
		
		
		//System.out.println("The access token is : "+accessToken);
		
		String response = given().queryParam("access_token", accessToken)
		.when().log().all() 
		.get("https://rahulshettyacademy.com/getCourse.php").asString();
		
		System.out.println(response);
	}
	
}
