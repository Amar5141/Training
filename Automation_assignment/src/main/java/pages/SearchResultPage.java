package pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage extends LocatorsHandling {
	
	String src = "./src/test/resources/SearchResultPage.spec";
	
	public void clear_searchBox(WebDriver driver) throws FileNotFoundException {
		super.fetch_locators("searchBox", src);
		driver.findElement(By.xpath(super.data)).clear();
	}
	
	public void click_searchIcon(WebDriver driver) throws FileNotFoundException {
		super.fetch_locators("searchIcon", src);
		driver.findElement(By.xpath(super.data)).click();
	}

}
