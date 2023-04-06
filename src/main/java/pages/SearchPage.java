package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends ParentPage {
    public SearchPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@class=\"module_title_text m-v text-center\"]")
    private WebElement yourToteElement;
    @FindBy(xpath = ".//*[@alt=\"Bakuchiol Oil Serum Cart Drawer Product Image\"]")
    private WebElement TARGET_ITEM_IN_CART;
    @FindBy(xpath = ".//*[@placeholder=\"Search our store\"]")
    private WebElement searchPlaceholder;
    @FindBy(xpath = ".//*[@alt=\"Product Grid - Bakuchiol Oil Serum\"]")
    private WebElement targetItem;
    @FindBy(xpath = ".//*[@data-variant-title=\"Default Title\"]")
    private WebElement addToToteBtn;
    @FindBy(xpath = ".//input[@id=\"quantity-desktop\"]")
    private WebElement inputQuantity;
    @FindBy(xpath = ".//*[@class=\"ajaxcart__qty-num\"]")
    private WebElement AdjustQuantityInCart;
    @FindBy(xpath = "//div[@id='cart__price']")
    private WebElement checkTotalPrice;
    @FindBy(xpath = "//*[@class=\"icon icon-x\" and@aria-hidden='true']")
    private WebElement closeCart;
    @FindBy(xpath = "//*[@alt='Product Grid - Bakuchiol Oil Serum']")
    private WebElement searchResultItem;

    @Override
    String getRelativeURL() {
        return "/search";
    }


    public SearchPage checkIfRedirectedToSearchPage() {
        Assert.assertTrue(isElementDisplayed(searchPlaceholder));
        return this;
    }


    public SearchPage clickTargetItem() {
        clickOnElement(targetItem);
        return this;
    }

    public SearchPage clickAddToTote() {
        clickOnElement(addToToteBtn);
        return this;
    }

    public SearchPage checkItemAreCorrect() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(yourToteElement));
        Assert.assertTrue("Element is not displayed", isElementDisplayed(TARGET_ITEM_IN_CART));
        return this;
    }

    public void closeCart() {
        clickOnElement(closeCart);
    }

    public SearchPage checkTargetItemInSearchResult() {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(searchResultItem));
        return this;
    }
}
