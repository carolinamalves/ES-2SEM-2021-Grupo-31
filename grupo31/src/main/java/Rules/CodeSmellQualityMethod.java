package Rules;

import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Support.Create_Method;
import Support.Method;

// TODO: Auto-generated Javadoc
//@author grupo 31
//Testa Qualidade do método
public class CodeSmellQualityMethod {

	/** The name MT. */
	static ArrayList<String> nameMT ;

	/** The name MO. */
	static ArrayList<String> nameMO ;

	/** The long MT. */
	static ArrayList<String> longMT;

	/** The long MO. */
	static ArrayList<String> longMO ;

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
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void getTheirs(String path) throws IOException {

		nameMT = new ArrayList<String>();
		longMT= new ArrayList<String>();
		String envFilePath =(path);

		FileInputStream fileName = new FileInputStream(new File(path));
		//int masterSheetColumnIndex = 0;

		XSSFWorkbook workbook = new XSSFWorkbook (fileName);

		// Get the first sheet.
		Sheet sheet = workbook.getSheetAt(0);

		//theirs
		//we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
		String columnWanted = "method";
		Integer columnNo = null;

		String columnWanted2 = "is_Long_Method";
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
					nameMT.add(c.toString());
					nameMT.set(it, c.toString());
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
					longMT.add(c.toString());
					longMT.set(it, c.toString());
				}
				it++;
			}
		}
	}

	/**
	 * Gets the ours.
	 *
	 * @param path the path
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void getOurs(String path) throws IOException {

		nameMO = new ArrayList<String>();
		FileInputStream fileName = new FileInputStream(new File(path));
		//int masterSheetColumnIndex = 0;

		XSSFWorkbook workbook = new XSSFWorkbook (fileName);

		// Get the first sheet.
		Sheet sheet = workbook.getSheetAt(0);

		//theirs
		//we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
		String columnWanted = "method";
		Integer columnNo = null;

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
					// Nothing in the cell in this row, skip it
				} else {
					nameMO.add(c.toString());
					nameMO.set(it, c.toString());
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
	public static void compareValues(String path, String path1) throws IOException {

		getOurs(path1);
		getTheirs(path);
		ArrayList<String> longMO = RulesLongMethod.longValues;
		VP = 0;
		VN = 0;
		FP = 0; 
		FN = 0;

		for (int i=0; i< nameMO.size(); i++) {

			boolean limite = true;

			for (int j = 1; j< nameMT.size(); j++) {

				if(limite) {

					if(nameMO.get(i).contains(nameMT.get(j))) {

						if(longMO.get(i).equals(longMT.get(j)) && longMO.get(i).equals("TRUE")) {
							VP+=1;
							limite = false;
						}
						if(longMO.get(i).equals(longMT.get(j)) && longMO.get(i).equals("FALSE")) {
							FP+=1;
							limite =false;
						}
						if(!longMO.get(i).equals(longMT.get(j)) && longMO.get(i).equals("TRUE")) {
							VN+=1;
							limite=false;
						}
						if(!longMO.get(i).equals(longMT.get(j)) && longMO.get(i).equals("FALSE")) {
							FN+=1;
							limite = false;
						}
					}
				}
			}
		}
	}
}