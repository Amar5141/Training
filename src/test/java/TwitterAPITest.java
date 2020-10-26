import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TwitterAPITest {
	
	String consumerKey = "tRZu44nnZNmXciEnbEi1xQWQ1";
	String consumerSecret = "QsX3Qmak6V0OAx6agXQcLCtoWiGl7eaJ2GYKpXYtZfFSXq";
	String accessToken = "1318140576240316416-qu0GrWiEvz59j7TOxudKXevYii3QDI";
	String secretToken = "JoyHhaiLEbReaTSNDrSQO0Zm8XiXyaCXoD3GC4ANX3qeR";
	
	@BeforeClass
	public void SetUp() {
		RestAssured.baseURI = "https://api.twitter.com/1.1/statuses/";
		//RestAssured.basePath = "";
	}
	
	@Test
	public void PostTweet() {
		RestAssured.given()
		.auth()
		.oauth(consumerKey , consumerSecret , accessToken , secretToken)
		.queryParam("status" , "Hello, Testing Twitter API ")
		.header("Content-Type", "application/json")
		.when()
		   .post("update.json")
		.then()
		   .statusCode(200);
		System.out.println("Done");
	}
}
