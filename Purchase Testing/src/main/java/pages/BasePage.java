package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import utils.Listener;

import java.util.List;


@Listeners({Listener.class})

public class BasePage {


    protected WebDriver driver;
    protected WebDriverWait wait;


    //Constructor
    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }


    //Click Method
    protected void click(By elementLocation) {

        waitForClickable(driver, elementLocation, 30).click();
        Listener.LOG.info("Click by locator successfully: " + elementLocation);


    }

    //Write Text
    protected void writeText(By elementLocation, String text) {
        Listener.LOG.info("Writing a text--: " + text + " --to the field " + elementLocation);
        waitForVisibleElement(driver, elementLocation, 30).sendKeys(text);
        Listener.LOG.info("Text entered successfully...: " + text);

    }

    //Read Text
    protected String readText(By elementLocation) {
        Listener.LOG.info("Trying read text from -- " + elementLocation);
        return waitForVisibleElement(driver, elementLocation, 30).getText();


    }

    //Clear text
    protected void clear(By elementLocation) {

        waitForVisibleElement(driver, elementLocation, 30).clear();
        Listener.LOG.info("Field -- " + elementLocation + " -- is cleared.");
    }

    //select from the list
    protected void selectElementFromDropDown(By elementLocation, String value) {
        Listener.LOG.info("Trying to select element -- " + elementLocation + " -- from the list");
        Select select = new Select(driver.findElement(elementLocation));
        select.selectByValue(value);
        Listener.LOG.info("Element is selected from the list:-- " + elementLocation);
    }


    //is element present on the page
    protected boolean isElementPresent(By elementLocation) {
        Listener.LOG.info("Trying to find element-- " + elementLocation);

        try {
            driver.findElement(elementLocation);

        } catch (NoSuchElementException e) {
            System.out.println("No such element on the page");
            return false;
        }
        return true;
    }

    protected static WebElement waitForClickable(WebDriver driver, By selector, int waitInterval) {
        return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.elementToBeClickable(selector));
    }

    protected static WebElement waitForVisibleElement(WebDriver driver, By selector, int waitInterval) {
        return (new WebDriverWait(driver, waitInterval)).until(ExpectedConditions.presenceOfElementLocated(selector));
    }

    //get all elements
    protected List getAllElements(By elementLocation) {
        Listener.LOG.info("Getting all elements-- " + elementLocation);
        return driver.findElements(elementLocation);

    }

    //verify messages
    protected String getMessage(By elementLocation) {
        Listener.LOG.info("Getting message from-- " + elementLocation);
        String actual = "";
        if (isElementPresent(elementLocation))
            actual = driver.findElement(elementLocation).getText();
        return actual;

    }


}
