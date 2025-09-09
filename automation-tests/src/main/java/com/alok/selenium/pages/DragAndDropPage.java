package com.alok.selenium.pages;

import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropPage {
	private WebDriver driver;
	private final String url = "https://demo.automationtesting.in/Static.html";
	private final By source = By.id("angular");
	private final By destination = By.xpath("//div[@id='droparea']");

	public DragAndDropPage(WebDriver driver) {
		this.driver = driver;
	}

	public DragAndDropPage openPage() {
		driver.get(url);
		return this;
	}

	public void perform_DragAndDrop() {
		openPage();
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(source), driver.findElement(destination)).perform();
	}

}