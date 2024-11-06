package com.fieldwire.test.ui.tests.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum CompanyType {

    SPECIALTY_CONTRACTOR("Specialty Contractor"),
    GENERAL_CONTRACTOR("General Contractor"),
    ARCHITECT_SLASH_DESIGNER("Architect / Engineer"),
    OWNER("Owner / Developer"),
    OTHER("Other");

    private final String name;
}
