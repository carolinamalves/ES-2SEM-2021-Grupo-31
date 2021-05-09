package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class WMC_classTest {
	protected String file;
	protected WMC_class wmC;
	

	@Test
	void testGetWMC_class() throws FileNotFoundException {
		file="C:\\Users\\Admin\\Desktop\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java";
		wmC=new WMC_class(file);
		assertEquals(6,wmC.contagem());
	}

}
