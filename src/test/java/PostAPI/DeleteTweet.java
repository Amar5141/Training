package PostAPI;

import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteTweet extends FetchKeys{

	@Test
	public void deleteTweet() throws Exception {

		String tweetID = "1320975676405469184";

		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.post("https://api.twitter.com/1.1/statuses/destroy/"+tweetID+".json");

		JsonPath json = response.jsonPath();
		System.out.println("Deleted Tweet : " + json.get("text"));
	}
}
