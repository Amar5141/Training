package pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends LocatorsHandling {
	
	String src = "./src/test/resources/LoginPage.spec";
	
	public void click_on_sign_in(WebDriver driver) throws FileNotFoundException {
		super.fetch_locators("signIn", src);
		driver.findElement(By.xpath(super.data)).click();
	}
	
	public void send_email(WebDriver driver , String username) throws FileNotFoundException {
		super.fetch_locators("email", src);
		driver.findElement(By.xpath(super.data)).sendKeys(username);
	}
	
	public void send_password(WebDriver driver , String password) throws FileNotFoundException {
		super.fetch_locators("password", src);
		driver.findElement(By.xpath(super.data)).sendKeys(password);
	}
	
	public void click_Login(WebDriver driver) throws FileNotFoundException {
		super.fetch_locators("Login", src);
		driver.findElement(By.xpath(super.data)).click();
	}
}
