package GetAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TweetByID extends FetchKeys {

	@Test
	public void getTweetByID() throws Exception {
		
	    super.fetchKeys();
		Response response=RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/1.1/statuses/show.json?id=1320991823091822593");

		JsonPath json = response.jsonPath();
		String actual = json.get("text");
		String expected = null;
		Assert.assertEquals(actual, expected, "Tweet not found...");
		System.out.println("Found the Tweet " + json.get("text"));
	}
}
