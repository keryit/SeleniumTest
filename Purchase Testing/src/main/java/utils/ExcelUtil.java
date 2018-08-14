package utils;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static utils.Constant.*;


public class ExcelUtil {


    private static XSSFWorkbook excelWBook;
    private static XSSFSheet excelWSheet;
    private static XSSFCell cell;
    private static XSSFRow row;
    private static int rowNumber;
    private static int columnNumber;


    public static void setRowNumber(int rowNum) {
        rowNumber = rowNum;
    }

    public static int getRowNumber() {
        return rowNumber;
    }

    public static void setColumnNumber(int colNum) {
        columnNumber = colNum;
    }

    public static int getColumnNumber() {
        return columnNumber;
    }


    public static void setExcelSheet(String sheetName) {

        try {
            // Open the Excel file
            FileInputStream excelFile = new FileInputStream(excelPath + File.separator + excelFileName);
            excelWBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelWBook.getSheet(sheetName);
        } catch (Exception e) {
            try {
                throw (e);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    //Reads the test data from the Excel cell.
    //Put row number and column number as parameters.
    public static String getCellData(int rowNum, int colNum) {
        try {
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell);
        } catch (Exception e) {
            System.out.println("No any value in testdata.xlsx in row number " + rowNum + " and column number " + colNum);
            return "";

        }
    }

    //Returns the data of given row number.
    public static XSSFRow getRowData(int rowNum) throws Exception {
        try {
            row = excelWSheet.getRow(rowNum);
            return row;
        } catch (Exception e) {
            throw (e);
        }
    }

    //Set a value to the cell.
    public static void setCellData(String value, int rowNum, int colNum) throws Exception {
        try {
            row = excelWSheet.getRow(rowNum);
            cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
                cell.setCellValue(value);
            } else {
                cell.setCellValue(value);
            }

            // Constant variables Test Data path and Test Data file name
            FileOutputStream fileOut = new FileOutputStream(excelPath + File.separator + excelFileName);
            excelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
