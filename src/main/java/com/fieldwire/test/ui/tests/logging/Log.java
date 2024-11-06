package com.fieldwire.test.ui.tests.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Reporter;

public class Log {

    private static final Logger LOGGER = LogManager.getLogger(Log.class.getName());

    private Log() {
    }

    public static void info(String msg) {
        LOGGER.info(msg);
        Reporter.log(msg);
    }

    public static void error(String msg) {
        LOGGER.error(msg);
        Reporter.log(msg);
    }
}
