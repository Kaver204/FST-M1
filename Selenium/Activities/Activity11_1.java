package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_1 {
	
	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
 
        //Open browser and get title
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println(driver.getTitle());
 
        //Click the button to open a simple alert
        driver.findElement(By.id("simple")).click();
 
        //Switch to alert 
        Alert simpleAlert = driver.switchTo().alert();
 
        //Get text  and print it
        String alertText = simpleAlert.getText();
        System.out.println("Alert text is: " + alertText);
 
        //Close the alert box
        simpleAlert.accept();
 
        //Close the Browser
        driver.close();
    }

}
