package pkg;

import java.io.File;
import java.io.IOException;

import jxl.Workbook;
import jxl.write.WritableCell;
import jxl.write.WritableWorkbook;

public class ExcelHandler {
	public File file;
	public WritableWorkbook workbook;

	public ExcelHandler(String path) {
		// TODO Auto-generated constructor stub
		this.file = new File(path);
		try {
			this.workbook = Workbook.createWorkbook(this.file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.printf("Error: Invalid File Name\n");
			e.printStackTrace();
		}
	}
	
	public double getCellValue(int i1, int i2){
		return Double.parseDouble(sGetCellValue(1,i1,i2));
	}
	
	public String sGetCellValue(int sNo, int i1, int i2){
		String s0 = "Sheet" + sNo+"!";
		s0 += ExcelHandler.getAlphaNumeric(i2);
		s0 += (i1+1);
		System.out.println(s0);
		WritableCell cell = this.workbook.getWritableCell(s0);
		return cell.getContents();
	}

	public static String getAlphaNumeric(int i2) {
		// TODO Auto-generated method stub
		if (i2 > 0){
			return ExcelHandler.getAlphaNumeric((int) (Math.floor(i2/25.0)-1))+ExcelHandler.getLetter(i2%25);
		}
		return "";
	}

	public static char getLetter(int i) {
		// TODO Auto-generated method stub
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(i);
	}
}
