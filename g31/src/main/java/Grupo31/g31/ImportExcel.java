package Grupo31.g31;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;

public class ImportExcel {
	public static String keep = "";

	public static void chooseFile() {
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();

			keep = selectedFile.getName();
			System.out.println(keep);
		}
	}
	
	private static String cellToString(HSSFCell cell) {
		CellType type = cell.getCellType();
		Object result;
		switch (type) {
		case NUMERIC: 
			result = cell.getNumericCellValue();
			break;
		case STRING :
			result = cell.getStringCellValue();
			break;
		default:
			throw new RuntimeException("there are no support for this type of cell");
		}
		return result.toString();
	}
	
	public static void main(String[] args) throws IOException {

		// File Openner
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("JComboBox Test");
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("Select File");

		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				chooseFile();
			}
		});
		frame.add(button);
		frame.pack();
		frame.setVisible(true);
		// end of the File opener
		// read from excel

		chooseFile(); // <- make sure that the file is chosen

		File excel = new File(keep);

		FileInputStream fis = new FileInputStream(excel);
		HSSFWorkbook wb = new HSSFWorkbook(fis);


		String sheetName = "Assignments"; //if my tempsheet start with "sheetname" thats okay

		for (int i = 0; i < wb.getNumberOfSheets() - 1; i++) {
			HSSFSheet tmpSheet = wb.getSheetAt(i);
			if (tmpSheet.getSheetName().startsWith(sheetName)) {

			} else {
				wb.removeSheetAt(i);
			}
		}


	}// end of the main
}