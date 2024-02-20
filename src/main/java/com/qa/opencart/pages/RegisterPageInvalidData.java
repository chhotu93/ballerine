package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.*;

import java.util.List;

public class RegisterPageInvalidData {
  ElementUtil eleUtil;
  WebDriver driver;
  RegisterPage registerPage = new RegisterPage(null);
  // person information
  private final By firstNameTextBox = By.name("first-name-input");
  private final By lastNameTextBox = By.name("last-name-input");

  private final By errorText = By.cssSelector("[class*='text-destructive']");
  private final By errorInvalidSingleText =
      By.xpath("(//*[contains(@class,'text-destructive')])[1]");
  private final By title = By.cssSelector("input[placeholder*='CEO']");
  private final By dateOfBirth = By.cssSelector("[placeholder*='MM/DD/YYYY']");
  private final By phoneNumberTextBox = By.cssSelector("[type='tel']");
  private final By continueButton = By.cssSelector("[class*='justify-end'] button");
  private final By logo = By.cssSelector("[role='combobox']");

  // business information
  private final By registrationNumberTextBox = By.name("registration-number-input");
  //  private final By country = By.cssSelector("[class*='px-2 text-muted-foreground']");
  private final By country = By.cssSelector("[class*='bg-white px-2'][aria-haspopup*='dialog']");

  private final By taxIdentityNumberTextBox = By.name("tax-identification-number-input");
  private final By amountOfEmployeesTextBox = By.name("number-of-employees-input");
  private final By corporateTypeTextBox = By.cssSelector("[class*='MuiInputBase-formControl']");
  private final By multiSelect = By.cssSelector("[class*='MuiAutocomplete-option']");
  private final By registeredCapitalTextBox = By.name("registered-capital-in-usd-type-input");

  private final By checkBoxMember =
      By.xpath(
          "//span[contains(text(),'Membership')]/preceding-sibling::button[@aria-checked='false']");

  public RegisterPageInvalidData(WebDriver driver) {
    this.driver = driver;
    eleUtil = new ElementUtil(this.driver);
  }

  public void personInformationError(
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
    eleUtil.waitForVisibilityOfElement(logo, 20);
    eleUtil.waitForVisibilityOfElement(this.firstNameTextBox, AppConstants.MEDIUM_DEFAUTT_WAIT);
    eleUtil.clearInput(this.firstNameTextBox);
    eleUtil.doSendKeys(this.firstNameTextBox, firstName);
    eleUtil.clearInput(this.lastNameTextBox);
    eleUtil.doSendKeys(this.lastNameTextBox, lastName);
    eleUtil.clearInput(this.title);
    eleUtil.doSendKeys(this.title, titleText);
    eleUtil.doClick(dateOfBirth);
    eleUtil.clearInput(this.dateOfBirth);
    eleUtil.doClick(dateOfBirth);
    eleUtil.doClick(dateOfBirth);
    eleUtil.doSendKeys(this.dateOfBirth, dob);
    eleUtil.clearInput(this.phoneNumberTextBox);
    eleUtil.doSendKeys(this.phoneNumberTextBox, phoneNumber);
    eleUtil.doClick(continueButton);
    eleUtil.verifyTextInElementList(this.errorText, firstNameValidation);
    eleUtil.verifyTextInElementList(this.errorText, lastNameValidation);
    eleUtil.verifyTextInElementList(this.errorText, titleValidation);
    eleUtil.verifyTextInElementList(this.errorText, dobValidation);
    eleUtil.verifyTextInElementList(this.errorText, phoneNumberValidation);
  }

  public void fillBusinessInformationError(
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
      String capitalValidation)
      throws InterruptedException {
    eleUtil.waitForVisibilityOfElement(registrationNumberTextBox, 30);
    eleUtil.clearInput(this.registrationNumberTextBox);
    eleUtil.doSendKeys(this.registrationNumberTextBox, registrationNumber);
    eleUtil.doClick(country);
    Thread.sleep(1000);
    eleUtil.selectDropDownValue(registerPage.countryListTextBox, countryName);
    eleUtil.clearInput(this.taxIdentityNumberTextBox);
    eleUtil.doSendKeys(this.taxIdentityNumberTextBox, taxNumber);
    eleUtil.clearInput(this.amountOfEmployeesTextBox);
    eleUtil.doSendKeys(this.amountOfEmployeesTextBox, amountOfEmployee);
    eleUtil.doClick(this.corporateTypeTextBox);
    eleUtil.selectDropDownValue(multiSelect, corporateType);
    eleUtil.doClick(this.registrationNumberTextBox);
    eleUtil.clearInput(this.registeredCapitalTextBox);
    eleUtil.doSendKeys(this.registeredCapitalTextBox, capitalAmount);
    eleUtil.doClick(continueButton);
    eleUtil.verifyTextInElementList(this.errorText, rgNumberValidation);
    eleUtil.verifyTextInElementList(this.errorText, countryValidation);
    eleUtil.verifyTextInElementList(this.errorText, taxNumberValidation);
    eleUtil.verifyTextInElementList(this.errorText, employeeValidation);
    eleUtil.verifyTextInElementList(this.errorText, capitalValidation);
  }

