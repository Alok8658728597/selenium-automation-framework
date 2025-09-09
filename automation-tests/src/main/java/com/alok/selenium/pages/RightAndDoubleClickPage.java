package com.alok.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RightAndDoubleClickPage{
	private WebDriver driver;
	private final By rightClickButton=By.xpath("//p[contains(text(),\"Right Click to see the menu\")]");
	private final By doubleClickButton=By.xpath("//button[normalize-space(text())=\"Double click me\"]");
	
	public RightAndDoubleClickPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String performRightClick() {
		driver.get("https://www.softwaretestingmentor.com/automation-practice-page-right-click-demo/");
		Actions action =new Actions(driver);
		action.contextClick(driver.findElement(rightClickButton)).perform();
		WebElement text=driver.findElement(By.linkText("Rate Us"));
		String linkText=text.getText();
		text.click();
		return linkText;
			
	}
	public void performDoubleClick() {
		driver.get("https://qa-practice.netlify.app/double-click");
		Actions action=new Actions(driver);
		action.doubleClick(driver.findElement(doubleClickButton)).perform();
		
		
	}
}