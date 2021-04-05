package Grupo31.g31;



import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class CreateMetodo {

	public static void main(String[] args) {
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
			
			//numero de linhas
			FileRead fl = new FileRead();
			fl.Contar();
			
			
			//fill data
			ArrayList<Metodo> a = createData(fl);
			CreationHelper creationHelper= workbook.getCreationHelper();
			CellStyle dataStyle = workbook.createCellStyle();
			
			
			int rownum = 1;
			for (Metodo i : a) {
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
			
			FileOutputStream fileOut = new FileOutputStream("C:\\Users\\alexm\\Desktop\\teste123.xlsx");
			workbook.write(fileOut);
			
			
			fileOut.close();
			workbook.close();
			System.out.println("done");
			
			
			
			
			
			
		}
			
			
		catch(Exception e) {
			e.printStackTrace();
		}

	

	}

	private static ArrayList<Metodo> createData(FileRead fl){
		ArrayList<Metodo> a = new ArrayList();
		
		//meter valoress
		a.add(new Metodo(1, "oi", "oii", "oiii", 2, fl.getTotalLines(), 4, 5,6 ));
		
		
		return a;
	}
	
	
	
	
	
	
	
	
	
	
	
}
