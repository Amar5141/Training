package pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends LocatorsHandling{

	String src = "./src/test/resources/HomePage.spec";
	
	public void find_searchBox(WebDriver driver) throws FileNotFoundException, InterruptedException {
		super.fetch_locators("searchBox", src);
		Thread.sleep(5000);
		driver.findElement(By.xpath(super.data)).clear();
		Thread.sleep(5000);
		driver.findElement(By.xpath(super.data)).sendKeys("4040-PDF-ENG");
	}
	
	public void find_searchIcon(WebDriver driver) throws FileNotFoundException {
		super.fetch_locators("searchIcon", src);
		driver.findElement(By.xpath(super.data)).click();
	}
}
