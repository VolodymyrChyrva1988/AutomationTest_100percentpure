package pages;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

abstract public class ParentPage extends CommonActionsWithElements{
        protected String base_url;


        public ParentPage(WebDriver webDriver) {
            super(webDriver);
            base_url = "https://www.100percentpure.com";
        }
        protected void waitChatToBeHide() {

            webDriverWait10.until(ExpectedConditions
                    .invisibilityOfElementLocated(By.xpath(".//*[@id='chat-wrapper']")));
        }


        abstract String getRelativeURL();

        protected void checkURL(){

            Assert.assertEquals("Invalid page", base_url + getRelativeURL() ,webDriver.getCurrentUrl());
        }

        protected void checkURLContainsRelative(){

            Assert.assertThat("",webDriver.getCurrentUrl()
                    , CoreMatchers.containsString(base_url + getRelativeURL()));
        }

        protected void checkURLWithPattern(){
            String actualURl = webDriver.getCurrentUrl();
            Assert.assertTrue("\nActual URL" + actualURl+ "\n"
                            +"Expected URL" + base_url + getRelativeURL()+"\n"
                    ,actualURl.matches(base_url+ getRelativeURL()));
        }
    }


