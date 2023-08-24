package com.example.helper.pages.login_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Selector {
    @SuppressWarnings("unused")
    private WebDriver driver;

    public Selector(WebDriver driver) {
        this.driver = driver;
    }

    public By loginPageLogo() {
        return By.xpath("//*[@id=\"root\"]/div/div[1]");
    }

    public By usernameField() {
        return By.id("user-name");
    }

    public By passwordField() {
        return By.id("password");
    }

    public By loginButton() {
        return By.id("login-button");
    }
}
