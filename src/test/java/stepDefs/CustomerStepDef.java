package stepDefs;

import constants.EndPoint;
import domainObjects.BillingDetails;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.PageFactoryMgr;
import pages.StorePage;
import sharedContext.TestContext;

import java.io.IOException;

public class CustomerStepDef {

  private final TestContext testContext;
  private final StorePage storePage;
public CustomerStepDef(TestContext testContext){
    this.testContext =testContext;
    storePage = PageFactoryMgr.getStorePage(testContext.driver);
}
    @Given("my billing details are")
    public void my_billing_details_are(BillingDetails billingDetails) {
        testContext.billingDetails = billingDetails;
    }

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer() throws IOException {
       storePage.load(EndPoint.STORE.url);
    }
}
