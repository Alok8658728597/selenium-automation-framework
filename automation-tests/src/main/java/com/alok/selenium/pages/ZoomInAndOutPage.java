package com.alok.selenium.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ZoomInAndOutPage {
	protected WebDriver driver;
	private String url;

	public ZoomInAndOutPage(WebDriver driver, String url) {
		this.driver = driver;
		this.url = url;
	}

	public ZoomInAndOutPage open() {
		driver.get(url);
		return this;
	}

	public void setZoomOut() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");

	}

	public void setZoomIn() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='120%'");

	}

	public void resetToOriginal() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='100%'");
	}

}