package com.fieldwire.test.ui.tests.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.fieldwire.test.ui.tests.logging.Log;

public class Dropdown extends UIElement {

    private Select select;

    public Dropdown(WebDriver webDriver, WebElement webElement) {
        super(webDriver, webElement);
    }

    private Select getSelect(){
        if(select == null){
            select = new Select(webElement);
        }

        return select;
    }

    public Dropdown(WebDriver webDriver, String locator, String description) {
        super(webDriver, locator, description);
    }

    public Dropdown(WebDriver webDriver, String locator, String description, WebElement webElement) {
        super(webDriver, locator, description, webElement);
    }

    public String getText() {
        waitForElementPresent();
        return getSelect().getFirstSelectedOption().getText();
    }

    public boolean isSelected(String value) {
        waitForElementPresent();
        return value.equalsIgnoreCase(getText());
    }

    public boolean isInvalid() {
        return webElement.getAttribute("class").contains("invalid");
    }

    public void validateIsValid() {
        if (isInvalid()) {
            throw new AssertionError("Selected Data is not Valid in Dropdown " + description);
        }
    }

    public void setValue(String value) {
        setValue(value, true);
    }

    public void setValue(String value, boolean validate) {
        waitForElementPresent();
        if (value == null || value.isEmpty() || isSelected(value))
            return;
        getSelect().selectByVisibleText(value);
        if (validate) {
            if (isInvalid()) {
                throw new AssertionError("Selected value is not Valid in dropdown " + description);
            }
            if (!isSelected(value)) {
                String message = "Actual=" + getText() + ", Expected: " + value;
                throw new AssertionError("Selected value is not Valid in dropdown " + description + ", " + message);
            }
        }
        Log.info("'" + description + "' was set to: '" + value + "'");
    }
}
