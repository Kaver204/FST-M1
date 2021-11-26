package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Activity5  {
	AppiumDriver<MobileElement> driver;	
	URL remoteURL;
    WebDriverWait wait;
 
    @BeforeTest
    public void setUp() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 4 emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.google.android.apps.messaging");
		caps.setCapability("appActivity", ".ui.ConversationListActivity");
		caps.setCapability("noReset", true);
			
		    remoteURL=new URL("http://localhost:4723/wd/hub");
			driver=new AndroidDriver<MobileElement>(remoteURL,caps);
			wait = new WebDriverWait(driver, 30);
			System.out.println("Device connected");
		
    }
 
    @Test
    public void message() {
      //clcik on start new conversation
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("description(\"Start new conversation\")")).click();
 
 
        // Enter phone number
        String textbox="com.google.android.apps.messaging:id/recipient_text_view";
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id(textbox)));
        System.out.println("Textbox appeared");
        driver.findElement(MobileBy.id(textbox)).sendKeys("7004507982");
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        
        // Type and send message
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")));
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/compose_message_text\")")).sendKeys("Testing");
        driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/send_message_button_icon\")")).click();
        System.out.println("Clciked on sent button ");
 
        //Verify the message
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/message_text\")")));
        String MessageText = driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.google.android.apps.messaging:id/message_text\")")).getText();
        Assert.assertEquals(MessageText, "Testing");
    }
 
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}