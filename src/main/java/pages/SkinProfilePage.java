package pages;

import com.beust.ah.A;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SkinProfilePage extends ParentPage {
    public SkinProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//select[@id=\"SkinType\"]//..")
    //  .//button[@class="cus-pfl-submit-btn btn btn-secondary p-v w-full disabled" and text()='updating ....']
    private WebElement skinTypeDD;
    @FindBy(xpath = ".//li[text()=\"Fair\"]")
    private WebElement skinToneFair;
    @FindBy(xpath = ".//*[@class=\"styled-select select-hidden\" and @id=\"SkinShade\"]")
    private WebElement skinTone;
    @FindBy(xpath = ".//*[@class=\"styled-select select-hidden\" and @id=\".//*[@class=\"]")
    private WebElement skinConcern;
    @FindBy(xpath = ".//*[@class=\"text-md inline m-b-sm\"and text()=\"Skin Type\"]")
    private WebElement skinTypeElement;
    @FindBy(xpath = ".//*[@class=\"m-v-sm p-h-md w-full\"]")
    private WebElement updateProfileBtn;
    @FindBy(xpath = ".//select[@id=\"SkinShade\"]//..")
    private WebElement skinToneDD;
    @FindBy(xpath = ".//li[text()=\"Dry\"]")
    private WebElement skinTypeDry;
    @FindBy(xpath = ".//div[@class=\"select-styled pointer\" and text()='Dry']")
    private WebElement skinTypeResult;
    @FindBy(xpath = ".//div[@class=\"select-styled pointer\" and text()='Fair']")
    private WebElement skinToneResult;
    @FindBy(xpath = ".//div[@class='m-v-sm p-h-md w-full']")
    private WebElement updatingIcon;

    @Override
    String getRelativeURL() {
        return "/account#profile";
    }

    public SkinProfilePage checkIfRedirectedToSkinProfilePage() {
        checkURL();
        Assert.assertTrue(isElementDisplayed(skinTypeElement));

        return this;
    }


    public SkinProfilePage selectSkinType() {
        clickOnElement(skinTypeDD);
        clickOnElement(skinTypeDry);
        return this;
    }

    public SkinProfilePage selectSkinTone() {
        clickOnElement(skinToneDD);
        clickOnElement(skinToneFair);
        return this;
    }

    public SkinProfilePage selectSkinConcern(String concernDehydration) {
        selectTextInDropDown(skinConcern, concernDehydration);
        return this;
    }

    public SkinProfilePage clickOnUpdateProfileBtn() {
        clickOnElement(updateProfileBtn);
        return this;
    }

    public SkinProfilePage checkChangesIsCorrect() {
        Assert.assertTrue(isElementDisplayed(skinTypeResult));
        Assert.assertTrue(isElementDisplayed(skinToneResult));
        Assert.assertEquals("Text on button", "UPDATING ....", updatingIcon.getText());
        return this;
    }
}
