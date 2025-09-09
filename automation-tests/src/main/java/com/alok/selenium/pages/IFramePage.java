package com.alok.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*driver.switchTo().frame(WebElement)
Switches the WebDriver context to a specific frame.
Interview Tip: Explain the three ways to switch to a frame: by index, name/id, or WebElement.
* driver.switchTo().defaultContent()
Switches back to the main document from a frame.
Interview Tip: Mention this is necessary after interacting with elements inside a frame.*/

public class IFramePage{
	protected WebDriver driver;
	private final String url="https://demo.automationtesting.in/Frames.html";
	
	public IFramePage(WebDriver driver) {
		this.driver=driver;
	}
	public IFramePage open() {
		driver.get(url);
		return this;
	}
	public void switchFrameAndPerformAction() throws InterruptedException {
		
		WebElement frameElement =driver.findElement(By.id("singleframe"));
		driver.switchTo().frame(frameElement);
		WebElement texFilled = driver.findElement(By.xpath("//div[contains(@class, 'col-xs-6')]//input[@type='text']"));
		texFilled.sendKeys("Alok");
		Thread.sleep(1500);
		driver.switchTo().defaultContent();
		
	}
}