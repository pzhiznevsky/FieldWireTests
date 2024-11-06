package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;

import com.fieldwire.test.ui.tests.domain.Task;
import com.fieldwire.test.ui.tests.elements.Button;
import com.fieldwire.test.ui.tests.elements.Input;

import lombok.Getter;

@Getter
public class NewTaskDialog extends ModalDialog {

    private final Button enterTitleButton;
    private final Input titleInput;
    private Button taskCheckButton;

    public NewTaskDialog(WebDriver webDriver) {
        this(webDriver, "//div[contains(@class,'task-edit-modal')]");
    }

    public NewTaskDialog(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        enterTitleButton = new Button(webDriver, window + "//span[@data-e2e='task-edit-name']", "EnterTitleButton");
        titleInput = new Input(webDriver, window + "//textarea[@name='name']", "TitleInput");
    }

    public void createTask(Task task) {
        createTask(task.getTitle());
    }

    public void createTask(String title) {
        waitForPagePresent();
        enterTitleButton.click();
        titleInput.setValue(title);
        taskCheckButton = new Button(webDriver, window + "//fw-button[@data-e2e='task-edit-check']", "ProjectCodeInput");
        taskCheckButton.click();
        close();
    }
}
