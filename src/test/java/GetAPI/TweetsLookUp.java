package GetAPI;

import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TweetsLookUp extends FetchKeys {

	@Test
	public void tweetLookUp() throws Exception {

		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/1.1/statuses/lookup.json?id=1320991823091822593,1320985462975066132");
		
		JsonPath json = response.jsonPath();

		System.out.println(json.get("text"));
		
	/*	[response.getBody().jsonPath().prettify()] */

	}
}
