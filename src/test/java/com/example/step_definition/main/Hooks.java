package com.example.step_definition.main;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.example.helper.Variable;
import com.example.helper.WebdriverManager;

public class Hooks {
    private WebDriver driver;
     
    @Before
    public void setup() {
        String browser = Variable.BROWSER;
        driver = WebdriverManager.getDriver(browser);
        driver.manage().window().maximize();
    }
     
    @After
    public void teardown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll(" ", "_");
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebdriverManager.quitDriver();
    }
}
