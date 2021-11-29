package activities;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity9 {
	
	 WebDriver driver;
	 WebDriverWait wait;
	 public static String url="https://alchemy.hguy.co/lms/";
	 public static String username="root";
	 public static String password="pa$$w0rd"; 
	 JavascriptExecutor js;
	  
	 @BeforeClass
	  public void beforeMethod() {
	      
		  //Create a new instance of the Firefox driver
	      driver = new FirefoxDriver();
		  wait = new WebDriverWait(driver, 30);
		  js = (JavascriptExecutor) driver;
		  
	      //Open browser
	      driver.get(url);
	  }
	  
	  @Test(priority=1)
	  public void logIn() {
		  //Click on my Account
		  driver.findElement(By.xpath("//*[contains(text(),'My Account')]")).click();
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

	  @Test(priority=2 , dependsOnMethods="logIn")
	  public void verifyClickedOnCourse() {
	     //open my account
		  driver.findElement(By.xpath("//*[contains(text(),'All Courses')]")).click();
		  System.out.println("Navigated to All courses");
		  //Click on course
		  WebElement course= driver.findElement(By.xpath("(//*[contains(text(),'See more...')])[1]"));
		  wait.until(ExpectedConditions.elementToBeClickable(course));
		  course.click();
		//verify title
		  String title=driver.getTitle();
		  Assert.assertEquals("Social Media Marketing – Alchemy LMS", title);
	  }
	  
	  @Test(priority=3,dependsOnMethods="verifyClickedOnCourse")
	   public void CompleteCourse() {
	     //Clicked on course content
		  driver.findElement(By.xpath("(//*[contains(text(),'Developing Strategy')])[2]")).click();  
		  //Verify title
		  String title=driver.getTitle();
		  Assert.assertEquals(title,"Developing Strategy – Alchemy LMS");
		  //if mark complete present , click on it
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//* [@id='ld-focus-mode-course-heading']")));
		  WebElement markComplete=driver.findElement(By.xpath("(//* [@class='sfwd-mark-complete'])[2]"));
		  Boolean elementPresent=driver.findElement(By.xpath("//*[@id='markComplete']")).isDisplayed();
		  if(elementPresent==true)
		  {
			  markComplete.click();
		  }
	  }
		  
		  @AfterClass
		    public void afterClass() {
		        driver.quit();
		    }
	 
		 

}
