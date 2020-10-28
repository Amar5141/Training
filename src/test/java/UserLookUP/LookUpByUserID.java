package UserLookUP;

import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LookUpByUserID extends FetchKeys {

	@Test
	public void fetch_User_Detail_By_ID() {

		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/2/users/71201743");

		System.out.println(response.getBody().jsonPath().prettify());
	}

}
