package com.alok.selenium.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.pages.LoginPageWithPageFactory;

public class LoginTestWithPageFactory extends BaseTest {

    @Test
    public void loginToTheApplicationAndVerifyWithMessage() {
        // Create an object of the PageFactory-based login page
        LoginPageWithPageFactory lf = new LoginPageWithPageFactory(driver);

        // Open the login page using the provided URL
        lf.open("https://the-internet.herokuapp.com/login");

        // Perform login using valid credentials
        lf.login("tomsmith", "SuperSecretPassword!");

        // Get the welcome message after login
        String actualText = lf.getMessage();

        // Verify that the welcome message contains the expected keyword
        Assert.assertTrue(actualText.contains("Secure"));
    }
}
