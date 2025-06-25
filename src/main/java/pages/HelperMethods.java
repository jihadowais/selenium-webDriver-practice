package pages;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class HelperMethods {
    public static boolean isValidURL(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }
}
