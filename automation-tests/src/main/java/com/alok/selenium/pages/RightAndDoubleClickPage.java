package com.alok.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Model class for handling right-click and double-click actions.
 * Demonstrates usage of Selenium's Actions class for mouse interactions.
 */
public class RightAndDoubleClickPage {

    private WebDriver driver;

    // Locator for the right-click target element
    private final By rightClickButton = By.xpath("//p[contains(text(),'Right Click to see the menu')]");

    // Locator for the double-click target element
    private final By doubleClickButton = By.xpath("//button[normalize-space(text())='Double click me']");

    /**
     * Constructor to initialize WebDriver.
     * @param driver WebDriver instance passed from the test class.
     */
    public RightAndDoubleClickPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Performs a right-click on the target element and clicks a menu item.
     * @return The text of the clicked menu item.
     */
    public String performRightClick() {
        // Open the demo page for right-click
        driver.get("https://www.softwaretestingmentor.com/automation-practice-page-right-click-demo/");

        // Interview Tip: Use Actions class for contextClick (right-click)
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(rightClickButton)).perform();

        // Click on the "Rate Us" option from the context menu
        WebElement text = driver.findElement(By.linkText("Rate Us"));
        String linkText = text.getText();
        text.click();

        return linkText;
    }

    /**
     * Performs a double-click on the target button.
     * NOTE: This action may trigger an alert or change in UI depending on the page.
     */
    public void performDoubleClick() {
        // Open the demo page for double-click
        driver.get("https://qa-practice.netlify.app/double-click");

        // Interview Tip: Use doubleClick() for simulating rapid double-clicks
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(doubleClickButton)).perform();

        // NOTE: You can add alert handling or result verification here if needed
    }
}
