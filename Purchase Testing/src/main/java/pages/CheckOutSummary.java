package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutSummary extends BasePage {

    private By btnDelete = By.className("cart_quantity_delete");
    private By unitPrice = By.xpath("//table[@id=\"cart_summary\"]//span[@class=\"price special-price\"]");
    private By qntValue = By.xpath("//table[@id='cart_summary']//input[@type='text']");
    private By qtyPlus = By.xpath("//table[@id=\"cart_summary\"]//a[@title=\"Add\"]");
    private By qtyMinus = By.xpath("//table[@id=\"cart_summary\"]//a[@title=\"Subtract\"]");
    private By totalPrice = By.xpath("//table[@id=\"cart_summary\"]//td[@data-title=\"Total\"]/span[@class=\"price\"]");
    private By totalProductPrice = By.id("total_product");
    private By totalShipping = By.id("total_shipping");
    private By withoutTax = By.id("total_price_without_tax");
    private By total = By.id("total_price");
    private By emptyCartMsg = By.xpath("//p[contains(text(), \"Your shopping cart is empty.\")]");
    private By proceedBtn = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]//span[contains(text(), \"Proceed to checkout\")]");
    private By contShoppingBtn = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]//span[contains(text(), \"Continue shopping\")]");


    public CheckOutSummary(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getDeleteBtn() {
        return waitForClickable(driver, btnDelete, 30);
    }

    public WebElement getUnitPrice() {

        return waitForVisibleElement(driver, unitPrice, 30);
    }

    public WebElement getQtyValue() {

        return waitForVisibleElement(driver, qntValue, 30);
    }

    public WebElement getQtyPlusBtn() {

        return waitForClickable(driver, qtyPlus, 30);
    }

    public WebElement qetQtyMinusBtn() {
        return waitForClickable(driver, qtyMinus, 30);
    }

    public WebElement getTotalWithoutShipping() {
        return waitForVisibleElement(driver, totalPrice, 30);
    }


    public WebElement getTotalProductsPrice() {
        return waitForVisibleElement(driver, totalProductPrice, 30);
    }

    public WebElement getTotalShippingPrice() {
        return waitForVisibleElement(driver, totalShipping, 30);
    }

    public WebElement getWithoutTaxPrice() {
        return waitForVisibleElement(driver, withoutTax, 30);
    }

    public WebElement getTotalPrice() {
        return waitForVisibleElement(driver, total, 30);
    }

    public WebElement getCartEmptyMessage() {
        return waitForVisibleElement(driver, emptyCartMsg, 30);
    }

    public WebElement getProceedBtn() {
        return waitForClickable(driver, proceedBtn, 30);
    }

    public WebElement getContinueShoppingBtn() {
        return waitForClickable(driver, contShoppingBtn, 30);
    }

    public void clickPlusQuantityBtn() {
        click(qtyPlus);
    }

    public void clickMinusQuantityBtn() {
        click(qtyMinus);
    }

    public void clickProceedBtn() {
        click(proceedBtn);
    }

    public void clickContinueShoppingBtn() {
        click(contShoppingBtn);
    }

    public void clickDeleteProductBtn(){
        click(btnDelete);
    }

}
