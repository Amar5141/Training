package UserLookUP;

import org.testng.annotations.Test;
import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LookUpByName extends FetchKeys {

	@Test
	public void fetch_query_detail() throws Exception {

		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/2/users/by/username/AryanKansal2");

		System.out.println(response.getBody().jsonPath().prettify());
		
		/* [https://api.twitter.com/1.1/users/search.json?q=Aryan Kansal] */
	}
}
