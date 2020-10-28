package PostAPI;

import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LikeTweet extends FetchKeys {
	
	@Test
	public void likeTweet() throws Exception {
		
		String tweetID = "1320975676405469184";
		
		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.post("https://api.twitter.com/1.1/favorites/create.json?id="+tweetID);
		
		JsonPath json = response.jsonPath();
		System.out.println("Liked the Tweet : " + json.get("text"));
		
		/* [response.getStatusCode()] */
	}

}
