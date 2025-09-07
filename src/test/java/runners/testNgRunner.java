package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        plugin = {"html:target/cucumber/cucumber.html"},
        features = "src/test/resources/features",
        publish = true,
        glue = {"stepDefs","hooks","customTypes"}
)
public class testNgRunner extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] paralleltests(){
        return super.scenarios();
    }

    @Test(description = "Runs Cucumber Scenarios", dataProvider = "paralleltests")
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        super.runScenario(pickleWrapper,featureWrapper);
    }
}
