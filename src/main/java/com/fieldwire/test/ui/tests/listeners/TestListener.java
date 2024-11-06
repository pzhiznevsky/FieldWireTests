package com.fieldwire.test.ui.tests.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.testng.IAnnotationTransformer;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestException;
import org.testng.annotations.ITestAnnotation;

import com.fieldwire.test.ui.tests.annotations.KnownIssue;
import com.fieldwire.test.ui.tests.annotations.KnownIssues;
import com.fieldwire.test.ui.tests.logging.Log;
import com.fieldwire.test.ui.tests.retry.RetryAnalyzer;

public class TestListener implements IInvokedMethodListener, IAnnotationTransformer, ITestListener {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if (method.isTestMethod() && testResult.getStatus() == ITestResult.FAILURE && matchesKnownIssuePattern(testResult)) {
            ITestResult currentTestResult = Reporter.getCurrentTestResult();
            ITestContext tc = currentTestResult.getTestContext();
            tc.getFailedTests().addResult(testResult);
            tc.getFailedTests().getAllMethods().remove(currentTestResult.getMethod());
            tc.getFailedTests().removeResult(currentTestResult);
            currentTestResult.setThrowable(new TestException("Known issues: " + getKnownIssuesList(testResult)));
            currentTestResult.setStatus(ITestResult.SKIP);
            tc.getSkippedTests().addResult(testResult);
            tc.getSkippedTests().addResult(currentTestResult);
        }
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        //do nothing stub
    }

    @SuppressWarnings("squid:MethodCyclomaticComplexity")
    private String getKnownIssuesList(ITestResult testResult) {
        Method method = testResult.getMethod().getConstructorOrMethod().getMethod();
        StringBuilder issuesList = new StringBuilder();
        try {
            if (method.isAnnotationPresent(KnownIssues.class) && method.getAnnotation(KnownIssues.class).value() != null) {
                for (KnownIssue issue : method.getAnnotation(KnownIssues.class).value()) {
                    if (StringUtils.isNotEmpty(issue.value())) {
                        issuesList.append(StringUtils.isNotEmpty(issuesList) ? ", " : "");
                        issuesList.append(issue.value());
                    }
                }
            }
            if (method.isAnnotationPresent(KnownIssue.class) && StringUtils.isNotEmpty(method.getAnnotation(KnownIssue.class).value())) {
                KnownIssue issue = method.getAnnotation(KnownIssue.class);
                issuesList.append(StringUtils.isNotEmpty(issuesList) ? ", " : "");
                issuesList.append(issue.value());
            }
        } catch (Exception e) {
            Log.info("Error processing known issues " + e);
        }

        return issuesList.toString();
    }

    private boolean matchesKnownIssuePattern(ITestResult testResult) {
        Method method = testResult.getMethod().getConstructorOrMethod().getMethod();
        return method.isAnnotationPresent(KnownIssues.class) || method.isAnnotationPresent(KnownIssue.class);
    }

    @Override
    public void onTestStart(ITestResult result) {
        Log.info(result.getMethod().getMethodName() + " Started");
        Log.info(result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Log.info(result.getMethod().getMethodName() + " Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.info("Failed because of - " + result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("Skipped because of - " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStart(ITestContext context) {
        Log.info("=========== onStart :-" + context.getName() + "===============");

    }

    @Override
    public void onFinish(ITestContext context) {
        Log.info("=========== onFinish :-" + context.getName() + "===============");

    }
}
