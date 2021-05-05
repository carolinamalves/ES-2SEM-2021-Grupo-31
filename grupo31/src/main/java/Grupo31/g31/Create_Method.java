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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.github.javaparser.ParseException;

public class Create_Method extends GUI {

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

	public static void createMethod(List<File> list) throws ParseException, IOException, ClassNotFoundException {	

		for (File s : Leitura_Projetos.ficheiro){

			String className = s.getAbsolutePath().toString().substring(s.getAbsolutePath().toString().lastIndexOf("\\") + 1); 
			Class<? extends String> c = className.getClass();


			String packName = c.getClass().getPackageName();
			System.out.println(c.getClass().getPackage());

			String fileS = s.getAbsolutePath();
			String cNameWJ = className.substring(0, className.indexOf(".java"));
			Nom_class nomClass = new Nom_class();
			nomC = nomClass.nomClass("com.jasml.classes." + cNameWJ, s);
			//			int locC = nomClass.getLoc();


			LOC_class locClass = new LOC_class(fileS);
			int locC = locClass.Contar();

			WMC_class wmcClass = new WMC_class(fileS);
			int wmcC = wmcClass.contagem();

			CYCLO_method cycloMethod = new CYCLO_method(fileS);
			cycloMethod.getMethodLineNumbers();
			ArrayList <Integer> cycloList = cycloMethod.getContador();

			LOC_method locMethod = new LOC_method(fileS);
			ArrayList<Integer> locList = locMethod.getList();

			createData(packName, className, "methodName", nomC, locC, wmcC, locList ,cycloList);
		}
	}

	public static void createExcel() {

		try{

			String[] columnHeadings = { "MethodId", "name_package", "name_class", "name_method", "Nom_Class",
					"Loc_Class", "Wmc_Class", "is_God_Class", "Loc_Method", "CYCLO_method", "is_Long_Method" };
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short) 12);
			headerFont.setColor(IndexedColors.BLACK.index);

			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFont(headerFont);
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

			Row headerRow = sh.createRow(0);
			for (int i = 0; i < columnHeadings.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columnHeadings[i]);
				cell.setCellStyle(headerStyle);
			}

			CreationHelper creationHelper = workbook.getCreationHelper();
			CellStyle dataStyle = workbook.createCellStyle();

			for (Method met : a) {

				row = sh.createRow(rownum++);
				row.createCell(0).setCellValue(met.getMethodId());
				row.createCell(1).setCellValue(met.getName_package());
				row.createCell(2).setCellValue(met.getName_class());
				row.createCell(3).setCellValue(met.getName_method());
				row.createCell(4).setCellValue(met.getNom_Class());
				row.createCell(5).setCellValue(met.getLoc_Class());
				row.createCell(6).setCellValue(met.getWmc_Class());
				row.createCell(8).setCellValue(met.getLoc_Method());
				row.createCell(9).setCellValue(met.getCYCLO_method());

				Rules.longMethod(GUI.v1, GUI.v2,met);
				Rules.godClass(GUI.v3, GUI.v4, met);
			}

			for (int i = 0; i < columnHeadings.length; i++) {
				sh.autoSizeColumn(i);
			}

			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\inesv\\Desktop\\" + 
					GUI.fname  + "_metrics.xlsx");

			workbook.write(fileOut);
			fileOut.close();

			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("done");
	}

	public static void createData (String packName, String className, String methodName, int nomC, int locC, int wmcC, ArrayList<Integer>
	locList, ArrayList<Integer> cycloList ) {
		testeN=0;
		testeLoc=0;
		
		for (int t = 0; t < nomC ; t++) {
			Method m;

			m = new Method(id, packName, className,"nome do metodo",nomC, locC, wmcC, locList.get(t), 1);
			a.add(m);
//			System.out.println(locList.get(0));
			id++;
//			System.out.println("LOC VALOR" + t);
//			//			cycloList.remove(id);
//			locList.remove(t);
			
		}

	}
}