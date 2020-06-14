package specBuilder;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.response.Response;
import pojoClassesForserialize.LocationObjects;
import pojoClassesForserialize.SerializePayLoad;

public class TestForSpecBuilder {

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
		
		System.out.println("Spec builder....");
		System.out.println("Spec builder1111....");
		//System.out.println("Spec builder22222....");
		SpecReqAndResponseBuilder specRequestansResponse = new SpecReqAndResponseBuilder();
		
		Response res = given()
		.spec(specRequestansResponse.requestbuilder())
		.body(payload)
		.log().all()
		.when()
		.post("https://rahulshettyacademy.com/maps/api/place/add/json")
		.then()
		.log().all()
		.assertThat()
		.spec(specRequestansResponse.responseBuilder()).extract().response();
	}

}
