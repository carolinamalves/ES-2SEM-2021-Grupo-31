package Grupo31.g31;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Rules.RulesGodClass;

class RulesGodClassTest {
	protected String s;
	protected String s1;
	protected RulesGodClass rlM= new RulesGodClass();
	@Test
	void testRules() {
		
			s=("LOC_class > 15");
			s1=("LOC_class < 15");
			rlM.rules(s);
			rlM.rules(s1);
			assertNotNull(rlM.godValues);
			
		}
	}


