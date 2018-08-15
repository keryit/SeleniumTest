package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountForm extends BasePage {
    public CreateAccountForm(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private By createForm = By.id("account-creation_form");
    private By titleMr = By.id("uniform-id_gender1");
    private By titleMrs = By.id("uniform-id_gender2");
    private By custFirstNameField = By.id("customer_firstname");
    private By custLastNameFiled = By.id("customer_lastname");
    private By custEmailField = By.id("email");
    private By custPassField = By.id("passwd");
    private By custDayOfBirth = By.id("days");
    private By custMonthOfBirth = By.id("months");
    private By custYearOfBirth = By.id("years");
    private By firstNameField = By.id("firstname");
    private By lastNameField =  By.id("lastname");
    private By companyField = By.id("company");
    private By addressField = By.id("address1");
    private By addressSecondField = By.name("address2");
    private By cityField = By.id("city");
    private By stateList = By.id("id_state");
    private By countryList = By.id("id_country");
    private By postalCodeField = By.id("postcode");
    private By additionalInfoField = By.id("other");
    private By homePhoneField = By.id("phone");
    private By mobilePhoneField = By.id("phone_mobile");
    private By aliasField = By.id("alias");
    private By registerBtn = By.id("submitAccount");
    private By successfullyRegMsg = By.xpath("//p[contains(text(), \"Welcome to your account.\")]");
    private By errorPanel = By.xpath("//li[contains(text(), \"You must register\")]/../..");






    public WebElement getAccountCreationForm() {
        return waitForVisibleElement(driver, createForm , 30);
    }

    public WebElement getTitleMr() {
        return waitForClickable(driver, titleMr , 30);
    }

    public WebElement getTitleMrs() {
        return waitForClickable(driver, titleMrs, 30);
    }

    public WebElement getCustomerFirstNameField() {
        return waitForVisibleElement(driver, custFirstNameField , 30);
    }

    public WebElement getCustomerLastNameField() {
        return waitForVisibleElement(driver,custLastNameFiled , 30);
    }

    public WebElement getCustomerEmailField() {
        return waitForVisibleElement(driver, custEmailField , 30);
    }

    public String getEmailFromField(){
        return waitForVisibleElement(driver, custEmailField,30).getAttribute("value");

    }

    public WebElement getCustomerPasswordField() {
        return waitForVisibleElement(driver, custPassField , 30);
    }

	public WebElement getCustomerDayOfBirth() {
		return waitForVisibleElement(driver, custDayOfBirth,30);
	}
    public WebElement getCustomerMonthOfBirth() {
        return waitForVisibleElement(driver, custMonthOfBirth,30);
    }
    public WebElement getCustomerYearOfBirth() {
        return waitForVisibleElement(driver, custYearOfBirth,30);
    }

    public WebElement getFirstNameField() {
        return waitForVisibleElement(driver,firstNameField , 30);
    }

    public WebElement getLastNameField() {
        return waitForVisibleElement(driver,lastNameField, 30);
    }

    public WebElement getCompanyField() {
        return waitForVisibleElement(driver, companyField , 30);
    }

    public WebElement getAddressField() {
        return waitForVisibleElement(driver,addressField , 30);
    }

    public WebElement getAddressSecondField() {
        return waitForVisibleElement(driver, addressSecondField , 30);
    }

    public WebElement getCity() {
        return waitForVisibleElement(driver, cityField , 30);
    }

    public WebElement getState() {
		return waitForVisibleElement(driver, stateList, 30);
	}

    public WebElement getPostalCodeField() {
        return waitForVisibleElement(driver, postalCodeField , 30);
    }

	public WebElement getCountry() {
		return waitForVisibleElement(driver, countryList, 30);
	}

    public WebElement getAdditionalInfoField() {
        return waitForVisibleElement(driver, additionalInfoField , 30);
    }

    public WebElement getHomePhoneField() {
        return waitForVisibleElement(driver, homePhoneField , 30);
    }

    public WebElement getMobilePhoneField() {
        return waitForVisibleElement(driver, mobilePhoneField , 30);
    }

    public WebElement getAliasField() {
        return waitForVisibleElement(driver, aliasField , 30);
    }

    public WebElement getRegisterBtn() {
        return waitForVisibleElement(driver, registerBtn, 30);
    }

    public WebElement successfullyCreatedAccount() {
        return waitForVisibleElement(driver, successfullyRegMsg , 30);
    }

    public void setCustomerTitleMr() {
        click(titleMr);
    }

    public void setCustomerTitleMrs() {
        click(titleMrs);
    }

    public void setCustomerFirstNameField(String firstName) {
       clear(custFirstNameField);
       writeText(custFirstNameField, firstName);
    }

    public void setCustomerLastNameField(String lastName) {
        clear(custLastNameFiled);
        writeText(custLastNameFiled, lastName);
    }

    public void setCustomerEmailField(String email) {
    clear(custEmailField);
    writeText(custEmailField, email);
    }

    public void setCustomerPasswordField(String password) {
        clear(custPassField);
        writeText(custPassField, password);
    }

    public void selectDayOfBirth(String day){
     selectElementFromDropDown(custDayOfBirth, day);
    }

    public void selectMonthOfBirth(String month) {
       selectElementFromDropDown(custMonthOfBirth, month);
    }

    public void selectYearOfBirth(String year) {
        selectElementFromDropDown(custYearOfBirth, year);
    }

    public void setCompanyField(String company) {
        clear(companyField);
        writeText(companyField, company);
    }

    public void setAddressField(String address) {
        clear(addressField);
        writeText(addressField, address);
    }

    public void setAddressSecondField(String secondAddress) {
        clear(addressSecondField);
        writeText(addressSecondField, secondAddress);
    }

    public void setCityField(String city) {
        clear(cityField);
        writeText(cityField, city);
    }

    public void selectState(String state) {
        selectElementFromDropDown(stateList, state);
    }

    public void setPostalCodeField(String zip) {
        clear(postalCodeField);
        writeText(postalCodeField, zip);
    }

    public void selectCountry(String country) {
        selectElementFromDropDown(countryList, country);
    }

    public void setAdditionalInfo(String info) {
      clear(additionalInfoField);
      writeText(additionalInfoField, info );
    }

    public void setHomePhoneField(String phone) {
       clear(homePhoneField);
       writeText(homePhoneField, phone);
    }

    public void setMobilePhoneField(String phone) {
        clear(mobilePhoneField);
        writeText(mobilePhoneField, phone);
    }

    public void setAddressAliasField(String alias) {
        clear(aliasField);
        writeText(aliasField, alias);
    }

    public WebElement getErrorPanel() {

        return waitForVisibleElement(driver, errorPanel , 30);
    }



















}
