package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountEmail extends BasePage {
    public CreateAccountEmail(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By accountForm = By.id("create-account_form");
    private By emailField = By.id("email_create");
    private By createAcountBtn = By.xpath("//button[@id=\"SubmitCreate\"]");
    private By errorExistingUser = By.id("create_account_error");
    private By invalidEmailError = By.xpath("//li[contains(text(), \"Invalid email address.\")]");


    public WebElement getCreateAccountForm() {
        return waitForVisibleElement(driver, accountForm, 30);
    }

    public WebElement getEmailField() {
        return waitForVisibleElement(driver, emailField, 30);
    }

    public WebElement getCreateAccountBtn() {
        return waitForVisibleElement(driver, createAcountBtn, 30);
    }

    public WebElement getErrorExistingUser() {
        return waitForVisibleElement(driver, errorExistingUser, 30);
    }

    public WebElement getEmailErrorMessage() {
        return waitForVisibleElement(driver, invalidEmailError, 30);
    }

    public void setEmailField(String email) {
        clear(emailField);
        writeText(emailField, email);

    }

    public void clickCreateAccountBtn() {
        clear(createAcountBtn);
    }

}
