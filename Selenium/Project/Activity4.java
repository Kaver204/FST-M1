package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {
	

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
	  public void verifypopularCoursesTitle() {
	      
		//Get the heading 
	      String title=driver.findElement(By.xpath("//*[contains(text(),'Email Marketing Strategies')]")).getText();
	    //Assert the heading
	      Assert.assertEquals(title, "Email Marketing Strategies");
	  }

	  @AfterClass
	  public void closeBrowser() {
	      //Close the browser
	      driver.quit();
	  }

}
