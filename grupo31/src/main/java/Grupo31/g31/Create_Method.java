
package Grupo31.g31;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

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
	public static int nomClass1;
	public static int locClass1;
	public static int wmcClass1;
	public static int locMethod1;
	public static int cycloMethod1;

		
		static void fillmethod() {
		try {
			XSSFWorkbook workbook= new XSSFWorkbook();

			// sheet
			XSSFSheet sh = workbook.createSheet("Metodo");

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

			String fileS = file.getAbsolutePath();
			//id

			//name class

			//name package

			//name method

			//nom class -- done

			Nom_class nomClass = new Nom_class();
			nomClass.nomClass();

			//loc class -- done

			LOC_class locClass = new LOC_class();
			locClass.Contar();

			//wmc -- done

			WMC_class wmcClass = new WMC_class(fileS);
			wmcClass.contagem();
			
			//locMethod

			LOC_method locMethod = new LOC_method(fileS);
			locMethod. getMethodLineNumbers();

			//cyclo method 

			CYCLO_method cycloMethod = new CYCLO_method(fileS);
			cycloMethod.getMethodLineNumbers();



			ArrayList <Method> a = createData(1,"nomeTeste","nomeTeste","nomeTeste",nomClass, locClass,wmcClass, locMethod, cycloMethod );
			//a = new ArrayList <Method>();
			CreationHelper creationHelper= workbook.getCreationHelper();
			CellStyle dataStyle = workbook.createCellStyle();

			int rownum = 1;
			for (Method i : a) {

				Row row = sh.createRow(rownum++);
				row.createCell(0).setCellValue(i.getMethodId());
				System.out.println(i.getMethodId());
				row.createCell(1).setCellValue(i.getName_package());
				row.createCell(2).setCellValue(i.getName_class());
				row.createCell(3).setCellValue(i.getName_method());
				row.createCell(4).setCellValue(i.getNom_Class());
				row.createCell(5).setCellValue(i.getLoc_Class());
				row.createCell(6).setCellValue(i.getWmc_Class());
				row.createCell(8).setCellValue(i.getLoc_Method());
				row.createCell(9).setCellValue(i.getCYCLO_method());



			}

			for(int i=0; i<columnHeadings.length; i++) {
				sh.autoSizeColumn(i);
			}


			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\inesv\\OneDrive\\Ambiente de Trabalho\\" + file.getName() +"_metrics.xlsx");
			System.out.println(fileOut);
			workbook.write(fileOut);

			fileOut.close();
			workbook.close();
			System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static ArrayList <Method> createData(int id, String namePack, String nameClass, String nameMethod, Nom_class nomClass, LOC_class locClass, WMC_class wmcClass, LOC_method locMethod, CYCLO_method cycloMethod)  {


		ArrayList<Method> a = new ArrayList<Method>();

		//meter valores
		a.add(new Method(id, namePack, nameClass, nameMethod, nomClass.getNomClass(), locClass.getTotalLines(), wmcClass.getWMC_class(), locMethod.getTotal(), 1 ));

		return a;
	}

	public static void main(String[] args) {
		new Create_Method();
	}
}