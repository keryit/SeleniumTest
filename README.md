# PurchaseTestSelenium
Test framework Selenium + Maven project + testNG for creating and running tests + ReportNG for reporting
                        + DDT model for keeping data for tests(searching and purchase workflow)

## Prerequisites

You need to install these software to run tests.

    Java JDK version 8 installed
    Maven installed
    git installed
    Latest Chrome installed

**Getting Started**

First you need to download the project. And then generate source code from models:

git clone https://github.com/keryit/SeleniumTest.git

Then you can open project using any ide.


 ## Running the tests

You can run test using maven from command line:

   cd SeleniumTest
   mvn clean tests

Or from any ide run TestNG suite:

![img](https://github.com/keryit/SeleniumTest/blob/master/img/runTestNg.png)


   ## How to create/change Tests

   You can change data in excel file

   Excel with data contains data just for 3 tests (located in /src/mai/resources/testData.xlsx

   1. Searching with wrong parameters

   excel sheet "SearchNegativeValue"

   SearchTest.class (/src/test/java/test)

   Test using "for loop" to get all values from excel and trying to search

   Also test get from excel expected result and compare with actual result which get from the web pages

   Than writes actual result to Excel

   If test case passed it writes status to the EXCEL as "PASSED" and "FAILED" if test failed

   2.Searching with correct value and verify returned dresses

   excel sheet "SearchPositiveValue"

   3. Select a product, add to cart and buy as new User

   excel sheet "BuyAsNewUser"

   contains all info about user and some expected result such as name, price, address



## Reporting and Logging

After each step you can see log.info in console something like:

    Test Started ------------> searchWithEmpty
    2018-08-14 23:39:40 INFO  Listener:62 - Field -- By.id: search_query_top -- is cleared.
    2018-08-14 23:39:40 INFO  Listener:44 - Writing a text--:  --to the field By.id: search_query_top
    2018-08-14 23:39:40 INFO  Listener:46 - Text entered successfully...:
    2018-08-14 23:39:41 INFO  Listener:37 - Click by locator successfully: By.name: submit_search
    2018-08-14 23:39:41 INFO  Listener:105 - Getting message from-- By.className: alert-warning



also it creates html report in **{user_dir}/test-output**

![img](https://github.com/keryit/SeleniumTest/blob/master/img/report.png)


Snapshots you can find **target/surefire-reports/failure_screenshots**


 ## About structure

![img](https://github.com/keryit/SeleniumTest/blob/master/img/structure.png)


**src/main/java/**


 **BasePage.class**
  this class contains all common methods - click();, writeText();, selectFromTheList();, wait();, and etc

  **utils package:**  

   *Listener.class*
  contains methods for logging and for taking a screenshot
  it listens the BasePage.class

  *Constant.class*
  contains all constants which uses (driver, user directory path, excel name, excel sheet name...) 

  *SetUpUtil.class*
  Just setup @BeforeClass- setup browser driver and @AfterClass quit from browser and delete cookies

   *ExcelUtil.class*
  reads and writs data to excel file


  **package pages:**
  contains all classes-pages which needs to testing


  **src/main/resources/**

  *log4j.properties*
  creates and writes logs

  *testData.xlsx*
  keeps test cases and data for using in test


  **/src/test/java/**

  **package test**
  contains tests
  You can create new test creating new Class or create new test using annotation @Test

  **pom.xml**
  that contains information about the project and configuration details used by Maven to build the project

  for setup webdriver I use WebDriverManager to manage the WebDriver binaries and keeping the last version, now to setup a browser looks like:

    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    //WebDriverManager.firefoxdriver().setup();
    //WebDriverManager.operadriver().setup();

   No need keeping binary file into your Java source code.
   The documentation see https://github.com/bonigarcia/webdrivermanager





