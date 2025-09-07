package pages;

import domainObjects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='billing_first_name']") private WebElement billingFirstNameFld;
    @FindBy(xpath = "//input[@id='billing_last_name']") private WebElement billingLastNameFld;
    @FindBy(xpath = "//input[@id='billing_address_1']") private WebElement billingAddressOneFld;
    @FindBy(xpath = "//input[@id='billing_city']") private WebElement billingCityFld;
    @FindBy(id = "billing_state") private WebElement billingStateDroDown;
    @FindBy(xpath = "//input[@id='billing_postcode']") private WebElement billingZipFld;
    @FindBy(xpath = "//input[@id='billing_email']") private WebElement  billingEmailFld;
    @FindBy(xpath = "//button[@id='place_order']") private WebElement placeOrderBtn;
    @FindBy(css = ".woocommerce-notice") private WebElement noticeTxt;

    public CheckOutPage enterBillingFirstName(String billingFirstName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingFirstNameFld));
        e.clear();
        e.sendKeys(billingFirstName);
        return this;
    }
    public CheckOutPage enterBillinglastName(String billingLastName){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingLastNameFld));
        e.clear();
        e.sendKeys(billingLastName);
        return this;
    }

    public CheckOutPage enterBillingAddressLineOne(String billingAddressLineOne){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingAddressOneFld));
        e.clear();
        e.sendKeys(billingAddressLineOne);
        return this;
    }

    public CheckOutPage enterBillingCity(String billingCity){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingCityFld));
        e.clear();
        e.sendKeys(billingCity);
        return this;
    }

    public CheckOutPage selectBillingState(String billingState){
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingStateDroDown)));
        select.selectByVisibleText(billingState);
        return this;
    }

    public CheckOutPage enterBillingZip(String billingZip){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingZipFld));
        e.clear();
        e.sendKeys(billingZip);
        return this;
    }

    public CheckOutPage enterBillingEmail(String billingEmail){
        WebElement e = wait.until(ExpectedConditions.visibilityOf(billingEmailFld));
        e.clear();
        e.sendKeys(billingEmail);
        return this;
    }

    public CheckOutPage setBillingdetails(BillingDetails billingDetails){
        return enterBillingFirstName(billingDetails.getBillingFirstName()).enterBillinglastName(billingDetails.getBillingLastName()).
                enterBillingAddressLineOne(billingDetails.getBillingAddressOne()).enterBillingCity(billingDetails.getBillingCity()).
        selectBillingState(billingDetails.getBillingStateName()).enterBillingZip(billingDetails.getBillingZip()).enterBillingEmail(billingDetails.getBillingEmail());
    }

    public CheckOutPage placeorder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn)).click();
        return this;
    }

    public String getNotice(){
        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }
}
