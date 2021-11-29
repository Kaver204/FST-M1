package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
	
	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        Actions actions = new Actions(driver);
 
        //Open browser
        driver.get("https://www.training-support.net/selenium/input-events");
        
        WebElement cube = driver.findElement(By.id("wrapD3Cube"));
 
        //Left click
        actions.click(cube);
        WebElement sideValue = driver.findElement(By.className("active"));
        System.out.println("on left Click: " + sideValue.getText());
 
        //Double click
        actions.doubleClick(cube).perform();
        sideValue = driver.findElement(By.className("active"));
        System.out.println("on double Click: " + sideValue.getText());
        
        //Right click        
        actions.contextClick(cube).perform();
        sideValue = driver.findElement(By.className("active"));
        System.out.println(" on right Click " + sideValue.getText());
 
        //Close browser
        driver.close();
    }

}
