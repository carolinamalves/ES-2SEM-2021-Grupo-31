package Grupo31.g31;

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

public class ImportExcel extends GUI{  

	static void fillData(File file){

		int index =- 1;
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

			for (int i = 0; i < strs.length; i++) {
				strs[i]= workbook.getSheetName(i); 
			}

			JFrame frame = new JFrame("Input Dialog");

			String selectedsheet = (String) JOptionPane.showInputDialog(
					frame, "Which worksheet you want to import ?", "Select Worksheet",
					JOptionPane.QUESTION_MESSAGE, null, strs, strs[0]);

			if (selectedsheet != null) {
				for (int i = 0; i < strs.length; i++) {

					if (workbook.getSheetName(i).equalsIgnoreCase(selectedsheet))
						index = i; 
				}

				XSSFSheet sheet = workbook.getSheetAt(index);
				XSSFRow row = sheet.getRow(0);

				headers.clear();

				for (int i = 0; i < row.getLastCellNum(); i++){
					XSSFCell cell1 = row.getCell(i);
					headers.add(cell1.toString());
				}

				data.clear();
				for (int j = 1; j < sheet.getLastRowNum() + 1; j++){
					Vector d = new Vector();
					row = sheet.getRow(j);
					int noofrows = row.getLastCellNum();
					for (int i = 0; i < noofrows; i++){
						XSSFCell cell = row.getCell(i,
								org.apache.poi.ss.usermodel.Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
						d.add(cell.toString());
					}
					d.add("\n");
					data.add(d);
				}
			}
			else { 
				return; 
			}
		}
		catch (Exception e) {
			e.printStackTrace(); 
		} 
	}
}