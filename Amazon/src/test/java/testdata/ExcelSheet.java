package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	public static Workbook book;
	public static Sheet sheet;

	public static Object[][] readdata(String Sheetname){
		FileInputStream file=null;
		try {                        //properties of excel sheet
			file=new FileInputStream("C:\\Users\\anith\\eclipse-workspace\\AmazonCreateAccount\\src\\test\\java\\testdata\\details.xlsx");
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {    
			 book=  WorkbookFactory.create(file); //HSSF XSSF
			 }   
		
			catch(IOException a) {
				a.printStackTrace();
				}
	 sheet=	book.getSheet(Sheetname);   //reading excel sheetname
	 Object [][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()]; 
	 for(int i=0;i<sheet.getLastRowNum(); i++) {
		 for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
			 data[i][k]=sheet.getRow(i+1).getCell(k).toString(); //read data from cell
		 }
	 }
	return data;
	}


}
