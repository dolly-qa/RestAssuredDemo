package oauth2Demo;

import static io.restassured.RestAssured.given;

import io.restassured.path.json.JsonPath;

public class Oauth2Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			System.out.println("Hello....");
			
			  String url =
			  "https://rahulshettyacademy.com/getCourse.php?code=4%2F0QG2wd_sCG4ah0ufljfkBZ_o1c_fYYX8tZo_a9yGMn2HjmtWM2xGzJJ-ACAnqN_0E3QQ6TP9AhmpubGzRTvsXDw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=1&prompt=none#";
			  
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
			 String rs = given() 
			  .log().all()
			  .contentType("application/json")
			  .queryParam("access_token", token) 
			  .when().log().all()
			  .get("https://rahulshettyacademy.com/getCourse.php") 
			  .asString();
			 
		System.out.println(rs);
	}

}
