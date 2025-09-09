package com.alok.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseHoverPage{
	protected WebDriver driver;
	private final String url="https://www.softwaretestingmaterial.com/selenium-tutorial/";
	private final By hoverElement=By.xpath("//span[text()='Tutorials']");
	private final By chooseContent=By.xpath("//li[@id='menu-item-17001']//a[text()='Agile']");
	
	public MouseHoverPage(WebDriver driver) {
		this.driver=driver;
	}
	public MouseHoverPage open() {
		driver.get(url);
		return this;
	}
	public String mouseHoverToElement() {
		open();
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(hoverElement)).perform();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(chooseContent));
		driver.findElement(chooseContent).click();
		return driver.getTitle();
	}
}