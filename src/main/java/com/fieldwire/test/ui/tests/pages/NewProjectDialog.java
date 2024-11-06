package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;

import com.fieldwire.test.ui.tests.domain.Project;
import com.fieldwire.test.ui.tests.elements.Button;
import com.fieldwire.test.ui.tests.elements.Input;

import lombok.Getter;

@Getter
public class NewProjectDialog extends ModalDialog {

    private final Input projectNameInput;
    private final Input projectCodeInput;
    private final Button createButton;

    public NewProjectDialog(WebDriver webDriver) {
        this(webDriver, "//div[contains(@class,'new-project-modal')]");
    }

    public NewProjectDialog(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        projectNameInput = new Input(webDriver, window + "//input[@name='name']", "ProjectNameInput");
        projectCodeInput = new Input(webDriver, window + "//input[@name='code']", "ProjectCodeInput");
        createButton = new Button(webDriver, window + "//button[contains(@class,'create-project-button')]", "CreateButton");
    }

    public void createProject(Project project) {
        createProject(project.getProjectName(), project.getProjectCode());
    }

    public void createProject(String projectName) {
        createProject(projectName, null);
    }

    public void createProject(String projectName, String projectCode) {
        waitForPagePresent();
        projectNameInput.setValue(projectName);
        if (projectCode != null) {
            projectCodeInput.setValue(projectCode);
        }
        createButton.click();
    }
}
