package com.travel.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.travel.automation.utils.DriverFactory;
import com.travel.automation.utils.WaitUtils;
import com.travel.automation.base.BaseTest;


public class BasePage {

    protected WebDriver driver;

    public BasePage() {
    	this.driver =DriverFactory.getDriver();
    }

    protected void click(WebElement element) {
        WaitUtils.waitForClickability(driver, element).click();
    }

    protected void type(WebElement element, String text) {
        WaitUtils.waitForVisibility(driver, element).sendKeys(text);
    }

    protected String getText(WebElement element) {
        return WaitUtils.waitForVisibility(driver, element).getText();
    }
}