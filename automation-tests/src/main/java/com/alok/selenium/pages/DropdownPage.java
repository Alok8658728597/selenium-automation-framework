package com.alok.selenium.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
     * @throws InterruptedException 
     */
    public void multiDropdownSelection() throws InterruptedException {
        driver.get("https://www.testautomationcentral.com/demo/dropdown.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the Multi-Select button and click it using Actions
        WebElement multiPart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Multi-Select']")));
        Actions action = new Actions(driver);
        action.moveToElement(multiPart).click().perform();

        // Optional: Print button text for debugging
        System.out.println("Button Text: " + multiPart.getText());

        // Fallback: JavaScript click in case normal click fails
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", multiPart);

        // Wait for dropdown to appear
        Thread.sleep(5000); // Increase wait time for dynamic rendering

        // Check if dropdown is present
        List<WebElement> dropdowns = driver.findElements(By.xpath("//select[contains(@class,'form-multiselect')]"));
        System.out.println("Dropdowns found: " + dropdowns.size());

        if (!dropdowns.isEmpty()) {
            WebElement dropdown = dropdowns.get(0);
            Select select = new Select(dropdown);

            if (select.isMultiple()) {
                select.selectByVisibleText("Option 2");
                select.selectByVisibleText("Option 4");
                System.out.println("Options selected successfully.");
            } else {
                System.out.println("Dropdown does not support multiple selection.");
            }
        } else {
            System.out.println("Dropdown not found after clicking Multi-Select.");
        }
    }

}
