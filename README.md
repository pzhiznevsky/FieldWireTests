# FieldWire UI Tests

Regression Suite: 18 tests

Smoke Suite: 5 tests

### ISSUES FOUND:

1. "Invalid Password." error message is displayed when First Name and/or Last Name are invalid values
   
Steps:
```
   10:21:54.860 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - Click on 'CreateAnAccountLink' link
   10:21:55.007 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - Link 'CreateAnAccountLink' was pressed.
   10:21:55.160 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - Typing 'AQAd31794faa0c847729aff4a57737399421659374514768~!@#$%^&*()_+<>?/\.,`[]{}:;'|"AQA19A4BA6BB5314B11990A36109334E72A1659374514770AQA088A710EB86047E7A71387E91D336F431659374514770AQA8DBB941B228E4931BC1E4593BD366A5B1659374514770AQA55603e0fe4254b6098664bbb5c5843591659374514770AQA48828A3226E940E09BE962CFE925516B1659374514770AQA3603A8DEB8F54DD9A5EE59DCD6A4552F1659374514771AQAEB9845AEC92544AC989A12DB202937D01659374514771AQA882AC8F4167149EE965E9C90D97E33351659374514771AQA7faec9e8ade54021bb6696bbba59abc31659374514771AQA164F616C50504EF0AFE6BB2277AD8FC41659374514771AQA5426dd6cf52644d7a4f95ecf2fd8dd0f1659374514771AQA322e393afbfc4a52b8225fe1a65da87c1659374514771AQA301111E9C30F46B9A90EA7AE817347131659374514771AQA8D200FBA430040E58F6AA2FFBE036A7D1659374514771AQA87742E8F25354D4595C99A771771E28A1659374514771AQA34f5d6c2a2c5403d95b962fc7df718d61659374514771AQA1316f21194a2420d9a7b679ec0a6a5461659374514772AQA6C181771CF7D489A9269184C9C0A2D191659374514772AQABAD09C0EB1D5437686DCD239808B27FD1659374514772AQAC81CA7A1C4424F8089DBE03626CDE0CC1659374514772' into FirstNameInput
   10:21:56.416 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - 'FirstNameInput' was set to: 'AQAd31794faa0c847729aff4a57737399421659374514768~!@#$%^&*()_+<>?/\.,`[]{}:;'|"AQA19A4BA6BB5314B11990A36109334E72A1659374514770AQA088A710EB86047E7A71387E91D336F431659374514770AQA8DBB941B228E4931BC1E4593BD366A5B1659374514770AQA55603e0fe4254b6098664bbb5c5843591659374514770AQA48828A3226E940E09BE962CFE925516B1659374514770AQA3603A8DEB8F54DD9A5EE59DCD6A4552F1659374514771AQAEB9845AEC92544AC989A12DB202937D01659374514771AQA882AC8F4167149EE965E9C90D97E33351659374514771AQA7faec9e8ade54021bb6696bbba59abc31659374514771AQA164F616C50504EF0AFE6BB2277AD8FC41659374514771AQA5426dd6cf52644d7a4f95ecf2fd8dd0f1659374514771AQA322e393afbfc4a52b8225fe1a65da87c1659374514771AQA301111E9C30F46B9A90EA7AE817347131659374514771AQA8D200FBA430040E58F6AA2FFBE036A7D1659374514771AQA87742E8F25354D4595C99A771771E28A1659374514771AQA34f5d6c2a2c5403d95b962fc7df718d61659374514771AQA1316f21194a2420d9a7b679ec0a6a5461659374514772AQA6C181771CF7D489A9269184C9C0A2D191659374514772AQABAD09C0EB1D5437686DCD239808B27FD1659374514772AQAC81CA7A1C4424F8089DBE03626CDE0CC1659374514772'
   10:21:56.454 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - Typing 'AQA6BACA3819C184EF08529E0E6325652211659374514772~!@#$%^&*()_+<>?/\.,`[]{}:;'|"AQA5E9889DA14434C8B9F48DFEEE2C0E66C1659374514772AQAc9267bd7c44941ffa82b3ceed3e824c81659374514772AQA73911d45a8d94bb592d8de4f1decaa3f1659374514772AQA3BE9FF75F8C448AB98BF6178ADDEE4661659374514772AQA8052156fab9c4413863002b22f4fa4181659374514772AQA3B8458F978324CD69A7E872C835F7DAB1659374514772AQA2261BE48BFDD4A0A8557B3441E6DAE3C1659374514772AQAAA30A1C5A9B24879B295109DD6F2F1591659374514772AQA9099d97b9c0843b59aa45c1777ce0fd91659374514772AQA981da8bb8e214750bae812fb72cc10f61659374514772AQAE0AD9B81FEAE44828AF28E028F81D5631659374514772AQA0a5e7f8cac40467491a14d3a0c5a8fab1659374514772AQA145c099e9a114d198309e6fdcf2012661659374514772AQAC247BDDA576442C294A22A9FFB5770D61659374514772AQA64DDDF0F3E5C41BA82ADDC84A993B9EF1659374514772AQA5B71B1678B2C44F1949783C2627573501659374514772AQA45c47e8cada045d09964d42d5f2a854b1659374514772AQA9F23531532054C578DB8AD2B93D79E2A1659374514772AQA82A5C96E0A484424BA8B4FCB0E46423C1659374514772AQA9303235B1A914CAAB7E194CE45F5142A1659374514772' into LastNameInput
   10:21:57.661 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - 'LastNameInput' was set to: 'AQA6BACA3819C184EF08529E0E6325652211659374514772~!@#$%^&*()_+<>?/\.,`[]{}:;'|"AQA5E9889DA14434C8B9F48DFEEE2C0E66C1659374514772AQAc9267bd7c44941ffa82b3ceed3e824c81659374514772AQA73911d45a8d94bb592d8de4f1decaa3f1659374514772AQA3BE9FF75F8C448AB98BF6178ADDEE4661659374514772AQA8052156fab9c4413863002b22f4fa4181659374514772AQA3B8458F978324CD69A7E872C835F7DAB1659374514772AQA2261BE48BFDD4A0A8557B3441E6DAE3C1659374514772AQAAA30A1C5A9B24879B295109DD6F2F1591659374514772AQA9099d97b9c0843b59aa45c1777ce0fd91659374514772AQA981da8bb8e214750bae812fb72cc10f61659374514772AQAE0AD9B81FEAE44828AF28E028F81D5631659374514772AQA0a5e7f8cac40467491a14d3a0c5a8fab1659374514772AQA145c099e9a114d198309e6fdcf2012661659374514772AQAC247BDDA576442C294A22A9FFB5770D61659374514772AQA64DDDF0F3E5C41BA82ADDC84A993B9EF1659374514772AQA5B71B1678B2C44F1949783C2627573501659374514772AQA45c47e8cada045d09964d42d5f2a854b1659374514772AQA9F23531532054C578DB8AD2B93D79E2A1659374514772AQA82A5C96E0A484424BA8B4FCB0E46423C1659374514772AQA9303235B1A914CAAB7E194CE45F5142A1659374514772'
   10:21:57.678 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - Typing 'yecqaxyqcuwqwgvinwzejpctjnpmioewvcecydnxfuldfifwfmfjlgxctxemupol@owcximwxbbjjjvzbzpngnyncaasthqrjapsskmbpzqhafovdtbdlkfyneaoatez.fptebdxjclptdypbfsimjawsgijztkyxlfvegxverutgcmuluamppftriyuajgq.ovutyrfhaxxqarpzwlmdkurmfryznmsnlppponcygxmbbyzcfmcwtpqoxhbsn' into WorkEmailInput
   10:21:58.001 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - 'WorkEmailInput' was set to: 'yecqaxyqcuwqwgvinwzejpctjnpmioewvcecydnxfuldfifwfmfjlgxctxemupol@owcximwxbbjjjvzbzpngnyncaasthqrjapsskmbpzqhafovdtbdlkfyneaoatez.fptebdxjclptdypbfsimjawsgijztkyxlfvegxverutgcmuluamppftriyuajgq.ovutyrfhaxxqarpzwlmdkurmfryznmsnlppponcygxmbbyzcfmcwtpqoxhbsn'
   10:21:58.010 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - Typing 'AQADCAFC9381AB04F3F9DACB3DAF6F2A7451659374514790Password' into PasswordInput
   10:21:58.124 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - 'PasswordInput' was set to: 'AQADCAFC9381AB04F3F9DACB3DAF6F2A7451659374514790Password'
   10:21:58.192 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - 'AcceptAgreementCheckbox' was set to: 'true'
   10:21:58.223 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - Click on 'CreateAccountButton' link
   10:21:58.306 [main] INFO  com.fieldwire.test.ui.tests.logging.Log - Button 'CreateAccountButton' was pressed.
