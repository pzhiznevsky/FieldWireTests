package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.fieldwire.test.ui.tests.domain.User;
import com.fieldwire.test.ui.tests.elements.Button;
import com.fieldwire.test.ui.tests.elements.Checkbox;
import com.fieldwire.test.ui.tests.elements.Input;
import com.fieldwire.test.ui.tests.elements.Label;
import com.fieldwire.test.ui.tests.elements.Link;

import lombok.Getter;

@Getter
public class SignUpPage extends BasePage {

    private final Input firstNameInput;
    private final Input lastNameInput;
    private final Input workEmailInput;
    private final Input passwordInput;
    private final Checkbox acceptAgreementCheckbox;
    private final Label acceptAgreementLabel;
    private final Button createAccountButton;
    private final Link logInLink;
    private final Link subscriptionAgreementLink;
    private final Link serviceDescriptionLink;
    private final Link privacyNoticeLink;

    public SignUpPage(WebDriver webDriver) {
        this(webDriver, "//*[@id='login']");
    }

    public SignUpPage(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        firstNameInput = new Input(webDriver, window + "//input[@id='firstNameInput']", "FirstNameInput");
        lastNameInput = new Input(webDriver, window + "//input[@id='lastNameInput']", "LastNameInput");
        workEmailInput = new Input(webDriver, window + "//input[@id='emailInput']", "WorkEmailInput");
        passwordInput = new Input(webDriver, window + "//input[@id='passwordInput']", "PasswordInput");
        acceptAgreementCheckbox = new Checkbox(webDriver, window + "//input[@id='explicitAgreement']", "AcceptAgreementCheckbox");
        acceptAgreementLabel = new Label(webDriver, window + "//label[@for='explicitAgreement']", "AcceptAgreementLabel");
        createAccountButton = new Button(webDriver, window + "//fw-button[@data-e2e='create-account-button']//button", "CreateAccountButton");
        logInLink = new Link(webDriver, window + "//a[@ui-sref='auth.sign_in']", "LogInLink");
        subscriptionAgreementLink = new Link(webDriver, window + "//a[text()='Subscription Agreement']", "SubscriptionAgreementLink");
        serviceDescriptionLink = new Link(webDriver, window + "//a[text()='Service Description']", "ServiceDescriptionLink");
        privacyNoticeLink = new Link(webDriver, "//a[text()='Privacy Notice']", "PrivacyNoticeLink");
    }

    public void fillOutForm(User user) {
        fillOutForm(user, true);
    }

    public void fillOutForm(User user, boolean validate) {
        firstNameInput.waitForElementPresent();
        firstNameInput.setValue(user.getFirstName(), validate);
        lastNameInput.setValue(user.getLastName(), validate);
        workEmailInput.setValue(user.getWorkEmail(), validate);
        passwordInput.setValue(user.getPassword(), validate);
    }

    public void createAccount(User user) {
        createAccount(user, true, true);
    }

    public void createAccount(User user, boolean validate, boolean acceptAgreement) {
        waitForPagePresent();
        fillOutForm(user, validate);
        getAcceptAgreementCheckbox().select(acceptAgreement);
        getCreateAccountButton().click();
    }

    public void validateDefaultValues() {
        waitForPagePresent();
        Assert.assertEquals(firstNameInput.getValue(), "", "FirstName should be empty by default!");
        Assert.assertEquals(lastNameInput.getValue(), "", "LastName should be empty by default!");
        Assert.assertEquals(workEmailInput.getValue(), "", "WorkEmail should be empty by default!");
        Assert.assertEquals(passwordInput.getValue(), "", "Password should be empty by default!");
    }

    public void openSubscriptionAgreement() {
        waitForPagePresent();
        subscriptionAgreementLink.click();
    }

    public void openServiceDescription() {
        waitForPagePresent();
        serviceDescriptionLink.click();
    }

    public void openPrivacyNotice() {
        waitForPagePresent();
        privacyNoticeLink.click();
    }
}
