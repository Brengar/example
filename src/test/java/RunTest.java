import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        tags = "@all",
        features = "src/main/resources",
        plugin = "json:target/cucumber-report.json")
public class RunTest {
}