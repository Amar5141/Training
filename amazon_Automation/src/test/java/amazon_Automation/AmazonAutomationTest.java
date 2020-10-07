package amazon_Automation;

import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.*;


public class AmazonAutomationTest{
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
	void amazonTest() throws FileNotFoundException {
		
		HomePage page  = new HomePage();
		page.click_sign_in(driver);
		
		SendEmail email = new SendEmail();
		email.send_email(driver);
		email.click_on_continue(driver);
		
		SendPassword pass = new SendPassword();
		pass.send_password(driver);
		pass.click_on_sign_in(driver);
		
		String actual = driver.findElement(By.xpath("//span[text()='Hello, myTest']")).getText();
		String expected = "Hello, myTest";
		Assert.assertEquals(actual, expected, "Login Failed...");
		System.out.println("Login successfull...");
		
	}
}
