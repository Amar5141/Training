package User;

import org.testng.Assert;
import org.testng.annotations.Test;

import ReadFileData.FetchKeys;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UserSettings extends FetchKeys {

	@Test
	public void get_User_Settings_details() throws Exception {

		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/1.1/account/settings.json");
		JsonPath json = response.jsonPath();
		String actual = json.get("screen_name");
		String expected =  "automat92049598";
		Assert.assertEquals(actual, expected, "API Failed ...");
		System.out.println("Settings details of : " + json.get("screen_name"));
	}
}
