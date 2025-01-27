package activities;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_4 {
	
	   public static void main(String[] args) {
	        // Create a new instance of the Firefox driver
	        WebDriver driver = new FirefoxDriver();
	        WebDriverWait wait = new WebDriverWait(driver, 5);
	 
	        //Open browser
	        driver.get("https://www.training-support.net/selenium/tab-opener");
	 
	        // title of page 
	        System.out.println("title : " + driver.getTitle());
	 
	        //Get parent window handle
	        String parentWindow = driver.getWindowHandle();
	        System.out.println("Parent Window: " + parentWindow);
	 
	        //Find link to open new tab and click it
	        driver.findElement(By.id("launcher")).click();
	        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	 
	        //Get Window handles
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        System.out.println("All window handles: " + allWindowHandles);
	        for (String handle : driver.getWindowHandles()) {
	            driver.switchTo().window(handle);
	        }
	 
	        //Print the handle of the current window
	        System.out.println("Current window handle: " + driver.getWindowHandle());
	 
	        //Wait for page to load completely
	        wait.until(ExpectedConditions.titleIs("Newtab"));
	 
	        //Print New Tab Title
	        System.out.println("New Tab Title is: " + driver.getTitle());
	 
	        //Get heading on new page
	        String newTab = driver.findElement(By.cssSelector("div.content")).getText();
	        System.out.println("New tab heading is: " + newTab);
	 
	        //Open Another Tab
	        driver.findElement(By.linkText("Open Another One!")).click();
	        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
	 
	        //Make sure the new tab's handle is part of the handles set
	        allWindowHandles = driver.getWindowHandles();
	        System.out.println("All window handles: " + allWindowHandles);
	 
	        //Loop through the handles set till we get to the newest handle
	        for (String handle : driver.getWindowHandles()) {
	            driver.switchTo().window(handle);
	        }
	 
	        //Print the handle of the current window
	        System.out.println("New tab handle: " + driver.getWindowHandle());
	 
	        //Wait for the newest tab to load completely
	        wait.until(ExpectedConditions.titleIs("Newtab2"));
	 
	        //Print New Tab Title
	        System.out.println("New Tab Title is: " + driver.getTitle());
	 
	        //Get heading on new page
	        newTab = driver.findElement(By.className("content")).getText();
	        System.out.println("New tab heading is: " + newTab);
	        
	        //Close the browser
	         driver.quit();
	    }

}
