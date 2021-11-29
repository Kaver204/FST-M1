package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity7 {
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
	  public void verifyCourses() {
	     //open my account
		  driver.findElement(By.xpath("//*[contains(text(),'All Courses')]")).click();
		  System.out.println("Navigated to All courses");
		  List<WebElement> courses=driver.findElements(By.xpath("//*[@class='ld-course-list-items row']//article"));
		  System.out.println("No of courses: "+courses.size());
		  
	  }
	  

}
