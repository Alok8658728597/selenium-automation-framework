package com.alok.selenium.pages;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertPage  {
	private final WebDriver driver;
	private final String url = "https://the-internet.herokuapp.com/javascript_alerts";

	public AlertPage(WebDriver driver) {
		this.driver = driver;
	}
	public AlertPage open() {
        driver.get(url);
        return this;
    }

	public void triggerAlert() {
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	public void dismisAlert() {
		driver.switchTo().alert().dismiss();
	}
	public void triggerAlert_filldetials_clickOk() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click for JS Prompt']"))).click();
		//driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		driver.switchTo().alert().sendKeys("alok");
		
	}

}