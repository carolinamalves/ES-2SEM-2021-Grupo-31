package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Rules.RulesLongMethod;

class RulesLongMethodTest {
	protected String s;
	protected String s1;
	protected RulesLongMethod rlM= new RulesLongMethod();
	@Test
	void testRules() {
		s=("LOC_method > 15");
		s1=("LOC_method < 15");
		rlM.rules(s);
		rlM.rules(s1);
		assertNotNull(rlM.longValues);
		
	}

}
