package login;

import org.testng.annotations.DataProvider;

public class LoginTestData {
    @DataProvider
    public Object[][] getLoginCredentials() {
        return new Object[][] {
                {true, "tomsmith", "SuperSecretPassword!", "You logged into a secure area!\n" + "×"},
                {false, "tomsmithh", "SuperSecretPassword!", "Your username is invalid!\n" + "×"},
                {false, "tomsmith", "SuperSecretPassword", "Your password is invalid!\n" + "×"}
        };
    }
}
