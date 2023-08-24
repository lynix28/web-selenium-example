package com.example.helper.pages.product_page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriverWait wait;
    private Selector selector;

    public ProductPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.selector = new Selector(driver);
    }

    public Boolean checkTitleIsDisplayed() {
        WebElement productPageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(selector.productPageTitle()));
        Boolean isDisplayed = productPageTitle.isDisplayed();

        return isDisplayed;
    }
    
    public String checkTextTitle() {
        WebElement productPageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(selector.productPageTitle()));
        String textTitle = productPageTitle.getText();

        return textTitle;
    }
}
