package keys;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

public class KeyPressesTests extends BaseTests {
    @Test(dataProvider = "getSpecialKeysData", dataProviderClass = KeyPressesTestData.class)
    public void specialKeysTest(String key, String expectedResultMessage) {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        String actualResultMessage = keyPressesPage.getPressedSpecialKeyMessage(key);
        Assert.assertEquals(actualResultMessage, expectedResultMessage, "Special pressed key's message is not correct!");
    }

    @Test(dataProvider = "getAlphanumericalKeysData", dataProviderClass = KeyPressesTestData.class)
    public void alphanumericalKeysTest(String key, String expectedResultMessage) {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        String actualResultMessage = keyPressesPage.getPressedAlphanumericalKeyMessage(key);
        Assert.assertEquals(actualResultMessage, expectedResultMessage, "Alphanumeric pressed key's message is not correct!");
    }

    @Test(dataProvider = "getMultipleKeysData", dataProviderClass = KeyPressesTestData.class)
    public void multipleKeysTest(String key1, String key2, String expectedResultMessage) {
        KeyPressesPage keyPressesPage = homePage.clickKeyPresses();
        String actualResultMessage = keyPressesPage.getPressedMultipleKeysMessage(key1, key2);
        Assert.assertEquals(actualResultMessage, expectedResultMessage, "Multiple keys pressed message is not correct!");
    }
}
