package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
	
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
	  public void contactForm() {
	     //open Contact
		  driver.findElement(By.xpath("//*[contains(text(),'Contact')]")).click();
		  System.out.println("Navigated to Contact");
		  List<WebElement> courses=driver.findElements(By.xpath("//*[@class='ld-course-list-items row']//article"));
		  System.out.println("No of courses: "+courses.size());
		  driver.findElement(By.xpath("//*[@name='wpforms[fields][0]']")).sendKeys("Username");
		  driver.findElement(By.xpath("//*[@name='wpforms[fields][1]']")).sendKeys("abcd@gmail.com");
		  driver.findElement(By.xpath("//*[@name='wpforms[fields][3]']")).sendKeys("Subject");
		  driver.findElement(By.xpath("//*[@name='wpforms[fields][2]']")).sendKeys("descriptions");
		  driver.findElement(By.xpath("//*[@name='wpforms[submit]']")).click();
		  System.out.println("Form filled and submitted");
		  Assert.assertEquals("Thanks for contacting us! We will be in touch with you shortly.",driver.findElement(By.xpath("//*[@id='wpforms-confirmation-8']/p")).getText());
	  }
	  
	  @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }

}
