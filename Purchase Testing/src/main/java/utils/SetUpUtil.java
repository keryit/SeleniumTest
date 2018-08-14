package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static utils.Constant.*;


public class SetUpUtil {


    @BeforeClass
    public void setupClass() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        driver.manage().window().maximize();
        driver.get(URL);

    }


    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();

    }

}
