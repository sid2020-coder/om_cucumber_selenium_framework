package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import sharedContext.TestContext;

public class hooks {
    private WebDriver driver;
    private final TestContext testContext;
    public hooks(TestContext testContext){
        this.testContext = testContext;
    }

    @Before
    public void before(Scenario scenario){
        testContext.scenarioName = scenario.getName();
        System.out.println("Scanerio name:" +testContext.scenarioName);
          System.out.println("Before Thread id :" + Thread.currentThread().threadId() +
                  "Scenario name: "+scenario.getName());
       driver = DriverFactory.initializeDriver(System.getProperty("browser","chrome"));
        testContext.driver = driver;
    }

    @After
    public void after(Scenario scenario){
        System.out.println("After Thread id :" + Thread.currentThread().threadId() +
                "Scenario name: "+scenario.getName());
        this.driver.quit();

    }
}
