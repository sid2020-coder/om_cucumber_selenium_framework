package stepDefs;

import domainObjects.ProductDetails;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CartPage;
import pages.PageFactoryMgr;
import sharedContext.TestContext;

//import static pages.PageFactoryMgr.cartPage;

public class CartStepDef {

    private final CartPage cartPage;

    public CartStepDef(TestContext testContext){
        cartPage = PageFactoryMgr.getCartPage(testContext.driver);
    }

    @Given("I'm on the checkout page")
    public void i_m_on_the_checkout_page() {
        cartPage.clickCheckOutBtn();
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int qty, ProductDetails product) {
        //CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getProductName(),product.getName());
        Assert.assertEquals(cartPage.getProductQuantity(),qty);
    }
}
