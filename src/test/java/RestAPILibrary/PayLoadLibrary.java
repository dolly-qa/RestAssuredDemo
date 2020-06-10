package RestAPILibrary;

import org.testng.annotations.DataProvider;

import io.restassured.path.json.JsonPath;

public class PayLoadLibrary {
	
	@DataProvider(name = "bodyDatas")
	public static Object[][] dataprovider() {
		return new Object[][]{
			{"WWWq", "2341","Rahul"},
			{"UUUq", "4561","Rahul"},
			{"UUURq", "23451","Rahul"}	
		};
	}
	
	public static String bodyData(String isbn, String aisle) {
		
		String str = "{\n" + 
				"\n" + 
				"\"name\":\"Learn Appium Automation with Java\",\n" + 
				"\"isbn\":\""+isbn+"\",\n" + 
				"\"aisle\":\""+aisle+"\",\n" + 
				"\"author\":\"John foe\"\n" + 
				"}\n" + 
				" ";
		return str;
	}

}
