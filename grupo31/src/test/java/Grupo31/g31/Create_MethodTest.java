package Grupo31.g31;

import java.io.File;

import org.junit.jupiter.api.Test;

import Support.Create_Method;

class Create_MethodTest {
	protected File file;
	protected Create_Method cm;
	@Test
	void testFillmethod() {
		file = new File("C:\\Users\\carol\\Desktop\\ISCTE-IUL\\Engenharia de Software\\jasml_0.10.zip_expanded\\src\\compiler\\SoureParseCode.java");
		cm.fillmethod(file);
		//assertEquals(0,file);
	}
}