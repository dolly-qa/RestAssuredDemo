import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class RestPostTestBDD {

	@Test(dataProvider = "datas", dataProviderClass= DataProvideClassForTest.class)
	public void TestPost(String name, String job) {
		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", name);
		jsonObj.put("job", job);
		
		System.out.println(jsonObj.toString());
		given().
		header("Content-Type","application/json").
		body(jsonObj.toString()).
		
		when().
		post("https://reqres.in/api/users").
		then().statusCode(201).log().all();
		
		
	}
}
