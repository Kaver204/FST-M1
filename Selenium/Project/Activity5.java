package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
	 WebDriver driver;
	 WebDriverWait wait;
	  public static String url="https://alchemy.hguy.co/lms/";
	 
	  @BeforeMethod
	  public void beforeMethod() {
	      
		  //Create a new instance of the Firefox driver
	      driver = new FirefoxDriver();
		  wait = new WebDriverWait(driver, 30);
	      //Open browser
	      driver.get(url);
	  }

	  @Test
	  public void verifyTitle() {
	     //open my account
		  driver.findElement(By.xpath("//*[contains(text(),'My Account')]")).click();
		//Get the title 
	      String title=driver.getTitle();
	    //Assert the title
	      Assert.assertEquals(title, "My Account – Alchemy LMS");
	  }

	  @AfterClass
	  public void closeBrowser() {
	      //Close the browser
	      driver.quit();
	  }


}
