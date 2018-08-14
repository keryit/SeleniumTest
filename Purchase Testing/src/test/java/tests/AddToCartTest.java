package tests;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagehelpers.SearchHelper;
import pages.*;
import utils.SetUpUtil;

import static utils.Constant.driver;
import static utils.Constant.wait;


public class AddToCartTest extends SetUpUtil {

    private SearchHelper search;
    private ProductImage product;
    private QuickView quickView;
    private AddedProductDialog dialog;
    private Actions action;
    private CheckOutSummary summary;
    private CreateAccountEmail createAccount;
    private CreateAccountForm createAccountForm;


    @Test(priority = 0, description = "Add to Cart as new User but with wrong State")

    public void addToCartAndPurchaseWithWrongParams() {
        quickView = new QuickView(driver, wait);
        action = new Actions(driver);
        search = new SearchHelper(driver, wait);
        product = new ProductImage(driver, wait);
        dialog = new AddedProductDialog(driver, wait);
        summary = new CheckOutSummary(driver, wait);
        createAccount = new CreateAccountEmail(driver, wait);
        createAccountForm = new CreateAccountForm(driver, wait);


        search.getSearchField().sendKeys("dress");
        search.getBtnSearch().click();
        action.moveToElement(product.getArticleFromThePage(1)).perform();
        action.moveToElement(quickView.getAddToCartBtn()).perform();
        Assert.assertTrue(quickView.getAddToCartBtn().isDisplayed());
        action.click(quickView.getAddToCartBtn()).build().perform();

        Assert.assertTrue(true, dialog.getSuccessAddedMessage());

        dialog.getProceedBtn().click();
        Assert.assertEquals(summary.getUnitPrice().getText(), "$28.98");


        summary.getQtyPlusBtn().click();
        summary.getProceedBtn().click();
        createAccount.setEmailField("abc@xyz.com");
        Assert.assertNotNull(createAccount.getErrorExistingUser().getText());
        createAccount.setEmailField("dron4@gmail.com");
        createAccount.getCreateAccountBtn().click();
        createAccountForm.setCustomerTitleMr();
        createAccountForm.setCustomerFirstNameField("Adam");
        createAccountForm.setCustomerLastNameField("Buelot");
        createAccountForm.setCustomerPasswordField("12345");
        createAccountForm.selectDayOfBirth("21");
        createAccountForm.selectMonthOfBirth("5");
        createAccountForm.selectYearOfBirth("1999");
        createAccountForm.setCompanyField("myCompany");
        createAccountForm.setAddressField("str Pochainicka");
        createAccountForm.setCityField("London");
        createAccountForm.selectState("22222");
        createAccountForm.setPostalCodeField("02807");
        createAccountForm.setAdditionalInfo("add info");
        createAccountForm.setMobilePhoneField("12345678");
        createAccountForm.getRegisterBtn().click();

    }


        @Test (priority = 1, description = "Add to Cart as Registered user with correct params")

                public void addToCartSucceededPurchase(){

        }


















}
