package PostAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReTweet extends FetchKeys {

	@Test
	public void reTweet() throws Exception {

		String tweetID = "1320975676405469184";

		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.post("https://api.twitter.com/1.1/statuses/retweet/"+tweetID+".json");
		
		JsonPath json = response.jsonPath();
		String actual = json.get("text");
		String expected = "Hello, Testing Twitter API";
		Assert.assertEquals(actual, expected, "ReTweet Failed ...");
		System.out.println("Successfully reTweeted : " + json.get("text"));

	}
}
