package com.fieldwire.test.ui.tests.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum NumberOfEmployees {

    N1_10("1 - 10"),
    N10_50("10 - 50"),
    N50_250("50 - 250"),
    N250_1000("250 - 1000"),
    N1000PLUS("1000+");

    private final String name;
}
