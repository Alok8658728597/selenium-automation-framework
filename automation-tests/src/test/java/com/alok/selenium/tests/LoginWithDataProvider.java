package com.alok.selenium.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;
import com.alok.selenium.dataprovider.TestData;

public class LoginWithDataProvider extends BaseTest{
	@Test(dataProvider="userData",dataProviderClass=TestData.class,enabled=false)
	public void loginWithMultipleUsers(String username,String password){
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
	}
	@Test(dataProvider="excelData",dataProviderClass=TestData.class)
	public void loginWithMultipleUsersUsingExcel(String username,String password){
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
		System.out.println("Running test with: " + username + " | " + password);
	}
     
}
/*In the test, you call the DataProvider by name: dataProvider = "userData"
In the data class, you define the name: @DataProvider(name = "userData")*/