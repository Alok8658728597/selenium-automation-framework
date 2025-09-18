package com.alok.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Page Object Model class for handling zoom in, zoom out, and reset actions.
 * Demonstrates how to use JavaScriptExecutor to manipulate page zoom in Selenium.
 */
public class ZoomInAndOutPage {

    protected WebDriver driver;
    private String url;

    /**
     * Constructor to initialize WebDriver and target URL.
     * @param driver WebDriver instance passed from the test class.
     * @param url URL of the page to test zoom functionality.
     */
    public ZoomInAndOutPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    /**
     * Opens the target page.
     * @return ZoomInAndOutPage instance for method chaining.
     */
    public ZoomInAndOutPage open() {
        driver.get(url);
        return this;
    }

    /**
     * Sets the zoom level to 80% (Zoom Out).
     * Interview Tip: JavaScriptExecutor is used when native Selenium APIs can't handle certain browser-level actions.
     */
    public void setZoomOut() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='80%'");
    }

    /**
     * Sets the zoom level to 120% (Zoom In).
     * Interview Tip: This is useful for testing responsive layouts or accessibility features.
     */
    public void setZoomIn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='120%'");
    }

    /**
     * Resets the zoom level to 100% (default).
     * Interview Tip: Always reset zoom after testing to avoid affecting other tests.
     */
    public void resetToOriginal() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='100%'");
    }
}
