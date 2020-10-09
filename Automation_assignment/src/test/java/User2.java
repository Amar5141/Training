import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class User2 extends LocatorsHandling {
	String src = "./src/test/resources/Assert.spec";
	WebDriver driver;
	
	 @BeforeMethod
	 public void run_chrome(){
		RunChrome obj = new RunChrome();
		driver = obj.run_chrome();
	}
	
	 @AfterMethod
	 public void close_driver() {
			driver.close();
			driver.quit();
		}
	 
	 @Test
	 (priority = 1)
	 public void login_test() throws FileNotFoundException, Exception {
		 
		 /* LOGIN */
		 LoginPage login = new LoginPage();
		 login.click_on_sign_in(driver);
		 super.fetch_credentials("user01");
		 login.send_email(driver, super.username);
		 login.send_password(driver , super.password);
		 login.click_Login(driver);
		 Thread.sleep(5000);
		 super.fetch_locators("username", src);
		 Thread.sleep(5000);
		 String actual = driver.findElement(By.xpath(super.data)).getText();
		 System.out.println(actual);
		 String expected = "Hi, test";
		 Assert.assertEquals(actual, expected, "Login Failed");
		 Reporter.log("Login successfull");		 
	 }
	 
	 @Test
	 (priority = 2)
	 public void home_page(WebDriver driver) throws FileNotFoundException, InterruptedException {
		 
		    /* SEARCH ITEM */
		    HomePage page = new HomePage();
			page.find_searchBox(driver);
			Thread.sleep(5000);
			page.find_searchIcon(driver);
			Thread.sleep(5000);
			super.fetch_locators("item", src);
			String actual_item = driver.findElement(By.xpath(super.data)).getText();
			String expected_item = "\"4040-PDF-ENG\"";
			Assert.assertEquals(actual_item, expected_item, "Item not found");
			Reporter.log("Item found");
			
		}
	 
	 @Test
	 (priority = 3)
	 public void search_result(WebDriver driver) throws FileNotFoundException {
			
		    /* BLANK SEARCH */
		    SearchResultPage page = new SearchResultPage();
			page.clear_searchBox(driver);
			page.click_searchIcon(driver);
		}
	 
	 @Test
	 (priority = 4)
	 public void apply_filters(WebDriver driver) throws FileNotFoundException, InterruptedException {
			
		    /* FILTERS */
		    ApplyFilters filters = new ApplyFilters();
			filters.quick_filters(driver);
			super.fetch_locators("cases_with_video", src);
			String actual = driver.findElement(By.xpath(super.data)).getText();
			String expected = "Cases with Video";
			Assert.assertEquals(actual, expected, "Cases with Video not found");
			Reporter.log("Cases with Video found");
			Thread.sleep(5000);
			
			filters.content_type(driver);
			super.fetch_locators("Article", src);
			String actual_result = driver.findElement(By.xpath(super.data)).getText();
			String expected_result = "Article";
			Assert.assertEquals(actual_result, expected_result, "Article not found");
			Reporter.log("Article found");
			Thread.sleep(5000);
			
			filters.page_length(driver);
			super.fetch_locators("11-15", src);
			String actual_filter_result = driver.findElement(By.xpath(super.data)).getText();
			String expected_filter_result = "11-15";
			Assert.assertEquals(actual_filter_result, expected_filter_result, "11-15 not found");
			Reporter.log("11-15 found");
			Thread.sleep(5000);
		}
}
