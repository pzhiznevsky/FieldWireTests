package com.fieldwire.test.ui.tests.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fieldwire.test.ui.tests.logging.Log;

public class Checkbox extends UIElement {

    public Checkbox(WebDriver webDriver, WebElement webElement) {
        super(webDriver, webElement);
    }

    public Checkbox(WebDriver webDriver, String locator, String description) {
        super(webDriver, locator, description);
    }

    public Checkbox(WebDriver webDriver, String locator, String description, WebElement webElement) {
        super(webDriver, locator, description, webElement);
    }

    public boolean isSelected() {
        try {
            return getWebElement().isSelected();
        } catch (StaleElementReferenceException e) {
            return isSelected(By.xpath(locator));
        }
    }

    public void waitForSelected() {
        try {
            wait.waitForCondition(webElement, WebElement::isSelected);
        } catch (StaleElementReferenceException e) {
            waitForCondition(By.xpath(getLocator()));
        }
    }

    public void waitForCondition(By by) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                WebElement element = getWebDriver().findElement(by);
                wait.waitForCondition(element, WebElement::isSelected);
            } catch (StaleElementReferenceException e) {
                //DO NOTHING
            }
            attempts++;
        }
    }

    public void select() {
        select(true);
    }

    public void select(Boolean select) {
        if (select == null || select == isSelected())
            return;
        waitForElementPresent();
        try {
            getWebElement().click();
        } catch (StaleElementReferenceException e) {
            click(By.xpath(locator));
        }
        Log.info("'" + description + "' was set to: '" + select + "'");
        waitForSelected();
    }
}
