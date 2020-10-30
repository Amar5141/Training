package GetAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReTweetStatus extends FetchKeys {

	@Test
	public void reTweetStatus() throws Exception  {
		
		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret,super.accessToken,super.tokenSecret)
				.get("https://api.twitter.com/1.1/statuses/retweets_of_me.json?count=2");

		JsonPath json = response.jsonPath();
		String actual = json.get("text");
		String expected = "reTweet";
		Assert.assertEquals(actual, expected, "ReTweet Failed ...");
		System.out.println("Successfully reTweeted ");
		
		/* [response.getBody().jsonPath().prettify()] */

	}
}