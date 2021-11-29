package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Activity9_1 {
	
	 public static void main(String[] args) {
	        WebDriver driver = new FirefoxDriver();
	 
	        //Open browser
	        driver.get("https://training-support.net/selenium/selects");
	 
	        //Chosen option
	        WebElement selectedOption = driver.findElement(By.id("single-value"));
	 
	        //Find dropdown
	        Select dropdown = new Select(driver.findElement(By.id("single-select")));
	 
	        //Select second option by visible text
	        dropdown.selectByVisibleText("Option 2");
	        System.out.println(selectedOption.getText());
	 
	        //Select third option by index
	        dropdown.selectByIndex(3);
	        System.out.println(selectedOption.getText());
	 
	        //Select fourth option by value
	        dropdown.selectByValue("4");
	        System.out.println(selectedOption.getText());
	        
	      //Print all
	        List<WebElement> options = dropdown.getOptions();	        
	        for(WebElement option : options) {
	            System.out.println("All the Options: " + option.getText());
	        }
	 
	        //Close browser
	        driver.close();
	    }

}
