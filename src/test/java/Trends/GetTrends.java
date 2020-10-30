package Trends;

import org.testng.annotations.Test;
import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetTrends extends FetchKeys{

	@Test
	public void getTrends() throws Exception {

		String id = "1";   // Global Where On Earth ID

		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/1.1/trends/place.json?id=" + id);

		System.out.println(response.getBody().jsonPath().prettify());
	}
}
