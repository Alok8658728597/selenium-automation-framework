package com.alok.seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final String url = "https://the-internet.herokuapp.com/login";

    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginBtn = By.cssSelector("button[type='submit']");
    private final By flash = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage open() {
        driver.get(url);
        return this;
    }

    public LoginPage enterUsername(String user) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
        return this;
    }

    public void submit() {
        driver.findElement(loginBtn).click();
    }

    public String getFlashMessage() {
        return driver.findElement(flash).getText().trim();
    }

    public boolean atSecureArea() {
        return driver.getCurrentUrl().contains("/secure");
    }

    public void loginAs(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        submit();
    }
}
