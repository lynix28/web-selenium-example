package com.example.helper;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

public class WebdriverManager {
    private static WebDriver driver;

    private static String findDriverPath(String baseName) {
        File driverDirectory = new File("./webdriver/");
        
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
                EdgeOptions options = new EdgeOptions();

                if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                    options.addArguments("--headless");
                    driver = new EdgeDriver(options);
                } else {
                    driver = new EdgeDriver(options);
                }
            } else if ("chrome".equalsIgnoreCase(browser)) {
                String driverBaseName = "chromedriver";
                String driverPath = findDriverPath(driverBaseName);
                System.setProperty("webdriver.chrome.driver", driverPath);
                ChromeOptions options = new ChromeOptions();

                if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                    options.addArguments("--headless");
                    driver = new ChromeDriver(options);
                } else {
                    driver = new ChromeDriver(options);
                }
            } else if ("firefox".equalsIgnoreCase(browser)) {
                String driverBaseName = "geckodriver";
                String driverPath = findDriverPath(driverBaseName);
                System.setProperty("webdriver.gekko.driver", driverPath);
                FirefoxOptions options = new FirefoxOptions();

                if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                    options.addArguments("-headless");
                    driver = new FirefoxDriver(options);
                } else {
                    driver = new FirefoxDriver(options);
                }
            } else if ("safari".equalsIgnoreCase(browser)) {
                if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                    throw new IllegalArgumentException(browser + " cannot run in HEADLESS");
                } else {
                    driver = new SafariDriver();
                }
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
