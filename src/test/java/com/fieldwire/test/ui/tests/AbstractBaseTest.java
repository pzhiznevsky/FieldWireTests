package com.fieldwire.test.ui.tests;

import org.testng.IConfigurable;
import org.testng.IConfigureCallBack;
import org.testng.ITestResult;

import com.fieldwire.test.ui.tests.logging.Log;
import com.fieldwire.test.ui.tests.retry.Retriable;

public class AbstractBaseTest implements IConfigurable {

    @Override
    public void run(IConfigureCallBack callBack, ITestResult testResult) {
        Retriable retriable =
                testResult.getMethod().getConstructorOrMethod().getMethod().getAnnotation(Retriable.class);
        int attempts = 1;
        if (retriable != null) {
            attempts = retriable.attempts();
        }
        for (int attempt = 1; attempt <= attempts; attempt++) {
            if (attempt > 1) {
                Log.info("RETRIABLE attempt " + attempt);
            }
            callBack.runConfigurationMethod(testResult);
            if (testResult.getThrowable() == null) {
                break;
            }
        }
    }
}