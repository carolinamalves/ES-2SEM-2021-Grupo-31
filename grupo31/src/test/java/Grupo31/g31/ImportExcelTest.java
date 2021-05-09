package Grupo31.g31;

import java.io.File;

import org.junit.jupiter.api.Test;

import Support.ImportExcel;

class ImportExcelTest {
	protected ImportExcel iE;
	protected File file;
	@Test
	void testFillData() {

		file = new File("C:\\Users\\carol\\Engenharia de Software\\jasml\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java");
		iE = new ImportExcel();
		//	iE.fillData(file);

		file= new File("C:\\Users\\Admin\\Desktop\\src_metrics.xlsx");
		iE=new ImportExcel();
		iE.fillData(file);

	}
}