package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends ParentPage {
    public MyAccountPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@class=\"pointer module_title_text inline m-v-xs large--m-b-md account-nav text-u-l\"]")
    private WebElement accountIcon;
    @FindBy(xpath = ".//input[@value=\"Sign In\"]")
    private WebElement signInButton;
    @FindBy(xpath = ".//*[@class=\"inline one-third right caption_text text-right " +
            "pointer account-2nd-nav text-u-l\" and @section-to=\"profile-skin\"]")
    private WebElement editSkinProfileBtn;
    @FindBy(xpath = ".//*[@class=\"lion-loyalty-panel-rule-item__title\" and text()=\"Happy Birthday\"]")
    private WebElement happyBirthdayIcon;
    @FindBy(xpath = ".//*[@class=\"pointer medium-down--hide content_text inline m-v-xs account-nav\" and @section-to=\"perk\"]")
    private WebElement puristPerksBtn;
    @FindBy(xpath = ".//*[@class=\"lion-loyalty-panel-sidebar__menu-item lion-loyalty-panel-sidebar__menu-item--icon lion-loyalty-panel-sidebar__menu-item--earn\"]")
    private WebElement earnPointsBtn;
    @FindBy(xpath = ".//*[@class=\"inline one-third right caption_text text-right pointer account-nav text-u-l\" and @section-to=\"profile\"]")
    private WebElement accountInfoEdit;
    @FindBy(xpath = ".//*[@class=\"lion-select lion-birthday-entry-form__select lion-birthday-entry-form__select--month\"]")
    private WebElement birtDayDD;
    @FindBy(xpath = ".//*[@class=\"lion-birthday-entry-form__input lion-birthday-entry-form__input--day\"]")
    private WebElement day;
    @FindBy(xpath = ".//*[@class=\"lion-birthday-entry-form__input lion-birthday-entry-form__input--year\"]")
    private WebElement year;
    @FindBy(xpath = ".//*[@class=\"lion-action-button lion-action-modal__button lion-birthday-entry-form__submit-button\"]")
    private WebElement saveBD;
    @FindBy(xpath = ".//*[@placeholder=\"Search\"]")
    private WebElement placeholderSearch;
    @FindBy(xpath = "//*[@class=\"site-header__cart-toggle js-drawer-open-right\" and @aria-expanded='true']")
    private WebElement myCartIcon;
    @FindBy(xpath = "//*[@placeholder=\"Enter your email\" and @aria-label='Enter your email']")
    private WebElement subscribeEmail;
    @FindBy(xpath = "//*[text()='Thanks for subscribing!']")
    private WebElement subscribeSuccessMsg;


    private LoginPage loginPage = new LoginPage(webDriver);


    @Override
    String getRelativeURL() {
        return "/account";
    }

    public MyAccountPage openMyAccountPage() {
        loginPage.openLoginPage();
        if (!isElementDisplayed(signInButton)) {
            loginPage.clickOnUserIcon()
                    .enterValidCredToLoginForm()
                    .clickOnSignInBtn();
            logger.info("Login credentials was entered");
        }
        checkIfRedirectedToMyAccountPage();
        logger.info("Redirected to HomePage");

        return this;
    }

    public SkinProfilePage clickOnEditSkinProfileBtn() {
        clickOnElement(editSkinProfileBtn);
        return new SkinProfilePage(webDriver);
    }

    public MyAccountPage checkIfRedirectedToMyAccountPage() {
        checkURL();
        Assert.assertTrue(isElementDisplayed(accountIcon));
        return new MyAccountPage(webDriver);
    }

    public MyAccountPage clickOnEditAccountBtn() {
        clickOnElement(accountInfoEdit);
        return this;
    }

    public MyAccountPage clickOnPuristPerksBtn() {
        clickOnElement(puristPerksBtn);
        return this;
    }

    public MyAccountPage clickErnPointsBtn() {
        clickOnElement(earnPointsBtn);
        return this;
    }

    public MyAccountPage clickOnHappyBD() {
        clickOnElement(happyBirthdayIcon);
        return this;
    }

    public void enterBirthDayData() {
        if (isElementDisplayed(saveBD)) {
            selectValueInDropDown(birtDayDD, "10");
            enterTextInToElement(day, "10");
            enterTextInToElement(year, "2000");
        } else
            logger.info("Birthday points claimed already");

    }

    public void clickSaveBirthday() {
        if (isElementDisplayed(saveBD)) {
            clickOnElement(saveBD);
        } else
            logger.info("Birthday points claimed already");
    }

    public void checkIfPointsWasClaimed() {
        Assert.assertTrue("Points was claimed ", !isElementDisplayed(saveBD));

    }


    public MyAccountPage enterTargetItemForSearch(String targetItem) {
        enterTextInToElement(placeholderSearch, targetItem);
        return this;
    }


    public MyCartPage clickOnMyCartBtn() {

        clickOnElement(myCartIcon);
        return new MyCartPage(webDriver);
    }


    public MyAccountPage enterEmailToSibscribe() {
        enterTextInToElement(subscribeEmail, "qwerty@ccc.com");
        return this;
    }

    public void checkSuccessMsg() {
        Assert.assertTrue(isElementDisplayed(subscribeSuccessMsg));
    }
}

