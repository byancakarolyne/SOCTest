package steps;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "C:\\Users\\byanc\\IdeaProjects\\SOCTest\\src\\test\\java\\features\\dados.feature",
        glue = {"C:\\Users\\byanc\\IdeaProjects\\SOCTest\\src\\test\\java\\steps"},
        plugin = {
                "pretty",
                "html:target/Relatorio-html"
        }
)

public class Runner {
}
