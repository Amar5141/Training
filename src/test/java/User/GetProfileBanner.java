package User;

import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetProfileBanner extends FetchKeys {

	@Test
	public void get_user_profile_banner() throws Exception {

		String screen_name = "automat92049598";
		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/1.1/users/profile_banner.json?screen_name=" + screen_name);

		System.out.println(response.getBody().jsonPath().prettify());
	}
}
