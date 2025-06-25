package home;

import base.BaseTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class HomeTests extends BaseTests {
    @Test(dataProvider = "getPageTitle", dataProviderClass = HomeTestData.class)
    public void shouldShowAppTitleCorrectlyTest(String title) {
        String actual = homePage.getTitle();
        Assert.assertEquals(actual, title, "Page has no or wrong title .");
    }

    @Test(dataProvider = "getURLs", dataProviderClass = HomeTestData.class)
    public void shouldShowElementAndRedirectToExpectedUrlTest(String elementName, String expectedURL) {
        SoftAssert softAssert = new SoftAssert();

        homePage.setCurrentElement(elementName);
        softAssert.assertTrue(homePage.isCurrentElementDisplayed(), "Element doesn't show.");

        String actualURL = homePage.getCurrentElementURL();
        softAssert.assertEquals(actualURL, expectedURL, "Wrong redirection URL.");

        softAssert.assertAll("Some elements are not visible or have wrong redirection URL.");
    }

    @Test
    public void verifyElementsHaveValidURLTest() {
        Map<String, Boolean> homeElements = homePage.getElementsIsValidURLs();
        SoftAssert softAssert = new SoftAssert();

        for (var element: homeElements.entrySet()) {
            softAssert.assertTrue(
                    element.getValue(),
                    "The element: " + element.getKey() + " has invalid URL.");
        }
        softAssert.assertAll("Some elements may have a wrong URL or maybe it's not found.");
    }
}
