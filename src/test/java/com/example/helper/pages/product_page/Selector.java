package com.example.helper.pages.product_page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Selector {
    @SuppressWarnings("unused")
    private WebDriver driver;

    public Selector(WebDriver driver) {
        this.driver = driver;
    }

    public By productPageTitle() {
        return By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    }
}
