package pages;

import org.openqa.selenium.WebDriver;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;

public class HomePage extends FileHandling{
	String src = "./src/test/resources/HomePage.spec";
	
	
	public void click_sign_in(WebDriver driver) throws FileNotFoundException {
		super.fetch_data("signIn", src);
		driver.findElement(By.xpath(super.data)).click();
	}

}