```
`Actual`: "Invalid Password." error message is displayed

`Expected`: Proper error message on length of First Name/Last Name field should be displayed.

2. Inconsistency found on entering required data during Signup process 

Description: User is able to sign up without entering secondary data (Company Name, phone etc) by going to the base page http://app.fieldwire.com/ right after the Create Account button is pushed.
Moreover, user is able to update First Name and/or Last Name under Edit Profile dialog without entering the secondary data.
If the system relies on the data, and it's really important to have it in the system then user should have a proper dialog to finish registration. 
Also, it shouldn't be allowed to update user's profile if any of the required fields is empty.

Steps:

1. Open http://app.fieldwire.com/
2. Click on Create an Account link
3. Fill out all fields and push Create Account button
4. Open http://app.fieldwire.com/ once again

Actual: Home page is displayed. Registration secondary data are not set (see Edit Profile dialog)

Expected: User have to finish registration process (TBD)

3. Privacy Notice document refers to French pages for the US users

Description:
https://www.fieldwire.com/legal/en/privacy_notice.pdf?_ga=2.84413905.916215025.1659390182-478994761.1659338128

Page 6 (last):
```
- Facebook : https://fr-fr.facebook.com/payments_terms/privacy
- LinkedIn : https://fr.linkedin.com/legal/privacy-policy
```
Actual: Links to Facebook and LinkedIn navigate user to French versions

Expected: Links to Facebook and LinkedIn should navigate user to the US versions
```
https://www.facebook.com/payments_terms/privacy
https://www.linkedin.com/legal/privacy-policy
```

### **TEST FRAMEWORK DESCRIPTION**

Tools: Java 11+, Maven, TestNG, Selenium WebDriver 4

Implemented test groups: SMOKE, REGRESSION

Supported browsers: Chrome, Firefox, Edge, Safari, Opera (only local connections)

Selenium Grid is supported to run tests remotely (see methods createDriverForGrid and beforeClassForGrid from BaseTest class)

Retry process: There are 3 attempts to rerun any failed test. See Retried section in TestNG HTML report. It's configurable in RetryAnalyzer class.
There is also another retry process in case of something go wrong in @BeforeMethod (see @Retriable(attempts = 3) in BaseTest class)

Predefined TestNG suites under resources folder:
```
    testng_smoke_Chrome.xml
    testng_smoke_Edge.xml
    testng_smoke_Opera.xml
    testng_regression_Chrome.xml
    testng_regression_Edge.xml
    testng_regression_Opera.xml
