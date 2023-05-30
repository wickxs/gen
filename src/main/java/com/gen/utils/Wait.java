package com.gen.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Wait {

    private final WebDriver driver;
    private static final Logger LOG = LoggerFactory.getLogger(Wait.class);

    public Wait(WebDriver driver) {
        this.driver = driver;
    }

    private void waitUntilCondition(ExpectedCondition<?> condition, String timeoutMessage, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout.getSeconds());
        wait.withMessage(timeoutMessage);
        wait.until(condition);
    }

    public void forLoading(String path) {
        ExpectedCondition<Boolean> condition = ExpectedConditions.urlMatches(path);
        Duration timeout = Duration.of(60, ChronoUnit.SECONDS);
        String timeoutMessage = "Page didn't load after " + timeout + "seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
    }

    public void waitUntilVisible(WebElement webElement) {
        ExpectedCondition<WebElement> condition = ExpectedConditions.visibilityOf(webElement);
        Duration timeout = Duration.of(60, ChronoUnit.SECONDS);
        String timeoutMessage = webElement + " wasn't displayed after " + timeout + "seconds.";
        waitUntilCondition(condition, timeoutMessage, timeout);
        LOG.info(webElement + " is visible.");
    }
}
