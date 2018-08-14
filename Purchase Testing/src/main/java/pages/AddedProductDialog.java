package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddedProductDialog extends BasePage {
    public AddedProductDialog(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    private By successAddedMessage = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[1]/h2");
    private By btnContinueShopping = By.xpath("//span[@title=\"Continue shopping\"]");
    private By btnProceedCheckout = By.xpath("//span[contains(text(), \"Proceed to checkout\")]");


    public String getSuccessAddedMessage() {

        return getMessage(successAddedMessage);
    }

    public WebElement getContinueShoppingBtn() {

        return waitForClickable(driver, btnContinueShopping, 30);
    }

    public WebElement getProceedBtn() {

        return waitForClickable(driver, btnProceedCheckout, 30);
    }

    public void clickProceedBtn() {
        click(btnProceedCheckout);
    }

    public void clickContinueShopping() {
        click(btnContinueShopping);
    }


}
