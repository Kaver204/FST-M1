package activities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity6 {
	
	AppiumDriver<MobileElement> driver;	
	URL remoteURL;
	String webUrl="https://www.training-support.net/selenium/lazy-loading";
	WebDriverWait wait;
	 
	@BeforeClass
	  public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
			
		    remoteURL=new URL("http://localhost:4723/wd/hub");
			driver=new AndroidDriver<MobileElement>(remoteURL,caps);
			wait = new WebDriverWait(driver, 60);
			System.out.println("Device connected");
			driver.get(webUrl);
			System.out.println("URL opened");
	  }
	 
	 @Test
	    public void imagescrollAndCount() {
		

		    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'Lazy Loading')]")));
		    System.out.println("Page loaded");
	        // Count the number of images shown on the screen
		    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,' 3 comments')]")));
			   
	        List<MobileElement> numberOfImages = driver.findElementsByClassName("android.widget.Image");
	        System.out.println("Number of image shown currently: " + numberOfImages.size());
	        Assert.assertEquals(numberOfImages.size(), 2);
	        
	        // Scroll to Helen
	        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).scrollTextIntoView(\"helen\")"));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.view.View[contains(@text,'helen')]"))); 
	        // number of images after scrolling
	        numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
	        List<MobileElement> numberOfImages1 = driver.findElementsByClassName("android.widget.Image");
	        System.out.println("Number of image shown currently: " + numberOfImages.size()+" ,  "+numberOfImages1.size());
	        //Assert.assertEquals(numberOfImages.size(), 4);
	    }
	 
	    @AfterClass
	    public void afterClass() {
	       // driver.quit();
	    }
	}


