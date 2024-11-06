package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;

import com.fieldwire.test.ui.tests.domain.Task;

import lombok.Getter;

import static com.fieldwire.test.ui.tests.constants.MenuItem.TASKS;

@Getter
public class ProjectPage extends BasePage {

    private final MenuSidebar menuSidebar;
    private TasksPage tasksPage;

    public ProjectPage(WebDriver webDriver) {
        this(webDriver, "//div[@ui-view]");
    }

    public ProjectPage(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        menuSidebar = new MenuSidebar(webDriver);
    }

    public void createTask(Task task) {
        waitForPagePresent();
        menuSidebar.goTo(TASKS);
        tasksPage = new TasksPage(webDriver);
        tasksPage.createNewTask(task);
    }
}
