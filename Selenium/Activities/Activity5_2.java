package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {
	
	 public static void main(String[] args) {
		 
	        WebDriver driver = new FirefoxDriver();
	 
	        //Open the browser
	        driver.get("https://www.training-support.net/selenium/dynamic-controls");
	 
	        //check if  the checkbox is selected
	        WebElement checkboxInput = driver.findElement(By.xpath("//input[@type='checkbox']"));
	        System.out.println("The checkbox is selected: " + checkboxInput.isSelected());
	 
	        //Click the checkbox
	        checkboxInput.click();
	        //check if  the checkbox is selected
	        System.out.println("The checkbox is selected: " + checkboxInput.isSelected());
	 
	        //Close the browser
	        driver.close();
	 
	    }

}
