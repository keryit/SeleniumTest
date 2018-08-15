package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutShipping extends BasePage {
    public CheckoutShipping(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By termsCheckBox = By.id("uniform-cgv");
    private By proceedBtn = By.xpath("//*[@id=\"form\"]/p/button//span[contains(text(), \"Proceed to checkout\")]");
    private By continueShoppingBtn = By.xpath("//*[@id=\"form\"]/p/a//span[contains(text(), \"Continue shopping\")]");


    public WebElement getAgreeTermsCheckBox() {
        return waitForClickable(driver, termsCheckBox, 30);
    }

    public WebElement getProceedBtn() {
        return waitForClickable(driver, proceedBtn, 30);
    }

    public WebElement getContinueShoppingBtn() {
        return waitForClickable(driver, continueShoppingBtn, 30);
    }

    public void setAgreeCheckBox() {
        click(termsCheckBox);
    }

    public void clickProceedBtn() {
        click(proceedBtn);
    }

    public void clickContinueShoppingBtn() {
        click(continueShoppingBtn);
    }


}
