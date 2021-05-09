package Grupo31.g31;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import Support.history;

class historyTest {

	protected ArrayList<String> s=new ArrayList<String>();
	protected history h;
	@Test
	void testUpdateHistoric() throws IOException {
		h = new history();
//		File historico = new File("historico.txt");
//		FileWriter writer= new FileWriter(historico,true);
//	    String stringHistoric = "aa";
//	    writer(s, writer);
//	   
//	    writer.close();
		s.add("LOC_method > 12");
	   
		h.updateHistoric("C:\\Users\\carol\\Desktop\\historico.txt",s);
		
		assertEquals(s, h.viewHistoric(s.get(1)));
		assertNotNull(h.viewHistoric(s.get(1)));

	}

	@Test
	void testViewHistoric() {
		System.out.println(s);
		ArrayList<String> hist=h.viewHistoric("C:\\Users\\carol\\Desktop\\historico.txt");
		
		assertEquals(s,hist);
		assertNotNull(hist);
	}

}
