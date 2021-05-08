package Grupo31.g31;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javaparser.ParseException;

public class Create_Method {

	public static ArrayList<Method> a = new ArrayList<Method>();

	static int testeN;
	static int testeLoc;

	static int iterator = 1;
	static int id = 1;
	static int rownum = 1;
	static int nomC;
	static XSSFWorkbook workbook = new XSSFWorkbook();
	static XSSFSheet sh = workbook.createSheet("Metodo");

	static Row row; 
	static int numberOfClasses;


	void fillmethod(File file) {
		
	try {
		numberOfClasses++;
			String fileS = file.getAbsolutePath();
			
			String className = file.getAbsolutePath().toString().substring(file.getAbsolutePath().toString().lastIndexOf("\\") + 1); 
			className.getClass();
			
			String classNameWJ = className.replace(".java", " ");

			LOC_class locClass = new LOC_class(fileS);
			int locC = locClass.Contar();

			WMC_class wmcClass = new WMC_class(fileS);
			int wmcC = wmcClass.contagem();

			CYCLO_method cycloMethod = new CYCLO_method(fileS);
			ArrayList <Integer> cycloList = cycloMethod.getContador();
			int nomC = cycloMethod.getNomClass();
			ArrayList<String> nameMethods = cycloMethod.getNameOfMethods();
			
			LOC_method locMethod = new LOC_method(fileS);
			ArrayList<Integer> locList = locMethod.getList();
	
			String packName = locClass.s1;

			createData(packName, classNameWJ, nameMethods, nomC, locC, wmcC, locList ,cycloList);

			CreationHelper creationHelper = workbook.getCreationHelper();
			CellStyle dataStyle = workbook.createCellStyle();
	
			XSSFWorkbook workbook = new XSSFWorkbook();

			// sheet
			XSSFSheet sh = workbook.createSheet("Metodo");

			// top row
			String[] columnHeadings = { "MethodID", "package", "class", "method", "NOM_class",
					"LOC_class", "WMC_class", "is_God_Class", "LOC_method", "CYCLO_method", "is_Long_Method" };
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 12);
			headerFont.setColor(IndexedColors.BLACK.index);

			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFont(headerFont);
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

			// header row
			Row headerRow = sh.createRow(0);
			for (int i = 0; i < columnHeadings.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columnHeadings[i]);
				cell.setCellStyle(headerStyle);
			}
			
			int rownum = 1;
			for (Method f : a) {

				Row row = sh.createRow(rownum++);
				row.createCell(0).setCellValue(f.getMethodId());
				System.out.println(f.getMethodId());
				row.createCell(1).setCellValue(f.getName_package());
				row.createCell(2).setCellValue(f.getName_class());
				row.createCell(3).setCellValue(f.getName_method());
				row.createCell(4).setCellValue(f.getNom_Class());
				row.createCell(5).setCellValue(f.getLoc_Class());
				row.createCell(6).setCellValue(f.getWmc_Class());
				row.createCell(8).setCellValue(f.getLoc_Method());
				row.createCell(9).setCellValue(f.getCYCLO_method());

			}

			for (int i = 0; i < columnHeadings.length; i++) {
				sh.autoSizeColumn(i);
			}
			  File desktopDir = new File(System.getProperty("user.home"), "Desktop");
			  String pathToDesktop = desktopDir.getPath();
			  FileOutputStream out =  new FileOutputStream(new File(desktopDir, GUI.fname + "_metrics.xlsx"));	
			
			 workbook.write(out);
			out.close();
			workbook.close();
			System.out.println("done");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createData (String packName, String className,  ArrayList <String> methodName, int nomC, int locC, int wmcC, ArrayList<Integer>
	locList, ArrayList<Integer> cycloList ) {
		
		for (int t = 0; t < nomC ; t++) {
			
			System.out.println("T:" + t + "  nom " + nomC);
			
			Method m;

			m = new Method(id, packName, className,methodName.get(t),nomC, locC, wmcC, locList.get(t), cycloList.get(t));
			a.add(m);
			id++;
		}
	}
}