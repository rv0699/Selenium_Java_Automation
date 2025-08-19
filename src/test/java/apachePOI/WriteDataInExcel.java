package apachePOI;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDataInExcel {
	
	/*
	 * Workbook
	 * Sheet
	 * Row
	 * Cell -> enter data
	 * 
	 * Create file
	 * Write data into file
	 * 
	 */

	@Test
	void writeDataToExcel() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sh = wb.createSheet("Data");
		
		//Header row
		XSSFRow r = sh.createRow(0);
		XSSFCell c01 = r.createCell(0);
		c01.setCellValue("S.No.");
		
		// Above can also be written in a single line -> r.createCell(0).setCellValue("S.No.");
		
		XSSFCell c02 = r.createCell(1);
		c02.setCellValue("Framework");
		
		
		XSSFCell c03 = r.createCell(2);
		c03.setCellValue("Language");

		
		//Data in row 1
		XSSFRow r1 = sh.createRow(1);
		XSSFCell c11 = r1.createCell(0);
		c11.setCellValue("1");
		
		XSSFCell c12 = r1.createCell(1);
		c12.setCellValue("Selenium");
		
		XSSFCell c13 = r1.createCell(2);
		c13.setCellValue("Java");
		
		//Data in row 2
		XSSFRow r2 = sh.createRow(2);
		XSSFCell c21 = r2.createCell(0);
		c21.setCellValue("2");
		
		XSSFCell c22 = r2.createCell(1);
		c22.setCellValue("Cypress");
		
		XSSFCell c23 = r2.createCell(2);
		c23.setCellValue("JavaScript");
		
		//Data in row 3
		XSSFRow r3 = sh.createRow(3);
		XSSFCell c31 = r3.createCell(0);
		c31.setCellValue("3");
		
		XSSFCell c32 = r3.createCell(1);
		c32.setCellValue("Robot");
		
		XSSFCell c33 = r3.createCell(2);
		c33.setCellValue("Python");
		
		String filePath = System.getProperty("user.dir") + "//testData//Writedata.xlsx";
		//
		FileOutputStream fo = new FileOutputStream(filePath);
		
		wb.write(fo);
		wb.close();
		wb.close();
	}

		
}
