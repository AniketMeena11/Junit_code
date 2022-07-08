package ReadandWriteExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	
public class WriteIntoExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] data = { { "EMP Name", "Salary" },
							{ "Arun Raj", "99231.67" }, 
							{ "Aniket", "52531.34" },
							};

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");

		for (int i = 0; i < 3; i++) {
			Row row = sheet.createRow(i);
			for (int j = 0; j < 2; j++) {
				Cell cell = row.createCell(j);
				cell.setCellValue(data[i][j]);
			}
		}

		FileOutputStream fos = null;
		
			try {
				fos = new FileOutputStream(".\\src\\ReadandWriteExcel\\WriteData.xlsx");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		try {
			workbook.write(fos);
			fos.close();
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		System.out.println("Data Written Successfully");
	}

}
