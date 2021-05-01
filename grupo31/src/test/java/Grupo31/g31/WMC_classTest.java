package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

class WMC_classTest {
	protected String file;
	protected WMC_class wmC;
	
	@Test
	void testWMC_class() {
		fail("Not yet implemented");
	}

	@Test
	void testContagem() {
		fail("Not yet implemented");
	}

	@Test
	void testGetWMC_class() throws FileNotFoundException {
		file="C:\\Users\\admin\\Desktop\\jasml\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java";
		wmC=new WMC_class(file);
		assertEquals(0,wmC.contagem());
		assertEquals(0,wmC.getWMC_class());
	}

}
