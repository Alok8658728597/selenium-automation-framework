package com.alok.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class for handling mouse hover interactions.
 * Demonstrates how to use Actions class to hover over elements and click sub-menu items.
 */
public class MouseHoverPage {

    protected WebDriver driver;

    // URL of the demo page
    private final String url = "https://www.softwaretestingmaterial.com/selenium-tutorial/";

    // Locator for the element to hover over
    private final By hoverElement = By.xpath("//span[text()='Tutorials']");

    // Locator for the sub-menu item to click after hover
    private final By chooseContent = By.xpath("//li[@id='menu-item-17001']//a[text()='Agile']");

    /**
     * Constructor to initialize WebDriver.
     * @param driver WebDriver instance passed from the test class.
     */
    public MouseHoverPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Opens the mouse hover demo page.
     * @return MouseHoverPage instance for method chaining.
     */
    public MouseHoverPage open() {
        driver.get(url);
        return this;
    }

    /**
     * Performs mouse hover over the target element and clicks the sub-menu item.
     * @return The title of the page after clicking the sub-menu.
     */
    public String mouseHoverToElement() {
        open(); // Open the page before performing hover
        // Interview Tip: Actions class is used for advanced user interactions like hover, drag-and-drop, etc.
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(hoverElement)).perform();

        // Interview Tip: Always use WebDriverWait for dynamic elements that appear after hover
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(chooseContent));

        // Click the sub-menu item after hover
        driver.findElement(chooseContent).click();

        // Return the page title to confirm navigation
        return driver.getTitle();
    }
}
