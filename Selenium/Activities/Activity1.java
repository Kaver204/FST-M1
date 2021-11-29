package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
	public static String url="https://www.training-support.net";
	
	public static void main(String[] args) {
		//Instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
			
		//Open the browser
		driver.get(url);
			
		//Close the browser
		driver.close();
	    }
	 
	
}
