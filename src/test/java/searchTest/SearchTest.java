package searchTest;

import BaseTest.BaseTest;
import org.junit.Test;

public class SearchTest extends BaseTest {

    final String TARGET_ITEM = "Bakuchiol Oil Serum";


    @Test
    public void searchItem() {
        myAccountPage.openMyAccountPage()
                .clickOnSearchIcon();
        myAccountPage.enterTargetItemForSearch(TARGET_ITEM)
                .clickEnter();
        searchPage.checkIfRedirectedToSearchPage()
                .checkTargetItemInSearchResult()

        ;



    }
}
