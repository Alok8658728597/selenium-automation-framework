package com.alok.selenium.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.alok.selenium.base.BaseTest;

public class LoginTestUsingPropertiesFile extends BaseTest {

    @Test
    public void loginTest() throws FileNotFoundException, IOException {
        // ✅ Step 1: Create a Properties object
        Properties prop = new Properties();

        // ✅ Step 2: Load the config.properties file
        // NOTE: Make sure this path is correct and the file exists in your project
        prop.load(new FileInputStream("src/test/resources/config.properties"));

        // ✅ Step 3: Read values from the properties file
        String username = prop.getProperty("username"); // e.g., tomsmith
        String password = prop.getProperty("password"); // e.g., SuperSecretPassword!
        String url = prop.getProperty("url");           // e.g., https://the-internet.herokuapp.com/login

        // ✅ Step 4: Launch the browser and navigate to the login page
        driver.get(url);

        // ✅ Step 5: Perform login using credentials from the properties file
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);

        // NOTE: Using XPath here to locate the login button by its icon text
        // You can also use CSS selector: button[type='submit']
        driver.findElement(By.xpath("//i[contains(text(),' Login')]")).click();

        // ✅ Optional: Add assertions to verify login success
        // Example: Assert that the secure area is displayed
        // Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"));
    }
}
