package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends ParentPage{

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeURL() {
        return "/account";
    }


    @FindBy(xpath = ".//input[@id=\"CustomerEmail\"]")
    private WebElement inputEmail;
    @FindBy(xpath = ".//input[@id=\"CustomerPassword\"]")
    private WebElement inputPassword;
    @FindBy(xpath = ".//*[@class=\"user-icon\"]")
    private WebElement userIcon;
    @FindBy(xpath = ".//input[@value=\"Sign In\"]")
    private WebElement signInButton;

@FindBy(xpath = ".//*[@id=\"onetrust-accept-btn-handler\"]")
private WebElement acceptCookie;
@FindBy(xpath = ".//div[@class=\"errors\"]")
private WebElement errorMsg;
    public final static String valid_password = "qwerty";
    public final static String valid_email = "volodymyr.chyrva@yahoo.com";
    public final static String inValidPass = "qwertyu";


    public LoginPage openLoginPage(){
        try {webDriver.get("https://www.100percentpure.com/");
            webDriverWait10.until(ExpectedConditions.visibilityOf(acceptCookie));
            clickAccCookies();
            logger.info("LoginPage was opened");
        }catch (Exception e){
            logger.error("Can not open Login Page" + e);
            Assert.fail("Can not open Login Page" + e);
        }
        return this;
    }
    public LoginPage enterInValidCredToLoginForm(){
        enterTextInToElement(inputEmail,valid_email);
        enterTextInToElement(inputPassword,inValidPass);
        return this;
    }

    public LoginPage enterEmailIntoInputEmail(String email) {
        enterTextInToElement(inputEmail,email);
        return this;
    }

    public LoginPage enterPasswordIntoInputPassword(String pass) {
        enterTextInToElement(inputPassword, pass);
        return this;
    }
public LoginPage enterValidCredToLoginForm(){
        enterTextInToElement(inputPassword,valid_password);
        enterTextInToElement(inputEmail,valid_email);
        logger.info("Valid email and password was input");
        return this;

}

    public void clickOnSignInBtn() {
        clickOnElement(signInButton);

    }

    public LoginPage clickOnUserIcon() {
        clickOnElement(userIcon);
        return this;
    }



    public LoginPage clickAccCookies() {
        clickOnElement(acceptCookie);
        return this;
    }

    public LoginPage checkErrorMsg() {
        webDriverWait10.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertEquals("Text in error message","Incorrect email or password.",errorMsg.getText());
        return this;
    }

}
