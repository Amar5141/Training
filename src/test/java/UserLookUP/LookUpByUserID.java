package UserLookUP;


import org.testng.annotations.Test;
import ReadFileData.FetchKeys;
import ReadJSONData.ReadJSONData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class LookUpByUserID extends FetchKeys {

	@Test
	public void fetch_User_Detail_By_ID() throws Exception {

		super.fetchKeys();
		Response response = RestAssured.given()
				.auth()
				.oauth(super.consumerKey, super.consumerSecret, super.accessToken, super.tokenSecret)
				.get("https://api.twitter.com/2/users/1004304998237257728");

		ReadJSONData data = new ReadJSONData();
		String parent = "data" , child = "name";
		String actual = data.read_data(response, parent, child);
		System.out.println(actual);
	}
}
