package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import com.qa.opencart.constants.AppConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.*;

public class ExcelUtil {

  //	private static final String TEST_DATA_SHEET_PATH =
  // "./src/test/resources/testdata/OpenCartTestData.xlsx";
  private static final String TEST_DATA_SHEET_PATH =
      "./src/test/resources/testdata/barlintestData.xlsx";
  private static final String TEST_InVALID_DATA_SHEET_PATH =
      "./src/test/resources/testdata/barlintestinvalidData.xlsx";
  private static Workbook book;
  private static Sheet sheet;

  public static Object[][] getTestData(String sheetName) {

    System.out.println("reading test data from sheet:" + sheetName);

    Object data[][] = null;

    try {
      FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
      book = WorkbookFactory.create(ip);
      sheet = book.getSheet(sheetName);

      int rowCount = sheet.getLastRowNum();
      int colCount = sheet.getRow(0).getLastCellNum();

      data = new Object[rowCount][colCount];

      DataFormatter dataFormatter = new DataFormatter();

      for (int i = 0; i < rowCount; i++) {
        for (int j = 0; j < colCount; j++) {
          Cell cell = sheet.getRow(i + 1).getCell(j);

          // Check for null before converting to string
          if (cell != null) {
            data[i][j] = dataFormatter.formatCellValue(cell);
            System.out.println("testdatat" + data[i][j]);
          } else {
            // If cell is null, you can set it to an empty string or any default value
            data[i][j] = "";
          }
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    System.out.println("testststt" + Arrays.deepToString(data));
    return data;
  }

  // inavalid

  public static Object[][] inValidDataSheet(String sheetName) {

    System.out.println("reading test data from sheet:" + sheetName);

    Object dataqa[][] = null;

    try {
      FileInputStream ip = new FileInputStream(TEST_InVALID_DATA_SHEET_PATH);
      book = WorkbookFactory.create(ip);
      sheet = book.getSheet(sheetName);

      int rowCount = sheet.getLastRowNum();
      int colCount = sheet.getRow(0).getLastCellNum();

      dataqa = new Object[rowCount][colCount];

      DataFormatter dataFormatter = new DataFormatter();

      for (int i = 0; i < rowCount; i++) {
        for (int j = 0; j < colCount; j++) {
          Cell cell = sheet.getRow(i + 1).getCell(j);

          // Check for null before converting to string
          if (cell != null) {
            dataqa[i][j] = dataFormatter.formatCellValue(cell);
                       System.out.println("bisheet" + dataqa[i][j]);
          } else {
            // If cell is null, you can set it to an empty string or any default value
            dataqa[i][j] = "";
          }
        }
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (InvalidFormatException e) {
      e.printStackTrace();
    } catch (IOException e) {
    }
    return dataqa;
  }
}

  //		try {
  //			FileInputStream ip = new FileInputStream(TEST_DATA_SHEET_PATH);
  //			book = WorkbookFactory.create(ip);
  //			sheet = book.getSheet(sheetName);
  //
  //			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
  //
  //			for (int i = 0; i < sheet.getLastRowNum(); i++) {
  //				for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
  //					data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
  //				}
  //			}
  //
  //		} catch (FileNotFoundException e) {
  //			e.printStackTrace();
  //		} catch (InvalidFormatException e) {
  //			e.printStackTrace();
  //		} catch (IOException e) {
  //			e.printStackTrace();
  //		}
  //
  //		return data;
  //
  //	}
