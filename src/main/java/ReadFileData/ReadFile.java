package ReadFileData;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class ReadFile {

	public  String getProperties(String value) throws Exception {

		Properties prop = new Properties();
		InputStream input = new FileInputStream("./src/test/resources/Keys.properties");
		prop.load(input);
		String propValue = prop.getProperty(value);
		return propValue;

	}
}
