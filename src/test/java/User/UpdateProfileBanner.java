package User;

import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateProfileBanner extends FetchKeys {

	@Test
	public void update_user_profile_banner() throws Exception {
		
		String src = "./src/test/resources/twitter.jpg";
		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.post("https://api.twitter.com/1.1/account/update_profile_banner.json?banner=" + src);
		
		System.out.println(response.getBody().jsonPath().prettify());
	}
}
