package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.fieldwire.test.ui.tests.domain.Task;
import com.fieldwire.test.ui.tests.elements.Button;
import com.fieldwire.test.ui.tests.elements.Label;

import lombok.Getter;

@Getter
public class TasksPage extends BasePage {

    private final Button newTaskButton;
    private NewTaskDialog newTaskDialog;
    private Label newTaskLabel;

    public TasksPage(WebDriver webDriver) {
        this(webDriver, "//div[contains(@class,'task-view-container')]");
    }

    public TasksPage(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        newTaskButton = new Button(webDriver, window + "//fw-button[@data-e2e='create-new-task']//button", "NewTaskButton");
    }

    public void createNewTask(Task task) {
        waitForPagePresent();
        newTaskButton.click();
        newTaskDialog = new NewTaskDialog(webDriver);
        newTaskDialog.createTask(task);
    }

    public void validateTask(Task task) {
        waitForPagePresent();
        newTaskLabel = new Label(webDriver, "//div[@data-e2e='task-name-ontaskpage']", "NewTaskLabel");
        Assert.assertEquals(newTaskLabel.getText(), task.getTitle(), "Unexpected title!");
    }
}
