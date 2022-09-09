package com.UtilsLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReaderClass {
	
	XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	
	public excelReaderClass(String filePath) throws Exception {
	
		File f=new File(filePath);
		System.out.println(f.exists());
		FileInputStream fis=new FileInputStream(f);
		workbook=new XSSFWorkbook(fis);
	}
	
	public String captureDataFromExcel(int sheetIndex,int rows,int cells)
	{
		sheet= workbook.getSheetAt(sheetIndex);
		try {
			return sheet.getRow(rows).getCell(cells).getStringCellValue();
		}
		
		catch(Exception e)
		{
			double d = sheet.getRow(rows).getCell(cells).getNumericCellValue();

			long abc = (long) d;

			return Long.toString(abc);
		}
		
	}
	
	public int countRows(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getLastRowNum()+1;
	}

	public int countCells(int sheetIndex) {
		return workbook.getSheetAt(sheetIndex).getRow(0).getLastCellNum();
	}


}
