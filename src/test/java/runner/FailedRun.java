package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/Team2BDDSeleniumHackathon.html", "json:target/cucumber.json",
                "rerun:target/failedrerun.txt"
        },
        monochrome = true,
        features = {"@target/failedrerun.txt"}, 
        glue = "stepdefinition")


public class FailedRun extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {

        return super.scenarios();
    }
}


