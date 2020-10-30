package User;

import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RemoveProfileBanner extends FetchKeys {

	@Test
	public void remove_profile_banner() throws Exception {

		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.post("https://api.twitter.com/1.1/account/remove_profile_banner.json");

		System.out.println(response.getBody().jsonPath().prettify());
	}
}
