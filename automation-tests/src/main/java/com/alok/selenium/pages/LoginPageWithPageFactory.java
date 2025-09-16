package com.alok.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory {
    protected WebDriver driver;

    // Interview Note: @FindBy is used to locate elements in PageFactory. It improves readability and avoids repeated driver.findElement calls.
    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//i[normalize-space(text())='Login']")
    WebElement loginBtn;

    // Interview Note: This element is used to verify successful login. Helps in writing assertions.
    @FindBy(xpath = "//h2[normalize-space(text())= 'Secure Area']")
    WebElement welcomeTxt;

    // Interview Note: PageFactory.initElements(driver, this) initializes all @FindBy elements. Must be called in constructor.
    public LoginPageWithPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Interview Note: Keep navigation logic separate from test logic. This method opens the login page.
    public void open(String url) {
        driver.get(url);
    }

    // Interview Note: Encapsulate actions like login in page classes. Avoid writing driver.findElement in test classes.
    public void login(String user, String pwd) {
        username.sendKeys(user);
        password.sendKeys(pwd);
        loginBtn.click();
    }

    // Interview Note: Useful for assertions in test class. Helps verify login success.
    public String getMessage() {
        return welcomeTxt.getText();
    }
}
