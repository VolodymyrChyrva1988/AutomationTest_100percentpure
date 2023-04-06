package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyCartPage extends ParentPage {
    public MyCartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = "//*[@class=\"cart__remove-btn display-table-cell text-right\"]")
    private WebElement deleteItem;
@FindBy(xpath = "//*[@class=\"text-center m-t\" and text()='Your tote is currently empty.']")
private WebElement cartEmptyMsg;
    @Override
    String getRelativeURL() {
        return "/";
    }

    public MyCartPage clickOnDeleteItem() {
        clickOnElement(deleteItem);
        return this;


    }

    public void checkCartIsEmpty() {
        Assert.assertTrue("Cart is not empty",isElementDisplayed(cartEmptyMsg));
    }
}