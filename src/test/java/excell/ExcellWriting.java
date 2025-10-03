package excell;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellWriting {
public static void main(String[] args) throws IOException {
	//  Writing mode
	FileOutputStream fo = new FileOutputStream("C:\\Users\\Dell\\Desktop\\jp\\EMS_Project_40\\ExellFileDoc\\WritingData.xlsx");
	// To read the data from the excell sheet we need to call FileOutputStream
	XSSFWorkbook wb= new XSSFWorkbook(); // here we identify the Workbook
	XSSFSheet sheet = wb.createSheet(); // here we create the sheet
	Scanner sc = new Scanner(System.in);
	for(int r=0; r<=3;r++) {
		//create row
		 XSSFRow row = sheet.createRow(r);
		 for(int c=0;c<=3;c++) {
			 System.out.println("Enter value");
			String value=sc.next();
			 row.createCell(c).setCellValue(value);
			 
		 }
	}
	
	wb.write(fo);    // here data is written in Excell sheet
	wb.close();      // Workbook is closed
	fo.close();      // Excell Sheet is closed
	System.out.println("Writing is Done!");

}

}

