package com.alok.selenium.base;
/*When you click a download link in Selenium, the browser usually 
 * opens a "Save As" dialog — which Selenium 
 * cannot interact with because it's an OS-level popup by using this bypass the popup and automatically 
 * download the file to a specific folder without any manual action.*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod; 

import java.time.Duration;
import java.util.Map;
import java.util.HashMap;


public class DownloadLogic {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	Map<String,Object> pref=new HashMap<>();
    	pref.put("download.default_directory", "C:\\Users\\ALSWAIN\\Downloads");
    	pref.put("download.prompt_for_download", false);
    	pref.put("profile.default_content_settings.popups", 0);
    	
    	
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", pref);
        options.addArguments("--start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        

        driver = new ChromeDriver(options); // Selenium Manager resolves driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
