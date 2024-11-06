package com.fieldwire.test.ui.tests.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static com.fieldwire.test.ui.tests.util.RandomGenerator.getRandomCompanyType;
import static com.fieldwire.test.ui.tests.util.RandomGenerator.getRandomNumberOfEmployees;
import static com.fieldwire.test.ui.tests.util.RandomGenerator.getRandomPhoneNumber;
import static com.fieldwire.test.ui.tests.util.RandomGenerator.getRandomString;
import static com.fieldwire.test.ui.tests.util.RandomGenerator.getRandomTradeType;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
public class User {

    @Builder.Default
    private String firstName = getRandomString() + "FirstName";
    @Builder.Default
    private String lastName = getRandomString() + "LastName";
    @Builder.Default
    private String workEmail = getRandomString() + "WorkEmail@email.com";
    @Builder.Default
    private String password = getRandomString() + "Password";
    @Builder.Default
    private String companyName = getRandomString() + "CompanyName";
    @Builder.Default
    private String companyType = getRandomCompanyType().getName();
    @Builder.Default
    private String tradeType = getRandomTradeType().getName();
    @Builder.Default
    private String numberOfEmployees = getRandomNumberOfEmployees().getName();
    @Builder.Default
    private String phoneNumber = "747-368-7108";

}