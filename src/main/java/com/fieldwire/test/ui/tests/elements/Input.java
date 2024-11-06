package com.fieldwire.test.ui.tests.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.fieldwire.test.ui.tests.logging.Log;

public class Input extends UIElement {

    public Input(WebDriver webDriver, WebElement webElement) {
        super(webDriver, webElement);
    }

    public Input(WebDriver webDriver, String locator, String description) {
        super(webDriver, locator, description);
    }

    public Input(WebDriver webDriver, String locator, String description, WebElement webElement) {
        super(webDriver, locator, description, webElement);
    }

    public String getValue() {
        waitForElementPresent();
        return getWebElement().getText();
    }

    public void setValue(String value) {
        setValue(value, true);
    }

    public void setValue(String value, boolean validate) {
        if (value == null)
            return;
        Log.info("Typing '" + value + "' into " + description);
        waitForElementPresent();
        try{
            getWebElement().sendKeys(value);
        } catch (StaleElementReferenceException e){
            setValue(By.xpath(locator), value);
        }
        Log.info("'" + description + "' was set to: '" + value + "'");

        if(validate){
            validateInputIsValid();
        }
    }

    public boolean isInputInvalid(){
        try{
            return webElement.getAttribute("class").contains("invalid");
        } catch (StaleElementReferenceException e){
            return isInputInvalid(By.xpath(getLocator()));
        }
    }

    public void validateInputIsValid(){
        if(isInputInvalid()){
            throw new AssertionError("Entered Data is not Valid in input " + description);
        }
    }
}
