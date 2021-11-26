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

public class Chrome_Activity1 {

	
	AppiumDriver<MobileElement> driver;	
	URL remoteURL;
	String webUrl="https://www.training-support.net/selenium";
	WebDriverWait wait;
	String task1="Add tasks to list";
	String task2="Get number of tasks";
	String task3="Clear the list";
	
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
			System.out.println("URL opened");
	  }
	  
	  @Test(priority=1)
	  public void toDoList_AddTAsks()
	  {
		  
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View")));
		// Scroll element into view and click it
	        driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector().scrollable(true)).flingToEnd(5)"));     
	        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	        driver.findElementByXPath("//android.view.View[contains(@text,'To-Do List')]").click();
	        System.out.println("Scrolled and clicked onto do list");
	        
	        //enter tasks1
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View/android.widget.EditText")));
	        driver.findElementByXPath("//android.view.View/android.widget.EditText").sendKeys(task1);
	        driver.findElementByXPath("//android.widget.Button[contains(@text,'Add Task')]").click();
	        System.out.println("task1 added");
	        
	      
	        //enter tasks1
            driver.findElementByXPath("//android.view.View/android.widget.EditText").sendKeys(task2);
	        driver.findElementByXPath("//android.widget.Button[contains(@text,'Add Task')]").click();
	        System.out.println("task2 added");
	      
	        //enter tasks1
	        driver.findElementByXPath("//android.view.View/android.widget.EditText").sendKeys(task3);
	        driver.findElementByXPath("//android.widget.Button[contains(@text,'Add Task')]").click();
	        System.out.println("task3 added");
	        
	        //verify the tasks
	        Assert.assertEquals(driver.findElementByXPath("//android.view.View[@resource-id='tasksList']/android.view.View[2]/android.view.View").getText(),task1);
	        Assert.assertEquals(driver.findElementByXPath("//android.view.View[@resource-id='tasksList']/android.view.View[3]/android.view.View").getText(),task2);
	        Assert.assertEquals(driver.findElementByXPath("//android.view.View[@resource-id='tasksList']/android.view.View[4]/android.view.View").getText(),task3);
	        System.out.println("Addititon of task test successful");

	  }
	  @Test(priority=2)
	  public void toDoList_StrikeTasks()
	  {  
		  
		  
	        //Strike tasks1
	     
	        driver.findElementByXPath("//android.view.View[@resource-id='tasksList']/android.view.View[2]/android.view.View").click();
	        System.out.println("Task 1 striked");
	      
	        //Strike tasks2
            driver.findElementByXPath("//android.view.View[@resource-id='tasksList']/android.view.View[3]/android.view.View").click();
            System.out.println("Task 2 striked");
	       
            //Strike tasks3
	        driver.findElementByXPath("//android.view.View[@resource-id='tasksList']/android.view.View[4]/android.view.View").click();
	        System.out.println("Task 3 striked");
	        
	        //Clear tasks
	        driver.findElementByXPath("//android.view.View[contains(@text,'Clear List')]").click();
	        System.out.println("Striking test successful");
	        
	  }
	  
	  @AfterClass
	    public void afterClass() {
	        driver.quit();
	    }
		
}
		

