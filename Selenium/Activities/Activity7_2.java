package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity7_2 {
	
	  public static void main(String[] args) {
	        WebDriver driver = new FirefoxDriver();
	        
	        //Open browser
	        driver.get("https://www.training-support.net/selenium/dynamic-attributes");
	        
	        //Find username and password fields
	        WebElement userName = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
	        WebElement password = driver.findElement(By.xpath("(//*[@type='password'])[2]"));
	        WebElement confirmPassword = driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following::input"));
	        WebElement email = driver.findElement(By.xpath("//label[contains(text(), 'mail')]/following-sibling::input"));
	        
	        //Type credentials
	        userName.sendKeys("user");
	        password.sendKeys("Password");
	        confirmPassword.sendKeys("Password");
	        email.sendKeys("abcd@gmail.com");
	        //Click Sign Up
	        driver.findElement(By.xpath("//button[contains(text(), 'Sign Up')]")).click();
	        
	        //Print login message
	        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
	        System.out.println("Login message: " + loginMessage);
	        
	        //Close browser
	        driver.close();
	 
	    }

}
