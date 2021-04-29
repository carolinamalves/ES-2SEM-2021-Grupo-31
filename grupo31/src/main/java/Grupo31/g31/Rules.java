package Grupo31.g31;

import java.util.ArrayList;

public class Rules {
	

	
	//regra 1 
		static boolean Regra1 (int LOC_min, int CYCLO_min) {
		
			for(Method m: Create_Method.a) {
				
				for (int i = 0; i < m.getNom_Class(); i++) {
				
					if(m.getLoc_Method() > LOC_min && m.getCYCLO_method() > CYCLO_min) {
					return true;
					}
				}
			}
			return false;
		}
		
		static boolean Regra2 (int WMC_min, int NOM_min) {
			
			for(Method m: Create_Method.a) {
				
				for (int i = 0; i < m.getNom_Class(); i++) {
				
					if(m.getWmc_Class() > WMC_min || m.getNom_Class() > NOM_min) {
					return true;
					}
				}
			}	
			return false;
		}

}
