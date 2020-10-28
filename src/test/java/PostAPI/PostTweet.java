package PostAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostTweet extends FetchKeys {

	@Test
	public void postTweet() throws Exception {

		String tweet = "Testing Twitter Tweet API ...";

		super.fetchKeys();
		Response response  = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.post("https://api.twitter.com/1.1/statuses/update.json?status=" + tweet);


		JsonPath json = response.jsonPath();
		String actual = json.get("text");
		String expected = "Testing Twitter Tweet API ...";
		Assert.assertEquals(actual, expected, "Tweet failed to post ...");
		System.out.println("ID of the Tweet is : " + json.get("id"));
		System.out.println("Successfully tweeted  : " + json.get("text"));

	}
}
