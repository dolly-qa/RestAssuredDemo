package restAPIGoogleMapTest;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;import static io.restassured.RestAssured.*;import io.restassured.RestAssured;
public class ComplexJsonParsing {	
	@Test	
	public void TestMockJson() {
		
		JsonPath js = new JsonPath(PayLoad.jsonResponse());		
		String purchaseAmt = js.getString("dashboard.purchaseAmount");	
		//int courseSize  = js.getInt("courses.size()");	
		//long courseSize  = js.get("courses.size()");
		int courseSize = js.getInt("courses.size()"); 
		String courses = js.getString("courses.title");	
		String firstcourses = js.get("courses[0].title");		
	

//String rPACopies = js.getString("courses[2].copies");		
//String rPACopies = js.getString("courses.title['RPA'].copies");	
System.out.println("PurchaseAmount: " + purchaseAmt);
System.out.println("No of Courses: " + courseSize);	
System.out.println("First Course = " + firstcourses);
System.out.println("Courses : " + courses);
//System.out.println("RPA Copies: " + rPACopies);
long sum = 0;
for (int i= 0; i < courseSize ; i++) {	
	String rPATitle = js.get("courses["+i+"].title");	
	int price = js.get("courses["+i+ "].price");
	int copies = js.getInt("courses["+i+"].copies");			
	if(rPATitle.contains("RPA")){				
		System.out.println("RPA copirs: " +copies);	
		}									
	sum = sum + (price * copies);			
	System.out.println(sum);					
	}		
System.out.println("Total Sum #####" +sum);	
}}