package appium_project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleTask {
	AppiumDriver<MobileElement> driver;
	URL remoteURL;
	//WebDriverWait wait;
	WebDriverWait wait;
	@BeforeTest
	public void setUp() throws MalformedURLException {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceName", "Pixel 4 emulator");
		caps.setCapability("platformName", "android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);
		
		
	
			// Create object for WebDriverWait class
		   
			remoteURL = new URL("http://localhost:4723/wd/hub");
			driver=new AndroidDriver<MobileElement>(remoteURL, caps);
			System.out.println("google task is open");	
			wait = new WebDriverWait(driver, 10);
	
	}
		
		@Test(priority=1)
		public void AddTask1()
		{
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tasks_fab")));
				driver.findElementById("tasks_fab").click();
				System.out.println("Clicked on add button");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_task_title")));
				driver.findElementById("add_task_title").click();
				driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
				System.out.println("text added");
				driver.findElementById("add_task_done").click();
				System.out.println("Clicked on save button");
				System.out.println("Task1 done!");
			}
				
			catch(Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Test(priority=2)
		public void AddTask2()
		{
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tasks_fab")));
				driver.findElementById("tasks_fab").click();
				System.out.println("Clicked on add button");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_task_title")));
				driver.findElementById("add_task_title").click();
				driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
				System.out.println("text added");
				driver.findElementById("add_task_done").click();
				System.out.println("Clicked on save button");
				System.out.println("Task2 done!");
			}
				
			catch(Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		@Test(priority=3)
		public void AddTask3()
		{
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tasks_fab")));
				driver.findElementById("tasks_fab").click();
				System.out.println("Clicked on add button");
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("add_task_title")));
				driver.findElementById("add_task_title").click();
				driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
				System.out.println("text added");
				driver.findElementById("add_task_done").click();
				System.out.println("Clicked on save button");
				System.out.println("Task3 done!");
			}
				
			catch(Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	

}
