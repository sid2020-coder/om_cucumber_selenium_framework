package stepDefs;

import constants.EndPoint;
import domainObjects.ProductDetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.PageFactoryMgr;
import pages.StorePage;
import sharedContext.TestContext;

import java.io.IOException;

public class StoreStepDef {

private final StorePage storePage;
    public StoreStepDef(TestContext testContext) {

        storePage = PageFactoryMgr.getStorePage(testContext.driver);
    }

    @Given("I'm on the store page")
    public void i_m_on_the_store_page() throws IOException {
       // new StorePage(driver).load(EndPoint.STORE.url);
        storePage.load(EndPoint.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(ProductDetails product) throws InterruptedException {
     //   new StorePage(driver).addToCart(product.getName());
        storePage.addToCart(product.getName());
    }

    @Given("I have a product in the cart")
    public void i_have_a_product_in_the_cart() throws InterruptedException {
       // new StorePage(driver).addToCart("Blue Shoes");
        storePage.addToCart("Blue Shoes");
    }
}
