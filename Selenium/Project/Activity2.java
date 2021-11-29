package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {

	  WebDriver driver;
	  public static String url="https://alchemy.hguy.co/lms/";
	 
	  @BeforeMethod
	  public void beforeMethod() {
	      
		  //Create a new instance of the Firefox driver
	      driver = new FirefoxDriver();
	      
	      //Open browser
	      driver.get(url);
	  }

	  @Test
	  public void verifyHeading() {
	      
		//Get the heading 
	      String heading=driver.findElement(By.xpath("//*[contains(text(),' Learn from Industry Experts ')]")).getText();
	    //Assert the heading
	      Assert.assertEquals(heading, "Learn from Industry Experts");
	  }

	  @AfterClass
	  public void closeBrowser() {
	      //Close the browser
	      driver.quit();
	  }

}
