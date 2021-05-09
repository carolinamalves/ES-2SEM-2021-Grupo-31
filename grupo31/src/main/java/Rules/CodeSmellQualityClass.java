package Rules;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Support.Create_Method;
import Support.Method;

// TODO: Auto-generated Javadoc
//@author grupo 31

public class CodeSmellQualityClass {

	/** The name CT. */
	static ArrayList<String> nameCT ;
	
	/** The name CO. */
	static ArrayList<String> nameCO ;
	
	/** The god T. */
	static ArrayList<String> godT;
	
	/** The god O. */
	static ArrayList<String> godO ;

	/** The theirs. */
	static HashMap <String, String> theirs = new HashMap<>();
	
	/** The ours. */
	static HashMap <String, String> ours= new HashMap<>();

	/** The vp. */
	public static int VP;
	
	/** The vn. */
	public static int VN;
	
	/** The fp. */
	public static int FP;
	
	/** The fn. */
	public static int FN;

	/** The a. */
	static ArrayList<Method> a = Create_Method.a;

	/**
	 * Gets the theirs.
	 *
	 * @param path the path
	 * @return the theirs
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void getTheirs(String path) throws IOException {

		nameCT = new ArrayList<String>();
		godT= new ArrayList<String>();
		String envFilePath =path;

		FileInputStream fileName = new FileInputStream(new File(path));
		//int masterSheetColumnIndex = 0;

		XSSFWorkbook workbook = new XSSFWorkbook (fileName);

		// Get the first sheet.
		Sheet sheet = workbook.getSheetAt(0);

		//theirs
		//we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
		String columnWanted = "class";
		Integer columnNo = null;

		String columnWanted2 = "is_God_Class";
		Integer columnNo2 = null;

		// Get the first cell.
		Row row = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		for (Cell cell : row) {
			// Column header names. 
			if (cell.getStringCellValue().equals(columnWanted)){
				columnNo = cell.getColumnIndex();
			}
		}

		if (columnNo != null){
			for (Row row1 : sheet) {
				int it = 0; 
				Cell c = row1.getCell(columnNo);
				if (c == null) {
					// Nothing in the cell in this row, skip it
				} else {
					nameCT.add(c.toString());
					nameCT.set(it, c.toString());
				}
				it++;
			}
		}

		// Get the first cell.
		Row rowCode = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		for (Cell cell : rowCode) {
			// Column header names.  
			if (cell.getStringCellValue().equals(columnWanted2)){
				columnNo2 = cell.getColumnIndex();
			}
		}

		if (columnNo2 != null){
			int it = 0;
			for (Row row2 : sheet) {
				Cell c = row2.getCell(columnNo2);
				if (c == null) {
					// Nothing in the cell in this row, skip it
				} else {
					godT.add(c.toString());
					godT.set(it, c.toString());
				}
				it++;
			}
		}
	}

	/**
	 * Gets the ours.
	 *
	 * @param path the path
	 * @return the ours
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void getOurs(String path) throws IOException {

		nameCO = new ArrayList<String>();
		FileInputStream fileName = new FileInputStream(new File(path));
		//int masterSheetColumnIndex = 0;

		XSSFWorkbook workbook = new XSSFWorkbook (fileName);

		// Get the first sheet.
		Sheet sheet = workbook.getSheetAt(0);

		//we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
		String columnWanted = "class";
		Integer columnNo = null;
		String columnWanted2 = "is_God_Class";
		Integer columnNo2 = null;
		//output all not null values to the list

		// Get the first cell.
		Row row = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		for (Cell cell : row) {
			// Column header names.
			if (cell.getStringCellValue().equals(columnWanted)){
				columnNo = cell.getColumnIndex();
			}
		}

		if (columnNo != null){
			for (Row row1 : sheet) {
				int it=0;
				Cell c = row1.getCell(columnNo);
				if (c == null) {
				} else {
					nameCO.add(c.toString());
					nameCO.set(it, c.toString());
				}
				it++;
			}
		}	
	}

	/**
	 * Compare values.
	 *
	 * @param path the path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void compareValues(String path) throws IOException {

		getOurs(path);
		getTheirs(path);
		ArrayList<String> godO = RulesGodClass.godValues;
		VP = 0;
		VN = 0;
		FP = 0; 
		FN = 0;

		for (int i=0; i< nameCO.size(); i++) {

			boolean limite = true;

			for (int j = 1; j< nameCT.size(); j++) {

				if(limite) {

					if(nameCO.get(i).contains(nameCT.get(j))) {

						if(godO.get(i).equals(godT.get(j)) && godO.get(i).equals("TRUE")) {
							VP+=1;
							limite = false;

						}
						if(godO.get(i).equals(godT.get(j)) && godO.get(i).equals("FALSE")) {
							FP+=1;
							limite =false;
						}
						if(!godO.get(i).equals(godT.get(j)) && godO.get(i).equals("TRUE")) {
							VN+=1;
							limite=false;
						}
						if(!godO.get(i).equals(godT.get(j)) && godO.get(i).equals("FALSE")) {
							FN+=1;
							limite = false;
						}
					}
				}
			}
		}
	}
}