package activities;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity4 {
	
	AppiumDriver<MobileElement> driver;
	URL remoteURL;
	WebDriverWait wait;
	
	@BeforeTest
	public void setUp() {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.android.contacts");
        caps.setCapability("appActivity", ".activities.PeopleActivity");
        caps.setCapability("noReset", true);
		
		try {
			remoteURL = new URL("http://localhost:4723/wd/hub");
			driver=new AndroidDriver<MobileElement>(remoteURL, caps);
			wait = new WebDriverWait(driver, 20);
			
			System.out.println("contacts is open");	
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	@Test
    public void addContact() {
        // Click on add new contact  button
        driver.findElementByAccessibilityId("Create new contact").click();
        
        // enter the first name, last name, and phone number 
         driver.findElementByXPath("//android.widget.EditText[@text='First name']").sendKeys("Aaditya");
         driver.findElementByXPath("//android.widget.EditText[@text='Last name']").sendKeys("Varma");
         driver.findElementByXPath("//android.widget.EditText[@text='Phone']").sendKeys("9991284782");
    
        // Save 
        driver.findElementById("editor_menu_save_button").click();
        
        // Wait for contact card to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("toolbar_parent")));
 
        // Assertion
        MobileElement mobileCard = driver.findElementById("toolbar_parent");
        Assert.assertTrue(mobileCard.isDisplayed());
        
        String contactName = driver.findElementById("large_title").getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}


