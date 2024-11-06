package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;

import lombok.Getter;

@Getter
public class Pages {

    private final WebDriver webDriver;
    private BasePage basePage;
    private SignInPage signInPage;
    private SignUpPage signUpPage;
    private SignUp2Page signUp2Page;
    private HeaderPage headerPage;
    private ProjectsPage projectsPage;
    private ProjectPage projectPage;
    private TasksPage tasksPage;

    public Pages(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public SignInPage signInPage() {
        if (signInPage == null) {
            signInPage = new SignInPage(webDriver);
        }
        return signInPage;
    }

    public SignUpPage signUpPage() {
        if (signUpPage == null) {
            signUpPage = new SignUpPage(webDriver);
        }
        return signUpPage;
    }

    public SignUp2Page signUp2Page() {
        if (signUp2Page == null) {
            signUp2Page = new SignUp2Page(webDriver);
        }
        return signUp2Page;
    }

    public BasePage basePage() {
        if (basePage == null) {
            basePage = new BasePage(webDriver);
        }
        return basePage;
    }

    public HeaderPage headerPage() {
        if (headerPage == null) {
            headerPage = new HeaderPage(webDriver);
        }
        return headerPage;
    }

    public ProjectsPage projectsPage() {
        if (projectsPage == null) {
            projectsPage = new ProjectsPage(webDriver);
        }
        return projectsPage;
    }

    public ProjectPage projectPage() {
        if (projectPage == null) {
            projectPage = new ProjectPage(webDriver);
        }
        return projectPage;
    }

    public TasksPage tasksPage() {
        if (tasksPage == null) {
            tasksPage = new TasksPage(webDriver);
        }
        return tasksPage;
    }
}
