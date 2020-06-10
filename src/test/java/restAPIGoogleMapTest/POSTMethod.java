package restAPIGoogleMapTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import jdk.nashorn.api.scripting.JSObject;

import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

public class POSTMethod {	
	@Test
	public void test() {
		//RestAssured.baseURI = "";	
		//JSONObject jsObj = new JSONObject();
		String jsBody  =  
		
		given()
		.queryParam("key", "qaclick123")
		
		.header("Content-Type", "application/json")
		.body("{\n" + 
				"  \"location\": {\n" + 
				"    \"lat\": -38.383494,\n" + 
				"    \"lng\": 33.427362\n" + 
				"  },\n" + 
				"  \"accuracy\": 50,\n" + 
				"  \"name\": \"Stuttgart----\",\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\n" + 
				"  \"types\": [\n" + 
				"    \"shoe park\",\n" + 
				"    \"shop\"\n" + 
				"  ],\n" + 
				"  \"website\": \"http://google.com\",\n" + 
				"  \"language\": \"Indian\"\n" + 
				"}")
		.log().all()
		.when()
		.post("https://rahulshettyacademy.com/maps/api/place/add/json")
		.then()
		//.log().all()
		.assertThat()
		.statusCode(200)
		.body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.18 (Ubuntu)")
		//.extract().response().asString();
		.extract().response().body().asString();
		
		System.out.println(jsBody);
		
		
		
		  JsonPath jsPath = new JsonPath(jsBody); 
		  String placeId = jsPath.getString("place_id"); 
		  System.out.println(placeId);
		  //String putUrl = "https://rahulshettyacademy.com/maps/api/place/update/json?key=qaclick123&place_id="+placeId;
		  //System.out.println(putUrl);
		  //Update Place
		  
		  given()
		  .queryParam("key", "qaclick123")
		  .and()
		  .queryParam("place_id", placeId)
		  .header("Content-Type", "application/json")
		  .body("{\n" + 
		  		"\"place_id\":\""+placeId+"\",\n" + 
		  		"\"address\":\"Hauptbahnhof 125\",\n" + 
		  		"\"key\":\"qaclick123\"\n" + 
		  		"}\n" + 
		  		"")
		 
		  .log().all()
		  .when()
		  .put("https://rahulshettyacademy.com/maps/api/place/update/json")
		  .then()
		  .log().all()
		  .assertThat()
		  .body("msg",equalTo("Address successfully updated"));
		  
		 // View Address
		  
		  given()
		  .header("Content-Type", "application/json")
		  .queryParam("key", "qaclick123")
		  .queryParam("place_id", placeId)
		  .log().all()
		  .when()
		  .get("https://rahulshettyacademy.com/maps/api/place/get/json")
		  .then()
		  .assertThat()
		  .statusCode(200).log().all()
		  .body("address", equalTo("Hauptbahnhof 125"));
}
}