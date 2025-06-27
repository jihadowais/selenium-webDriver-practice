package quiz.chapter4;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

public class ForgotPasswordTests extends BaseTests {
    @Test(dataProvider = "getForgotPasswordEmails", dataProviderClass = ForgotPasswordTestData.class)
    public void validateForgotPasswordSendEmail(boolean expectedIsEmailSent, String email, String expectedAlertMessage, String assertionSentEmailErrorMessage) {
        ForgotPasswordPage forgetPasswordPage = homePage.clickForgetPassword();
        EmailSentPage emailSentPage = forgetPasswordPage.retrievePassword(email);

        // handle internal server error 500
        Assert.assertTrue(emailSentPage.isOnEmailSentPage(), "Server did not redirect to Email Sent page. Possible 500 error.");

        boolean actualIsEmailSent = emailSentPage.isEmailSent(); // should be enhanced to cover the non-sent-email scenario but the server now is down: "internal server error" with status-code: 500
        String actualAlertMessage = emailSentPage.getMessageContent();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualIsEmailSent, expectedIsEmailSent, assertionSentEmailErrorMessage);
        softAssert.assertEquals(actualAlertMessage, expectedAlertMessage, "The displayed alert message is NOT as expected.");
        softAssert.assertAll();
    }
}
