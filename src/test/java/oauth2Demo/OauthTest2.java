package oauth2Demo;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class OauthTest2 {
	@Test
	public void Test() {
		System.out.println("Hello....");
		
		  String url =
		  "https://rahulshettyacademy.com/getCourse.php?code=4%2F0gE_It9XR32LvDhbAzj6TQjJOtA1sVij2SKMQkd92QcldRsjX8wFeUJ97r8gJMIjA-xAwsuOD0D2yN3XD7_IWgw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=none#";
		  
		  String partialcode=url.split("code=")[1];
		  
		  String code=partialcode.split("&scope")[0];
		  
		  System.out.println("############## "+ code);
		  
		  ////////////////////// 
		  String responceToken = 
				  	given() 
				  .queryParams("code","") 
				  .queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				  .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				  .queryParams("grant_type", "authorization_code") 
				  .queryParams("scope","email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
				  .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				  .when().log().all() 
				  .post("https://www.googleapis.com/oauth2/v4/token")
				  .asString();
		  
		  JsonPath js = new JsonPath(responceToken); String token =
		  js.getString("access_token"); System.out.println("################ " +token);
		  
		  ///////////////////////// 
		  given() 
		  .queryParam("access_token", token) 
		  .when()
		  .get("https://rahulshettyacademy.com/getCourse.php") 
		  .asString();
		 
	}
	
	
}
