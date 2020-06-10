import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TestGetMethod {
	@Test
	
	public void testGet()
	{
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(response.getBody().jsonPath().prettify());
		System.out.println("/n" + response.getBody().asString());
		System.out.println(response.getStatusCode());
	}

}
