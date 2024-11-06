package com.fieldwire.test.ui.tests.pages;

import org.openqa.selenium.WebDriver;

import com.fieldwire.test.ui.tests.domain.User;
import com.fieldwire.test.ui.tests.elements.Button;
import com.fieldwire.test.ui.tests.elements.Dropdown;
import com.fieldwire.test.ui.tests.elements.Input;

import lombok.Getter;

import static com.fieldwire.test.ui.tests.constants.CompanyType.SPECIALTY_CONTRACTOR;

@Getter
public class SignUp2Page extends BasePage {

    private final Input companyNameInput;
    private final Dropdown companyTypeDropdown;
    private Dropdown tradeTypeDropdown;
    private final Dropdown numberOfEmployeesDropdown;
    private final Input phoneNumberInput;
    private final Button completeButton;

    public SignUp2Page(WebDriver webDriver) {
        this(webDriver, "//*[@id='login']//form[contains(@class,'form-signin') and contains(@class,'profile')]");
    }

    public SignUp2Page(WebDriver webDriver, String window) {
        super(webDriver, window);
        this.window = window;
        companyNameInput = new Input(webDriver, window + "//input[@id='company']", "CompanyNameInput");
        companyTypeDropdown = new Dropdown(webDriver, window + "//select[@id='companyType']", "CompanyTypeDropdown");
        numberOfEmployeesDropdown = new Dropdown(webDriver, window + "//select[@id='companySize']", "NumberOfEmployeesDropdown");
        phoneNumberInput = new Input(webDriver, window + "//input[@id='phone']", "PhoneNumberInput");
        completeButton = new Button(webDriver, window + "//fw-button[@data-e2e='create-account-complete']//button", "CompleteButton");
    }

    public void fillOutForm(User user) {
        fillOutForm(user, true);
    }

    public void fillOutForm(User user, boolean validate) {
        companyNameInput.waitForElementPresent();
        companyNameInput.setValue(user.getCompanyName(), validate);
        companyTypeDropdown.setValue(user.getCompanyType(), validate);
        if (user.getCompanyType() != null && SPECIALTY_CONTRACTOR.getName().equalsIgnoreCase(user.getCompanyType())) {
            tradeTypeDropdown = new Dropdown(webDriver, window + "//select[@id='tradeType']", "TradeTypeDropdown");
            tradeTypeDropdown.setValue(user.getTradeType(), validate);
        }
        numberOfEmployeesDropdown.setValue(user.getNumberOfEmployees(), validate);
        phoneNumberInput.setValue(user.getPhoneNumber(), validate);
    }

    public void createAccount(User user) {
        createAccount(user, true);
    }

    public void createAccount(User user, boolean validate) {
        waitForPagePresent();
        fillOutForm(user, validate);
        getCompleteButton().click();
    }
}
