package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutOrderSummary extends BasePage {
    public CheckOutOrderSummary(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By orderDetails = By.xpath("//*[@id=\"center_column\"]/div");
    private By backToOrders = By.xpath("//*[@class=\"cart_navigation exclusive\"]//i[contains(text(), \"Back to orders\")]");


    public WebElement getOrderDetails() {
        return waitForVisibleElement(driver, orderDetails, 30);
    }

    public WebElement getBackToOrdersBtn() {
        return waitForClickable(driver, backToOrders, 30);
    }

    public void clickToBackToOrders() {
        clear(backToOrders);
    }
}