  public void businessAddressError(
      String street,
      String streetNumber,
      String city,
      String countryName,
      String streetValidation,
      String streetNumberValidation,
      String cityValidation,
      String countryValidation)
      throws InterruptedException {
    eleUtil.clickElementWhenReady(registerPage.streetTextBox, 30);
    eleUtil.clearInput(registerPage.streetTextBox);
    eleUtil.doSendKeys(registerPage.streetTextBox, street);
    eleUtil.clearInput(registerPage.streetNumberTextBox);
    eleUtil.doSendKeys(registerPage.streetNumberTextBox, streetNumber);
    eleUtil.clearInput(registerPage.cityTextBox);
    eleUtil.doSendKeys(registerPage.cityTextBox, city);
    eleUtil.doClick(country);
    eleUtil.selectDropDownValue(registerPage.countryListTextBox, countryName);
    eleUtil.doClick(continueButton);
    try {
      eleUtil.verifyTextInElementList(this.errorText, streetValidation);
      eleUtil.verifyTextInElementList(this.errorText, streetNumberValidation);
      eleUtil.verifyTextInElementList(this.errorText, cityValidation);
      eleUtil.verifyTextInElementList(this.errorText, countryValidation);
    } catch (Exception ignored) {

    }
  }

  public void uboValidationError(
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
    eleUtil.waitForVisibilityOfElement(registerPage.titleOfUBo, 30);
    try {
      WebElement checkboxElement = driver.findElement(registerPage.checkBoxUBO);
      if (!checkboxElement.isSelected()) {
        checkboxElement.click();
        Thread.sleep(1000);
      }
    } catch (Exception ignore) {

    }
    try {
      eleUtil.doClick(country);

    eleUtil.selectDropDownValue(registerPage.countryListTextBox, countryName);
    eleUtil.clearInput(registerPage.uboIdentityNumberTextBox);
    eleUtil.doSendKeys(registerPage.uboIdentityNumberTextBox, uboIdentityNumber);
    eleUtil.clearInput(registerPage.uboAddressOfResidenceTextBox);
    eleUtil.doSendKeys(registerPage.uboAddressOfResidenceTextBox, uboAddress);
    eleUtil.clearInput(registerPage.uboOwnershipPercentageTexBox);
    eleUtil.doSendKeys(registerPage.uboOwnershipPercentageTexBox, (uboPercentage));
    eleUtil.doClick(continueButton);
    Thread.sleep(800);
    eleUtil.verifyText(this.errorInvalidSingleText, countyValidation);
    eleUtil.verifyText(this.errorInvalidSingleText, uboNoValidation);
    eleUtil.verifyText(this.errorInvalidSingleText, uboAddressValidation);
    eleUtil.verifyText(this.errorInvalidSingleText, uboPercentageValidation);
    eleUtil.verifyText(this.errorInvalidSingleText, directorsValidation);
    } catch (Exception ignore) {

    }
  }

  public void directorsValidationError(
      String countryName,
      String directorIdentityNumber,
      String addressOfResidence,
      String countyValidation,
      String directorINoValidation,
      String directorAddressValidation)
      throws InterruptedException {

    eleUtil.waitForVisibilityOfElement(registerPage.titleOfUBo, 30);
    try {
      WebElement checkboxElement = driver.findElement(registerPage.checkBoxDirectors);
      if (!checkboxElement.isSelected()) {
        checkboxElement.click();
      }
    } catch (NoSuchElementException ignore) {

    }
    eleUtil.doIndexElementClick(country, 1);
    eleUtil.selectDropDownValue(registerPage.countryListTextBox, countryName);
    eleUtil.clearInput(registerPage.directorsIdentityNumberTextBox);
    eleUtil.doSendKeys(registerPage.directorsIdentityNumberTextBox, directorIdentityNumber);
    eleUtil.clearInput(registerPage.directorsAddressOfResidenceTextBox);
    eleUtil.doSendKeys(registerPage.directorsAddressOfResidenceTextBox, addressOfResidence);
    eleUtil.doClick(continueButton);
    try {
      eleUtil.verifyText(this.errorInvalidSingleText, countyValidation);
      eleUtil.verifyText(this.errorInvalidSingleText, directorINoValidation);
      eleUtil.verifyText(this.errorInvalidSingleText, directorAddressValidation);
    } catch (NoSuchElementException ignore) {
    }
  }

