package Grupo31.g31;

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
			//			//numero de linhas
			//
			//			LOC_class fl = new LOC_class();
			//			fl.Contar();


			ArrayList <Method> a;
			a = new ArrayList <Method>();
			CreationHelper creationHelper= workbook.getCreationHelper();
			CellStyle dataStyle = workbook.createCellStyle();

			int rownum = 1;
			for (Method i : a) {
				int id = i.getMethodId();
				String namePack = i.getName_package();
				String nameClass = i.getName_class();
				String nameMethod = i.getName_method();
				int nomClass = i.getNom_Class();
				int locClass = i.getLoc_Class();
				int wmcClass = i.getWmc_Class();
				int locMethod = i.getLoc_Method();
				int cycloMethod = i.getCYCLO_method();

				Row row = sh.createRow(rownum++);
				row.createCell(0).setCellValue(id);
				System.out.println(i.getMethodId());
				row.createCell(1).setCellValue(namePack);
				row.createCell(2).setCellValue(nameClass);
				row.createCell(3).setCellValue(nameMethod);
				row.createCell(4).setCellValue(nomClass);
				row.createCell(5).setCellValue(locClass);
				row.createCell(6).setCellValue(wmcClass);
				row.createCell(8).setCellValue(locMethod);
				row.createCell(9).setCellValue(cycloMethod);

				//a = createData(id, namePack, nameClass, nameMethod, nomClass, locClass, wmcClass, locMethod, 1 );
			}

			for(int i=0; i<columnHeadings.length; i++) {
				sh.autoSizeColumn(i);
			}

			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\inesv\\OneDrive\\Ambiente de Trabalho\\java1.xlsx" );
			workbook.write(fileOut);

			fileOut.close();
			workbook.close();
			System.out.println("done");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static ArrayList <Method> createData(int id, String namePack, String nameClass, String nameMethod, int nomClass, LOC_class locClass, int wmcClass, int locMethod, int cycloMethod)  {
		ArrayList<Method> a = new ArrayList();
		//meter valores
		a.add(new Method(id, namePack, nameClass, nameMethod, nomClass, LOC_class.getTotalLines(), wmcClass, locMethod, cycloMethod ));

		return a;
	}

	public static void main(String[] args) {
		//Create_Method m = new Create_Method();
	}
}