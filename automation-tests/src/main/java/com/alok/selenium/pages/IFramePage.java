package com.alok.selenium.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
🧠 Interview Tip:
- Use `driver.switchTo().frame()` to switch into an iframe.
- You can switch by index, name/id, or WebElement.
- Always switch back using `driver.switchTo().defaultContent()` after interacting inside a frame.
*/

public class IFramePage {
    protected WebDriver driver;
    private final String url;

    // Constructor to initialize WebDriver and target URL
    public IFramePage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    // Opens the target page
    public IFramePage open() {
        driver.get(url);
        return this;
    }

    // 🔹 Handles a single iframe and performs an action inside it
    public void switchFrameAndPerformAction() throws InterruptedException {
        // Locate the single iframe by ID
        WebElement frameElement = driver.findElement(By.id("singleframe"));

        // Switch to the iframe using WebElement
        driver.switchTo().frame(frameElement);

        // Locate input field inside the iframe and enter text
        WebElement textField = driver.findElement(By.xpath("//div[contains(@class, 'col-xs-6')]//input[@type='text']"));
        textField.sendKeys("Alok");

        // Wait for demo visibility (can be replaced with explicit wait)
        Thread.sleep(1500);

        // Switch back to the main document
        driver.switchTo().defaultContent();
    }

    // 🔹 Handles nested iframes (iframe inside another iframe)
    public void switchToNestedFrame() {
        // Scroll down to bring iframe into view (optional but useful)
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,150)");

        // Locate the parent iframe
        WebElement parentFrame = driver.findElement(By.id("parent_iframe"));

        // Switch to parent iframe
        driver.switchTo().frame(parentFrame);

        // Wait until the nested iframe is available and switch to it
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframe1")));

        // Perform action inside the nested iframe
        driver.findElement(By.xpath("//button[@id='u_5_6']")).click();

        // ✅ Important: Always switch back to default content after iframe work
        driver.switchTo().defaultContent();
    }
}
