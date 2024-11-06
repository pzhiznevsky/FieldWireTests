package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;

import com.fieldwire.test.ui.tests.elements.Button;

import lombok.Getter;

@Getter
public class UploadPlansDialog extends ModalDialog {

    private final Button nextButton;

    public UploadPlansDialog(WebDriver webDriver) {
        this(webDriver, "//div[contains(@class,'project-wizard-modal')]");
    }

    public UploadPlansDialog(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        nextButton = new Button(webDriver, window + "//button[contains(@class,'next-btn')]", "NextButton");
    }
}
