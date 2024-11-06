package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.fieldwire.test.ui.tests.Wait;

public class BasePage {

    protected WebDriver webDriver;
    protected String window;
    protected Wait wait;
    private static final String ERROR_LOCATOR = "//*[contains(@class,'alert')]";

    protected BasePage() {
    }

    protected BasePage(WebDriver webDriver) {
        this(webDriver, "");
    }

    protected BasePage(WebDriver webDriver, String window) {
        this.webDriver = webDriver;
        this.window = window;
        wait = new Wait(webDriver);
    }

    public void waitForPagePresent() {
        this.wait.waitForElementPresent(this.window);
    }

    private WebElement getErrorWebElement() {
        return webDriver.findElement(By.xpath(ERROR_LOCATOR));
    }

    public void waitForErrorPresent() {
        this.wait.waitForElementPresent(ERROR_LOCATOR);
    }

    public boolean isErrorOnPage() {
        return getErrorWebElement().isDisplayed();
    }

    public String getErrorOnPage() {
        return getErrorWebElement().getText();
    }

    public void validateErrorOnPage(String error) {
        Assert.assertEquals(getErrorOnPage(), error, "Unexpected Error Message!");
    }
}
