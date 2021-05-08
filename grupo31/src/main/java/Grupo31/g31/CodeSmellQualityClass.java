package Grupo31.g31;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xalan.xsltc.compiler.sym;

public class CodeSmellQualityClass {

	static ArrayList<String> nameCT ;
	static ArrayList<String> nameCO ;
	static ArrayList<String> godT;
	static ArrayList<String> godO ;

	static HashMap <String, String> theirs = new HashMap<>();
	static HashMap <String, String> ours= new HashMap<>();

	static int VP;
	static int VN;
	static int FP;
	static int FN;

	static ArrayList<Method> a = Create_Method.a;

	public static void getTheirs() throws IOException {

		nameCT = new ArrayList<String>();
		godT= new ArrayList<String>();
		String envFilePath =("C:\\Users\\inesv\\OneDrive\\Ambiente de Trabalho\\Code_Smells.xlsx");


		FileInputStream fileName = new FileInputStream(new File("C:\\Users\\inesv\\OneDrive\\Ambiente de Trabalho\\Code_Smells.xlsx"));
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
					nameCT.add(c.toString());
					nameCT.set(it, c.toString());
					//System.out.println(c);
				}
				it++;
			}


			System.out.println("nameT" + nameCT);
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
					godT.add(c.toString());
					godT.set(it, c.toString());
					//System.out.println(c);
				}
				it++;
			}


			System.out.println("GodT" + godT);
		}

		//				for (int i=0; i < godT.size(); i++ ) {
		//					theirs.put(nameCT.get(i), godT.get(i));
		//				}
		//				return theirs;
	}





	public static void getOurs() throws IOException {


		nameCO = new ArrayList<String>();
		FileInputStream fileName = new FileInputStream(new File("C:\\Users\\inesv\\Desktop\\src_metrics.xlsx"));
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
					nameCO.add(c.toString());
					nameCO.set(it, c.toString());
					//System.out.println(c);
				}
				it++;
			}
			System.out.println("name Ours" + nameCO);
		}	

	}

	public static void compareValues() throws IOException {


		getOurs();
		getTheirs();
		ArrayList<String> godO = RulesGodClass.godValues;
		VP = 0;
		VN = 0;
		FP = 0; 
		FN = 0;
		System.out.println("god values : " + godO);
		System.out.println("nome deles : " + nameCT);
		System.out.println("nome nosso : " + nameCO);

		
		System.out.println("tamanho da lista " + nameCO.size());
	
		for (int i=0; i< nameCO.size(); i++) {
			
			boolean limite = true;
			
				for (int j = 1; j< nameCT.size(); j++) {

				if(limite) {
					
					if(nameCO.get(i).contains(nameCT.get(j))) {
						
						
						System.out.println();
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

		System.out.println("VN = " + VN + "VP = " + VP + "FN = " + FN + "FP = " + FP);
	}
}


