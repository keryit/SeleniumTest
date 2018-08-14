package tests;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagehelpers.SearchHelper;
import utils.ExcelUtil;
import utils.SetUpUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static utils.Constant.*;


class SearchTest extends SetUpUtil {


    @Test(priority = 0, description = "Search negativeTest data from excel")

    public void searchWithEmpty() throws Exception {
        SearchHelper searchHelper = new SearchHelper(driver, wait);
        ExcelUtil.setExcelSheet(exelSheetSearchNegative);


        File src = new File(excelPath + File.separator + excelFileName);

        try {
            // Load the file.
            FileInputStream finput = new FileInputStream(src);
            // Access the required test data sheet
            XSSFWorkbook wb = new XSSFWorkbook(finput);
            XSSFSheet sheet = wb.getSheet(exelSheetSearchNegative);
            // Loop through all rows in the sheet
            // Start at row 1 as row 0 is our header row

            for (int count = 1; count <= sheet.getLastRowNum(); count++) {
                XSSFRow row = sheet.getRow(count);
                searchHelper.searchByKeyword(ExcelUtil.getCellData(count, 2));
                Assert.assertEquals(searchHelper.getMessageAfterWrongKeyword(), ExcelUtil.getCellData(count, 3));
                ExcelUtil.setCellData(searchHelper.getMessageAfterWrongKeyword(), count, 4);


            }
            finput.close();
        } catch (IOException e) {
            System.out.println("Test data file not found");
        }


    }

    @Test(priority = 0, description = "Search failed")

    public void searchExistingValue() {

        SearchHelper searchHelper = new SearchHelper(driver, wait);

        ExcelUtil.setExcelSheet(excelSheetSearchPositive);

        searchHelper.searchByKeyword(ExcelUtil.getCellData(1, 2));
        System.out.println("Number of found goods is: " + searchHelper.getCountAllArticles());
        System.out.println(searchHelper.getMessageArticleFound());
        Assert.assertTrue(searchHelper.getMessageArticleFound().contains(searchHelper.getCountAllArticles().toString()));
        Assert.assertEquals("123", "222");


    }
}
