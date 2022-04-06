package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/cucumber/features"},
        glue = {"stepDefinitions", "cucumberHooks"},
        plugin = {"pretty","html:target/test-output", "json:target/json_output/cucumber.json", "junit:target/junit_xml/cucumber.xml"}, //to generate different types of reporting
        monochrome = true, //display the console output in a proper readable format
        dryRun = false //to check the mapping is proper between feature file and step def file

)

public class CucumberTestRunner {

}
