package myAccountTest;

import BaseTest.BaseTest;
import org.junit.Test;

public class SubscribeForEmail extends BaseTest {
    @Test
    public void subscribeForEmail(){
        myAccountPage.openMyAccountPage()
                .enterEmailToSibscribe()
                .clickEnter();
        myAccountPage.checkSuccessMsg()
                ;
    }
}
