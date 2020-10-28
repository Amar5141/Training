package UserLookUP;

import org.testng.annotations.Test;
import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LookUpByName extends FetchKeys {

	@Test
	public void fetch_user_detail_by_name() {

		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/2/users/imVkohli");

		System.out.println(response.getBody().jsonPath().prettify());
	}
}
