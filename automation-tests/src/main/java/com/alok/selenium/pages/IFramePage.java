package com.alok.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
/*driver.switchTo().frame(WebElement)
Switches the WebDriver context to a specific frame.
Interview Tip: Explain the three ways to switch to a frame: by index, name/id, or WebElement.
* driver.switchTo().defaultContent()
Switches back to the main document from a frame.
Interview Tip: Mention this is necessary after interacting with elements inside a frame.*/
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFramePage {
	protected WebDriver driver;
	private final String url;

	public IFramePage(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
	}

	public IFramePage open() {
		driver.get(url);
		return this;
	}

	public void switchFrameAndPerformAction() throws InterruptedException {

		WebElement frameElement = driver.findElement(By.id("singleframe"));
		driver.switchTo().frame(frameElement);
		WebElement texFilled = driver.findElement(By.xpath("//div[contains(@class, 'col-xs-6')]//input[@type='text']"));
		texFilled.sendKeys("Alok");
		Thread.sleep(1500);
		driver.switchTo().defaultContent();

	}

	public void switchToNestedFrame() {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,150)");
		WebElement parentFrame = driver.findElement(By.id("parent_iframe"));
		// WebElement nestedFrame=driver.findElement(By.id("iframe1"));
		driver.switchTo().frame(parentFrame);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframe1")));
		// driver.switchTo().frame(nestedFrame);
		driver.findElement(By.xpath("//button[@id='u_5_6']")).click();
		driver.switchTo().defaultContent();
	}

}