package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//td[@class='product-name']") private WebElement productNameField;
    @FindBy(xpath = "//input[@type='number']") private WebElement productQtyField;
    @FindBy(xpath = "//a[normalize-space()='Proceed to checkout']") private WebElement checkOutBtn;
    public String getProductName(){
        return  wait.until(ExpectedConditions.visibilityOf(productNameField)).getText();
    }

    public int getProductQuantity(){
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQtyField)).getAttribute("value"));
    }

    public void clickCheckOutBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn)).click();
    }
}
