package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;

public class RegisterPageInvalidDataTest extends BaseTest {

  @BeforeClass
  public void accSetUp() throws URISyntaxException, InterruptedException {
    registerPage = loginPage.navigate();
    registerPage.addUserEmail(prop.getProperty("userEmail"), prop.getProperty("domain"));
    registerInvalidData = loginPage.logoImage();
  }

  @DataProvider
  public Object[][] getUserExcelData() {
    return ExcelUtil.inValidDataSheet(AppConstants.PERSONAL_REGISTER_DATA_SHEET_NAME);
  }

  @Test(dataProvider = "getUserExcelData", priority = 1)
  public void profile(
      String firstName,
      String lastName,
      String titleText,
      String dob,
      String phoneNumber,
      String firstNameValidation,
      String lastNameValidation,
      String titleValidation,
      String dobValidation,
      String phoneNumberValidation)
      throws InterruptedException {
    registerInvalidData.personInformationError(
        firstName,
        lastName,
        titleText,
        dob,
        phoneNumber,
        firstNameValidation,
        lastNameValidation,
        titleValidation,
        dobValidation,
        phoneNumberValidation);
  }

  @DataProvider
  public Object[][] qaBusniess() {
    return ExcelUtil.inValidDataSheet(AppConstants.BUSINESS_INFORMATION_DATA);
  }

  @Test(dataProvider = "qaBusniess", priority = 2)
  public void BusinessInformation(
      String registrationNumber,
      String countryName,
      String taxNumber,
      String amountOfEmployee,
      String corporateType,
      String capitalAmount,
      String rgNumberValidation,
      String countryValidation,
      String taxNumberValidation,
      String employeeValidation,
      String corporateValidation)
      throws InterruptedException {
    registerInvalidData.fillBusinessInformationError(
        registrationNumber,
        countryName,
        taxNumber,
        amountOfEmployee,
        corporateType,
        capitalAmount,
        rgNumberValidation,
        countryValidation,
        taxNumberValidation,
        employeeValidation,
        corporateValidation);
  }

  @DataProvider
  public Object[][] address() {
    return ExcelUtil.inValidDataSheet(AppConstants.BUSINESS_ADDRESS_INFORMATION_DATA);
  }

  @Test(dataProvider = "address", priority = 3)
  public void BusinessAddress(
      String street,
      String streetNumber,
      String city,
      String countryName,
      String streetValidation,
      String streetNumberValidation,
      String cityValidation,
      String countryValidation)
      throws InterruptedException {
    registerInvalidData.businessAddressError(
        street,
        streetNumber,
        city,
        countryName,
        streetValidation,
        streetNumberValidation,
        cityValidation,
        countryValidation);
  }

  @DataProvider
  public Object[][] ubo() {
    return ExcelUtil.inValidDataSheet(AppConstants.UBO_INFORMATION_DATA);
  }

  @Test(dataProvider = "ubo", priority = 4)
  public void uboAddress(
      String countryName,
      String uboIdentityNumber,
      String uboAddress,
      String uboPercentage,
      String countyValidation,
      String uboNoValidation,
      String uboAddressValidation,
      String uboPercentageValidation,
      String directorsValidation)
      throws InterruptedException {
    registerInvalidData.uboValidationError(
        countryName,
        uboIdentityNumber,
        uboAddress,
        uboPercentage,
        countyValidation,
        uboNoValidation,
        uboAddressValidation,
        uboPercentageValidation,
        directorsValidation);
  }

  @DataProvider
  public Object[][] directors() {
    return ExcelUtil.inValidDataSheet(AppConstants.DIRECTORS_INFORMATION_DATA);
  }

  @Test(dataProvider = "directors", priority = 5)
  public void directorsAddress(
      String countryName,
      String directorIdentityNumber,
      String addressOfResidence,
      String countyValidation,
      String directorINoValidation,
      String directorAddressValidation)
      throws InterruptedException {
    registerInvalidData.directorsValidationError(
        countryName,
        directorIdentityNumber,
        addressOfResidence,
        countyValidation,
        directorINoValidation,
        directorAddressValidation);
  }

  @DataProvider
  public Object[][] contacts() {
    return ExcelUtil.inValidDataSheet(AppConstants.CONTACTS_INFORMATION_DATA);
  }

