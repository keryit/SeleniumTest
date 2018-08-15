package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Constant {

    public static final String URL = "http://automationpractice.com";
    public static final String currentDir = System.getProperty("user.dir");
    public static final String excelFileName = "testData.xlsx";
    public static final String excelPath = currentDir + File.separator + "src" + File.separator + "main" +
            File.separator + "resources";
    public static final String exelSheetSearchNegative = "SearchNegativeValue";
    public static final String excelSheetSearchPositive = "SearchPositiveValue";
    public static final String excelSheetNameSetUserInfo = "BuyAsNewUser";
    public static WebDriver driver;
    public static WebDriverWait wait;

}
