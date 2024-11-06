package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.fieldwire.test.ui.tests.elements.Label;

import lombok.Getter;

@Getter
public class HeaderPage extends BasePage {

    private final Label profileName;

    public HeaderPage(WebDriver webDriver) {
        this(webDriver, "//div[@class='navbar-header']");
    }

    public HeaderPage(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        profileName = new Label(webDriver, window + "//a[@data-e2e='profile-menu']//span", "ProfileNameLabel");
    }

    public String getProfileName() {
        waitForPagePresent();
        return profileName.getText();
    }

    public void validateProfileName(String firstName) {
        Assert.assertEquals(getProfileName(), firstName, "Unexpected Profile Name!");
    }
}
