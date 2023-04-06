package myAccountTest;

import BaseTest.BaseTest;
import org.junit.Test;

public class MyPerksPoints extends BaseTest {

    @Test
    public void getPointsForBirthday(){
        myAccountPage.openMyAccountPage()
                .clickOnPuristPerksBtn()
                .clickErnPointsBtn()
                .clickOnHappyBD()
                .enterBirthDayData();
                myAccountPage.clickSaveBirthday();
                myAccountPage.checkIfPointsWasClaimed()
                ;


    }

}
