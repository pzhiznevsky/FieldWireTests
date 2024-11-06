package com.fieldwire.test.ui.tests.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum TradeType {

    CONCRETE("Concrete"),
    EARTHWORK("Earthwork"),
    ELECTRICAL("Electrical"),
    FIRE_SUPPRESSION("Fire Suppression"),
    FRAMING_AND_OR_DRYWALL("Framing and/or drywall"),
    HVAC("HVAC"),
    LOW_VOLTAGE("Low voltage (security, audio visual, cabling)"),
    MECHANICAL("Mechanical"),
    PLUMBING("Plumbing"),
    UTILITIES("Utilities"),
    OTHER("Other");

    private final String name;
}
