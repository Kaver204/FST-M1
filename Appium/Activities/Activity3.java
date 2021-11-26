package activities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3 {
	
	AppiumDriver<MobileElement> driver;
	URL remoteURL;
	
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", ".Calculator");
		caps.setCapability("noReset", true);
		
		
		
			remoteURL = new URL("http://localhost:4723/wd/hub");
			driver=new AndroidDriver<MobileElement>(remoteURL, caps);
			System.out.println("Calculator is open");	
	}
		
		@Test
	    public void add() {
	        driver.findElementById("digit_5").click();
	        driver.findElementById("op_add").click();
	        driver.findElementById("digit_9").click();
	        // Perform Calculation
	        driver.findElementById("eq").click();
	 
	        // Display Result
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "14");
	    }
	    
	    @Test
	    public void subtract() {
	        driver.findElementById("digit_1").click();
	        driver.findElementById("digit_0").click();
	        driver.findElementById("op_sub").click();
	        driver.findElementById("digit_5").click();
	        driver.findElementById("eq").click();
	 
	       
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "5");
	    }
	 
	    @Test
	    public void multiply() {
	        driver.findElementById("digit_5").click();
	        driver.findElementById("op_mul").click();
	        driver.findElementById("digit_1").click();
	        driver.findElementById("digit_0").click();
	        driver.findElementById("digit_0").click();
	        //Calculation
	        driver.findElementById("eq").click();
	 
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "500");
	    }
	 
	    @Test
	    public void divide() {
	        driver.findElementById("digit_5").click();
	        driver.findElementById("digit_0").click();
	        driver.findElementById("op_div").click();
	        driver.findElementById("digit_2").click();
	        // Calculation
	        driver.findElementById("eq").click();
	 
	        //Result
	        String result = driver.findElementById("result").getText();
	        System.out.println(result);
	        Assert.assertEquals(result, "25");
	    }
	 
	    @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
	}
		


