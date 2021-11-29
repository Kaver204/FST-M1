package activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Activity6 {
	 WebDriver driver;
	 WebDriverWait wait;
	 public static String url="https://alchemy.hguy.co/lms/";
	  public static String  username="root";
	  public static String password="pa$$w0rd";
	 
	  @BeforeClass
	  public void beforeMethod() {
	      
		  //Create a new instance of the Firefox driver
	      driver = new FirefoxDriver();
		  wait = new WebDriverWait(driver, 30);
	      //Open browser
	      driver.get(url);
	  }

	  @Test(priority=1)
	  public void verifyTitle() {
	     //open my account
		  driver.findElement(By.xpath("//*[contains(text(),'My Account')]")).click();
		  System.out.println("Clicked on my account");
		  //Get the title 
	      String title=driver.getTitle();
	    //Assert the title
	      Assert.assertEquals(title, "My Account – Alchemy LMS");
	      System.out.println("Title verified");
	      
	  }
	  

	  @Test(priority=2)
	  public void logIn() {
	     //click on button
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@href='#login']")));
		  driver.findElement(By.xpath("//*[@href='#login']")).click();
		 //enter credentials
		  driver.findElement(By.id("user_login")).sendKeys(username);
		  driver.findElement(By.id("user_pass")).sendKeys(password);;
	    //Click on submit
		  driver.findElement(By.id("wp-submit")).click();
		 //verify login
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'  My Account    ')]")));
		  String text=driver.findElement(By.xpath("//*[contains(text(),'  My Account    ')]")).getText();
		  Assert.assertEquals(text,"My Account");
		  
	  }

	  @AfterClass
	  public void closeBrowser() {
	      //Close the browser
	    // driver.quit();
	  }

}
