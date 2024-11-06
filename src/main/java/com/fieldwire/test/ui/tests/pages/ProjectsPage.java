package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;

import com.fieldwire.test.ui.tests.domain.Project;
import com.fieldwire.test.ui.tests.elements.Button;

import lombok.Getter;

@Getter
public class ProjectsPage extends BasePage {

    private final Button newProjectButton;
    private NewProjectDialog newProjectDialog;
    private UploadPlansDialog uploadPlansDialog;

    public ProjectsPage(WebDriver webDriver) {
        this(webDriver, "//div[@ui-view]");
    }

    public ProjectsPage(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        newProjectButton = new Button(webDriver, window + "//button[contains(@ng-click,'newProject')]", "NewProjectButton");
    }

    public void createNewProject(Project project) {
        waitForPagePresent();
        newProjectButton.click();
        newProjectDialog = new NewProjectDialog(webDriver);
        newProjectDialog.createProject(project);
        uploadPlansDialog = new UploadPlansDialog(webDriver);
        uploadPlansDialog.close();
    }
}
