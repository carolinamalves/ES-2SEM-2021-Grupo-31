package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;
	
class ImportExcelTest {
	protected ImportExcel iE;
	protected File file;
	@Test
	void testFillData() {
		file= new File("C:\\Users\\admin\\Desktop\\jasml\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java");
		iE=new ImportExcel();
		iE.fillData(file);
	}

}
