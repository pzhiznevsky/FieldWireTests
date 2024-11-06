package com.fieldwire.test.ui.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.fieldwire.test.ui.tests.constants.Browsers;
import com.fieldwire.test.ui.tests.domain.User;
import com.fieldwire.test.ui.tests.logging.Log;
import com.fieldwire.test.ui.tests.pages.Pages;
import com.fieldwire.test.ui.tests.retry.Retriable;
import com.fieldwire.test.ui.tests.signup.SignUpTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import static com.fieldwire.test.ui.tests.constants.Constants.BASE_URL;
import static com.fieldwire.test.ui.tests.constants.Constants.BASE_URL_TO_VERIFY;
import static com.fieldwire.test.ui.tests.constants.Constants.DEFAULT_BROWSER;
import static com.fieldwire.test.ui.tests.constants.Constants.TIMEOUT;

public class BaseTest extends AbstractBaseTest {

    protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private URL seleniumServerUrl;
    protected static ThreadLocal<Wait> wait = new ThreadLocal<>();
    protected static ThreadLocal<Pages> pages = new ThreadLocal<>();
    public static LinkedList<User> USER_POOL = new LinkedList<>();

    @Retriable(attempts = 3)
    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(@Optional String browser) {
        createDriver(browser);
        configureBefore();
    }

    @Parameters({"browser"})
    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result, @Optional String browser) {
        takeScreenshotOnFailure(result, browser);
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }

    public WebDriver getWebDriver(){
        return webDriver.get();
    }

    public Pages getPages(){
        return pages.get();
    }

    private void takeScreenshotOnFailure(ITestResult result, String browser) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) getWebDriver();
                File source = ts.getScreenshotAs(OutputType.FILE);
                try {
                    String basePath = System.getProperty("user.dir") + "/target/screenshots/";
                    new File(basePath).mkdirs();
                    String timestamp = Instant.now().toString().replace("-", "").replace(":", "");
                    FileHandler.copy(source, new File(basePath + browser + "_" + result.getName() + "_" + timestamp + ".png"));
                    Log.info("Screenshot taken");
                } catch (Exception e) {
                    Log.error("Exception while taking screenshot " + e.getMessage());
                }
            } catch (Exception e) {
                Log.error("Can't take a screenshot! Error: " + e.getMessage());
            }
        }
    }

    private void configureBefore() {
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getWebDriver().manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TIMEOUT));
        wait.set(new Wait(getWebDriver()));
        pages.set(new Pages(getWebDriver()));
        navigateToBasePage();
    }

    protected void navigateToBasePage() {
        getWebDriver().get(BASE_URL);
        wait.get().until(ExpectedConditions.urlToBe(BASE_URL_TO_VERIFY));
        validateUrl(BASE_URL_TO_VERIFY);
    }

    protected void validateUrl(String url) {
        Assert.assertEquals(getWebDriver().getCurrentUrl(), url, "Unexpected URL!");
    }

    private void setupBrowser(String browser) {
        String broString = java.util.Optional.ofNullable(browser).orElse(DEFAULT_BROWSER).toUpperCase();
        Browsers bro = Browsers.valueOf(broString);
        switch (bro) {
            case CHROME:
            default:
                WebDriverManager.chromedriver().setup();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                break;
            case EDGE:
                WebDriverManager.edgedriver().setup();
                break;
            case SAFARI:
                WebDriverManager.safaridriver().setup();
                break;
            case OPERA:
                WebDriverManager.operadriver().setup();
                break;
        }
    }

    private void createDriver(String browser) {
        String broString = java.util.Optional.ofNullable(browser).orElse(DEFAULT_BROWSER).toUpperCase();
        Browsers bro = Browsers.valueOf(broString);
        synchronized (this) {
            switch (bro) {
                case CHROME:
                default:
                    webDriver.set(WebDriverManager.chromedriver().create());
                    break;
                case EDGE:
                    webDriver.set(WebDriverManager.edgedriver().create());
                    break;
                case FIREFOX:
                    webDriver.set(WebDriverManager.firefoxdriver().create());
                    break;
                case SAFARI:
                    webDriver.set(WebDriverManager.safaridriver().create());
                    break;
                case OPERA:
                    webDriver.set(WebDriverManager.operadriver().create());
                    break;
            }
        }
    }

    private void createDriverForGrid(String browser) {
        String broString = java.util.Optional.ofNullable(browser).orElse(DEFAULT_BROWSER).toUpperCase();
        Browsers bro = Browsers.valueOf(broString);
        switch (bro) {
            case CHROME:
            default:
                webDriver.set(new RemoteWebDriver(seleniumServerUrl, new ChromeOptions()));
                break;
            case EDGE:
                webDriver.set(new RemoteWebDriver(seleniumServerUrl, new EdgeOptions()));
                break;
            case FIREFOX:
                webDriver.set(new RemoteWebDriver(seleniumServerUrl, new FirefoxOptions()));
                break;
            case SAFARI:
                webDriver.set(new RemoteWebDriver(seleniumServerUrl, new SafariOptions()));
                break;
        }
    }

    public void beforeClassForGrid(String browser) {
        setupBrowser(browser);
        int port = PortProber.findFreePort();
        Main.main(new String[] {"standalone", "--port", String.valueOf(port)});//default: "4444"
        try {
            seleniumServerUrl = new URL(String.format("http://localhost:%d/", port));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getFromUserPool(){
        synchronized (SignUpTest.class){
            if(!USER_POOL.isEmpty()){
                return USER_POOL.get(0);
            }
        }

        return null;
    }
}
