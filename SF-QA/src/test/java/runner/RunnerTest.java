package runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/resources/features/TesteSecretaria.feature"}, plugin = {"json:target/reports/CucumberReport.json"},
        glue = "steps", tags = {"~@ignore"}, snippets = SnippetType.CAMELCASE)

public class RunnerTest {
     
	 
}