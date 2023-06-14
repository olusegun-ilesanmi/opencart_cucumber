package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		
		//specify the location of the feature files 
		features = {"./features/Login.feature"}, 
		//features = {".features/"}
		//features = {"./features/LoginDataDriven.feature"},
		//features = "@target/rerun.txt" // runs only failed tests
	   // features = {"./features/LoginDataDrivenExcel.feature"},
		//specify the step definition files
		glue = "stepDefinitions",
		//to generate reports
		plugin = {"pretty", 
				"html:reports/myreports.html",
				"json:reports/myreport.json",
				"rerun: target/rerun.txt"}, //mandatory for failed test reports
		
		
		dryRun = false, //checks if methods in step definition class corresponds with feature file 
		monochrome = true, // removes Gherkins junk texts in console output
		//for grouping
		tags = "@Sanity"

		)
public class TestRunner {

}
