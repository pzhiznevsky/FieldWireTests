package com.fieldwire.test.ui.tests.signup;

import java.util.LinkedList;

import org.testng.annotations.Test;

import com.fieldwire.test.ui.tests.BaseTest;
import com.fieldwire.test.ui.tests.domain.User;

import static com.fieldwire.test.ui.tests.constants.Constants.REGRESSION;
import static com.fieldwire.test.ui.tests.constants.Constants.SIGNUP;
import static com.fieldwire.test.ui.tests.constants.Constants.SIGNUP_VALID;
import static com.fieldwire.test.ui.tests.constants.Constants.SMOKE;
import static com.fieldwire.test.ui.tests.constants.Constants.URL_SIGNUP_SUCCESSFUL;
import static com.fieldwire.test.ui.tests.constants.Constants.URL_SIGNUP_SUCCESSFULLY_WITH_PASSWORD;

@Test(groups = {SIGNUP})
public class SignUpTest extends BaseTest {

    @Test(groups = {REGRESSION, SMOKE, SIGNUP_VALID}, description = "testSignUp")
    public void testSignUp() {
        User user = new User().toBuilder().build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user);
        getPages().signUp2Page().createAccount(user);
        validateUrl(URL_SIGNUP_SUCCESSFUL);
        getPages().headerPage().validateProfileName(user.getFirstName());
        USER_POOL.add(user);
    }

    @Test(groups = {REGRESSION, SMOKE}, description = "testSignUpPartially without filling the secondary data")
    public void testSignUpPartially() {
        User user = new User().toBuilder().build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user);
        navigateToBasePage();
        getPages().signInPage().signIn(user);
        validateUrl(String.format(URL_SIGNUP_SUCCESSFULLY_WITH_PASSWORD, user.getWorkEmail()));
        getPages().headerPage().validateProfileName(user.getFirstName());
        USER_POOL.add(user);
    }

    @Test(groups = {REGRESSION}, description = "testSignUpPageDefaultValues")
    public void testSignUpPageDefaultValues() {
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().validateDefaultValues();
    }

    @Test(groups = {REGRESSION}, description = "testOpenPrivacyNotice")
    public void testOpenPrivacyNotice() {
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().openPrivacyNotice();
    }

    @Test(groups = {REGRESSION}, description = "testOpenServiceDescription")
    public void testOpenServiceDescription() {
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().openServiceDescription();
    }

    @Test(groups = {REGRESSION}, description = "testOpenSubscriptionAgreement")
    public void testOpenSubscriptionAgreement() {
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().openSubscriptionAgreement();
    }
}
