package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHistory extends BasePage {
    public OrderHistory(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By price = By.className("history_price");
    private By stateOrder = By.className("history_state");
    private By backToAccount = By.xpath("\"//span[contains(text(), \" Back to your account.\")]\"");
    private By homeBtn = By.xpath("//span[contains(text(), \" Home\")]");



    public WebElement  getPrice(){
        return waitForVisibleElement(driver,price,30);
    }

    public WebElement getHistoryState(){
        return waitForVisibleElement(driver, stateOrder,30);
    }

    public void clickHomeBtn(){
        click(homeBtn);
    }

    public void clickBackToAccountBtn(){
        click(backToAccount);
    }
}
