package Grupo31.g31;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CodeSmellQualityMethod {

	static ArrayList<String> nameMT ;
	static ArrayList<String> nameMO ;
	static ArrayList<String> longMT;
	static ArrayList<String> longMO ;

	static int VP;
	static int VN;
	static int FP;
	static int FN;

	static ArrayList<Method> a = Create_Method.a;

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
			//System.out.println(cell.toString());  
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
					//System.out.println(c);
				}
				it++;
			}
		}


		// Get the first cell.
		Row rowCode = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		for (Cell cell : rowCode) {
			// Column header names.
			//System.out.println(cell.toString());  
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
					//System.out.println(c);
				}
				it++;
			}
		}
 
	}





	public static void getOurs(String path) throws IOException {


		nameMO = new ArrayList<String>();
		FileInputStream fileName = new FileInputStream(new File("C:\\Users\\inesv\\Desktop\\src_metrics.xlsx"));
		//int masterSheetColumnIndex = 0;

		XSSFWorkbook workbook = new XSSFWorkbook (fileName);

		// Get the first sheet.
		Sheet sheet = workbook.getSheetAt(0);


		//theirs
		//we will search for column index containing string "Your Column Name" in the row 0 (which is first row of a worksheet
		String columnWanted = "method";
		Integer columnNo = null;
		
		//output all not null values to the list


		// Get the first cell.
		Row row = sheet.getRow(0);
		//Cell cell = row.getCell(0);
		for (Cell cell : row) {
			// Column header names.
			//System.out.println(cell.toString());  
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
					//System.out.println(c);
				}
				it++;
			}
		}	

	}

	public static void compareValues(String path) throws IOException {


		getOurs(path);
		getTheirs(path);
		ArrayList<String> longMO = RulesLongMethod.longValues;
		VP = 0;
		VN = 0;
		FP = 0; 
		FN = 0;


		System.out.println("tamanho da lista " + nameMO.size());

		for (int i=0; i< nameMO.size(); i++) {

			boolean limite = true;

			for (int j = 1; j< nameMT.size(); j++) {

				if(limite) {

					if(nameMO.get(i).contains(nameMT.get(j))) {


						System.out.println();
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

		System.out.println("VN = " + VN + "VP = " + VP + "FN = " + FN + "FP = " + FP);
	}
}

