package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
	
	 public static void main(String[] args) {
	        WebDriver driver = new FirefoxDriver();
	        Actions actions = new Actions(driver);
	        
	        //Open browser
	        driver.get("https://www.training-support.net/selenium/input-events");
	        System.out.println(driver.getTitle());
	        WebElement pressedKey = driver.findElement(By.id("keyPressed"));
	        
	        //Create action sequence for initials
	        Action action1 = actions.sendKeys("K").build();
	        action1.perform();
	        //print text
	        System.out.println("Pressed key is: " + pressedKey.getText());  
	        
	        //Create action sequence for Spacebar
	        Action action2 = actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build();
	        action2.perform();
	        //print text
	        System.out.println("Pressed key is: " + pressedKey.getText());
	 
	        //Close browser
	        driver.close();
	 }

}
