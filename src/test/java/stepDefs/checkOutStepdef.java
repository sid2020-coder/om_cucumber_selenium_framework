package stepDefs;

import domainObjects.BillingDetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.CheckOutPage;
import pages.PageFactoryMgr;
import sharedContext.TestContext;

public class checkOutStepdef {

   private TestContext testContext;
   private final CheckOutPage checkOutPage;
    public checkOutStepdef(TestContext testContext){
        this.testContext = testContext;
        checkOutPage = PageFactoryMgr.getCheckOutPage(testContext.driver);
    }

    @When("I provide billing details")
    public void i_provide_billing_details() {
        checkOutPage.setBillingdetails(testContext.billingDetails);
    }
    @When("I place an order")
    public void i_place_an_order()  {
        checkOutPage.placeorder();
    }
    @Then("Order should be placed successfully")
    public void order_should_be_placed_successfully() {
        Assert.assertEquals(checkOutPage.getNotice(),"Thank you. Your order has been received.");
    }
}
