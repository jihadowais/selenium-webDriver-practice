package alerts;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.JavaScriptAlertsPage;

public class AlertsTests extends BaseTests {
    @Test
    public void verifyAlertResultMessageTest() {
        JavaScriptAlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickAlertButton();
        alertsPage.acceptAlert();
        String actualResultMessage = alertsPage.readResultMessage();
        Assert.assertEquals(actualResultMessage, "You successfully clicked an alert", "Incorrect result message.");
    }

    @Test
    public void verifyConfirmAlertTextThenCancelTest() {
        JavaScriptAlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickConfirmAlertButton();
        String actualAlertText = alertsPage.getAlertText();
        alertsPage.cancelAlert();
        String actualResultMessage = alertsPage.readResultMessage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualAlertText, "I am a JS Confirm", "Incorrect alert text.");
        softAssert.assertEquals(actualResultMessage, "You clicked: Cancel", "Incorrect result message.");
        softAssert.assertAll();
    }

    @Test
    public void verifyInputPromptMessageShowsTest() {
        JavaScriptAlertsPage alertsPage = homePage.clickJavaScriptAlerts();
        alertsPage.clickPromptAlertButton();
        alertsPage.inputText("Hello world!");
        alertsPage.acceptAlert();
        String actualResultMessage = alertsPage.readResultMessage();
        Assert.assertEquals(actualResultMessage, "You entered: Hello world!", "Incorrect result message.");
    }
}
