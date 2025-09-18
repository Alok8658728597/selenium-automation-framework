package com.alok.selenium.pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model class for handling multiple browser windows.
 * Demonstrates how to switch between parent and child windows and perform actions.
 */
public class MultipleWindows {

    private WebDriver driver;

    // URL of the demo page for window handling
    private final String url = "https://www.hyrtutorials.com/p/window-handles-practice.html";

    // Locator for the button that opens a new window
    private final By clickLink = By.id("newWindowBtn");

    /**
     * Constructor to initialize WebDriver.
     * @param driver WebDriver instance passed from the test class.
     */
    public MultipleWindows(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Opens the demo page for window handling.
     * @return MultipleWindows instance for method chaining.
     */
    public MultipleWindows open() {
        driver.get(url);
        return this;
    }

    /**
     * Opens a new window, switches to it, performs an action, and returns to the parent window.
     * @return Title of the parent window after switching back.
     */
    public String switchWindow() throws InterruptedException {
        // ✅ Step 1: Store parent window handle
        String parentWindow = driver.getWindowHandle();

        // ✅ Step 2: Click to open new window
        driver.findElement(clickLink).click();

        // ✅ Step 3: Get all window handles
        Set<String> allWindows = driver.getWindowHandles();

        // ✅ Step 4: Switch to child window and perform action
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                Thread.sleep(1500); // NOTE: Replace with WebDriverWait in real projects
                driver.switchTo().window(window);
                System.out.println("Child window title: " + driver.getTitle());

                // Example action in child window
                driver.findElement(By.linkText("Tech News")).click();
                break;
            }
        }

        // ✅ Step 5: Switch back to parent window
        driver.switchTo().window(parentWindow);
        return driver.getTitle();
    }

    /**
     * Opens multiple windows and switches to a specific one (e.g., 3rd window).
     * Performs an action and returns to the parent window.
     */
    public void selectSpecificWindow() {
        String parentWindow = driver.getWindowHandle();

        // ✅ Open multiple windows by clicking the button repeatedly
        for (int i = 0; i <= 4; i++) {
            driver.findElement(clickLink).click();
        }

        // ✅ Get all window handles
        Set<String> getAllWindow = driver.getWindowHandles();

        int count = 0;
        for (String window : getAllWindow) {
            count++;
            if (count == 3) { // Switch to the 3rd window
                driver.switchTo().window(window);
                System.out.println("Switched to 3rd window: " + driver.getTitle());

                // Example action in the 3rd window
                driver.findElement(By.linkText("Tech News")).click();
                break;
            }
        }

        // ✅ Switch back to parent window
        driver.switchTo().window(parentWindow);
        System.out.println("Returned to parent window: " + driver.getTitle());
    }
}
