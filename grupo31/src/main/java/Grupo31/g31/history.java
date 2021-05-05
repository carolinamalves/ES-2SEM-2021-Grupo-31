//package Grupo31.g31;
//
//import java.io.FileOutputStream;
//import java.io.IOException;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.CreationHelper;
//import org.apache.poi.ss.usermodel.FillPatternType;
//import org.apache.poi.ss.usermodel.Font;
//import org.apache.poi.ss.usermodel.IndexedColors;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class history {
//	
//	static XSSFWorkbook workbook = new XSSFWorkbook();
//	static XSSFSheet sh = workbook.createSheet("Metodo");
//
//	static Row row;
//	
//	static int rownum = 1;
//	
//	public static void createHistory(){
//		
//		String[] columnHeadings = { "Metric", "Operator", "Value", "AND/OR", "Metric", "Operator", "Value" };
//		Font headerFont = workbook.createFont();
//		headerFont.setBold(true);
//		headerFont.setFontHeightInPoints((short) 12);
//		headerFont.setColor(IndexedColors.BLACK.index);
//
//		CellStyle headerStyle = workbook.createCellStyle();
//		headerStyle.setFont(headerFont);
//		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
//
//		Row headerRow = sh.createRow(0);
//		for (int i = 0; i < columnHeadings.length; i++) {
//			Cell cell = headerRow.createCell(i);
//			cell.setCellValue(columnHeadings[i]);
//			cell.setCellStyle(headerStyle);
//		}
//	}
//	
//	
//	
//	
//	public static void saveHistory (String metrica1, String operador1, int valor1, String op, String metrica2, String operador2, int valor2) {
//		
//		try {
//		
//		String[] columnHeadings = { "Metric", "Operator", "Value", "AND/OR", "Metric", "Operator", "Value" };
//		Font headerFont = workbook.createFont();
//		headerFont.setBold(true);
//		headerFont.setFontHeightInPoints((short) 12);
//		headerFont.setColor(IndexedColors.BLACK.index);
//
//		CellStyle headerStyle = workbook.createCellStyle();
//		headerStyle.setFont(headerFont);
//		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//		headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
//
//		Row headerRow = sh.createRow(0);
//		for (int i = 0; i < columnHeadings.length; i++) {
//			Cell cell = headerRow.createCell(i);
//			cell.setCellValue(columnHeadings[i]);
//			cell.setCellStyle(headerStyle);
//		}
//
//		CreationHelper creationHelper = workbook.getCreationHelper();
//		CellStyle dataStyle = workbook.createCellStyle();
//
//
//		for (int numRules = 0; numRules < 3; numRules++) {
//			row = sh.createRow(rownum++);
//			row.createCell(0).setCellValue(metrica1);
//			row.createCell(1).setCellValue(operador1);
//			row.createCell(2).setCellValue(valor1);
//			row.createCell(3).setCellValue(op);
//			row.createCell(4).setCellValue(metrica2);
//			row.createCell(5).setCellValue(operador2);
//			row.createCell(6).setCellValue(valor2);
//		}
//
//		for (int i = 0; i < columnHeadings.length; i++) {
//			sh.autoSizeColumn(i);
//		}
//
//		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\inesv\\Desktop\\RuleHistory.xlsx");
//
//		workbook.write(fileOut);
//		fileOut.close();
//
//		workbook.close();
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
//	System.out.println("done");
//}
//		
//	}
//
//}
