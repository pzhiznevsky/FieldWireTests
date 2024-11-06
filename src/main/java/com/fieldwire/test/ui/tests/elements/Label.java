package com.fieldwire.test.ui.tests.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Label extends UIElement {

    public Label(WebDriver webDriver, WebElement webElement) {
        super(webDriver, webElement);
    }

    public Label(WebDriver webDriver, String locator, String description) {
        super(webDriver, locator, description);
    }

    public Label(WebDriver webDriver, String locator, String description, WebElement webElement) {
        super(webDriver, locator, description, webElement);
    }

    public String getText() {
        waitForElementPresent();
        return getWebElement().getText();
    }

}
