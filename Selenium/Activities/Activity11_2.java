package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_2 {
	
	 public static void main(String[] args) throws InterruptedException {
	        WebDriver driver = new FirefoxDriver();
	 
	        //Open browser
	        driver.get("https://www.training-support.net/selenium/javascript-alerts");
	        //get title
	        System.out.println(driver.getTitle());
	 
	        //Click the button to open a simple alert
	        driver.findElement(By.id("confirm")).click();
	 
	        //Switch to alert 
	        Alert confirmAlert = driver.switchTo().alert();
	 
	        //Get text in the alert box and print it
	        String alertText = confirmAlert.getText();
	        System.out.println("Alert text is: " + alertText);
	 
	        //Close the alert with OK
	        confirmAlert.accept();
	 
	        //Dismiss the Alert
	        driver.findElement(By.id("confirm")).click();
	        confirmAlert.dismiss();
	 
	        //Close the Browser
	        driver.close();
	    }

}
