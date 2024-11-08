package com.fieldwire.test.ui.tests.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.fieldwire.test.ui.tests.logging.Log;

public class RetryAnalyzer implements IRetryAnalyzer {

    static final int MAX_RETRIES = 1;

    int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRIES) {
            retryCount++;
            Log.info("Retry attempt " + retryCount);
            return true;
        }
        return false;
    }
}
