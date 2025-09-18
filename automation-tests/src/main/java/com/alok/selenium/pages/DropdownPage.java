package com.alok.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Page Object Model class for handling dropdown interactions.
 * Demonstrates single-select and multi-select dropdown handling using Selenium.
 */
public class DropdownPage {

    private WebDriver driver;

    // URL of the single-select dropdown demo page
    private final String url = "https://practice.expandtesting.com/dropdown";

    // Locators for dropdowns
    private final By withVisibleText = By.xpath("//select[@id='dropdown']");
    private final By withValue = By.xpath("//select[@id='elementsPerPageSelect']");

    /**
     * Constructor to initialize WebDriver.
     * @param driver WebDriver instance passed from the test class.
     */
    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Opens the dropdown demo page.
     * @return DropdownPage instance for method chaining.
     */
    public DropdownPage open() {
        driver.get(url);
        return this;
    }

    /**
     * Selects an option from dropdown using visible text.
     * @return The text of the selected option.
     */
    public String selectOnText() {
        Select select = new Select(driver.findElement(withVisibleText));
        select.selectByVisibleText("Option 1");

        WebElement selectedOption = select.getFirstSelectedOption();

        // Interview Tip: Use getFirstSelectedOption() to verify selected value
        System.out.println("Is selected: " + selectedOption.isSelected());

        return selectedOption.getText();
    }

    /**
     * Selects an option from dropdown using value attribute.
     * @return The value attribute of the selected option.
     */
    public String selectOnValue() {
        Select select = new Select(driver.findElement(withValue));
        select.selectByValue("10");

        WebElement selectedValue = select.getFirstSelectedOption();

        // Interview Tip: selectByValue() is useful when working with backend-driven dropdowns
        return selectedValue.getAttribute("value");
    }

    /**
     * Handles multi-select dropdown and selects multiple options.
     * Uses JavaScript click for dynamic button and waits for dropdown visibility.
     */
    public void multiDropdownSelection() {
        driver.get("https://www.testautomationcentral.com/demo/dropdown.html");

        // Wait for the multi-select button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement multiPart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Multi-Select']")));

        // Interview Tip: Use JavaScriptExecutor when normal click fails due to overlays or dynamic elements
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", multiPart);

        // Wait for the dropdown to be visible
        WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[contains(@class,'form-multiselect')]")));

        Select select = new Select(dropdown);

        // Interview Tip: Always check if dropdown supports multiple selections using isMultiple()
        if (select.isMultiple()) {
            select.selectByVisibleText("Option 2");
            select.selectByVisibleText("Option 4");
        }
    }
}
