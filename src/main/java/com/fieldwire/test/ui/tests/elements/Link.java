package com.fieldwire.test.ui.tests.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fieldwire.test.ui.tests.logging.Log;

public class Link extends UIElement {

    public Link(WebDriver webDriver, WebElement webElement) {
        super(webDriver, webElement);
    }

    public Link(WebDriver webDriver, String locator, String description) {
        super(webDriver, locator, description);
    }

    public Link(WebDriver webDriver, String locator, String description, WebElement webElement) {
        super(webDriver, locator, description, webElement);
    }

    public void click() {
        Log.info("Click on '" + description + "' link");
        waitForElementPresent();
        try {
            getWebElement().click();
        } catch (StaleElementReferenceException e) {
            click(By.xpath(locator));
        }
        Log.info("Link '" + description + "' was pressed.");
    }

    public String getText() {
        waitForElementPresent();
        return getWebElement().getText();
    }
}
