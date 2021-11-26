package appium_project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class Chrome_Activity3 {
	
	AppiumDriver<MobileElement> driver;	
	URL remoteURL;
	String webUrl="https://www.training-support.net/selenium";
	WebDriverWait wait;
	String username1="admin";
	String password1="password";
	String username2="admin2";
	String password2="password2";
	  @BeforeTest
	  public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.android.chrome");
		caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		caps.setCapability("noReset", true);
			remoteURL=new URL("http://localhost:4723/wd/hub");
			
			driver=new AndroidDriver<MobileElement>(remoteURL,caps);
			wait = new WebDriverWait(driver, 20);
			System.out.println("Device connected");
			driver.get(webUrl);
			
	  }
	  
	  @Test(priority=1)
	  public void OpenPopUps()
	  {
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View")));
		  System.out.println("URL opened");
		  // Scroll element into view and click it
	      driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));     
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      driver.findElementByXPath("//android.view.View[contains(@text,'Popups')]").click();
	      System.out.println("Scrolled and clicked on Popups");
	  }
	  
	  
	  @Test(priority=2,dependsOnMethods="OpenPopUps")
	  public void CorrectCredentials()
	  {
		  
	    try{ 
	    	  
	        //Sign in 
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[contains(@text,'Sign In')]")));
	        driver.findElementByXPath("//android.widget.Button[contains(@text,'Sign In')]").click();
	        System.out.println("Clicked on sign in");
	        
	        //enter username password
	        driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys(username1);
	        driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys(password1);
	        driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.webkit.WebView/android.view.View[1]/android.view.View[4]")));
	        String LoginMessage=driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[4]").getText();
	        Assert.assertEquals(LoginMessage, "Welcome Back, admin","Successfully logged in" );
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	  }
	  
	  @Test(priority=3,dependsOnMethods="OpenPopUps")
	  public void wrongCredentials()
	  {
		  try {
	        
		    //Sign in
		    driver.findElementByXPath("//android.widget.Button[contains(@text,'Sign In')]").click();
		    //enter credentials
	        driver.findElementByXPath("//android.view.View/android.widget.EditText[1]").sendKeys(username2);
	        driver.findElementByXPath("//android.view.View/android.widget.EditText[2]").sendKeys(password2);
	        driver.findElementByXPath("//android.widget.Button[contains(@text,'Log in')]").click();
	        Assert.assertEquals(driver.findElementByXPath("//android.webkit.WebView/android.view.View[1]/android.view.View[4]").getText(),"Invalid Credentials","logged in failed");
		  }
		  catch (Exception e)
		  {
			  e.printStackTrace();
		  }
		  
	  }  
	  
	  @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }

}
