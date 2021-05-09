package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LOC_classTest {
	protected  String file;
	protected  LOC_class lC;
	
	@Test
	public void testLOC_class() {
		
	}

	@Test
	void testGetTotalLines() {
		fail("Not yet implemented");
	}

	@Test
	void testSetTotalLines() {
		fail("Not yet implemented");
	}

	@Test
	void testContar() {
		file="C:\\Users\\Admin\\Desktop\\jasml_0.10\\src\\com\\jasml\\classes\\Attribute.java";
		lC= new LOC_class(file);
		assertEquals(38,lC.Contar());
	}

}
