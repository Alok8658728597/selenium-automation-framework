package com.alok.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Page Object Model class for handling drag-and-drop functionality.
 * Demonstrates usage of Selenium's Actions class for advanced user interactions.
 */
public class DragAndDropPage {

    private WebDriver driver;

    // URL of the first demo page
    private final String url = "https://demo.automationtesting.in/Static.html";

    // Locators for source and destination elements on the first page
    private final By source = By.id("angular");
    private final By destination = By.xpath("//div[@id='droparea']");

    /**
     * Constructor to initialize WebDriver.
     * @param driver WebDriver instance passed from the test class.
     */
    public DragAndDropPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Opens the first drag-and-drop demo page.
     * @return DragAndDropPage instance for method chaining.
     */
    public DragAndDropPage openPage() {
        driver.get(url);
        return this;
    }

    /**
     * Performs drag-and-drop on the first demo page.
     * Uses Actions class to drag the 'angular' logo into the drop area.
     */
    public void perform_DragAndDrop() {
        openPage(); // Open the page before performing action
        // Interview Tip: Actions class is used for complex gestures like drag-and-drop, hover, double-click, etc.
        Actions action = new Actions(driver);

        // Perform drag-and-drop using WebElement references
        action.dragAndDrop(driver.findElement(source), driver.findElement(destination)).perform();
    }

    /**
     * Performs drag-and-drop on a second demo page and returns the success message.
     * This method demonstrates how to validate drag-and-drop success.
     * @return Success message displayed after drop.
     */
    public String drag_drop_andGetSuccessMessage() {
        // Navigate to second demo page
        driver.get("https://testautomationcentral.com/demo/drag_and_drop.html");

        // Locate source and destination elements
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement destination = driver.findElement(By.id("droppable"));

        // Interview Tip: Always validate drag-and-drop by checking the UI change or success message.
        Actions action = new Actions(driver);
        action.dragAndDrop(source, destination).perform();

        // Return the success message text after drop
        return driver.findElement(By.xpath("//p[text()='Dropped successfully!']")).getText();
    }
}
