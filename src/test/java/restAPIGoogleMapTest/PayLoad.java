package restAPIGoogleMapTest;

import io.restassured.path.json.JsonPath;

public class PayLoad {
	
	public static String jsonResponse() {
		
		String str = "{\n" + 
				"\"dashboard\": {\n" + 
				"\"purchaseAmount\": 910,\n" + 
				"\"website\": \"rahulshettyacademy.com\"\n" + 
				"},\n" + 
				"\"courses\": [\n" + 
				"{\n" + 
				"\"title\": \"Selenium Python\",\n" + 
				"\"price\": 50,\n" + 
				"\"copies\": 6\n" + 
				"},\n" + 
				"{\n" + 
				"\"title\": \"Cypress\",\n" + 
				"\"price\": 40,\n" + 
				"\"copies\": 4\n" + 
				"},\n" + 
				"{\n" + 
				"\"title\": \"RPA\",\n" + 
				"\"price\": 45,\n" + 
				"\"copies\": 10\n" + 
				"}\n" + 
				"]\n" + 
				"}";
		return str;
	}

}