  @Test(dataProvider = "contacts", priority = 6)
  public void contactsDetails(
      String firstname,
      String lastName,
      String email,
      String phoneNumber,
      String legalNameValidation,
      String lastNameValidation,
      String emailValidation,
      String phoneNumberValidation)
      throws InterruptedException {
    registerInvalidData.contactsValidationError(
        firstname,
        lastName,
        email,
        phoneNumber,
        legalNameValidation,
        lastNameValidation,
        emailValidation,
        phoneNumberValidation);
  }

  @DataProvider
  public Object[][] banking() {
    return ExcelUtil.inValidDataSheet(AppConstants.BANKING_DETAILS_INFORMATION_DATA);
  }

  @Test(dataProvider = "banking", priority = 7)
  public void bankingDetails(
      String cardholderName,
      String residentAddress,
      String accountNumber,
      String SWIFTCode,
      String bankName,
      String bankAddress,
      String accountCurrency,
      String cardholderNameValidation,
      String residentAddressValidation,
      String accountNumberValidation,
      String SWIFTCodeValidation,
      String bankNameValidation,
      String bankAddressValidation,
      String accountCurrencyValidation)
      throws InterruptedException {
    registerInvalidData.bankingValidationError(
        cardholderName,
        residentAddress,
        accountNumber,
        SWIFTCode,
        bankName,
        bankAddress,
        accountCurrency,
        cardholderNameValidation,
        residentAddressValidation,
        accountNumberValidation,
        SWIFTCodeValidation,
        bankNameValidation,
        bankAddressValidation,
        accountCurrencyValidation);
  }

  @DataProvider
  public Object[][] storeInfo() {
    return ExcelUtil.inValidDataSheet(AppConstants.STORE_INFORMATION_DATA);
  }

  @Test(dataProvider = "storeInfo", priority = 7)
  public void storeInfoDetails(
      String websiteUrl,
      String descriptor,
      String industry,
      String products,
      String establishedDate,
      String websiteUrlValidation,
      String descriptorValidation,
      String industryValidation,
      String productsValidation,
      String establishedDateValidation)
      throws InterruptedException {
    registerInvalidData.StoreInfoValidationError(
        websiteUrl,
        descriptor,
        industry,
        products,
        establishedDate,
        websiteUrlValidation,
        descriptorValidation,
        industryValidation,
        productsValidation,
        establishedDateValidation);
  }

  @DataProvider
  public Object[][] websiteBasic() {
    return ExcelUtil.inValidDataSheet(AppConstants.WEBSITE_BASICS_INFORMATION_DATA);
  }

  @Test(dataProvider = "websiteBasic", priority = 8)
  public void websiteBasicDetails(
      String websiteUrl,
      String returnAddress,
      String productQuantity,
      String productDescription,
      String productPrice,
      String websiteUrlValidation,
      String returnAddressValidation,
      String productQuantityValidation,
      String productDescriptionValidation,
      String productPriceValidation)
      throws InterruptedException {
    registerInvalidData.WebsiteBasicRequirementValidationError(
        websiteUrl,
        returnAddress,
        productQuantity,
        productDescription,
        productPrice,
        websiteUrlValidation,
        returnAddressValidation,
        productQuantityValidation,
        productDescriptionValidation,
        productPriceValidation);
  }

  @DataProvider
  public Object[][] processing() {
    return ExcelUtil.inValidDataSheet(AppConstants.PROCESSING_INFORMATION_DATA);
  }

  @Test(dataProvider = "processing", priority = 9)
  public void processingDetails(
      String monthSalesVolume,
      String monthNumberTransactions,
      String ticketAmount,
      String category,
      String salesVolumeValidation,
      String monthNumberTransactionsValidation,
      String ticketAmountValidation,
      String categoryValidation)
      throws InterruptedException {
    registerInvalidData.ProcessingDetailsValidationError(
        monthSalesVolume,
        monthNumberTransactions,
        ticketAmount,
        category,
        salesVolumeValidation,
        monthNumberTransactionsValidation,
        ticketAmountValidation,
        categoryValidation);
  }

  @Test(priority = 10)
  public void companyDocuments() throws InterruptedException {
    String relativeFilePath = "./src/test/resources/testdata/passportImg.jpg";
    String absoluteFilePath = new File(relativeFilePath).getAbsolutePath();
    registerInvalidData.companyDocuments(absoluteFilePath);
  }
}
