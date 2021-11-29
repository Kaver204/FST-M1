package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {

	WebDriver driver;
	WebDriverWait wait;
	public static String url="https://www.training-support.net/selenium/login-form";
	
	@Given ("^User is on Login page$")
	public void openUrl()
	{
		//instantiation
		driver=new FirefoxDriver();
		wait=new WebDriverWait(driver,20);
		driver.get(url);
	}
    @When ("^User enters username and password$")
    public void login()
	{
    	//logging in
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    	driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("password");
		driver.findElement(By.xpath("//*[contains(text(),'Log in')]")).click();
	}
    @When ("^User enters \"(.*)\" and \"(.*)\"$")
    public void loginWithUserInput(String username,String password)
	{
    	//logging in
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
    	driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//*[contains(text(),'Log in')]")).click();
	}
    @Then ("^Read the page title and confirmation message$")
    public void verifyTitle()
	{
    	//getting the confirmations
		String Title=driver.getTitle();
		String confirmMessage=driver.findElement(By.id("action-confirmation")).getText();
		//printing the texts
		System.out.println(Title);
		System.out.println(confirmMessage);
	}
    @And ("^Close the Browser$")
    public void close()
	{
    	//closing the browser
		driver.quit();
	}
	
}
