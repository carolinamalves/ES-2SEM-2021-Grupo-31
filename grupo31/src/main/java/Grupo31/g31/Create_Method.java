
package Grupo31.g31;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.batik.transcoder.keys.IntegerKey;
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

	public static int id;
	public static String namePack;
	public static String nameClass;
	public static String nameMethod;
	public static int nomClass1;
	public static int locClass1;
	public static int wmcClass1;
	public static int locMethod1;
	public static int cycloMethod1;
	public static ArrayList<Method> a = new ArrayList<Method>();

	static void fillmethod(File file) {
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

			// header row
			Row headerRow = sh.createRow(0);
			for (int i = 0; i < columnHeadings.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columnHeadings[i]);
				cell.setCellStyle(headerStyle);
			}

			String fileS = file.getAbsolutePath();

			// name class

			// name package

			// name method

			Nom_class nomClass = new Nom_class();
			nomClass.nomClass();

			// loc class -- done

			LOC_class locClass = new LOC_class(fileS);
			locClass.Contar();

			// wmc -- done

			WMC_class wmcClass = new WMC_class(fileS);
			wmcClass.contagem();

			// locMethod

			// for (int f = 0; f < nomClass.getNomClass(); f++) {

			LOC_method locMethod = new LOC_method(fileS);
			// locMethod.getMethodLineNumbers();

			// cyclo method

			CYCLO_method cycloMethod = new CYCLO_method(fileS);
			// cycloMethod.getList().get(f);

			createData(1, "nomeTeste", "nomeTeste", "nomeTeste", nomClass, locClass, wmcClass, locMethod, cycloMethod);

			// }

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

			FileOutputStream fileOut = new FileOutputStream(
					"C:\\Users\\admin\\Desktop\\" + file.getName() + "_metrics.xlsx");
			System.out.println(fileOut);
			workbook.write(fileOut);

			fileOut.close();
			workbook.close();
			System.out.println("done");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void createData(int id, String namePack, String nameClass, String nameMethod, Nom_class nomClass,
			LOC_class locClass, WMC_class wmcClass, LOC_method locMethod, CYCLO_method cycloMethod)
			throws ParseException, IOException {
		// Nom_class nomClass1 = new Nom_class();
		// nomClass.nomClass();

		for (int i = 0; i < nomClass.getNomClass(); i++) {
			// meter valores

			Method m = new Method(id, namePack, nameClass, nameMethod, nomClass.getNomClass(), locClass.getTotalLines(),
					wmcClass.getWMC_class(), locMethod.getList().get(i), cycloMethod.getList().get(i));
			System.out.println("teste------" + i);
			System.out.println(nomClass.getNomClass());
			System.out.println(locClass.getTotalLines());
			System.out.println(wmcClass.getWMC_class());
			System.out.println(locMethod.getList().get(i));
			System.out.println(cycloMethod.getList().get(i));
			a.add(m);
		}
	}

	public static void main(String[] args) {
		new Create_Method();
	}
}