package com.travel.automation.utils;

	import java.time.Duration;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class WaitUtils {

	    private static final int TIMEOUT = 10;

	    public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    }

	    public static WebElement waitForPresence(WebDriver driver, By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
	        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	    }

	    public static WebElement waitForClickability(WebDriver driver, WebElement element) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
	        return wait.until(ExpectedConditions.elementToBeClickable(element));
	    }

	    public static boolean waitForInvisibility(WebDriver driver, By locator) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
	        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	    }
	}



