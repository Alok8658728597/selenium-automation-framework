package com.alok.selenium.utils;
//F-W-S-R-C-D-R → File → Workbook → Sheet → Row/Col → Create Array → Data Loop → Return
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    // Reads Excel data and returns it as a 2D Object array (excluding header row)
    public static Object[][] readExcelData(String filePath, String sheetName) throws Exception {

        // Step 1: Load the Excel file using FileInputStream
        FileInputStream fis = new FileInputStream(filePath);

        // Step 2: Create workbook instance from the file
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // Step 3: Get the desired sheet by name
        XSSFSheet sheet = workbook.getSheet(sheetName);

        // Step 4: Get total number of rows and columns
        int rowCount = sheet.getPhysicalNumberOfRows(); // includes header
        int colCount = sheet.getRow(0).getLastCellNum(); // assumes header row has all columns

        // Step 5: Create a 2D array to store data (excluding header row)
        Object[][] data = new Object[rowCount - 1][colCount];

        // Step 6: Loop through rows (starting from 1 to skip header)
        for (int i = 1; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);

            // Step 7: Loop through columns and store cell data as String
            for (int j = 0; j < colCount; j++) {
                data[i - 1][j] = row.getCell(j).toString(); // convert cell to String
            }
        }

        // Step 8: Close workbook and file stream to avoid memory leaks
        workbook.close();
        fis.close();

        // Step 9: Return the extracted data
        return data;
    }
}
