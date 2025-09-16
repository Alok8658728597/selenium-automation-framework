package com.alok.selenium.pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class CookiesPage {
    protected WebDriver driver;

    // Locators for login elements
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By clickLogin = By.xpath("//i[normalize-space(text())='Login']");

    private String url;

    // Constructor to initialize WebDriver and URL
    public CookiesPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    // Opens the login page
    public CookiesPage open() {
        driver.get(url);
        return this;
    }

    // Logs in using provided username and password
    public void login(String user, String pwd) {
        open(); // Open the login page
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(clickLogin).click();
    }

    // Fetches and prints all cookies from the browser
    public void getAllCookies() {
        Set<Cookie> allCookies = driver.manage().getCookies();
        for (Cookie cookie : allCookies) {
            System.out.println("Cookie Name: " + cookie.getName());
            System.out.println("Cookie Value: " + cookie.getValue());
            System.out.println("Cookie Domain: " + cookie.getDomain());
        }
    }

    // Fetches a specific cookie by name and prints its value
    public Cookie getSpecficCookieByName(String cookieName) {
        Cookie cookieValue = driver.manage().getCookieNamed(cookieName);
        System.out.println("Cookie Value: " + cookieValue);
        return cookieValue;
    }

    // Adds a previously fetched cookie to the browser session
    public void loginWithCookieValue(Cookie sessionCookie) {
        driver.manage().addCookie(sessionCookie);
        // Note: You should call open() after this in your test to trigger login via cookie
    }
}
