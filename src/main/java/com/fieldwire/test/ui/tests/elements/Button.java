package com.fieldwire.test.ui.tests.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fieldwire.test.ui.tests.logging.Log;

public class Button extends UIElement {

    public Button(WebDriver webDriver, WebElement webElement) {
        super(webDriver, webElement);
    }

    public Button(WebDriver webDriver, String locator, String description) {
        super(webDriver, locator, description);
    }

    public Button(WebDriver webDriver, String locator, String description, WebElement webElement) {
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

        Log.info("Button '" + description + "' was pressed.");
    }

    public String getText() {
        waitForElementPresent();
        return getWebElement().getText();
    }

    public boolean isButtonDisabled() {
        return webElement.getAttribute("class").contains("fw-button-disabled");
    }

    public void validateButtonEnabled() {
        if (isButtonDisabled()) {
            throw new AssertionError("Button is disabled " + description);
        }
    }
}
