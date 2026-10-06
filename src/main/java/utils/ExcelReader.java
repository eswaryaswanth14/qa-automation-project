package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static Object[][] getExceldata () throws IOException {
		String path="C:\\Sel Practice\\qa-automation-project\\src\\test\\resources\\LoginData.xlsx";
		FileInputStream f=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(f);
		XSSFSheet sheet=workbook.getSheet("LoginData");
		//		XSSFRow row=sheet.getRow(i);
		//		XSSFCell usernameCell=row.getCell(0);
		//		String un=usernameCell.getStringCellValue();
		//		System.out.println(un);
		//		XSSFRow	row1=sheet.getRow(0);
		//		XSSFCell cell=row.getCell(1);
		//		String text=cell.getStringCellValue();
		//		System.out.println(text);
		//		XSSFCell text2=row.getCell(2);
		//		String ve=text2.getStringCellValue();
		//		System.out.println(ve);

		Object[][] data=new Object[sheet.getLastRowNum()][3];
		for(int i=1;i<=sheet.getLastRowNum();i++) {
			XSSFRow currentRow=sheet.getRow(i);
			XSSFCell cells=currentRow.getCell(0);
			String n=cells.getStringCellValue();
			data[i-1][0]=n;

			//			String n2 = cells.getStringCellValue();


			XSSFCell cell1=currentRow.getCell(1);
			String n1=cell1.getStringCellValue();
			//			String n1 = cell1.getStringCellValue();
			data[i-1][1]=n1;
			XSSFCell cell2=currentRow.getCell(2);
			String n2=cell2.getStringCellValue();
			data[i-1][2]=n2;
			//			System.out.println(n2);

		}
		return data;




	}



}
