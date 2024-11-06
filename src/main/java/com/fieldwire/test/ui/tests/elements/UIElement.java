package com.fieldwire.test.ui.tests.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fieldwire.test.ui.tests.Wait;
import com.fieldwire.test.ui.tests.util.Utils;

import lombok.Getter;

@Getter
public abstract class UIElement {

    protected String locator;
    protected String description;
    protected WebElement webElement;
    private WebDriver webDriver;
    protected Wait wait;

    public UIElement() {
    }

    protected UIElement(WebDriver webDriver, WebElement webElement) {
        this(webDriver, Utils.generateXPATH(webElement, ""), "", webElement);
    }

    protected UIElement(WebDriver webDriver, String locator, String description) {
        this(webDriver, locator, description, webDriver.findElement(By.xpath(locator)));
    }

    protected UIElement(WebDriver webDriver, String locator, String description, WebElement webElement) {
        this.webDriver = webDriver;
        this.locator = locator;
        this.description = description;
        this.webElement = webElement;
        this.wait = new Wait(webDriver);
    }

    public void waitForElementPresent() {
        wait.waitForElementPresent(this.getLocator());
    }

    public void waitForElementClickable() {
        wait.waitForElementClickable(this.getLocator());
    }

    public void click(By by) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                WebElement element = getWebDriver().findElement(by);
                element.click();
                break;
            } catch (StaleElementReferenceException e) {
                //DO NOTHING
            }
            attempts++;
        }
    }

    public boolean isSelected(By by) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                return getWebDriver().findElement(by).isSelected();
            } catch (StaleElementReferenceException e) {
                //DO NOTHING
            }
            attempts++;
        }
        return false;
    }

    public boolean isInputInvalid(By by) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                return getWebDriver().findElement(by).getAttribute("class").contains("invalid");
            } catch (StaleElementReferenceException e) {
                //DO NOTHING
            }
            attempts++;
        }
        return false;
    }

    public void setValue(By by, String value) {
        int attempts = 0;
        while (attempts < 2) {
            try {
                getWebDriver().findElement(by).sendKeys(value);
                break;
            } catch (StaleElementReferenceException e) {
                //DO NOTHING
            }
            attempts++;
        }
    }

}
