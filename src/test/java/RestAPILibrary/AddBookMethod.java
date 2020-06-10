package RestAPILibrary;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import jdk.nashorn.api.scripting.JSObject;

import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

import static io.restassured.RestAssured.*;

public class AddBookMethod {	
	
	@Test(dataProvider = "bodyDatas", dataProviderClass = PayLoadLibrary.class)
	/*
	 * public void test() { //RestAssured.baseURI = ""; //JSONObject jsObj = new
	 * JSONObject(); String jsBody =
	 * 
	 * given()
	 * 
	 * .header("Content-Type", "application/json")
	 * .body(PayLoadLibrary.bodyData("sdawf","56564")) .log().all() .when()
	 * .post("http://216.10.245.166/Library/Addbook.php") .then() //.log().all()
	 * .assertThat() .statusCode(200)
	 * 
	 * .header("Server", "Apache") //.extract().response().asString();
	 * .extract().response().body().asString();
	 * 
	 * System.out.println(jsBody);
	 * 
	 * 
	 * 
	 * JsonPath jsPath = new JsonPath(jsBody); String id = jsPath.get("ID");
	 * System.out.println("ID is: " + id); //String putUrl =
	 * "https://rahulshettyacademy.com/maps/api/place/update/json?key=qaclick123&place_id="
	 * +placeId; //System.out.println(putUrl); //Update Place
	 * 
	 * 
	 * 
	 * }
	 */
	public void test(String isbn,String aisle, String name) {
		//RestAssured.baseURI = "";	
		//JSONObject jsObj = new JSONObject();
		String jsBody  =  
		
		given()
		
		.header("Content-Type", "application/json")
		.body(PayLoadLibrary.bodyData(isbn,aisle))
		.log().all()
		.when()
		.post("http://216.10.245.166/Library/Addbook.php")
		.then()
		//.log().all()
		.assertThat()
		.statusCode(200)
		
		.header("Server", "Apache")
		//.extract().response().asString();
		.extract().response().body().asString();
		
		System.out.println(jsBody);
		
		
		
		  JsonPath jsPath = new JsonPath(jsBody); 
		  String id = jsPath.get("ID"); 
		  System.out.println("ID is: " + id);
		  //String putUrl = "https://rahulshettyacademy.com/maps/api/place/update/json?key=qaclick123&place_id="+placeId;
		  //System.out.println(putUrl);
		  //Update Place
		  
		  
		
}
}