package Hovers;

import org.testng.annotations.DataProvider;

public class HoversTestData {
    @DataProvider
    public Object[][] getUsers() {
        return new Object[][] {
                {"user1", "/users/1"},
                {"user2", "/users/2"},
                {"user3", "/users/3"},
        };
    }
}
