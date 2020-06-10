package pojoClassesForserialize;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

public class TestForSerialize {

	public static void main(String[] args) {
		
		SerializePayLoad payload = new SerializePayLoad();
		LocationObjects locationObj = new LocationObjects();
		List<String> types = new ArrayList<String>();
		payload.setAccuracy(50);
		payload.setAddress("29, side layout, cohen 09");
		payload.setLanguage("French-IN");
		payload.setWebsite("http://google.com");
		
		locationObj.setLat(-38.383494);
		locationObj.setLng(33.427362);
		payload.setLocation(locationObj);
		
		payload.setName("Frontline house ");
		payload.setPhone_number("(+91) 983 893 3937");
		
		types.add("shoe park");
		types.add("shop");
		payload.setTypes(types);
		
		
		
		given()
		.queryParam("key", "qaclick123")
		.header("Content-Type", "application/json")
		.body(payload)
		.log().all()
		.when()
		.post("https://rahulshettyacademy.com/maps/api/place/add/json")
		.then()
		.log().all()
		.assertThat()
		.statusCode(200);
	}

}
