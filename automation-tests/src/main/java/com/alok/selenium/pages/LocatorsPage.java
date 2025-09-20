package com.alok.selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocatorsPage{
	private final WebDriver driver;
	private final String url="https://www.bronid.com/article/create-test-account";
	
	public LocatorsPage(WebDriver driver){
		this.driver=driver;
	}
	public LocatorsPage open(){
		driver.get(url);
		return this;
	}
	public void clickOnLink(){
	driver.findElement(By.linkText("Contact us")).click();
	   
	}
	public void clickOnPartialLinkText(){
		driver.findElement(By.linkText("Contact us")).click();
		}
	public boolean isContactPageDisplayed() {
		System.out.println("Get the current URL:"+driver.getCurrentUrl());
		return driver.getCurrentUrl().contains("company");
	}
	public String clickByXpath() {
		driver.findElement(By.xpath("//div[text()='Developers']")).click();
		WebElement clickableElement=driver.findElement(By.linkText("API Sandbox"));
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(clickableElement));
		clickableElement.click();
		return clickableElement.getText();
		
	}
	
}