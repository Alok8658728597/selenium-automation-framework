package com.alok.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
	
}