package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import Support.Create_Method;

class Create_MethodTest {
	protected File file;
	protected Create_Method cm;
	@Test
	void testFillmethod() {
		file= new File("C:\\Users\\carol\\Desktop\\ISCTE-IUL\\Engenharia de Software\\jasml_0.10.zip_expanded\\src\\com\\jasml\\compiler\\SourceCodeParser.java");
		cm.fillmethod(file);
		assertEquals(1,cm.numberOfClasses);
		assertNotNull(cm.numberOfClasses);
		
	}

}
