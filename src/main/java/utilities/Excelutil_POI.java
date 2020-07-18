package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutil_POI {

	public static XSSFWorkbook ExcelBook;
	public static XSSFSheet ExcelSheet;
	public static XSSFRow Row;
	public static XSSFCell Cell;

	// Set the File Path and open the Excel File
	// passing args as path and sheetname
	public static void setExcelFile(String path, String sheetname) throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(path);
			// Access the required test data sheet
			ExcelBook = new XSSFWorkbook(ExcelFile);
			ExcelSheet = ExcelBook.getSheet(sheetname);
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {
		try {
			ExcelSheet.createRow(RowNum).createCell(ColNum).setCellValue(Result);
			FileOutputStream fileOut = new FileOutputStream(
					"C:\\Users\\Ujjwal Jain\\Documents\\Java Program Maven\\FlightProject\\TestData\\MakeMyTrip.xlsx");
			ExcelBook.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

}
