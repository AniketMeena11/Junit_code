package ReadandWriteExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import com.google.common.collect.Table.Cell;

public class ReadFromExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FileInputStream fis = null;
		XSSFWorkbook workBook = null;

		String file = ".\\src\\ReadandWriteExcel\\ReadData.xlsx";

		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			workBook = new XSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFSheet sheet = workBook.getSheetAt(0); // workBook.getSheet("Sheet1")

		int rowCount = sheet.getLastRowNum();

		System.out.println("Row Count: " + rowCount);

		for (int rowNo = 1; rowNo <= rowCount; rowNo++) {

			int cellCount = sheet.getRow(rowNo).getLastCellNum(); // 3

			for (int cellNo = 0; cellNo < cellCount; cellNo++) {

				Cell cell = sheet.getRow(rowNo).getCell(cellNo);

				if (cell.getCellType() == CellType.STRING)
					System.out.print(sheet.getRow(rowNo).getCell(cellNo).getStringCellValue() + "\t"); // 1,0

				else if (cell.getCellType() == CellType.NUMERIC) {
					if (cellNo == 0)
						System.out.print((int)sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue() + "\t");
					else
						System.out.print(sheet.getRow(rowNo).getCell(cellNo).getNumericCellValue() + "\t");
				}
			}
			System.out.println();
		}

	}
}
