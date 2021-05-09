package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Metrics.LOC_class;

class LOC_classTest {
	protected  String file;
	protected  LOC_class lC;
	
	@Test
	public void testLOC_class() {
		
	}

	@Test
	void testGetTotalLines() {

	}

	@Test
	void testSetTotalLines() {

	}

	@Test
	void testContar() {

		file="C:\\Users\\carol\\Desktop\\ISCTE-IUL\\Engenharia de Software\\jasml_0.10.zip_expanded\\src\\com\\jasml\\compiler\\SourceCodeParser.java";

		file="C:\\Users\\Admin\\Desktop\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java";

		lC= new LOC_class(file);
		assertEquals(38,lC.Contar());
	}

}
