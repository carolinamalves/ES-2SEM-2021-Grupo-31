package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Support.Method;

class MethodTest {
	protected Method m= new Method(1,"a","a","a",1,1,1,1,1);
	@Test
	void testGetMethodId() {
		m.getMethodId();
	}

	@Test
	void testGetName_package() {
		m.getName_package();
	}

	@Test
	void testGetName_class() {
		m.getName_class();
	}

	@Test
	void testGetName_method() {
		m.getName_method();
	}

	@Test
	void testGetNom_Class() {
		m.getNom_Class();
	}

	@Test
	void testGetLoc_Class() {
		m.getLoc_Class();
	}

	@Test
	void testGetWmc_Class() {
		m.getWmc_Class();
	}

	@Test
	void testGetLoc_Method() {
		m.getLoc_Method();
	}

	@Test
	void testGetCYCLO_method() {
		m.getCYCLO_method();
	}

	@Test
	void testMethod() {

	}

}
