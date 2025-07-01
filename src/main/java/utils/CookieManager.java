package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

/**
 * This class is a general class to manage cookies through the test project.
 */
public class CookieManager {
    private final WebDriver driver;

    public CookieManager(WebDriver driver){
        this.driver = driver;
    }

    public void addCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }

    public void deleteCookie(Cookie cookie){
        driver.manage().deleteCookie(cookie);
    }

    public boolean isCookiePresent(Cookie cookie){
        return driver.manage().getCookieNamed(cookie.getName()) != null;
    }

    public Cookie buildCookie(String name, String value, String domainURL){
        return new Cookie.Builder(name, value)
                .domain(domainURL)
                .build();
    }

    /**
     * Just a simple example for setting a cookie.<br>
     * Does the cookie have meaning to a page?<br>
     * 		✅ Yes: put cookie logic in the Page Object.<br>
     * 		❌ No, generic test config: keep it in BaseTest.
     */
    public void setCookie(String domainURL){
        Cookie cookie = new Cookie.Builder("username", "Ammer")
                .domain(domainURL).build(); // The domain needs to be the website that we're actually storing this cookie for.
        driver.manage().addCookie(cookie);
        driver.navigate().refresh(); // Optional: reload so the cookie is active
    }
}
