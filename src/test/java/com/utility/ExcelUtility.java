package com.utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public static String getTestData(int rowNumber, int CellNumber) throws InvalidFormatException, IOException {
		
		//create fileclass object
		File file=new File("C:\\Users\\Nickson Abraham\\OneDrive\\Documents\\Test data.xlsx");
		
		//create work book object
		XSSFWorkbook book= new XSSFWorkbook(file);
		
		//create sheet object
		XSSFSheet sheet=book.getSheetAt(0);
		
		//specify row and cell number
        return  sheet.getRow(rowNumber).getCell(CellNumber).getStringCellValue();
		
	}

}
