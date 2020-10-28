package ReadFileData;

public class FetchKeys {
	protected  String consumerKey ;
	protected  String consumerSecret;
	protected  String accessToken;
	protected  String tokenSecret; 
		
	public void fetchKeys() throws Exception {
		
		ReadFile readFile = new ReadFile();

		this.consumerKey    = readFile.getProperties("consumerKey");
		this.consumerSecret = readFile.getProperties("consumerSecret");
		this.accessToken    = readFile.getProperties("accessToken");
		this.tokenSecret    = readFile.getProperties("tokenSecret");
	}	
}

