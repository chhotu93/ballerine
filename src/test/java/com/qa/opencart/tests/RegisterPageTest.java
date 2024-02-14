package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import com.qa.opencart.utils.ExcelUtil;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URISyntaxException;

public class RegisterPageTest extends BaseTest {
  @BeforeClass
  public void accSetUp() {
    registerPage = loginPage.navigate();
  }

  @DataProvider
  public Object[][] getUserRegTestExcelData() {
    return ExcelUtil.getTestData(AppConstants.REGISTER_DATA_SHEET_NAME);
  }

  @Test(dataProvider = "getUserRegTestExcelData")
  public void Signup(String firstName, String dob, String phoneNumber)
      throws InterruptedException, URISyntaxException {
    registerPage.addUserEmail(prop.getProperty("userEmail"), prop.getProperty("domain"));

    registerPage.changeChinese();
    registerPage.clickEnglish();
    registerPage.fillPersonalInformation(firstName, dob, phoneNumber);
  }

  @DataProvider
  public Object[][] testQA() {
    return ExcelUtil.getTestData(AppConstants.PRODUCT_DATA_SHEET_NAME);
  }

  @Test(dataProvider = "testQA")
  public void business(
      String registrationNumber,
      String taxNumber,
      String amountOfEmployee,
      String Partnership,
      String capitalAmount)
      throws InterruptedException {
    registerPage.fillBusinessInformation(
        registrationNumber, taxNumber, amountOfEmployee, Partnership, capitalAmount);
  }

  @Test
  public void fillform() throws InterruptedException {
    registerPage.fillBusinessAddress("test", "15", "London");
    String relativeFilePath = "./src/test/resources/testdata/passportImg.jpg";
    String absoluteFilePath = new File(relativeFilePath).getAbsolutePath();
    registerPage.fillDirectorsAndUBO(
        "Indian", 123456, "22, Choyangmen", 25, 45123, absoluteFilePath);
    registerPage.fillContacts("Test", "jhon", "testballe12@getnada.com", "8788946785");
    registerPage.fillBankingDetails(
        "john de",
        "Fla 5A, Tower 2 Hong Kong",
        12456333,
        "HK00HKB01234567890123",
        "HK00HKB012",
        12345,
        "hong ",
        "12345",
        "456 kings road",
        123,
        "CHE");
    registerPage.fillStoreDetails(
        "www.collection-sb.eu",
        "Barclays",
        "Aerospace Engineering",
        "Smart Watches, Wireless Earbuds, Portable Chargers",
        "12201998");
    registerPage.fillWebsiteBasicRequirement(
        "www.google.com", "22, Choyangmen", 100, "test new product", 100);
    registerPage.fillProcessingDetails(5000, 50, 20, "B2C");
    registerPage.fillCompanyDocuments(absoluteFilePath);
  }
}
