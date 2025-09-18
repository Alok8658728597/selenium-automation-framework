package com.alok.selenium.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Page Object Model class for handling multiple browser tabs/windows.
 * Demonstrates how to switch between tabs and validate content in Selenium.
 */
public class MultipleTab {

    protected WebDriver driver;

    // URL of the demo page for window/tab handling
    private final String url = "https://www.hyrtutorials.com/p/window-handles-practice.html";

    // Locator for the button that opens a new tab
    private final By newTabLink = By.id("newTabBtn");

    /**
     * Constructor to initialize WebDriver.
     * @param driver WebDriver instance passed from the test class.
     */
    public MultipleTab(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Opens the demo page for tab handling.
     * @return MultipleTab instance for method chaining.
     */
    public MultipleTab open() {
        driver.get(url);
        return this;
    }

    /**
     * Clicks the button to open a new tab, switches to it, prints its title,
     * and then switches back to the original tab.
     */
    public void chooseNewTab() {
        // Store the handle of the parent tab
        String parentTab = driver.getWindowHandle();

        // Click the button to open a new tab
        driver.findElement(newTabLink).click();

        // Interview Tip: Use WebDriverWait to wait until a new tab is opened
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> driver.getWindowHandles().size() > 1);

        // Get all window handles
        Set<String> allTabs = driver.getWindowHandles();

        // Switch to the newly opened tab
        for (String tab : allTabs) {
            if (!tab.equals(parentTab)) {
                driver.switchTo().window(tab);

                // Print the title of the new tab
                System.out.println("Title of new tab: " + driver.getTitle());
            }
        }

        // Switch back to the parent tab
        driver.switchTo().window(parentTab);
    }
}