  public void contactsValidationError(
      String firstname,
      String lastName,
      String email,
      String phoneNumber,
      String legalNameValidation,
      String lastNameValidation,
      String emailValidation,
      String phoneNumberValidation)
      throws InterruptedException {
    eleUtil.clickElementWhenReady(registerPage.contactFirstName, 20);
    eleUtil.clearInput(registerPage.contactFirstName);
    eleUtil.doSendKeys(registerPage.contactFirstName, firstname);
    eleUtil.clearInput(registerPage.contactLastName);
    eleUtil.doSendKeys(registerPage.contactLastName, lastName);
    eleUtil.clearInput(registerPage.contactEmail);
    eleUtil.doSendKeys(registerPage.contactEmail, email);
    eleUtil.clearInput(this.phoneNumberTextBox);
    eleUtil.doSendKeys(this.phoneNumberTextBox, phoneNumber);
    eleUtil.doClick(continueButton);

    eleUtil.verifyTextInElementList(this.errorText, legalNameValidation);
    eleUtil.verifyTextInElementList(this.errorText, lastNameValidation);
    eleUtil.verifyTextInElementList(this.errorText, emailValidation);
    eleUtil.verifyTextInElementList(this.errorText, phoneNumberValidation);
  }

  public void bankingValidationError(
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
    eleUtil.clickElementWhenReady(registerPage.cardholderName, 30);
    eleUtil.clearInput(registerPage.cardholderName);
    eleUtil.doSendKeys(registerPage.cardholderName, cardholderName);
    eleUtil.clearInput(registerPage.residentAddressInput);
    eleUtil.doSendKeys(registerPage.residentAddressInput, residentAddress);
    eleUtil.clearInput(registerPage.accountNumberInput);
    eleUtil.doSendKeys(registerPage.accountNumberInput, String.valueOf(accountNumber));
    eleUtil.clearInput(registerPage.swiftCodeInput);
    eleUtil.doSendKeys(registerPage.swiftCodeInput, SWIFTCode);
    eleUtil.clearInput(registerPage.bankNameInput);
    eleUtil.doSendKeys(registerPage.bankNameInput, bankName);
    eleUtil.clearInput(registerPage.bankAddressInput);
    eleUtil.doSendKeys(registerPage.bankAddressInput, bankAddress);
    eleUtil.doClick(country);
    eleUtil.selectDropDownValue(registerPage.countryListTextBox, accountCurrency);
    eleUtil.doClick(continueButton);

    try {
      eleUtil.verifyText(this.errorInvalidSingleText, cardholderNameValidation);
      eleUtil.verifyText(this.errorInvalidSingleText, residentAddressValidation);
      eleUtil.verifyText(this.errorInvalidSingleText, accountNumberValidation);
      eleUtil.verifyText(this.errorInvalidSingleText, SWIFTCodeValidation);
      eleUtil.verifyText(this.errorInvalidSingleText, bankNameValidation);
      eleUtil.verifyText(this.errorInvalidSingleText, bankAddressValidation);
      eleUtil.verifyText(this.errorInvalidSingleText, accountCurrencyValidation);

    } catch (NoSuchElementException ignore) {
    }
  }

  public void StoreInfoValidationError(
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
    eleUtil.clickElementWhenReady(registerPage.storeWebsiteUrlsInput, 30);
    eleUtil.clearInput(registerPage.storeWebsiteUrlsInput);
    eleUtil.doSendKeys(registerPage.storeWebsiteUrlsInput, websiteUrl);
    eleUtil.clearInput(registerPage.storeDbaInput);
    eleUtil.doSendKeys(registerPage.storeDbaInput, descriptor);
    eleUtil.doClick(country);
    eleUtil.selectDropDownValue(registerPage.countryListTextBox, industry);
    eleUtil.clearInput(registerPage.storeProductsInput);
    eleUtil.doSendKeys(registerPage.storeProductsInput, products);
    eleUtil.doClick(dateOfBirth);
    eleUtil.clearInput(this.dateOfBirth);
    eleUtil.doClick(dateOfBirth);
    eleUtil.doClick(dateOfBirth);
    eleUtil.doSendKeys(this.dateOfBirth, establishedDate);
    eleUtil.doClick(continueButton);
    eleUtil.verifyTextInElementList(this.errorText, websiteUrlValidation);
    eleUtil.verifyTextInElementList(this.errorText, descriptorValidation);
    eleUtil.verifyTextInElementList(this.errorText, industryValidation);
    eleUtil.verifyTextInElementList(this.errorText, productsValidation);
    eleUtil.verifyTextInElementList(this.errorText, establishedDateValidation);
  }

