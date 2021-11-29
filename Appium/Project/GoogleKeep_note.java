package appium_project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleKeep_note {
	
	AppiumDriver<MobileElement> driver;
	URL remoteURL;
	//WebDriverWait wait;
	WebDriverWait wait;
	String note_title="FST Task";
	String note_body="FST Task body in the note";
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);
		
		
	
			// Create object for WebDriverWait class
		   
			remoteURL = new URL("http://localhost:4723/wd/hub");
			driver=new AndroidDriver<MobileElement>(remoteURL, caps);
			System.out.println("google task is open");	
			wait = new WebDriverWait(driver, 10);
	
	}
		
		@Test(priority=1)
		public void AddNote()
		{
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new_note_button")));
				driver.findElementById("new_note_button").click();
				System.out.println("Clicked on add button");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("editable_title")));
				driver.findElementById("editable_title").click();
				driver.findElementById("editable_title").sendKeys(note_title);
				System.out.println("Title added");
				driver.findElementById("edit_note_text").sendKeys(note_body);
				driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']").click();
				System.out.println("Clicked on Back button");
				String actual_title=driver.findElementById("index_note_title").getText();
				Assert.assertEquals(note_title, actual_title);
				System.out.println("Assertion successful : Keep Task successfully completed");
				
				
			}
				
			catch(Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		

}
