package com.qa.opencart.base;

import java.util.Properties;

import com.qa.opencart.pages.*;
import com.qa.opencart.tests.CreateWorkFlowApi;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;

public class BaseTest {

  protected WebDriver driver;
  protected Properties prop;
  DriverFactory df;
  protected LoginPage loginPage;
  protected RegisterPage registerPage;
  protected SoftAssert softAssert;
  protected RegisterPageInvalidData registerInvalidData;

  @Parameters("browser")
  @BeforeTest
  public void setup(String browserName) throws InterruptedException {
    CreateWorkFlowApi workFlowApi = new CreateWorkFlowApi();
    workFlowApi.login();
    df = new DriverFactory();
    prop = df.initProp();

    if (browserName != null) {
      prop.setProperty("browser", browserName);
    }

    driver = df.initDriver(prop);
    loginPage = new LoginPage(driver);
    softAssert = new SoftAssert();
  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}
