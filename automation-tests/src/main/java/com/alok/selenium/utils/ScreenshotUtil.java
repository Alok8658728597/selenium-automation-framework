package com.alok.selenium.utils;

// Importing necessary Java and Selenium classes
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {

    /**
     * Captures a screenshot of the current browser window.
     * @param driver   The WebDriver instance controlling the browser.
     * @param testName A custom name to identify the screenshot (usually the test method name).
     */
    public  static String captureScreenshot(WebDriver driver, String testName) {
        
        // Generate a timestamp to make the screenshot filename unique
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        
        // Construct the full file path for the screenshot
        String filePath = "screenshots/" + testName + "_" + timestamp + ".png";
        
        // Capture the screenshot and store it as a temporary file
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        // Create a destination file object with the desired path
        File destFile = new File(filePath);

        try {
            // Ensure the 'screenshots' directory exists; create if it doesn't
            FileHandler.createDir(new File("screenshots"));
            
            // Copy the screenshot from source to destination
            FileHandler.copy(srcFile, destFile);
            
            // Log the success message with the screenshot path
            System.out.println("Screenshot saved at: " + filePath);
        } catch (IOException e) {
            // Handle any file-related exceptions and log the error
            System.err.println("Screenshot saving failed: " + e.getMessage());
        }
        return filePath;//Retun becasue its needed in extent report 
    }
    
}
