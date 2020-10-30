package ReadJSONData;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ReadJSONData {

	String data;
	public String read_data(Response response , String parent , String child) {
		
		JsonPath json = response.jsonPath();
		JSONArray array = json.get(parent);
		
		for(int i = 0; i< array.size(); i++) {
			JSONObject obj = (JSONObject) array.get(i);
			
			 data = (String) obj.get(child);
		}
		return data;
	}
}
