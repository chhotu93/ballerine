package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    eleUtil.verifyTextInElementList(this.dateOfBirth, dobValidation);
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

    eleUtil.verifyTextInElementList(this.errorText, streetValidation);
    eleUtil.verifyTextInElementList(this.errorText, streetNumberValidation);
    eleUtil.verifyTextInElementList(this.errorText, cityValidation);
    eleUtil.verifyTextInElementList(this.errorText, countryValidation);
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
      }
    } catch (NoSuchElementException ignore) {

    }
    eleUtil.doClick(country);
    eleUtil.selectDropDownValue(registerPage.countryListTextBox, countryName);
    eleUtil.clearInput(registerPage.uboIdentityNumberTextBox);
    eleUtil.doSendKeys(registerPage.uboIdentityNumberTextBox, uboIdentityNumber);
    eleUtil.clearInput(registerPage.uboAddressOfResidenceTextBox);
    eleUtil.doSendKeys(registerPage.uboAddressOfResidenceTextBox, uboAddress);
    eleUtil.clearInput(registerPage.uboOwnershipPercentageTexBox);
    eleUtil.doSendKeys(registerPage.uboOwnershipPercentageTexBox, (uboPercentage));
    eleUtil.doClick(continueButton);
    eleUtil.verifyText(this.errorInvalidSingleText, countyValidation);
    eleUtil.verifyText(this.errorInvalidSingleText, uboNoValidation);
    eleUtil.verifyText(this.errorInvalidSingleText, uboAddressValidation);
    eleUtil.verifyText(this.errorInvalidSingleText, uboPercentageValidation);
    eleUtil.verifyText(this.errorInvalidSingleText, directorsValidation);
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
}
