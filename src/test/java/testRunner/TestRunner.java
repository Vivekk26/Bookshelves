package testRunner;

import org.junit.runner.RunWith;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {".//FeatureFile/urbanladder.feature"},
		//features={"@target/rerun.txt"},
		glue="stepDefinition",
	    plugin= {"pretty", "html: report/myreport.html",
	    		"rerun:target/rerun.txt",
	    		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	    		},
	    dryRun=false,
	    monochrome=true,
	    publish=true,
	    tags="@smoke or @regression"
		
		)
public class TestRunner {
	

}
