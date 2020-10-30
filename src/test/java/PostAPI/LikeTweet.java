package PostAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LikeTweet extends FetchKeys {
	
	@Test
	public void likeTweet() throws Exception {
		
		PostTweet tweet = new PostTweet();
		tweet.postTweet();
		String tweetID = tweet.ID;
		
		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.post("https://api.twitter.com/1.1/favorites/create.json?id=" + tweetID);
		
		JsonPath json = response.jsonPath();
		String actual = json.get("text").toString();
		String expected = "Testing Twitter Tweet API 6 ...";
		Assert.assertEquals(actual, expected, "API Failed ...");
		System.out.println("Liked the tweet : " + json.get("text") );
		
		/* [response.getStatusCode()] */
	}

}
