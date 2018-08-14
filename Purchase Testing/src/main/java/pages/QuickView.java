package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuickView extends BasePage {


    public QuickView(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }


    private By btnAddToCart = By.xpath("//*[@id=\"center_column\"]/ul/li//span[contains(text(), \"Add to cart\")]");
    private By btnMore = By.xpath("//*[@id=\"center_column\"]/ul/li//span[contains(text(), \"More\")]");


    public WebElement getAddToCartBtn() {
        return waitForVisibleElement(driver, btnAddToCart, 30);
    }

    public WebElement getMoreBtn() {
        return waitForVisibleElement(driver, btnMore, 30);
    }


}
