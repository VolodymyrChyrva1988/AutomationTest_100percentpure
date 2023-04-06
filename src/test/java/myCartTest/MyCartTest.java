package myCartTest;

import BaseTest.BaseTest;
import org.junit.After;
import org.junit.Test;


public class MyCartTest extends BaseTest {
    final String TARGET_ITEM = "Bakuchiol Oil Serum";

    @Test
    public void addItemToCart() {
        myAccountPage.openMyAccountPage()
                .clickOnSearchIcon();
        myAccountPage.enterTargetItemForSearch(TARGET_ITEM)
                .clickEnter();
        searchPage.checkIfRedirectedToSearchPage()
                .clickTargetItem()
                .clickAddToTote()
                .checkItemAreCorrect()
               .closeCart()
        ;
    }
    @After
    public  void emptyCart(){
        myAccountPage
                .clickOnMyCartBtn()
               .clickOnDeleteItem()
                .checkCartIsEmpty()
                ;
    }
}
