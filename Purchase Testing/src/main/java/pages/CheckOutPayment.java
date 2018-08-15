package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPayment extends BasePage {
    public CheckOutPayment(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By payByBankWire = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
    private By payByCheck = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a");
    private By totalPrice = By.id("total_price_container");
    private By continueShoppingBtn = By.xpath("//*[@id=\"center_column\"]/div/p/a[contains(text(), \"Continue shopping\")]");


    public WebElement getPayByBankWire() {
        return waitForClickable(driver, payByBankWire, 30);
    }

    public WebElement getPayByCheck() {
        return waitForClickable(driver, payByCheck, 30);
    }

    public WebElement getContinueShoppingBtn() {
        return waitForClickable(driver, continueShoppingBtn, 30);
    }

    public WebElement getTotalPrice(){
        return waitForVisibleElement(driver,totalPrice,30);
    }
    public void clickPayByBank() {
        click(payByBankWire);
    }

    public void clickPayByCheck() {
        click(payByCheck);
    }

    public void clickContinue() {
        click(continueShoppingBtn);
    }


}
