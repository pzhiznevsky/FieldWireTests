package com.fieldwire.test.ui.tests;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class Wait {

    private final FluentWait<WebDriver> waiterWD;
    private static final int TIMEOUT = 30;
    private static final int POLLING = 5;

    public Wait(WebDriver webDriver) {
        this.waiterWD = new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(TIMEOUT))
                .pollingEvery(Duration.ofSeconds(POLLING))
                .ignoring(NoSuchElementException.class);
    }

    public <V> V until(Function<? super WebDriver, V> isTrue) {
        return waiterWD.until(isTrue);
    }

    public void waitForElementPresent(String locator) {
        waiterWD.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementClickable(String locator) {
        waiterWD.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void waitForCondition(WebElement webElement, Function<? super WebElement, Boolean> condition) {
        new FluentWait<>(webElement)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .until(condition);
    }

    public void waitForTextPresent(WebElement webElement) {
        new FluentWait<>(webElement)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .until(WebElement::getText);
    }

    public void waitForTextContainsAString(WebElement webElement, String value) {
        new FluentWait<>(webElement)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .until(element -> element.getText().contains(value));
    }
}
