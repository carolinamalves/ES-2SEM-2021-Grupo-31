package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import Metrics.WMC_class;

class WMC_classTest {
	protected String file;
	protected WMC_class wmC;

	@Test
	void testWMC_class() {

	}

	@Test
	void testContagem() {

	}

	@Test
	void testGetWMC_class() throws FileNotFoundException {
		file = "C:\\Users\\carol\\Desktop\\ISCTE-IUL\\Engenharia de Software\\jasml_0.10.zip_expanded\\src\\com\\jasml\\compiler\\SourceCodeParser.java";
		file="C:\\Users\\Admin\\Desktop\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java";
		wmC=new WMC_class(file);
		assertEquals(0,wmC.contagem());
		assertEquals(6,wmC.contagem());
	}
}