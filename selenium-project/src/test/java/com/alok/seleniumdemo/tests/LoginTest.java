package com.alok.seleniumdemo.tests;

import com.alok.seleniumdemo.base.BaseTest;
import com.alok.seleniumdemo.pages.LoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void validLogin_shouldNavigateToSecureArea_andShowSuccess() {
        LoginPage login = new LoginPage(driver).open();
        login.loginAs("tomsmith", "SuperSecretPassword!");

        assertThat(login.atSecureArea())
                .as("User should land on secure area after valid login")
                .isTrue();

        assertThat(login.getFlashMessage())
                .contains("You logged into a secure area!");
    }

    @Test
    public void invalidLogin_shouldShowError() {
        LoginPage login = new LoginPage(driver).open();
        login.loginAs("wronguser", "wrongpass");

        assertThat(login.atSecureArea())
                .as("User should NOT land on secure area for invalid login")
                .isFalse();

        assertThat(login.getFlashMessage())
                .contains("Your username is invalid"); // partial match is enough
    }
}
