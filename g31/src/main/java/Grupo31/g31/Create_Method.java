
package Grupo31.g31;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Create_Method extends GUI{

	public static int id;
	public static String namePack;
	public static String nameClass;
	public static String nameMethod;
	static  int nomClass1;
	static  int locClass1;
	static  int wmcClass1;
	static  int locMethod1;
	static  int cycloMethod1;



	static void fillmethod(File file) {

		try {
			
			HSSFWorkbook workbook= new HSSFWorkbook();

			// sheet
			HSSFSheet sh = workbook.createSheet("Metodo");

			//top row
			String[] columnHeadings = {"MethodId", "name_package", "name_class", "name_method", "Nom_Class", "Loc_Class", "Wmc_Class"
					,"is_God_Class","Loc_Method", "CYCLO_method","is_Long_Method"};
			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setFontHeightInPoints((short)12);
			headerFont.setColor(IndexedColors.BLACK.index);

			CellStyle headerStyle = workbook.createCellStyle();
			headerStyle.setFont(headerFont);
			headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);

			//header row
			Row headerRow =  sh.createRow(0);
			for(int i= 0; i<columnHeadings.length;i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columnHeadings[i]);
				cell.setCellStyle(headerStyle);
			}

			String fileS = file.getCanonicalPath();

			//id
			id = 1;
			//name Class
			nameClass = "neni";
			//name Package
			namePack = "oi";
			//nom class

			Nom_class nomClass = new Nom_class ();
			nomClass1 = nomClass.getNomClass();
			System.out.println(nomClass1);

			// loc metodo

			LOC_method locMethod = new LOC_method(fileS);
			locMethod1 = locMethod.getLocMethod();
			System.out.println(locMethod1);

			// loc class

			LOC_class locClass = new LOC_class();
			locClass1 = locClass.getTotalLines();
			System.out.println(locClass1);
			//wmc

			WMC_class wmcClass = new WMC_class(fileS);
			wmcClass1 = wmcClass.getWMC_class();
			System.out.println(wmcClass1);
			//cyclo 

			CYCLO_method cycloMethod = new CYCLO_method(fileS);
			cycloMethod1 = cycloMethod.getWmcClass();
			System.out.println(cycloMethod1);

		//	createData (id, namePack, nameClass, nameMethod, nomClass1, locClass1, wmcClass1, locMethod1, cycloMethod1 );
						ArrayList <Method> a = createData (id, namePack, nameClass, nameMethod, nomClass1, locClass1, wmcClass1, locMethod1, cycloMethod1 );
						
						CreationHelper creationHelper= workbook.getCreationHelper();
						CellStyle dataStyle = workbook.createCellStyle();

						int rownum = 1;
						for (Method i : a) {
			
			
							Row row = sh.createRow(rownum++);
							row.createCell(0).setCellValue(id);
							System.out.println(i.getMethodId());
							row.createCell(1).setCellValue(namePack);
							row.createCell(2).setCellValue(nameClass);
							row.createCell(3).setCellValue(nameMethod);
							row.createCell(4).setCellValue(nomClass1);
							row.createCell(5).setCellValue(locClass1);
							row.createCell(6).setCellValue(wmcClass1);
							row.createCell(8).setCellValue(locMethod1);
							row.createCell(9).setCellValue(cycloMethod1);
			
							a = createData(id, namePack, nameClass, nameMethod, nomClass1, locClass1, wmcClass1, locMethod1, cycloMethod1 );
			
						}

			for(int i=0; i<columnHeadings.length; i++) {
				sh.autoSizeColumn(i);
			}

			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\inesv\\OneDrive\\Ambiente de Trabalho\\carol.xls" );
			workbook.write(fileOut);

			fileOut.close();
			workbook.close();
			System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static ArrayList <Method> createData(int id, String namePack, String nameClass, String nameMethod, int nomClass,int locClass, int wmcClass, int locMethod, int cycloMethod)  {
		ArrayList<Method> a = new ArrayList<>();

		//meter valores
		a.add(new Method(1, "teste", "teste", "teste", nomClass,locClass, wmcClass, locMethod, cycloMethod ));

		return a;
	}

	public static void main(String[] args) {
		new Create_Method();

	}

}