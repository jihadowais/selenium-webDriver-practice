package quiz.chapter4;

import org.testng.annotations.DataProvider;

public class ForgotPasswordTestData {
    @DataProvider
    public Object[][] getForgotPasswordEmails() {
        return new Object[][] {
                {true, "tau@example.com", "Your e-mail's been sent!", "Expected email to be sent for valid address, but it was not."},
                {false, "wrong email", "Invalid email address!", "Expected email should not be sent for invalid address, but it was not."},
        };
    }
}
