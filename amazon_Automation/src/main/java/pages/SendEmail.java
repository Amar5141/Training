package pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendEmail extends FileHandling{
	String src = "./src/test/resources/SendEmail.spec";
	
	public void send_email(WebDriver driver) throws FileNotFoundException {
		
		super.fetch_data("find_emailBox",src);
		driver.findElement(By.xpath(super.data)).sendKeys("automationtesting150920@gmail.com");
	}
	
	public void click_on_continue(WebDriver driver) throws FileNotFoundException {
		
		super.fetch_data("continue",src);
		driver.findElement(By.xpath(super.data)).click();
	}
}
