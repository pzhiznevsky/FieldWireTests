package com.fieldwire.test.ui.tests.util;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.ITestContext;

import static com.fieldwire.test.ui.tests.constants.Constants.SMOKE;

public class TestNGHelper {

    private TestNGHelper() {
    }

    public static Object[][] getScenariosBasedOnIncludedGroups(ITestContext iTestContext,
            Object[][] smokeScenarios, Object[][] regressionScenarios) {
        if (includesSmokeGroup(iTestContext)) {
            return smokeScenarios;
        }
        return ArrayUtils.addAll(smokeScenarios, regressionScenarios);
    }

    public static boolean includesSmokeGroup(ITestContext iTestContext) {
        for (String group : iTestContext.getIncludedGroups()) {
            if (group.equals(SMOKE)) {
                return true;
            }
        }
        return false;
    }

}
