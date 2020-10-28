package UserLookUP;

import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FriendList extends FetchKeys {

	@Test
	public void fetch_Friend_List() {

		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/1.1/friends/list.json?screen_name=imVkohli");

		System.out.println(response.getBody().jsonPath().prettify());
	}
}
