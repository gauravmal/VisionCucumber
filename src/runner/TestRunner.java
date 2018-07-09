package runner;

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber-html-report/cucumber.json",overviewReport=true,outputFolder="target")
@CucumberOptions(plugin = { "pretty","html:target/cucumber-html-report",
        "json:target/cucumber-html-report/cucumber.json",
        "usage:target/cucumber-html-report/cucumber-usage.json", "junit:target/cucumber-html-report/cucumber-results.xml" },
        features = "Feature",glue={"stepsDefinition"})
public class TestRunner{}
