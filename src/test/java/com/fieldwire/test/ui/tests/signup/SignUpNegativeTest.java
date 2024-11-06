package com.fieldwire.test.ui.tests.signup;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fieldwire.test.ui.tests.BaseTest;
import com.fieldwire.test.ui.tests.annotations.KnownIssue;
import com.fieldwire.test.ui.tests.domain.User;

import static com.fieldwire.test.ui.tests.constants.Constants.REGRESSION;
import static com.fieldwire.test.ui.tests.constants.Constants.SIGNUP;
import static com.fieldwire.test.ui.tests.util.RandomGenerator.getRandomString;

@Test(groups = {SIGNUP})
public class SignUpNegativeTest extends BaseTest {

    @Test(groups = {REGRESSION}, description = "testSignUp")
    public void testSignUpWithExistingEmail() {
        User user = new User().toBuilder().build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user);

        navigateToBasePage();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user, false, true);
        getPages().signUpPage().waitForErrorPresent();
        String error = "An account with that email address already exists.";
        getPages().signUpPage().validateErrorOnPage(error);
    }

    @KnownIssue("FW1 Invalid Password error message is displayed when First Name and/or Last Name are more than required length")
    @Test(groups = {REGRESSION}, description = "testSignUpWithInvalidFirstName")
    public void testSignUpWithInvalidFirstName() {
        User user = new User().toBuilder().firstName(getRandomString(1001)).build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user);
        getPages().signUpPage().waitForErrorPresent();
        String error = "Invalid First Name.";
        getPages().signUpPage().validateErrorOnPage(error);
    }

    @KnownIssue("FW1 Invalid Password error message is displayed when First Name and/or Last Name are more than required length")
    @Test(groups = {REGRESSION}, description = "testSignUpWithInvalidLastName")
    public void testSignUpWithInvalidLastName() {
        User user = new User().toBuilder().lastName(getRandomString(1001)).build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user);
        getPages().signUpPage().waitForErrorPresent();
        String error = "Invalid Lst Name.";
        getPages().signUpPage().validateErrorOnPage(error);
    }

    @Test(groups = {REGRESSION}, description = "testSignUpWithInvalidPassword")
    public void testSignUpWithInvalidPassword() {
        User user = new User().toBuilder().password(getRandomString(1001)).build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user);
        getPages().signUpPage().waitForErrorPresent();
        String error = "Invalid password.";
        getPages().signUpPage().validateErrorOnPage(error);
    }

    @Test(groups = {REGRESSION}, description = "testSignUpUserWithEmptyFirstName")
    public void testSignUpUserWithEmptyFirstName() {
        User user = new User().toBuilder().firstName("").build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user, false, true);

        Assert.assertTrue(getPages().signUpPage().getFirstNameInput().isInputInvalid(),
                "An error should be shown for First Name field! User: " + user);
    }

    @Test(groups = {REGRESSION}, description = "testSignUpUserWithEmptyLastName")
    public void testSignUpUserWithEmptyLastName() {
        User user = new User().toBuilder().lastName("").build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user, false, true);

        Assert.assertTrue(getPages().signUpPage().getLastNameInput().isInputInvalid(),
                "An error should be shown for Last Name field! User: " + user);
    }

    @Test(groups = {REGRESSION}, description = "testSignUpUserWithEmptyEmail")
    public void testSignUpUserWithEmptyEmail() {
        User user = new User().toBuilder().workEmail("").build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user, false, true);

        Assert.assertTrue(getPages().signUpPage().getWorkEmailInput().isInputInvalid(),
                "An error should be shown for Work Email field! User: " + user);
    }

    @Test(groups = {REGRESSION}, description = "testSignUpUserWithEmptyPassword")
    public void testSignUpUserWithEmptyPassword() {
        User user = new User().toBuilder().password("").build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user, false, true);

        Assert.assertTrue(getPages().signUpPage().getPasswordInput().isInputInvalid(),
                "An error should be shown for Password field! User: " + user);
    }

    @Test(groups = {REGRESSION}, description = "testSignUpUserWithUnacceptedAgreement")
    public void testSignUpUserWithUnacceptedAgreement() {
        User user = new User().toBuilder().build();
        getPages().signInPage().goToCreateAccount();
        getPages().signUpPage().createAccount(user, false, false);

        Assert.assertTrue(getPages().signUpPage().getCreateAccountButton().isButtonDisabled(),
                "Create Account button should be disabled! User: " + user);
    }
}
