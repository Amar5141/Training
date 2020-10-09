package pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApplyFilters extends LocatorsHandling{
	String src = "./src/test/resources/ApplyFilters.spec";
	
	public void quick_filters(WebDriver driver) throws FileNotFoundException {
		super.fetch_locators("quick_filters", src);
		driver.findElement(By.xpath(super.data)).click();
	}
	public void content_type(WebDriver driver) throws FileNotFoundException {
		super.fetch_locators("content_type", src);
		driver.findElement(By.xpath(super.data)).click();
		super.fetch_locators("Article", src);
		driver.findElement(By.xpath(super.data)).click();
	}
	public void page_length(WebDriver driver) throws FileNotFoundException {
		super.fetch_locators("Page_Length", src);
		driver.findElement(By.xpath(super.data)).click();
		super.fetch_locators("11-15", src);
		driver.findElement(By.xpath(super.data)).click();
	}
}
