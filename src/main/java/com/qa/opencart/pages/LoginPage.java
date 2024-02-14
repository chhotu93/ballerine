package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

  private WebDriver driver;
  private ElementUtil eleUtil;

  // By locators: OR
  private final By logoImage = By.xpath("(//img[@alt='Inboxes Logo'])[1]");

  private final By  logoImageText=By.xpath("(//img[@alt='Clipspay'])[1]");

  // page const...
  public LoginPage(WebDriver driver) {
    this.driver = driver;
    eleUtil = new ElementUtil(this.driver);
  }

  public RegisterPage navigate() {
    eleUtil.waitForVisibilityOfElement(logoImage, AppConstants.MEDIUM_DEFAUTT_WAIT).isDisplayed();
    return new RegisterPage(driver);
  }
  public RegisterPageInvalidData logoImage() {
    eleUtil.waitForVisibilityOfElement(logoImageText, AppConstants.MEDIUM_DEFAUTT_WAIT).isDisplayed();
    return new RegisterPageInvalidData(driver);
  }
}
