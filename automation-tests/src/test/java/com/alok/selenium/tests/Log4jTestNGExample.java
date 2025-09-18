package com.alok.selenium.tests;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class Log4jTestNGExample {

    Logger log = Logger.getLogger(Log4jTestNGExample.class);

    @Test
    public void sampleTest() {
        log.debug("Debug message - test started");
        log.info("Info message - performing test steps");
        log.warn("Warning message - something might be wrong");
        log.error("Error message - test failed");
        log.fatal("Fatal message - critical issue");
    }
}
