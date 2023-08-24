package com.example.runner.regression_test;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
@CucumberOptions(
    features = { 
        "./src/test/resources/feature/login.feature" 
    },
    glue = {
        "com.example.step_definition.main",
        "com.example.step_definition.login"
    },
    tags = "@RegressionTest",
    plugin = { "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" }
)
public class RunnerRegressionTest extends AbstractTestNGCucumberTests {   
}