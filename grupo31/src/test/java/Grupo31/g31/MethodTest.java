package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Support.Method;

class MethodTest {
	protected Method m= new Method(1,"a","a","a",1,1,1,1,1);
	@Test
	void testGetMethodId() {
		assertEquals(1,m.getMethodId());
	}

	@Test
	void testGetName_package() {
		assertEquals("a",m.getName_package());
	}

	@Test
	void testGetName_class() {
		assertEquals("a",m.getName_class());
	}

	@Test
	void testGetName_method() {
		assertEquals("a",m.getName_method());
	}

	@Test
	void testGetNom_Class() {
		assertEquals(1,m.getNom_Class());
	}

	@Test
	void testGetLoc_Class() {
		assertEquals(1,m.getLoc_Class());
	}

	@Test
	void testGetWmc_Class() {
		assertEquals(1,m.getWmc_Class());
	}

	@Test
	void testGetLoc_Method() {
		assertEquals(1,m.getLoc_Method());
	}

	@Test
	void testGetCYCLO_method() {
		assertEquals(1,m.getCYCLO_method());
	}

	@Test
	void testMethod() {

	}
}