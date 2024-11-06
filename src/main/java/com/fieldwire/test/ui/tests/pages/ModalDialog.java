package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;

import com.fieldwire.test.ui.tests.elements.Button;

import lombok.Getter;

@Getter
public class ModalDialog extends BasePage {

    private final Button closeButton;

    public ModalDialog(WebDriver webDriver) {
        this(webDriver, "//div[@uib-modal-window='modal-window'");
    }

    public ModalDialog(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        closeButton = new Button(webDriver, window + "//div[@class='close-modal']", "CloseButton");
    }

    public void close() {
        waitForPagePresent();
        closeButton.click();
    }
}
