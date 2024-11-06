package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;

import com.fieldwire.test.ui.tests.constants.MenuItem;
import com.fieldwire.test.ui.tests.elements.Link;

import lombok.Getter;

@Getter
public class MenuSidebar extends BasePage {

    private final Link tasksLink;

    public MenuSidebar(WebDriver webDriver) {
        this(webDriver, "//div[@id='sidebar-wrapper']");
    }

    public MenuSidebar(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        tasksLink = new Link(webDriver, window + "//a[contains(@ui-sref,'root.projects.project.tasks')]", "ProjectNameInput");
    }

    public void goTo(MenuItem menuItem) {
        waitForPagePresent();
        switch (menuItem) {
            case TASKS:
                tasksLink.click();
                break;
        }
    }
}
