package com.alok.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropdownPage {
	private WebDriver driver;
	private String url = "https://practice.expandtesting.com/dropdown";
	private final By withvisibleText = By.xpath("//select[@id='dropdown']");
	private final By withValue = By.xpath("//select[@id='elementsPerPageSelect']");

	public DropdownPage(WebDriver driver) {
		this.driver = driver;
	}

	public DropdownPage open() {
		driver.get(url);
		return this;
	}

	public String selectOnText() {
		Select select = new Select(driver.findElement(withvisibleText));
		select.selectByVisibleText("Option 1");
		WebElement selectedOption = select.getFirstSelectedOption();
		return selectedOption.getText();

	}

	public String selectOnValue() {
		Select select = new Select(driver.findElement(withValue));
		select.selectByValue("10");
		WebElement selectedValue = select.getFirstSelectedOption();
		return selectedValue.getAttribute("value");
	}

	public void multiDropdownSelection() throws InterruptedException {
		driver.get("https://www.testautomationcentral.com/demo/dropdown.html");
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement multiPart = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Multi-Select']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", multiPart);

		WebElement dropdown = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//select[contains(@class,'form-multiselect')]")));
		Select select = new Select(dropdown);
		if (select.isMultiple()) {
			select.selectByVisibleText("Option 2");
			select.selectByVisibleText("Option 4");
		}
	}

}
/*How do you select an option from a dropdown using visible text in Selenium?
What is the difference between selectByVisibleText() and selectByValue()?
How do you verify which option is currently selected in a dropdown?
How can you check if a dropdown supports multiple selections?
How do you handle multi-select dropdowns in Selenium?*/
