package helpers;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( format = {"pretty", "html:target/cucumber-report-html", "json:target/cucumber.json"},
        tags = {"not @wip"},
        glue={"steps"},
        features = "src/test/resources/features" )
public class RunCukesTest {
}

