package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sharedContext.TestContext;

public class DriverFactory {
private final TestContext testContext;
    public DriverFactory(TestContext testContext) {
        this.testContext = testContext;
    }

    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser){
            case "chrome":
                //WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();break;
            case "edge":driver = new EdgeDriver();break;
            default:throw new IllegalStateException("Invalid browser :" +browser);
        }
      //  driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

}
