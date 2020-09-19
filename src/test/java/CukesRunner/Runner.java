package CukesRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    //  plugin = {"html:/Users/saidakaraeva/Downloads/CucumberBatch5/
        //  target/cucumber-reports/cucumber-html-reports",
        //  "json:target/cucumber.json"},
        features = "src/test/resources/EtsyTest",
        glue = "StepDefinition",
        tags = "@TEC-2009",

        dryRun =false
)
public class Runner {


}
