package com.fieldwire.test.ui.tests.signup;

import org.testng.annotations.Test;

import com.fieldwire.test.ui.tests.BaseTest;
import com.fieldwire.test.ui.tests.domain.User;

import static com.fieldwire.test.ui.tests.constants.Constants.REGRESSION;
import static com.fieldwire.test.ui.tests.constants.Constants.SIGNIN;
import static com.fieldwire.test.ui.tests.constants.Constants.SIGNUP_VALID;
import static com.fieldwire.test.ui.tests.constants.Constants.SMOKE;
import static com.fieldwire.test.ui.tests.constants.Constants.URL_SIGNUP_SUCCESSFULLY_WITH_PASSWORD;

@Test(groups = {SIGNIN})
public class SignInTest extends BaseTest {

    @Test(groups = {REGRESSION, SMOKE}, description = "testSignIn", dependsOnGroups = {SIGNUP_VALID})
    public void testSignIn() {
        User user = getFromUserPool();
        getPages().signInPage().signIn(user);
        validateUrl(String.format(URL_SIGNUP_SUCCESSFULLY_WITH_PASSWORD, user.getWorkEmail()));
        getPages().headerPage().validateProfileName(user.getFirstName());
    }
}
