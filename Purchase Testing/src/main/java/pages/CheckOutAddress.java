package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutAddress extends BasePage {
    public CheckOutAddress(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By addressList = By.id("id_address_delivery");
    private By addressDeliveryBox = By.id("address_delivery");
    private By addressBillingBox = By.id("address_invoice");
    private By idCheckBox = By.id("addressesAreEquals");
    private By updateDeliveryBtn = By.xpath("//*[@id=\"address_delivery\"]/li[8]/a/span");
    private By updateBillingBtn = By.xpath("//*[@id=\"address_invoice\"]/li[8]/a/span");
    private By addNewAddressBtn = By.xpath("//*[@id=\"center_column\"]/form/div/p/a//span[contains(text(), \"Add a new address\")]");
    private By addCommentField = By.xpath("//*[@id=\"ordermsg\"]/textarea");
    private By proceedBtn = By.xpath("//*[@id=\"center_column\"]/form/p/button//span[contains(text(), \"Proceed to checkout\")]");
    private By continueShoppingBtn = By.xpath("//*[@id=\"center_column\"]/form/p/a//span[contains(text(), \"Continue shopping\")]");


    public void selectDeliveryAddress(String address) {
        selectElementFromDropDown(addressList, address);
    }

    public void setAddressSameCheckBox() {
        click(idCheckBox);
    }

    public void clickUpdateDelivery() {
        click(updateDeliveryBtn);
    }

    public void clickUpdateBilling() {
        click(updateBillingBtn);
    }

    public void clickAddNewAddress() {
        click(addNewAddressBtn);
    }

    public void setComment(String text) {
        writeText(addCommentField, text);
    }

    public void clickProceedBtn() {
        click(proceedBtn);
    }

    public void clickContinueShop() {
        click(continueShoppingBtn);
    }

    public WebElement getAddressDeliveryBox(){
        return waitForVisibleElement(driver, addressDeliveryBox, 30);
    }

    public WebElement getBillingAddressBox(){
        return waitForVisibleElement(driver, addressBillingBox,30);
    }

    public WebElement getUseDeliveryAddressCheckBox() {
        return waitForClickable(driver, idCheckBox, 30);
    }

    public WebElement getUpdateDeliveryBtn() {
        return waitForClickable(driver, updateDeliveryBtn, 30);
    }

    public WebElement getUpdateBillingAddressBtn() {
        return waitForClickable(driver, updateBillingBtn, 30);
    }

    public WebElement getAddNewAddressBtn() {
        return waitForClickable(driver, addNewAddressBtn, 30);
    }

    public WebElement getCommentField() {
        return waitForVisibleElement(driver, addCommentField, 30);
    }

    public WebElement getProceedBtn() {
        return waitForClickable(driver, proceedBtn, 30);
    }

    public WebElement getContinueShoppingBtn() {
        return waitForClickable(driver, continueShoppingBtn, 30);
    }
}
