package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.ExcelUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class RegisterPage {
  ElementUtil eleUtil;
  WebDriver driver;
  private final By getInbox = By.cssSelector("[class*='text-center font-medium']");
  private final By userName = By.cssSelector("input[class*=' focus:bg-white']");
  private final By selectDomain = By.cssSelector("[class*='dark:focus:border-primary-500']");
  private final By addInbox = By.cssSelector("[class*='rounded-lg w-full1']");
  private final By noReplyText = By.xpath("(//*[text()='no-reply@ballerin...'])[1]");
  private final By myAccountText = By.xpath("//*[text()='Activate your account']");

  // personal information form element
  public final By logo = By.cssSelector("[role='combobox']");
  private final By language = By.cssSelector("[class*='text-sm outline-none']");
  private final By title = By.cssSelector("input[placeholder*='CEO']");
  private final By dateOfBirth = By.cssSelector("[placeholder*='MM/DD/YYYY']");
  private final By phoneNumberTextBox = By.cssSelector("[type='tel']");
  private final By continueButton = By.cssSelector("[class*='justify-end'] button");

  // Business Information form element
  private final By registrationNumberTextBox = By.name("registration-number-input");
  private final By country = By.cssSelector("[class*='px-2 text-muted-foreground']");
  private final By countryName = By.cssSelector("[data-value='india']");
  private final By taxIdentityNumberTextBox = By.name("tax-identification-number-input");
  private final By amountOfEmployeesTextBox = By.name("number-of-employees-input");
  private final By corporateType = By.cssSelector("[class*='MuiInputBase-formControl']");
  private final By multiSelect = By.cssSelector("[class*='MuiAutocomplete-option']");
  private final By registeredCapitalTextBox = By.name("registered-capital-in-usd-type-input");

  // Business Address form element
  public final By streetTextBox = By.name("street-input");
  public final By streetNumberTextBox = By.name("street-number-input");
  public final By cityTextBox = By.name("city-input");

  // Directors and UBOs elements
  public final By titleOfUBo = By.cssSelector("[class*='grid'] [class*='text-3xl font-bold']");
  public final By checkBox = By.cssSelector("[role='checkbox']");
  public final By checkBoxUBO =
      By.xpath("//span[contains(text(),'25%')]/preceding-sibling::button[@aria-checked='false']");
  public final By checkBoxDirectors =
      By.xpath(
          "//span[contains(text(),'I am a director')]/preceding-sibling::button[@aria-checked='false']");
  public final By countryListTextBox = By.cssSelector("[role*='option']");
  public final By uboIdentityNumberTextBox = By.name("ubos:identity-number-input");
  public final By uboAddressOfResidenceTextBox = By.name("ubos:address-of-residence-input");
  public final By uboOwnershipPercentageTexBox = By.name("ubos:ownership-percentage-input");
  //  private final By directorsFirstNameTexBox = By.name("directors:first-name-input");
  //  private final By directorsLastNameTextBox = By.name("directors:last-name-input");
  public final By directorsIdentityNumberTextBox = By.name("directors:identity-number-input");
  public final By directorsAddressOfResidenceTextBox =
      By.name("directors:address-of-residence-input");
  public final By FileAttache = By.cssSelector("[type='file']");

  // Contacts elements
  public final By contactFirstName = By.name("contact-first-name-input");
  public final By contactLastName = By.name("contact-last-name-input");
  public final By contactEmail = By.name("contact-email-input");

  // Banking Details elements
  public final By cardholderName = By.name("card-holder-name-input");
  public final By residentAddressInput = By.name("resident-address-input");
  public final By accountNumberInput = By.name("account-number-input");
  public final By ibanInput = By.name("iban-input");
  public final By swiftCodeInput = By.name("swift-code-input");
  public final By routeNumberInput = By.name("route-number-input");
  public final By bankNameInput = By.name("bank-name-input");
  public final By bankCodeInput = By.name("bank-code-input");
  public final By bankAddressInput = By.name("bank-address-input");
  public final By bankSubBranchInput = By.name("bank-sub-branch-input");

  // Store Info elements

  public final By storeWebsiteUrlsInput = By.name("store-website-urls-input");
  public final By storeDbaInput = By.name("store-dba-input");
  public final By storeProductsInput = By.name("store-products-input");

  // Website Basic Requirement elements

  public final By mainCompanyWebsiteInput = By.name("main-company-website-input");
  public final By contactDetailsInput = By.name("contact-details-input");
  public final By productQuantityInput = By.name("product-quantity-input");
  public final By productDescriptionInput = By.name("product-description-input");
  public final By productPriceInput = By.name("product-price-input");

  // Processing Details elements

  public final By monthlySalesVolumeInput = By.name("monthly-sales-volume-input");
  public final By monthlyNumberTransactionsInput = By.name("monthly-number-transactions-input");
  public final By averageTicketSalesInput = By.name("average-ticket-sales-input");
  public final By categoryInput = By.cssSelector("[placeholder*='Select more...']");
  public final By monthlyTransactions = By.name("est-monthly-transactions-clipspay-input");

  // form submitted successfully

  public final By successfullyText = By.cssSelector(" img[src*='papers-checked.svg']");
  private final By logoImage = By.xpath("(//img[@alt='Clipspay'])[1]");

  public RegisterPage(WebDriver driver) {
    this.driver = driver;
    eleUtil = new ElementUtil(this.driver);
  }

  public void addUserEmail(String username, String domain)
      throws InterruptedException, URISyntaxException {
    eleUtil.waitForVisibilityOfElement(getInbox, 30);
    eleUtil.doClick(getInbox);
    eleUtil.waitForVisibilityOfElement(userName, 20);

    eleUtil.doSendKeys(userName, username);
    eleUtil.doSelectDropDownByVisibleText(selectDomain, domain);
    eleUtil.waitForVisibilityOfElement(addInbox, 20);
    eleUtil.doClick(addInbox);
    eleUtil.waitForVisibilityOfElement(noReplyText, 30);
    eleUtil.doClick(noReplyText);
    eleUtil.waitForVisibilityOfElement(myAccountText, 10);
    eleUtil.doClick(myAccountText);
    eleUtil.switchToTab(1);
    eleUtil.waitForVisibilityOfElement(logo, 50);
  }

  public void changeChinese() throws URISyntaxException {

    eleUtil.waitForVisibilityOfElement(logo, 10);
    Assert.assertTrue(eleUtil.getElement(logo).getText().contains("English"));
    eleUtil.doClick(logo);
    for (WebElement la : eleUtil.getElements(language)) {
      la.getText();
      if (la.getText().contains("中国人")) {
        la.click();
        break;
      }
    }
    String currentUrl = driver.getCurrentUrl();
    URI uri = new URI(currentUrl);
    String actualLanguage = uri.getQuery().split("&")[1].split("=")[1];
    String expectedLanguage = "cn";

    // Verify that the actual language matches the expected language
    Assert.assertEquals(
        actualLanguage,
        expectedLanguage,
        "Actual language: "
            + actualLanguage
            + " does not match expected language: "
            + expectedLanguage);
  }

  public void clickEnglish() throws InterruptedException, URISyntaxException {
    eleUtil.waitForVisibilityOfElement(logo, 30);
    eleUtil.doClick(logo);
    for (WebElement la : eleUtil.getElements(language)) {
      la.getText();
      if (la.getText().contains("English")) {
        la.click();
        break;
      }
    }
    String currentUrl = driver.getCurrentUrl();
    URI uri = new URI(currentUrl);
    String actualLanguage = uri.getQuery().split("&")[1].split("=")[1];
    String expectedLanguage = "en";
    Assert.assertEquals(
        actualLanguage,
        expectedLanguage,
        "Actual language: "
            + actualLanguage
            + " does not match expected language: "
            + expectedLanguage);
  }

  public void fillPersonalInformation(String firstName, String dob, String phoneNumber) {

    eleUtil
        .waitForVisibilityOfElement(this.title, AppConstants.MEDIUM_DEFAUTT_WAIT)
        .sendKeys(firstName);
    eleUtil.waitForVisibilityOfElement(dateOfBirth, 30);
    eleUtil.doClick(dateOfBirth);
    eleUtil.doClick(dateOfBirth);
    eleUtil.doSendKeys(this.dateOfBirth, dob);
    eleUtil.doSendKeys(this.phoneNumberTextBox, phoneNumber);
    eleUtil.doClick(continueButton);
  }

  public void fillBusinessInformation(
      String registrationNumber,
      String taxNumber,
      String amountOfEmployee,
      String Partnership,
      String capitalAmount)
      throws InterruptedException {
    eleUtil.waitForVisibilityOfElement(registrationNumberTextBox, 30);
    eleUtil.doSendKeys(this.registrationNumberTextBox, registrationNumber);
    eleUtil.doClick(country);
    eleUtil.doClick(countryName);
    eleUtil.doSendKeys(this.taxIdentityNumberTextBox, taxNumber);
    eleUtil.doSendKeys(this.amountOfEmployeesTextBox, amountOfEmployee);
    eleUtil.doClick(corporateType);
    eleUtil.selectDropDownValue(multiSelect, Partnership);
    eleUtil.doSendKeys(this.registeredCapitalTextBox, capitalAmount);
    eleUtil.doClick(continueButton);
  }

  public void fillBusinessAddress(String street, String streetNumber, String city) {
    driver.navigate().refresh();
    eleUtil.clickElementWhenReady(streetNumberTextBox, 30);
    eleUtil.doSendKeys(this.streetTextBox, street);
    eleUtil.doSendKeys(this.streetNumberTextBox, streetNumber);
    eleUtil.doSendKeys(this.cityTextBox, city);
    eleUtil.doClick(country);
    eleUtil.doClick(countryName);
    eleUtil.waitForVisibilityOfElement(continueButton, 20);
    eleUtil.doClick(continueButton);
  }

  public void fillDirectorsAndUBO(
      String countryName,
      int uboIdentityNumber,
      String uboAddress,
      int uboPercentage,
      int directorUbo,
      String absoluteFilePath)
      throws InterruptedException {
    eleUtil.waitForVisibilityOfElement(titleOfUBo, 30);
    Thread.sleep(2000);
    eleUtil.doIndexElementClick(checkBox, 0);
    Thread.sleep(2000);
    eleUtil.doClick(country);
    eleUtil.selectDropDownValue(this.countryListTextBox, countryName);
    eleUtil.clickElementWhenReady(uboIdentityNumberTextBox, 10);
    eleUtil.doSendKeys(this.uboIdentityNumberTextBox, String.valueOf(uboIdentityNumber));
    eleUtil.doSendKeys(this.uboAddressOfResidenceTextBox, uboAddress);
    eleUtil.doSendKeys(this.uboOwnershipPercentageTexBox, String.valueOf(uboPercentage));
    eleUtil.doIndexElementClick(checkBox, 1);
    Thread.sleep(2000);
    eleUtil.doClick(country);
    eleUtil.selectDropDownValue(this.countryListTextBox, countryName);
    eleUtil.doSendKeys(this.directorsIdentityNumberTextBox, String.valueOf(directorUbo));
    eleUtil.doSendKeys(this.directorsAddressOfResidenceTextBox, uboAddress);
    eleUtil.doIndexElementSend(FileAttache, 0, absoluteFilePath);
    Thread.sleep(2000);
    eleUtil.doIndexElementSend(FileAttache, 1, absoluteFilePath);
    eleUtil.doClick(continueButton);
  }

  public void fillContacts(String firstname, String lastname, String email, String phoneNumber) {
    eleUtil.clickElementWhenReady(contactFirstName, 20);
    eleUtil.doSendKeys(contactFirstName, firstname);
    eleUtil.doSendKeys(contactLastName, lastname);
    eleUtil.doSendKeys(contactEmail, email);
    eleUtil.doSendKeys(this.phoneNumberTextBox, phoneNumber);
    eleUtil.doClick(continueButton);
  }

  public void fillBankingDetails(
      String cardholder,
      String residentAddress,
      long accountNumber,
      String iban,
      String swiftCode,
      int routeNumber,
      String bankName,
      String bankCode,
      String bankAddress,
      int SubBranchNumber,
      String accountCurrency) {
    eleUtil.clickElementWhenReady(cardholderName, 30);
    eleUtil.doSendKeys(this.cardholderName, cardholder);
    eleUtil.doSendKeys(this.residentAddressInput, residentAddress);
    eleUtil.doSendKeys(this.accountNumberInput, String.valueOf(accountNumber));
    eleUtil.doSendKeys(this.ibanInput, iban);
    eleUtil.doSendKeys(this.swiftCodeInput, swiftCode);
    eleUtil.doSendKeys(this.routeNumberInput, String.valueOf(routeNumber));
    eleUtil.doSendKeys(this.bankNameInput, bankName);
    eleUtil.doSendKeys(this.bankCodeInput, bankCode);
    eleUtil.doSendKeys(this.bankAddressInput, bankAddress);
    eleUtil.doSendKeys(this.bankSubBranchInput, String.valueOf(SubBranchNumber));
    eleUtil.doClick(country);
    eleUtil.selectDropDownValue(this.countryListTextBox, accountCurrency);
    eleUtil.doClick(continueButton);
  }

  public void fillStoreDetails(
      String websiteUrl, String DBA, String industry, String products, String dob) {
    eleUtil.clickElementWhenReady(storeWebsiteUrlsInput, 30);
    eleUtil.doSendKeys(this.storeWebsiteUrlsInput, websiteUrl);
    eleUtil.doSendKeys(this.storeDbaInput, DBA);
    eleUtil.doClick(country);
    eleUtil.selectDropDownValue(this.countryListTextBox, industry);
    eleUtil.doSendKeys(this.storeProductsInput, products);
    eleUtil.waitForVisibilityOfElement(dateOfBirth, 30);
    eleUtil.doClick(dateOfBirth);
    eleUtil.doClick(dateOfBirth);
    eleUtil.doSendKeys(this.dateOfBirth, dob);
    eleUtil.doClick(continueButton);
  }

  public void fillWebsiteBasicRequirement(
      String websiteUrl,
      String returnAddress,
      int productQuantity,
      String productDescription,
      int productPrice) {
    eleUtil.clickElementWhenReady(mainCompanyWebsiteInput, 30);
    eleUtil.doSendKeys(this.mainCompanyWebsiteInput, websiteUrl);
    eleUtil.doSendKeys(this.contactDetailsInput, returnAddress);
    eleUtil.doSendKeys(this.productQuantityInput, String.valueOf(productQuantity));
    eleUtil.doSendKeys(this.productDescriptionInput, productDescription);
    eleUtil.doSendKeys(this.productPriceInput, String.valueOf(productPrice));
    eleUtil.doClick(continueButton);
  }

  public void fillProcessingDetails(
      int monthSalesVolume, int montNumberSales, int ticketAmount, String category)
      throws InterruptedException {
    eleUtil.clickElementWhenReady(monthlySalesVolumeInput, 30);
    eleUtil.doSendKeys(this.monthlySalesVolumeInput, String.valueOf(monthSalesVolume));
    eleUtil.doSendKeys(this.monthlyNumberTransactionsInput, String.valueOf(montNumberSales));
    eleUtil.doSendKeys(this.averageTicketSalesInput, String.valueOf(ticketAmount));
    eleUtil.doClick(categoryInput);
    eleUtil.selectDropDownValue(this.countryListTextBox, category);
    eleUtil.doClick(monthlyTransactions);
    Thread.sleep(1000);
    eleUtil.doIndexElementClick(checkBox, 1);
    Thread.sleep(500);
    eleUtil.doIndexElementClick(checkBox, 2);
    Thread.sleep(500);
    eleUtil.doIndexElementClick(checkBox, 3);
    Thread.sleep(500);
    eleUtil.doClick(continueButton);
  }

  public void fillCompanyDocuments(String attachFile) throws InterruptedException {
    eleUtil.clickElementWhenReady(continueButton, 30);
    List<WebElement> uploadFile = driver.findElements(FileAttache);
    for (WebElement up : uploadFile) {
      up.sendKeys(attachFile);
      Thread.sleep(1000);
    }
    eleUtil.doIndexElementClick(checkBox, 0);
    Thread.sleep(500);
    eleUtil.doClick(continueButton);
    driver.navigate().refresh();
    eleUtil.waitForVisibilityOfElement(successfullyText, 40);
  }
}
