package activities;

import java.net.URL;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity2 {
	
AppiumDriver<MobileElement> driver;	
URL remoteURL;
String webUrl="https://www.training-support.net/";
WebDriverWait wait; 
@BeforeTest
  public void setUp() {
	DesiredCapabilities caps = new DesiredCapabilities();
	caps.setCapability("deviceName", "Pixel 4 emulator");
	caps.setCapability("platformName", "android");
	caps.setCapability("appPackage", "com.android.chrome");
	caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
	caps.setCapability("noReset", true);
	try {
		remoteURL=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver<MobileElement>(remoteURL,caps);
		wait = new WebDriverWait(driver, 20);
		System.out.println("Device connected");
		driver.get(webUrl);
	
	}
	catch(Exception e) {
		e.printStackTrace();
	}
  }
	
  @Test
  public void getTitle() {
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'Training Support')]")));
	  String title=driver.findElementByXPath("//android.view.View[contains(@text,'Training Support')]").getText();
	  Assert.assertEquals("Training Support", title);
	  System.out.println("Success -Title of the page: " +title);
	  
	  driver.findElementByXPath("//android.view.View[contains(@text,'About Us')]").click();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'About Us')]")));
	  String title2=driver.findElementByXPath("//android.view.View[contains(@text,'About Us')]").getText();
	  
	  Assert.assertEquals("About Us", title2);
	  System.out.println("Success -Title of the page: " +title2);
	  
	  
	 
	  
  }
  
}
