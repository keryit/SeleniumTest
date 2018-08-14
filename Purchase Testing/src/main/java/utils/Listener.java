package utils;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static utils.Constant.currentDir;
import static utils.Constant.driver;


public class Listener extends TestListenerAdapter {


    public static final Logger LOG = LogManager.getLogger(Listener.class);


    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }


    @Override
    public void onTestFailure(ITestResult result) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        String methodName = result.getName();
        if (!result.isSuccess()) {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String reportDirectory = currentDir + File.separator + "target" + File.separator + "surefire-reports";
                File destFile = new File((String) reportDirectory + File.separator + "failure_screenshots" +
                        File.separator + methodName + "_" + formater.format(calendar.getTime()) + ".png");
                FileUtils.copyFile(scrFile, destFile);
                LOG.info("Screenshot for " + result.getName() + " saved in: " + destFile.getAbsolutePath());
                Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override

    public void onStart(ITestContext arg0) {

        System.out.println("Start Of Execution(TEST)----------------> " + arg0.getName());

    }

    @Override

    public void onTestStart(ITestResult arg0) {

        System.out.println("Test Started ------------> " + arg0.getName());

    }

    @Override

    public void onTestSuccess(ITestResult arg0) {

        System.out.println("Test Passed ----------------> " + arg0.getName());

    }


    @Override

    public void onTestSkipped(ITestResult arg0) {

        System.out.println("Test Skipped --------------------> " + arg0.getName());

    }

    @Override

    public void onFinish(ITestContext arg0) {

        System.out.println("END Of Execution(TEST)--------------------> " + arg0.getName());

    }

    @Override

    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {

        // TODO Auto-generated method stub


    }


}
