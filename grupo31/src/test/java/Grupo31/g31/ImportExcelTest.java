package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import Support.ImportExcel;
	
class ImportExcelTest {
	protected ImportExcel iE;
	protected File file;
	protected File file2;
	@Test
	void testFillData() {
		file= new File("C:\\Users\\carol\\Desktop\\src_metrics.xlsx");
	//	file2= new File("C:\\Users\\Admin\\Desktop\\Excil.xlsx");
		iE=new ImportExcel();
		iE.fillData(file);
		
		assertEquals(0, iE.index);
		assertNotNull(iE.index);
		
		
	}

}
