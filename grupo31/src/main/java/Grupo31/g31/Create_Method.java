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

	public static int id = 0;
	public static String namePack;
	public static String nameClass;
	public static String nameMethod;
	public static int nomClass1;
	public static int locClass1;
	public static int wmcClass1;
	public static int locMethod1;
	public static int cycloMethod1;
	public static ArrayList<Method> a = new ArrayList<Method>();

	static void fillmethod(List <File> file, String fileName) {
			
		try {


			XSSFWorkbook workbook = new XSSFWorkbook();

			// sheet
			XSSFSheet sh = workbook.createSheet("Metodo");

			// top row
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


			for (File s : Leitura_Projetos.ficheiro) {


				// header row
				Row headerRow = sh.createRow(0);
				for (int i = 0; i < columnHeadings.length; i++) {
					Cell cell = headerRow.createCell(i);
					cell.setCellValue(columnHeadings[i]);
					cell.setCellStyle(headerStyle);
				}

				String fileS = s.getAbsolutePath();

			

				Nom_class nomClass = new Nom_class();
				nomClass.nomClass();

				// loc class -- done

				LOC_class locClass = new LOC_class(fileS);
				locClass.Contar();

				// wmc -- done

				WMC_class wmcClass = new WMC_class(fileS);
				wmcClass.contagem();

				// locMethod

				System.out.print("antes do for : " + nomClass.getNomClass());

				LOC_method locMethod = new LOC_method(fileS);
				locMethod.getMethodLineNumbers();

				// cyclo method

				CYCLO_method cycloMethod = new CYCLO_method(fileS);
				
				String className = s.getAbsolutePath().toString().substring(s.getAbsolutePath().toString().lastIndexOf("\\") + 1);

				createData(id, GUI.fname, className, "nomeTeste", nomClass, locClass, wmcClass, locMethod, cycloMethod);

				CreationHelper creationHelper = workbook.getCreationHelper();
				CellStyle dataStyle = workbook.createCellStyle();
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
				
			}
				fileName = "C:\\Users\\inesv\\Desktop\\" + 
				GUI.fname  + "_metrics.xlsx";

				System.out.println(fileName);
			
				
				FileOutputStream fileOut = new FileOutputStream(fileName);
				System.out.println(fileOut);
				workbook.write(fileOut);

				fileOut.close();
				workbook.close();
				System.out.println("done");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	//	//regra 1 
	//	static boolean Regra1 (int LOC_min, int CYCLO_min) {
	//	
	//		for(Method m: a) {
	//			
	//			for (int i = 0; i < m.getNom_Class(); i++) {
	//			
	//				if(m.getLoc_Method() > LOC_min && m.getCYCLO_method() > CYCLO_min) {
	//				return true;
	//				}
	//			}
	//		}
	//		return false;
	//	}
	//	
	//	static boolean Regra2 (int WMC_min, int NOM_min) {
	//		
	//		for(Method m: a) {
	//			
	//			for (int i = 0; i < m.getNom_Class(); i++) {
	//			
	//				if(m.getWmc_Class() > WMC_min || m.getNom_Class() > NOM_min) {
	//				return true;
	//				}
	//			}
	//		}	
	//		return false;
	//	}

	private static void createData(int id1, String namePack, String nameClass, String nameMethod1, Nom_class nomClass,
			LOC_class locClass, WMC_class wmcClass, LOC_method locMethod, CYCLO_method cycloMethod)
					throws ParseException, IOException {
		// Nom_class nomClass1 = new Nom_class();
		// nomClass.nomClass();

		for (int i = 0; i < nomClass.getNomClass(); i++) {
			// meter valores
			id++;
			System.out.println("antes do Array " + locMethod.getTotal());

			Method m = new Method(id, namePack, nameClass, nameMethod, nomClass.getNomClass(), locClass.getTotalLines(),
					wmcClass.getWMC_class(), locMethod.getTotal(), cycloMethod.getContador());

			a.add(m);
			
		}

		for(Method m: a) {
			System.out.println("linha no array: " + m.getLoc_Method());
		}
	}
	//
	//	public static void main(String[] args) {
	//		new Create_Method();
	//	}
}