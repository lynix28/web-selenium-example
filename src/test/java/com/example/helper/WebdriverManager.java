package com.example.helper;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverManager {
    public static WebDriver driver;

    private static String findDriverPath(String baseName) {
        File driverDirectory = new File("./webdriver/");
        
        File[] matchingFiles = driverDirectory.listFiles(file -> file.getName().startsWith(baseName));
        
        if (matchingFiles != null && matchingFiles.length > 0) {
            return matchingFiles[0].getPath();
        }
        
        return null;
    }

    public static WebDriver setDriver(String browser) {
        String seleniumHost = System.getProperty("host");
        if ("edge".equalsIgnoreCase(browser)) {
            String driverBaseName = "msedgedriver";
            String driverPath = findDriverPath(driverBaseName);
            
            if (driverPath == null) {
                System.out.println("No local driver found!");
                System.out.println("Using WDM");
                WebDriverManager.edgedriver().setup();
            } else {
                System.out.println("Local driver found");
                System.setProperty("webdriver.edge.driver", driverPath);
            }
            EdgeOptions options = new EdgeOptions();

            if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                options.addArguments("--headless");

                if ("true".equalsIgnoreCase(System.getProperty("remote"))) {
                    try {
                        return driver = new RemoteWebDriver(new URL("http://" + seleniumHost + ":4444"), options);
                    } catch (MalformedURLException e) {
                        System.out.println("Invalid URL");
                    }
                }
                return driver = new EdgeDriver(options);
            } else {
                return driver = new EdgeDriver(options);
            }
        } else if ("chrome".equalsIgnoreCase(browser)) {
            String driverBaseName = "chromedriver";
            String driverPath = findDriverPath(driverBaseName);

            if (driverPath == null) {
                System.out.println("No local driver found!");
                System.out.println("Using WDM");
                WebDriverManager.chromedriver().setup();
            } else {
                System.out.println("Local driver found");
                System.setProperty("webdriver.chrome.driver", driverPath);
            }
            ChromeOptions options = new ChromeOptions();

            if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                options.addArguments("--headless");

                if ("true".equalsIgnoreCase(System.getProperty("remote"))) {
                    try {
                        return driver = new RemoteWebDriver(new URL("http://" + seleniumHost + ":4444"), options);
                    } catch (MalformedURLException e) {
                        System.out.println("Invalid URL");
                    }
                }
                return driver = new ChromeDriver(options);
            } else {
                return driver = new ChromeDriver(options);
            }
        } else if ("firefox".equalsIgnoreCase(browser)) {
            String driverBaseName = "geckodriver";
            String driverPath = findDriverPath(driverBaseName);

            if (driverPath == null) {
                System.out.println("No local driver found!");
                System.out.println("Using WDM");
                WebDriverManager.firefoxdriver().setup();
            } else {
                System.out.println("Local driver found");
                System.setProperty("webdriver.gekko.driver", driverPath);
            }
            FirefoxOptions options = new FirefoxOptions();

            if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                options.addArguments("-headless");

                if ("true".equalsIgnoreCase(System.getProperty("remote"))) {
                    try {
                        return driver = new RemoteWebDriver(new URL("http://" + seleniumHost + ":4444"), options);
                    } catch (MalformedURLException e) {
                        System.out.println("Invalid URL");
                    }
                }
                return driver = new FirefoxDriver(options);
            } else {
                return driver = new FirefoxDriver(options);
            }
        } else if ("safari".equalsIgnoreCase(browser)) {
            if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
                throw new IllegalArgumentException(browser + " cannot run in HEADLESS");
            } else {
                return driver = new SafariDriver();
            }
        } else {
            throw new IllegalArgumentException("Invalid browser name: " + browser);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
