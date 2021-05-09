package Support;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// TODO: Auto-generated Javadoc
//@author grupo 31


	
public class ImportExcel extends GUI{  
	public static int index;
	/**
	 * Fill data.
	 *
	 * @param file the file
	 */
	public static void fillData(File file){

		index =- 1;
		XSSFWorkbook workbook = null;

		try {
			try {
				FileInputStream inputStream = new FileInputStream (file);
				workbook = new XSSFWorkbook(inputStream);
			}

			catch (IOException ex)
			{
				Logger.getLogger(ImportExcel.class. getName()).log(Level.SEVERE, null, ex);
			}

			String[] strs=new String[workbook.getNumberOfSheets()];

			strs = strs(workbook, strs);
			JFrame frame = new JFrame("Input Dialog");

			String selectedsheet = (String) JOptionPane.showInputDialog(
					frame, "Which worksheet you want to import ?", "Select Worksheet",
					JOptionPane.QUESTION_MESSAGE, null, strs, strs[0]);

			if (selectedsheet != null) {
				headers(index, workbook, strs, selectedsheet);
				index = index(index, workbook, strs, selectedsheet);
				XSSFSheet sheet = workbook.getSheetAt(index);
				XSSFRow row = sheet.getRow(0);

				data(sheet, row);
			}
			else { 
				return; 
			}
		}
		catch (Exception e) {
			e.printStackTrace(); 
		} 
	}

	/**
	 * Headers.
	 *
	 * @param index the index
	 * @param workbook the workbook
	 * @param strs the strs
	 * @param selectedsheet the selectedsheet
	 */
	private static void headers(int index, XSSFWorkbook workbook, String[] strs, String selectedsheet) {
		index = index(index, workbook, strs, selectedsheet);
		XSSFSheet sheet = workbook.getSheetAt(index);
		XSSFRow row = sheet.getRow(0);
		headers.clear();
		for (int i = 0; i < row.getLastCellNum(); i++) {
			XSSFCell cell1 = row.getCell(i);
			headers.add(cell1.toString());
		}
	}

	/**
	 * Strs.
	 *
	 * @param workbook the workbook
	 * @param strs the strs
	 * @return the string[]
	 */
	private static String[] strs(XSSFWorkbook workbook, String[] strs) {
		for (int i = 0; i < strs.length; i++) {
			strs[i] = workbook.getSheetName(i);
		}
		return strs;
	}

	/**
	 * Index.
	 *
	 * @param index the index
	 * @param workbook the workbook
	 * @param strs the strs
	 * @param selectedsheet the selectedsheet
	 * @return the int
	 */
	private static int index(int index, XSSFWorkbook workbook, String[] strs, String selectedsheet) {
		for (int i = 0; i < strs.length; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(selectedsheet))
				index = i;
		}
		return index;
	}

	/**
	 * Data.
	 *
	 * @param sheet the sheet
	 * @param row the row
	 */
	private static void data(XSSFSheet sheet, XSSFRow row) {
		data.clear();
		for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
			Vector d = d(sheet, row, j);
			data.add(d);
		}
	}

	/**
	 * D.
	 *
	 * @param sheet the sheet
	 * @param row the row
	 * @param j the j
	 * @return the vector
	 */
	private static Vector d(XSSFSheet sheet, XSSFRow row, int j) {
		Vector d = new Vector();
		row = sheet.getRow(j);
		int noofrows = row.getLastCellNum();
		for (int i = 0; i < noofrows; i++) {
			XSSFCell cell = row.getCell(i, org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			d.add(cell.toString());
		}
		d.add("\n");
		return d;
	}
}