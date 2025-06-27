package Hovers;

import base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HoversPage;

public class HoversTests extends BaseTests {
    @Test(dataProvider = "getUsers", dataProviderClass = HoversTestData.class)
    public void hoverUserTest(String username, String profileURL) {
        HoversPage hoversPage = homePage.clickHovers();
        hoversPage.hoverOverFigure(username);

        boolean isUserNameDisplayed = hoversPage.isUserNameDisplayed(username);
        boolean isUserProfileLinkDisplayed = hoversPage.isUserProfileLinkDisplayed(profileURL);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isUserNameDisplayed, "User's name is not displayed on hover Image.");
        softAssert.assertTrue(isUserProfileLinkDisplayed, "User's profile link is not displayed on hover Image.");
        softAssert.assertAll();
    }

}
