package excell;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellReading {
public static void main(String[] args) throws IOException 
{
	// Reading mode
	FileInputStream fs = new FileInputStream("C:\\Users\\Dell\\Desktop\\jp\\EMS_Project_40\\ExellFileDoc\\ReadingData.xlsx");
	// To read the data from the excell sheet we need to call FileInputStream
	XSSFWorkbook wb= new XSSFWorkbook(fs); // here we need to Identify the Workbook
	XSSFSheet sheet = wb.getSheet("Sheet1"); // here we identify the sheet
	                                         
	// Now Identify the roll and cells 
	int rows =sheet.getLastRowNum();  // here we get the last row 
	int cell =sheet.getRow(rows).getLastCellNum();  // here we get the last row and last cell

	for(int i=0; i<= rows;i++) {
		XSSFRow row = sheet.getRow(i);  // here i=0 
		for(int c=0;c< cell;c++) // here c=0
		{
			String value = row.getCell(c).toString();   // to retrive the data of 'c' we used tostring method
			System.out.print(value + "  ");
		}
		System.out.println();
		
	}
	
	
}
}
