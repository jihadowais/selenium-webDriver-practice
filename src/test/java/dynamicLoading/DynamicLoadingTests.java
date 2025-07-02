package dynamicLoading;

import base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DynamicLoadingTests extends BaseTests {
    @Test
    public void messageDisplayedCorrectlyOnClickStartTest() {
        var dynamicPage = homePage.clickDynamicLoading().clickExample1();
        dynamicPage.clickStartButton();

        boolean isDisplayed = dynamicPage.isMessageDisplayed();
        String displayedMessage = dynamicPage.getDisplayedMessage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isDisplayed, "Message is not displayed!");
        softAssert.assertEquals(displayedMessage, "Hello World!", "The message content is not correct.");
        softAssert.assertAll();
    }
}
