package com.example.helper.pages.login_page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriverWait wait;
    private Selector selector;

    public LoginPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.selector = new Selector(driver);
    }

    public void checkContent() {
        WebElement logoLogin = wait.until(ExpectedConditions.presenceOfElementLocated(selector.loginPageLogo()));
        logoLogin.isDisplayed();

        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(selector.usernameField()));
        usernameField.isDisplayed();

        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(selector.passwordField()));
        passwordField.isDisplayed();

        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(selector.loginButton()));
        loginButton.isDisplayed();
    }

    public void enterUsername(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.presenceOfElementLocated(selector.usernameField()));
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(selector.passwordField()));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(selector.loginButton()));
        loginButton.click();
    }
}
