package editSkinProfile;

import BaseTest.BaseTest;
import org.junit.Test;

public class SkinProfile extends BaseTest {
    @Test
    public void editSkinProfile(){
        myAccountPage.openMyAccountPage()
                .clickOnEditAccountBtn()
                .clickOnEditSkinProfileBtn()
                .checkIfRedirectedToSkinProfilePage()
                .selectSkinType()
                .selectSkinTone()
                .clickOnUpdateProfileBtn()
                .checkChangesIsCorrect()
        ;

    }
}
