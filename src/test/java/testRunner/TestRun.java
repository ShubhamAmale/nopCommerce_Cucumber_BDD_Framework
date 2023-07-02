package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features = ".//Features/",//for specific feature file to execute enter along with name i.e. with Customers.feature
		features = {".//Features/Login.feature" , ".//Features/Customers.feature"},
		glue = "stepDefinitions", //same for stepDefinition file also
		dryRun = false,//cross check if every feature in feature file have test method or not
		monochrome = true, //remove unnecessary characters from output
		plugin = {"pretty", "html:test-output"}
		)

public class TestRun {

	
}

