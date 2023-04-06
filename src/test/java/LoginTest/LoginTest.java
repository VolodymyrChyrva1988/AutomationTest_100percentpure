package LoginTest;

import BaseTest.BaseTest;
import org.junit.Test;

public class LoginTest extends BaseTest {


    @Test
    public void ValidLogin(){
loginPage.openLoginPage()
        .clickOnUserIcon()
        .enterValidCredToLoginForm()
        .clickOnSignInBtn();
        myAccountPage.checkIfRedirectedToMyAccountPage()

        ;
    }
@Test
    public void inValidLogin(){
    loginPage.openLoginPage()
            .clickOnUserIcon()
            .enterInValidCredToLoginForm()
            .clickOnSignInBtn();
            loginPage.checkErrorMsg()

    ;

}


}
