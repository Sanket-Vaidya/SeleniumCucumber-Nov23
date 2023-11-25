package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//features = { ".//Features//Login.feature" }, 
features= "@target/rerun.txt", 
glue = "stepDefinitions", plugin = { "pretty",
		"html:reports/myreport.html", "json:reports/myreport.json","rerun:target/rerun.txt" }, // Mandatory to capture failures
		dryRun = false, monochrome = true, 
		tags = "@sanity" // Scenarios tagged with @sanity,
		//tags="@sanity and @smoke",
		//tags="@sanity or @smoke"
		//tags=@sanity and not @regression

)

public class TestRunner {

}
