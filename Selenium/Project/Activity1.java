package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity1 {
	
  WebDriver driver;
  public static String url="https://alchemy.hguy.co/lms/";
  public static String  username="root";
  public static String password="pa$$w0rd";
 
  @BeforeMethod
  public void beforeMethod() {
      
	  //Create a new instance of the Firefox driver
      driver = new FirefoxDriver();
      
      //Open browser
      driver.get(url);
  }

  @Test
  public void verifyTitle() {
      // Check the title of the page
      String title = driver.getTitle();
          
      //Print the title of the page
      System.out.println("Page title is: " + title);
          
      //Assertion for page title
      Assert.assertEquals("Alchemy LMS – An LMS Application", title);                
  }

  @AfterClass
  public void closeBrowser() {
      //Close the browser
      driver.quit();
  }

}
 

