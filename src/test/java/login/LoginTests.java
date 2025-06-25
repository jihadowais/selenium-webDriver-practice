package login;

import base.BaseTests;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.SecureAreaPage;

public class LoginTests extends BaseTests {
    @Test(dataProvider = "getLoginCredentials", dataProviderClass = LoginTestData.class)
    public void verifyLoginFunctionality(boolean expectedIsLoggedIn, String username, String password, String expectedAlertMessage) {
        LoginPage loginPage = homePage.clickFormAuthentication();

        SecureAreaPage secureAreaPage = loginPage.login(username, password);
        boolean actualIsLoggedIn = secureAreaPage.isLoggedIn();
        String actualAlertMessage = secureAreaPage.readAlertMessage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualIsLoggedIn, expectedIsLoggedIn, "Unexpected login behaviour.");
        softAssert.assertEquals(actualAlertMessage, expectedAlertMessage, "Displayed Alert Message is not correct.");
        softAssert.assertAll("Unexpected login behaviour happened or the displayed alert message correctly.");
    }
}