```
Multi-thread parameters (tests are not stable if run in more than thread, so it's set 1 thread for now): 

`parallel:methods`

`threadcount: 1`

`dataproviderthreadcount: 1`

`suitethreadpoolsize: 1`

In case of a failure a screentshot will be captured right before closing browser window
Screenshots folder:
```
/target/screenshots/
```

If a test fails due to a known issue then `@KnownIssue` annotation may be used to mark a failed test as expected.

### **CONFIGURE TESTS**

There is `suiteXmlFiles` section in pom.xml to configure what are tests to run 

Examples: 
To run smoke tests in Chrome set `suiteXmlFiles` as
```
<suiteXmlFile>src/main/resources/testng_smoke_Chrome.xml</suiteXmlFile>
```
This is set by default.

To run regression tests in Chrome, Edge and Opera set suiteXmlFiles as
```
    <suiteXmlFile>src/main/resources/testng_regression_Chrome.xml</suiteXmlFile>
    <suiteXmlFile>src/main/resources/testng_regression_Edge.xml</suiteXmlFile>
    <suiteXmlFile>src/main/resources/testng_regression_Opera.xml</suiteXmlFile>
```

### **RUN TESTS**

```
mvn clean test
```
To run a particular group (default group is `smoke`):
```
mvn clean test -Dgroups=regression
```

### **TEST REPORT AND LOGS**

Standard TestNG HTML report is available  
```
{projectFolder}\target\surefire-reports\emailable-report.html
```
Full log file stored in `<project>/all.log`