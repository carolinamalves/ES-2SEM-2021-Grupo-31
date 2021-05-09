package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class historyTest {

	protected ArrayList<String> s;
	protected history h;
	@Test
	void testUpdateHistoric() {
		fail("Not yet implemented");
	}

	@Test
	void testClear() {
		fail("Not yet implemented");
	}

	@Test
	void testViewHistoric() {
		s.add("aa");
		ArrayList<String> hist=h.viewHistoric("C:\\Users\\Admin\\Desktop\\historico.txt");
		
		assertEquals(s,hist);
	}

}
