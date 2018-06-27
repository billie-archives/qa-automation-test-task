package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features="features",
		glue="stepDefinition"
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	
}