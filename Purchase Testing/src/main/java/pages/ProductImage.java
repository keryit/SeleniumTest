package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductImage extends BasePage {


    public ProductImage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getArticleFromThePage(int dressNum) {

        return driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[" + dressNum + "]"));
    }
}
