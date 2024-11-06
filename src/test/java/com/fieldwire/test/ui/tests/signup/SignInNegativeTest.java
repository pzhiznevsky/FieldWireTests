package com.fieldwire.test.ui.tests.signup;

import org.testng.annotations.Test;

import com.fieldwire.test.ui.tests.BaseTest;
import com.fieldwire.test.ui.tests.domain.User;

import static com.fieldwire.test.ui.tests.constants.Constants.REGRESSION;
import static com.fieldwire.test.ui.tests.constants.Constants.SIGNIN;
import static com.fieldwire.test.ui.tests.constants.Constants.SIGNUP_VALID;
import static com.fieldwire.test.ui.tests.constants.Constants.SMOKE;

@Test(groups = {SIGNIN})
public class SignInNegativeTest extends BaseTest {

    @Test(groups = {REGRESSION, SMOKE}, description = "testSignInIncorrectPassword", dependsOnGroups = {SIGNUP_VALID})
    public void testSignInIncorrectPassword() {
        User user = getFromUserPool();
        getPages().signInPage().signIn(user.getWorkEmail(), "invalidpassword");
        String error = "Invalid password. Try again or click Forgot your password? to reset it.";
        getPages().signInPage().validateErrorOnPage(error);
    }
}
