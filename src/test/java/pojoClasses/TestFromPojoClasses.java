package pojoClasses;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class TestFromPojoClasses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.out.println("Hello....");
			
			  String url =
			  "https://rahulshettyacademy.com/getCourse.php?code=4%2F0gFgQOjT0YoLgqPJjz1rQEFdxfQMGdlma9W1WXbIWoFI4zJMQOksebJ-jv34TgNxh7KdzctK8I8JCTwa4VcM198&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=none#";
			  
			  String partialcode=url.split("code=")[1];
			  
			  String code=partialcode.split("&scope")[0];
			  
			  System.out.println("############## "+ code);
			  
			  ////////////////////// 
			  String responseToken = 
					  	given() 
					  	.contentType("application/json")
					  	 .urlEncodingEnabled(false)
					  .queryParams("code",code) 
					  .queryParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
					  .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
					  .queryParams("grant_type", "authorization_code") 
					  .queryParams("scope","email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
					  .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
					  .when().log().all() 
					  .post("https://www.googleapis.com/oauth2/v4/token")
					  .asString();
			  
			  JsonPath js = new JsonPath(responseToken); 
			  String token = js.getString("access_token"); 
			  System.out.println("################ Token " +token);
			  
			  ///////////////////////// 
			 GetCourses pojoResponse = 
					 given()
					 
			  .contentType("application/json")
			  .queryParam("access_token", token) 
			  .expect().defaultParser(Parser.JSON)  
			  .when()
			  .get("https://rahulshettyacademy.com/getCourse.php") 
			  .as(GetCourses.class);
			 
		System.out.println(pojoResponse.getInstructor());
		//System.out.println(pojoResponse.getCourses().getApi().get(1).getCourseTitle());
		List<Api> apiCourses = pojoResponse.getCourses().getApi();
		//List<String> expectedCourses = new ArrayList<String>();
		List<String> expectedCourses = new ArrayList<String>();
		List<WebApplication> webCourses = pojoResponse.getCourses().getWebAutomation();
		for(int i=0;i<apiCourses.size();i++)
		{
			if (apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
			{
			 
			System.out.println(apiCourses.get(i).getCourseTitle()+" = "+apiCourses.get(i).getPrice());
		}
		}
		for(int j = 0; j<webCourses.size();j++)
		{
			expectedCourses.add(webCourses.get(j).getCourseTitle());
			System.out.println(webCourses.get(j).getCourseTitle());
		}
		List<String> actualCourses = new ArrayList<String>();
		actualCourses.add("Selenium Webdriver Java");
		actualCourses.add("Cypress");
		actualCourses.add("Protractor");
		
		Assert.assertTrue(expectedCourses.equals(actualCourses));
		
	}
}
	
