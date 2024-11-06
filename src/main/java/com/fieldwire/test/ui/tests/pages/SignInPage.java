package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;

import com.fieldwire.test.ui.tests.domain.User;
import com.fieldwire.test.ui.tests.elements.Button;
import com.fieldwire.test.ui.tests.elements.Input;
import com.fieldwire.test.ui.tests.elements.Link;

import lombok.Getter;

@Getter
public class SignInPage extends BasePage {

    private final Input emailAddressInput;
    private Input passwordInput;
    private final Button nextButton;
    private Button logInButton;
    private final Link accountLockedLink;
    private final Link createAnAccountLink;

    public SignInPage(WebDriver webDriver) {
        this(webDriver, "//*[@id='auth-sign-in' or @id='auth-sign-in-with-password']");
    }

    public SignInPage(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        emailAddressInput = new Input(webDriver, window + "//input[@id='email-input']", "EmailAddressInput");
        nextButton = new Button(webDriver, window + "//button[contains(@class,'fw-button')]", "NextButton");
        accountLockedLink = new Link(webDriver, window + "//a[contains(@ui-sref,'auth.locked_password')]", "AccountLockedLink");
        createAnAccountLink = new Link(webDriver, window + "//a[@ui-sref='auth.register']", "CreateAnAccountLink");
    }

    public void goToCreateAccount() {
        waitForPagePresent();
        createAnAccountLink.click();
    }

    public void signIn(User user) {
        signIn(user.getWorkEmail(), user.getPassword());
    }

    public void signIn(String email, String password) {
        emailAddressInput.setValue(email);
        nextButton.click();
        passwordInput = new Input(webDriver, window + "//input[@id='password-input']", "PasswordInput");
        passwordInput.setValue(password);
        logInButton = new Button(webDriver, window + "//fw-button[@data-e2e='signin-with-password']//button", "LogInButton");
        logInButton.click();
    }
}
