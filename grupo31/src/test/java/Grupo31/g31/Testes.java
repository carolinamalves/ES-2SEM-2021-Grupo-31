package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Testes {

	@Test
	private static void correrLOC() {
		// TODO Auto-generated method stub
		String s=new String("as");
		LOC_class LOC1=new LOC_class(s);
		LOC1.Contar();
		AssertEquals();
		LOC1.getTotalLines();
	}
}
