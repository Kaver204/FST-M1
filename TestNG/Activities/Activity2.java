package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Activity2 {
	
	  WebDriver driver;
	    
	    @BeforeTest
	    public void beforeMethod() {
	        //Create a new instance of the Firefox driver
	        driver = new FirefoxDriver();
	            
	        //Open the browser
	        driver.get("https://www.training-support.net/selenium/target-practice");
	    }
	    
	    @Test
	    public void testCase1() {
	        // test case will pass
	        String title = driver.getTitle();
	        System.out.println("Title is: " + title);
	        Assert.assertEquals(title, "Target Practice");
	    }
	    
	    @Test
	    public void testCase2() {
	        // test case will Fail
	        WebElement blackButton = driver.findElement(By.cssSelector("button.black"));
	        Assert.assertTrue(blackButton.isDisplayed());
	        Assert.assertEquals(blackButton.getText(), "abcd");
	    }
	    
	    @Test(enabled = false)
	    public void testCase3() {
	        //to skip
	        String subHeading = driver.findElement(By.className("sub")).getText();
	        Assert.assertTrue(subHeading.contains("Practice"));
	    }
	    
	    @Test
	    public void testCase4() {
	        
	        throw new SkipException("Skipping test case");      
	    }
	 
	    @AfterTest
	    public void afterMethod() {
	        //Close the browser
	        driver.close();
	    }

}
