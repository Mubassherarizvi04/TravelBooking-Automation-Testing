package com.travel.automation.base;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.travel.automation.utils.DriverFactory;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {

        // You can later read this from config file
        String browser = "chrome";

        driver = DriverFactory.initDriver(browser);
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}