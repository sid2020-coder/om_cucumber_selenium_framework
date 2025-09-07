package utils;

import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
//import org.openqa.selenium.Cookie;   // alias in explanation, but in Java just use org.openqa.selenium.Cookie

import java.util.HashSet;
import java.util.Set;

public class CookieUtils {

    // Convert Rest-Assured Cookies -> Selenium Cookies
    public static Set<org.openqa.selenium.Cookie> convertToSeleniumCookies(Cookies restAssuredCookies) {
        Set<org.openqa.selenium.Cookie> seleniumCookies = new HashSet<>();

        for (Cookie restCookie : restAssuredCookies.asList()) {
            org.openqa.selenium.Cookie seleniumCookie = new org.openqa.selenium.Cookie.Builder(restCookie.getName(), restCookie.getValue())
                    .domain(restCookie.getDomain())       // optional, may be null
                    .path(restCookie.getPath())           // optional, may be null
                    .isSecure(restCookie.isSecured())
                    .expiresOn(restCookie.getExpiryDate()) // optional, may be null
                    .build();

            seleniumCookies.add(seleniumCookie);
        }
        return seleniumCookies;
    }
}
