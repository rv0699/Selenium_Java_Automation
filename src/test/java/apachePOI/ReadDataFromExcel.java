package apachePOI;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	
	@Test
	void readData() throws IOException {
		
		//Excel File >> Workbook >> Sheet >> Rows >> cells
		// For reading data from excel FileInputStream shall be used
		// For operations to be performed on respective components mentioned above , following will be used
		
		/*
		 * Workbook - XSSFWorkbook
		 * Sheet - XSSFsheet
		 * Rows - XSSFRow
		 * Cells - XSSFCell
		 *
		 */
		
		
		// Accessing file for read operation using FileInputStream
		String filePath = System.getProperty("user.dir") + "//testData//data.xlsx";
		System.out.println(filePath);
		FileInputStream fi = new FileInputStream(filePath);
		
		//To access workbook
		XSSFWorkbook workBook = new XSSFWorkbook(fi);
		
		//To access sheet in which data is present
		XSSFSheet sheet = workBook.getSheet("Sheet1");
		
		//To access total number of rows of data
		int totalRows = sheet.getLastRowNum();
		
		//To access total number of cells in the row
		int totalCells = sheet.getRow(1).getLastCellNum();
		
		//To print data present in the cells
		for(int i=0;i<=totalRows;i++){
			
			//To access rows in the sheet
			XSSFRow currentRow = sheet.getRow(i);
			
			for(int j=0;j<totalCells;j++) {
				//To access cells from each row
				XSSFCell cell = currentRow.getCell(j);
				System.out.print(cell.toString()+"\t");
			}
			
			System.out.println();
		}
		
		workBook.close();
		fi.close();
		
		
	}

}
