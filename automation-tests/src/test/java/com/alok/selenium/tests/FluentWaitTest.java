package com.alok.selenium.tests;

import java.time.Duration; 
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;

/*
 ✅ Fluent Wait – Simple Explanation

 🔹 What is Fluent Wait?
 Fluent Wait is a type of Explicit Wait in Selenium that allows:
 - Custom timeout duration
 - Custom polling interval
 - Ignoring specific exceptions

 🧠 Memory Hook:
 Fluent = Flexible Wait
 You control how long to wait, how often to check, and what exceptions to ignore.

 🔹 When to Use:
 - Waiting for elements that load dynamically
 - Handling flaky or slow-loading elements

 🎯 Interview Tip:
 "FluentWait gives you fine-grained control over wait behavior — you can define polling frequency and ignore exceptions like NoSuchElementException."

 🔹 Reminder:
 If the method name ends with 'Located' → it expects a By locator.
 If it doesn’t, it usually accepts a WebElement.

 🔹 Minimum Working Example:
*/

public class FluentWaitTest extends BaseTest {
    String url = "https://demo.automationtesting.in/Windows.html";
    By clickElement = By.xpath("//a[text()='WebTable']");

    @Test
    public void performClickAction() {
        driver.get(url);

        // Create a FluentWait instance with timeout, polling interval, and exception to ignore
        Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

        // Wait until the element located by the By locator is visible
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(clickElement));

        // Perform click action
        element.click();
    }
}