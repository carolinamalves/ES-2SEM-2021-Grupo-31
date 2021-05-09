package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Support.Leitura_Projetos;

class Leitura_ProjetosTest {
	protected String s;
	protected Leitura_Projetos lP=new Leitura_Projetos();
	//protected ArrayList<String> aL;

	@Test
	void testLista() {
		s=("C:\\Users\\carol\\Desktop\\ISCTE-IUL\\Engenharia de Software\\jasml_0.10.zip_expanded\\src\\com\\jasml\\compiler");
		//aL.add("C:\\Users\\Admin\\Desktop\\jasml_0.10\\src\\com\\jasml\\classes\\Method.java");
		lP.lista(s);
		assertEquals(54,lP.lista(s).size());
		assertNotNull(lP.lista(s).size());
		
	}

}
