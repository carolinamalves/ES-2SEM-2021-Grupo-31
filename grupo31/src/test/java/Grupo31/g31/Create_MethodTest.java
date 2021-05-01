package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class Create_MethodTest {
	protected File file;
	protected Create_Method cm;
	@Test
	void testFillmethod() {
		file= new File("C:\\Users\\admin\\Desktop\\jasml\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java");
		cm.fillmethod(file);
	}

}
