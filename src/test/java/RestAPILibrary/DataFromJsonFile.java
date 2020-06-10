package RestAPILibrary;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

public class DataFromJsonFile {
	
// path = /RestApiDemo/src/test/resources
	@Test
	public void test() throws IOException {
		//RestAssured.baseURI = "";	
		//JSONObject jsObj = new JSONObject();
		String jsBody  =  
		
		given()
		
		.header("Content-Type", "application/json")
		.body(jsnFileData("/Users/maharshi/eclipse-workspace/RestApiDemo/src/test/resources/bookJson.json"))
		
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
		
		
}
	
	public String jsnFileData(String path) throws IOException {
		//byte[] fls = Files.readAllBytes(Paths.get(path));
		//System.out.println("File: " + fls);
		
		String s = new String(Files.readAllBytes(Paths.get(path)));
		System.out.println("File: " + s);
		return s;
				//new String(Files.readAllBytes(Paths.get(path)));
	}
}


