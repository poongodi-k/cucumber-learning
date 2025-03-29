package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
@CucumberOptions(features = {"src/test/resources/Features/loginPage.feature"}, dryRun = false
, glue = {"stepDefinition"},snippets = SnippetType.CAMELCASE)
public class LoginRunner extends AbstractTestNGCucumberTests{

	
}
