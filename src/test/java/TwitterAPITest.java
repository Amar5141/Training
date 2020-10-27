import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@Test
public class TwitterAPITest {

	public void postTweet() {

		String consumerKey = "4yCrbDl85BUoWdi9qVtrSaHR0";
		String consumerSecret = "dtJDUB8iNW8NmADfKdT06J01o195etAHNFpBZvJHvMETRmPlbC";
		String accessKey = "1318140576240316416-CcvS9MvrnllMFEZKh1ReQw333wtWaT";
		String accessToken = "cvlcdWeBJiQuV1fhsnFSauhs9z3qR8n55lcxYgimeBfF4";

		String Tweet = "Tweet via RestAssured API 2";
		String URI = "https://api.twitter.com/1.1/statuses/update.json?status="+Tweet;

		Response response = RestAssured.given()
				.auth()
				.oauth(consumerKey,consumerSecret,accessKey,accessToken)
				.post(URI);

		System.out.println(response.getStatusCode());
	}

}