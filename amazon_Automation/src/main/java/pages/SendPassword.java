package pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendPassword extends FileHandling{
	String src = "./src/test/resources/SendPassword.spec";
	
	public void send_password(WebDriver driver) throws FileNotFoundException {
		
		super.fetch_data("find_passwordBox",src);
		driver.findElement(By.xpath(super.data)).sendKeys("automation@testing");
	}
	
	public void click_on_sign_in(WebDriver driver) throws FileNotFoundException {
		
		super.fetch_data("signIN",src);
		driver.findElement(By.xpath(super.data)).click();
	}
}
