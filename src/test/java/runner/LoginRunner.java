package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = { "src/test/resources/Features" }, dryRun = false, monochrome = false, glue = {
		"stepDefinition" }, snippets = SnippetType.CAMELCASE, plugin = { "pretty", "json:target/report.json",
				"html:target/cucumeber-reports.html" })
public class LoginRunner extends AbstractTestNGCucumberTests {

}

//plugin = { "pretty", "html:target/cucumber-reports.html",
//		"json:target/cucumber.json", }