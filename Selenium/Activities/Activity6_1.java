package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_1 {
	
	 public static void main(String[] args) {
	        WebDriver driver = new FirefoxDriver();
	        WebDriverWait wait = new WebDriverWait(driver, 10);
	        
	        //Open browser
	        driver.get("https://training-support.net/selenium/dynamic-controls");
	 
	        //Find checkbox and toggle button
	        WebElement checkbox = driver.findElement(By.xpath("//*[@id='dynamicCheckbox']/input"));
	        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
	        
	        //Click the toggle button
	        toggleButton.click();
	        
	        //Wait for checkbox to disappear
	        wait.until(ExpectedConditions.invisibilityOf(checkbox));
	        System.out.println("Checkbox invisible");
	        //Click toggle button again
	        toggleButton.click();
	        System.out.println("Clicked on toggle button ");
	        
	        //Wait for checkbox to appear
	        wait.until(ExpectedConditions.visibilityOf(checkbox));
	        checkbox.click();
	        System.out.println("Checkbox appeared again and clicked on it");
	        
	        //Close browser
	        driver.close();
	    }
	    

}
