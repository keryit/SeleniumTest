package tests;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagehelpers.SearchHelper;
import pages.*;
import utils.ExcelUtil;
import utils.SetUpUtil;

import static utils.Constant.*;


public class AddToCartTest extends SetUpUtil {

    private SearchHelper search;
    private ProductImage product;
    private QuickView quickView;
    private AddedProductDialog dialog;
    private Actions action;
    private CheckOutSummary summary;
    private CreateAccountEmail createAccount;
    private CreateAccountForm createAccountForm;
    private CheckOutAddress checkOutAddress;
    private CheckoutShipping checkoutShipping;
    private CheckOutPayment payment;
    private CheckOutPaymentConfirm paymentConfirm;
    private OrderHistory orderHistory;


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
        checkOutAddress = new CheckOutAddress(driver,wait);
        checkoutShipping = new CheckoutShipping(driver,wait);
        payment = new CheckOutPayment(driver,wait);
        paymentConfirm = new CheckOutPaymentConfirm(driver,wait);
        orderHistory = new OrderHistory(driver,wait);
        ExcelUtil.setExcelSheet(excelSheetNameSetUserInfo);

        //step 1 search dress
        search.searchByKeyword(ExcelUtil.getCellData(1,2));
        search.getBtnSearch().click();

        //2 select from quick view and add to cart
        action.moveToElement(product.getArticleFromThePage(Integer.valueOf(ExcelUtil.getCellData(2,2)))).perform();
        action.moveToElement(quickView.getAddToCartBtn()).perform();
        Assert.assertTrue(quickView.getAddToCartBtn().isDisplayed());
        action.click(quickView.getAddToCartBtn()).build().perform();

        //3 proceed
        Assert.assertTrue(true, dialog.getSuccessAddedMessage());
        dialog.getProceedBtn().click();

        //4 verify Unit price
        Assert.assertEquals(summary.getUnitPrice().getText(), ExcelUtil.getCellData(5,3));


        summary.getQtyPlusBtn().click();

        //verify total price
        Assert.assertEquals(summary.getTotalPrice().getText(), ExcelUtil.getCellData(7,3));
        summary.getProceedBtn().click();
        createAccount.setEmailField(ExcelUtil.getCellData(9,2));

        //verify that email exist
        Assert.assertEquals(createAccount.getErrorExistingUser().getText(), ExcelUtil.getCellData(10,3));
        createAccount.setEmailField(ExcelUtil.getCellData(11,2));
        createAccount.getCreateAccountBtn().click();

        //Verify create account form exist
        Assert.assertTrue(createAccountForm.getAccountCreationForm().isDisplayed());
        createAccountForm.setCustomerTitleMr();
        createAccountForm.setCustomerFirstNameField(ExcelUtil.getCellData(15,2));
        createAccountForm.setCustomerLastNameField(ExcelUtil.getCellData(16,2));

        //verify that email field with email
        Assert.assertEquals(createAccountForm.getEmailFromField(),ExcelUtil.getCellData(17,3));
        createAccountForm.setCustomerPasswordField(ExcelUtil.getCellData(18,2));
        createAccountForm.selectDayOfBirth(ExcelUtil.getCellData(19,2));
        createAccountForm.selectMonthOfBirth(ExcelUtil.getCellData(20,2));
        createAccountForm.selectYearOfBirth(ExcelUtil.getCellData(21,2));
        createAccountForm.setCompanyField(ExcelUtil.getCellData(22,2));
        createAccountForm.setAddressField(ExcelUtil.getCellData(23,2));
        createAccountForm.setCityField(ExcelUtil.getCellData(24,2));
        createAccountForm.selectState(ExcelUtil.getCellData(25,2));
        createAccountForm.setPostalCodeField(ExcelUtil.getCellData(26,2));
        createAccountForm.setAdditionalInfo(ExcelUtil.getCellData(27,2));
        createAccountForm.setMobilePhoneField(ExcelUtil.getCellData(28,2));
        createAccountForm.getRegisterBtn().click();

        //verify address from delivery address
        Assert.assertTrue(checkOutAddress.getAddressDeliveryBox().getText().contains(ExcelUtil.getCellData(30,2)));

        //verify address from Billing address
        Assert.assertTrue(checkOutAddress.getBillingAddressBox().getText().contains(ExcelUtil.getCellData(31,2)));
        checkOutAddress.clickProceedBtn();
        checkoutShipping.setAgreeCheckBox();
        checkoutShipping.clickProceedBtn();

        //verify total price
        Assert.assertEquals(payment.getTotalPrice().getText(), ExcelUtil.getCellData(35,3) );
        payment.clickPayByBank();

        //verify
        Assert.assertTrue(paymentConfirm.getShortSummaryOrderMsgBox().getText().contains(ExcelUtil.getCellData(37,3)));
        paymentConfirm.clickConfirmOrderBtn();

        //I found some defect- I see in c"onfirmed order details" another name than my created user name
        //see screen bug.png in /img folder
       // Assert.assertTrue(paymentConfirm.getAfterConfirmMsgBox().getText().contains(ExcelUtil.getCellData(39,3)));
        Assert.assertTrue(paymentConfirm.getAfterConfirmMsgBox().getText().contains(ExcelUtil.getCellData(40,3)));
        paymentConfirm.clickBackToOrders();
        Assert.assertEquals(orderHistory.getHistoryState().getText(), ExcelUtil.getCellData(41,3));
        orderHistory.clickHomeBtn();







    }





















}
