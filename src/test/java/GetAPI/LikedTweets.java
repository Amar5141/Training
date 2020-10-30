package GetAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ReadFileData.FetchKeys;

public class LikedTweets extends FetchKeys {

	@Test
	public void getLikedTweets() throws Exception {
		
		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/1.1/favorites/list.json");

		JsonPath json = response.jsonPath();
		System.out.println(response.getBody().jsonPath().prettify());
		System.out.println(json.get("text"));
		/* [response.getBody().jsonPath().prettify()] */
	}	
}
