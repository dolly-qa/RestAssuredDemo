package specBuilder;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecReqAndResponseBuilder {

	public RequestSpecification requestbuilder()
	{
		RequestSpecification request = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addQueryParam("key", "qaclick123").build();
		return request;
	}
	
	public ResponseSpecification responseBuilder() {
		ResponseSpecification response = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON).build();
		return response;
	}
}
