package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8_2 {
	public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
 
        //Open browser
        driver.get("https://training-support.net/selenium/tables");
 
        //Get columns
        List<WebElement> cols = driver.findElements(By.xpath("//*[@id='sortableTable']/thead/tr/th"));
        //Get rows
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='sortableTable']/tbody/tr"));
 
        //Number of columns
        System.out.println("Number of columns are: " + cols.size());
        //Number of rows
        System.out.println("Number of rows are: " + rows.size());
 
        //Cell value of second row, second column
        WebElement cellValueBeforeSort = driver.findElement(By.xpath("//*[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value(Before sorting): " + cellValueBeforeSort.getText());
 
        //Sort the table
        driver.findElement(By.xpath("//*[@id='sortableTable']/thead/tr/th[2]")).click();
 
        //Print the value again
        WebElement cellValueAfterSort = driver.findElement(By.xpath("//*[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value(After sorting): " + cellValueAfterSort.getText());
 
        //Print footer cellvalue
        WebElement footer = driver.findElement(By.xpath("//*[@id='sortableTable']/tfoot/tr"));
        System.out.println("Table footer values: " + footer.getText());
 
        //Close browser
        driver.close();
    }

}
