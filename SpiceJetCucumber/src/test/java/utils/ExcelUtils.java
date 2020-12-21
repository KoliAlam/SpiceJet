package utils;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static void main(String[] args) {
		RowCount();
		CellData();
	}
	public static void RowCount() {

		XSSFWorkbook workbook;
		try {
			workbook = new XSSFWorkbook("./Excel/Data.xlsx");
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			int rowCount = sheet.getPhysicalNumberOfRows();
		
		System.out.println(""+rowCount);
		
		} catch (IOException exp) {
			
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			
			exp.getStackTrace();
		}
	}
		public static void CellData() {
			XSSFWorkbook workbook;
			try {
				workbook = new XSSFWorkbook("./Excel/Data.xlsx");
				XSSFSheet sheet = workbook.getSheet("Sheet1");
				int rowCount = sheet.getPhysicalNumberOfRows();
				
				XSSFRichTextString cellData = sheet.getRow(1).getCell(0).getRichStringCellValue();
			System.out.println(""+cellData);
			
			} catch (IOException exp) {
				
				System.out.println(exp.getMessage());
				System.out.println(exp.getCause());
				
				exp.getStackTrace();
		}
	}

}