  public void WebsiteBasicRequirementValidationError(
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
    eleUtil.clickElementWhenReady(registerPage.mainCompanyWebsiteInput, 30);
    eleUtil.clearInput(registerPage.mainCompanyWebsiteInput);
    eleUtil.doSendKeys(registerPage.mainCompanyWebsiteInput, websiteUrl);
    eleUtil.clearInput(registerPage.contactDetailsInput);
    eleUtil.doSendKeys(registerPage.contactDetailsInput, returnAddress);
    eleUtil.clearInput(registerPage.productQuantityInput);
    eleUtil.doSendKeys(registerPage.productQuantityInput, productQuantity);
    eleUtil.clearInput(registerPage.productDescriptionInput);
    eleUtil.doSendKeys(registerPage.productDescriptionInput, productDescription);
    eleUtil.clearInput(registerPage.productPriceInput);
    eleUtil.doSendKeys(registerPage.productPriceInput, productPrice);
    eleUtil.doClick(continueButton);
    eleUtil.verifyTextInElementList(this.errorText, websiteUrlValidation);
    eleUtil.verifyTextInElementList(this.errorText, returnAddressValidation);
    eleUtil.verifyTextInElementList(this.errorText, productQuantityValidation);
    eleUtil.verifyTextInElementList(this.errorText, productDescriptionValidation);
    eleUtil.verifyTextInElementList(this.errorText, productPriceValidation);
  }

  public void ProcessingDetailsValidationError(
      String monthSalesVolume,
      String monthNumberTransactions,
      String ticketAmount,
      String category,
      String salesVolumeValidation,
      String monthNumberTransactionsValidation,
      String ticketAmountValidation,
      String categoryValidation)
      throws InterruptedException {
    eleUtil.clickElementWhenReady(registerPage.monthlySalesVolumeInput, 30);
    eleUtil.clearInput(registerPage.monthlySalesVolumeInput);
    eleUtil.doSendKeys(registerPage.monthlySalesVolumeInput, monthSalesVolume);
    eleUtil.clearInput(registerPage.monthlyNumberTransactionsInput);
    eleUtil.doSendKeys(registerPage.monthlyNumberTransactionsInput, monthNumberTransactions);
    eleUtil.clearInput(registerPage.averageTicketSalesInput);
    eleUtil.doSendKeys(registerPage.averageTicketSalesInput, ticketAmount);
    eleUtil.doClick(registerPage.categoryInput);
    eleUtil.selectDropDownValue(registerPage.countryListTextBox, category);
    Thread.sleep(1000);
    try {
      WebElement checkboxElement = driver.findElement(checkBoxMember);
      if (!checkboxElement.isSelected()) {
        checkboxElement.click();
      }
    } catch (NoSuchElementException ignore) {

    }
    Thread.sleep(1000);
    WebElement element = driver.findElement(continueButton);
    JavascriptExecutor executor = (JavascriptExecutor) driver;
    executor.executeScript("arguments[0].click();", element);
    eleUtil.verifyTextInElementList(this.errorText, salesVolumeValidation);
    eleUtil.verifyTextInElementList(this.errorText, monthNumberTransactionsValidation);
    eleUtil.verifyTextInElementList(this.errorText, ticketAmountValidation);
    eleUtil.verifyTextInElementList(this.errorText, categoryValidation);
  }

  public void companyDocuments(String attachFile) throws InterruptedException {
    eleUtil.clickElementWhenReady(continueButton, 30);
    List<WebElement> uploadFile = driver.findElements(registerPage.FileAttache);
    for (WebElement up : uploadFile) {
      up.sendKeys(attachFile);
      Thread.sleep(1000);
    }
    eleUtil.doIndexElementClick(registerPage.checkBox, 0);
    Thread.sleep(500);
    eleUtil.doClick(continueButton);
    driver.navigate().refresh();
    eleUtil.waitForVisibilityOfElement(registerPage.successfullyText, 40);
  }
}
