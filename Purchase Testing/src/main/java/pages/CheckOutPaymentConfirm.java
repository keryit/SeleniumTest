package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPaymentConfirm extends BasePage {
    public CheckOutPaymentConfirm(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By confirmOrder = By.xpath("//*[@id=\"cart_navigation\"]/button//span[contains(text(), \"I confirm my order\")]");
    private By otherPaymentMethods = By.xpath("//*[@id=\"cart_navigation\"]/a[contains(text(), \"Other payment methods\")]");
    private By shortSummaryOrder = By.id("amount");
    private By orderAfterConfirm = By.xpath("//div[contains(@class,'box')]");
    private By backToOrders = By.xpath("//*[@id=\"center_column\"]/p/a");


    public WebElement getConfirmOrderBtn() {
        return waitForClickable(driver, confirmOrder, 30);
    }

    public WebElement getOtherPaymentMethods() {
        return waitForClickable(driver, otherPaymentMethods, 30);
    }

    public WebElement getShortSummaryOrderMsgBox(){
        return waitForVisibleElement(driver, shortSummaryOrder,30);
    }
    public WebElement getAfterConfirmMsgBox(){
        return waitForVisibleElement(driver,orderAfterConfirm,30);
    }

    public void clickConfirmOrderBtn() {
        click(confirmOrder);
    }

    public void clickOtherPaymentMethods() {
        click(otherPaymentMethods);
    }

    public void clickBackToOrders(){
        click(backToOrders);
    }


}
