package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features",
		glue= {"stepDefinitions"},
		tags= "@SimpleAlert",
		plugin = {"pretty", "html:target/cucumber-reports/reports"},
	    monochrome = true
		)
		
public class testrunner {
	
}

