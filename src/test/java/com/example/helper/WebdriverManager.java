package com.example.helper;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverManager {
    private static WebDriver driver;

    private static String findDriverPath(String baseName) {
        File driverDirectory = new File("./src/test/resources/webdriver/");
        
        File[] matchingFiles = driverDirectory.listFiles(file -> file.getName().startsWith(baseName));
        
        if (matchingFiles != null && matchingFiles.length > 0) {
            return matchingFiles[0].getPath();
        }
        
        return null;
    }

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            if ("edge".equalsIgnoreCase(browser)) {
                String driverBaseName = "msedgedriver";
                String driverPath = findDriverPath(driverBaseName);
                System.setProperty("webdriver.edge.driver", driverPath);
                driver = new EdgeDriver();
            } else if ("chrome".equalsIgnoreCase(browser)) {
                System.setProperty("webdriver.chrome.driver", "");
                driver = new ChromeDriver();
            } else if ("firefox".equalsIgnoreCase(browser)) {
                System.setProperty("webdriver.gekko.driver", "");
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Invalid browser name: " + browser);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
