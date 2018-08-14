# PurchaseTestSelenium
Test framework Selenium + Maven + ReportNG (searching and purchase workflow)

**Prerequisites**

You need to install these software to run tests.

    Java JDK version 8 installed
    Maven installed
    git installed
    Latest Chrome installed

Getting Started

First you need to download the project. And then generate source code from models:

git clone https://github.com/keryit/SeleniumTest.git

Then you can open project using ide.


**Running the tests**

You can run test using maven from command line:

>>mvn clean tests

Or run from Ide run TestNG suite:

![img](https://github.com/keryit/SeleniumTest/blob/master/img/runTestNg.png)


**Reporting and Logging**

After each step you can see log.info in console something like:

    Test Started ------------> searchWithEmpty
    2018-08-14 23:39:40 INFO  Listener:62 - Field -- By.id: search_query_top -- is cleared.
    2018-08-14 23:39:40 INFO  Listener:44 - Writing a text--:  --to the field By.id: search_query_top
    2018-08-14 23:39:40 INFO  Listener:46 - Text entered successfully...:
    2018-08-14 23:39:41 INFO  Listener:37 - Click by locator successfully: By.name: submit_search
    2018-08-14 23:39:41 INFO  Listener:105 - Getting message from-- By.className: alert-warning



also it creates html report in target/surefire-reports

![img](https://github.com/keryit/SeleniumTest/blob/master/img/report.png)


Snapshots you can find target/surefire-reports/failure_screenshots