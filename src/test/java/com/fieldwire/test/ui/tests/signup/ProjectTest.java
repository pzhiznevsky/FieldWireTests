package com.fieldwire.test.ui.tests.signup;

import org.testng.annotations.Test;

import com.fieldwire.test.ui.tests.BaseTest;
import com.fieldwire.test.ui.tests.domain.Project;
import com.fieldwire.test.ui.tests.domain.Task;

import static com.fieldwire.test.ui.tests.constants.Constants.PROJECT;
import static com.fieldwire.test.ui.tests.constants.Constants.PROJECT_VALID;
import static com.fieldwire.test.ui.tests.constants.Constants.REGRESSION;
import static com.fieldwire.test.ui.tests.constants.Constants.SIGNIN;
import static com.fieldwire.test.ui.tests.constants.Constants.SIGNUP_VALID;
import static com.fieldwire.test.ui.tests.constants.Constants.SMOKE;
import static com.fieldwire.test.ui.tests.constants.Constants.TASK;

@Test(groups = {SIGNIN, PROJECT, TASK})
public class ProjectTest extends BaseTest {

    public static final ThreadLocal<Project> PROJECT = ThreadLocal.withInitial(() -> new Project().toBuilder().build());
    public static final ThreadLocal<Task> TASK = ThreadLocal.withInitial(() -> new Task().toBuilder().build());

    @Test(groups = {REGRESSION, SMOKE, PROJECT_VALID}, description = "testCreateProjectAndTask", dependsOnGroups = {SIGNUP_VALID})
    public void testCreateProjectAndTask() {
        getPages().signInPage().signIn(getFromUserPool());
        getPages().projectsPage().createNewProject(PROJECT.get());
        getPages().projectPage().createTask(TASK.get());
        getPages().tasksPage().validateTask(TASK.get());
    }
}
