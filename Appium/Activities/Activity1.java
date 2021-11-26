package activities;


import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity1 {
	AppiumDriver<MobileElement> driver;
	URL remoteURL;
	
	@Test
	public void setUp() {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.android.calculator2");
		caps.setCapability("appActivity", ".Calculator");
		
		
		try {
			remoteURL = new URL("http://localhost:4723/wd/hub");
			driver=new AndroidDriver<MobileElement>(remoteURL, caps);
			System.out.println("Calculator is open");	
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	
	

}
