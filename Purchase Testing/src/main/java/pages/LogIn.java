package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogIn extends BasePage {

    public LogIn(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By signInForm = By.id("login_form");
    private By emailField = By.id("email");
    private By passField = By.id("passwd");
    private By signInBtn = By.id("SubmitLogin");
    private By emaiReqErr = By.xpath("//li[contains(text(), \"An email address required.\")]");
    private By emailInvalidErr = By.xpath("//li[contains(text(), \"Invalid email address.\")]");
    private By loginErr = By.xpath("//li[contains(text(), \"Authentication failed.\")]");
    private By wrongPassErr = By.xpath("//li[contains(text(), \"Password is required.\")]");
    private By invakidPass = By.xpath("//li[contains(text(), \"Invalid password\")]");
    private By highlightRed = By.xpath("//div[@class=\"form-group form-error\"]//input[@id=\"email\"]");
    private By highlightGreen = By.xpath("//div[@class=\"form-group form-ok\"]//input[@id=\"email\"]");


    public WebElement getSignInForm() {
        return waitForVisibleElement(driver, signInForm , 30);
    }

    public WebElement getSignInEmailField() {
        return waitForVisibleElement(driver, emailField, 30);
    }

    public WebElement getSignInPasswordField() {
        return waitForVisibleElement(driver, passField , 30);
    }

    public WebElement getSignInBtn() {
        return waitForVisibleElement(driver, signInBtn, 30);
    }


    public void setEmailField(String email) {
       clear(emailField);
       writeText(emailField, email);
    }

    public void setPasswordField(String pass) {
       clear(passField);
       writeText(passField, pass);
    }

    public void clickSignInBtn(){
        click(signInBtn);
    }


    public WebElement getEmailRequiredError() {
        return waitForVisibleElement(driver, emaiReqErr, 30);
    }

    public WebElement getEmailInvalidError() {
        return waitForVisibleElement(driver, emailInvalidErr, 30);
    }

    public WebElement getAuthenticationFailedError() {
        return waitForVisibleElement(driver, loginErr, 30);
    }
    public WebElement getPasswordRequiredError() {
        return waitForVisibleElement(driver, wrongPassErr , 30);
    }

    public WebElement getInvalidPasswordError() {
        return waitForVisibleElement(driver, invakidPass, 30);
    }


    public WebElement getEmailHighlighRed() {
        return waitForVisibleElement(driver, highlightRed , 30);
    }

    public WebElement getEmailHighlightedGreen() {
        return waitForVisibleElement(driver, highlightGreen, 30);
    }
}
