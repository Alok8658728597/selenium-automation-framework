package com.alok.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolTipPage {
    private WebDriver driver;
    private String url;

    // Constructor to initialize WebDriver and URL
    public ToolTipPage(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;
    }

    // Opens the tooltip demo page
    public ToolTipPage open() {
        driver.get(url);
        return this;
    }

    /**
     * ✅ Tooltip using the 'title' attribute
     * This method works when the tooltip is defined directly in the HTML using the 'title' attribute.
     * No hover action is needed — just fetch the 'title' attribute value.
     */
    public void getToolTipUsingTitleAttribute() {
        open();
        WebElement element = driver.findElement(By.xpath("//a[text()='Buy us a coffee']"));

        // Get tooltip text from the 'title' attribute
        String tooltipText = element.getAttribute("title");
        System.out.println("Tooltip: " + tooltipText);
    }

    /**
     * ✅ Tooltip using hover (Actions class)
     * This method works when the tooltip is dynamically injected into the DOM after hovering.
     * Bootstrap tooltips behave this way.
     */
    public void getToolTipUsingActionClass() {
        open();

        // Locate the button that triggers the tooltip
        WebElement element = driver.findElement(By.xpath("//button[@id='btn1']"));

        // Hover over the element to trigger the tooltip
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();

        // Wait for the tooltip to appear in the DOM
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        /**
         * ✅ Why By.className("tooltip") works:
         * After hovering, Bootstrap dynamically injects a <div class="tooltip"> element into the DOM.
         * So By.className("tooltip") will work ONLY after the tooltip is visible.
         * However, to get the actual tooltip text, it's better to use:
         * By.cssSelector(".tooltip .tooltip-inner")
         * This targets the inner text container of the tooltip.
         */
        WebElement tooltip = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".tooltip .tooltip-inner")
        ));

        // Extract and print the tooltip text
        String tooltipText = tooltip.getText();
        System.out.println("Tooltip: " + tooltipText);
    }
}
