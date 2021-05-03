package Grupo31.g31;

import java.util.ArrayList;

public class Rules {
	
	public static String m1 = "LOC_method";
	public static String m2 = "CYCLO_method";
	public static String m3 = "LOC_class";
	public static String m4 = "NOM_class";
	public static String m5 = "WMC_class";
	public static String op1 = "and";
	public static String op2 = "or";

	
	//regra 1 
		static boolean Regras (String met1 ,int valor1, String operador,String met2, int valor2) {
		
//			int rule = rField.indexOf(' ');
//			String metrica1 = rField.substring(0,rule);
//			int valor1 =Integer.parseInt(rField.substring(2,rule));
//			String opLogico = rField.substring(3,rule);
//			String metrica2 = rField.substring(4,rule);
//			int valor2 = Integer.parseInt(rField.substring(6,rule));
//			
			
			for(Method m: Create_Method.a) {
				
				for (int i = 0; i < m.getNom_Class(); i++) {
				
					//LOC_method > 50 E LOC_class >10
				
					if (met1.equals(m1) && met2.equals(m3) ) {
						if (m.getLoc_Method() > valor1 && m.getLoc_Class() > valor2) {
							return true;
						}
					
					}
					
					
					
					//WMC_class > 50 OU NOM_class > 10
					
					if (met1.equals(m5) && met2.equals(m4) ) {
						if (m.getLoc_Method() > valor1 || m.getCYCLO_method() > valor2) {
							return true;
						}
					
					}
				
				}
				
			}
			return false;
		}		
					
//LOC_method > 50 OU CYCLO_method >10
					
//					if (opLogico.equals(op2) && metrica1.equals(m1) && metrica2.equals(m2) ) {
//						if (m.getLoc_Method() > valor1 || m.getCYCLO_method() > valor2) {
//							return true;
//						}
//						return false;
//					}
					
		}
		
//		static boolean Regra2 (int WMC_min, int NOM_min) {
//			
//			for(Method m: Create_Method.a) {
//				
//				for (int i = 0; i < m.getNom_Class(); i++) {
//				
//					if(m.getWmc_Class() > WMC_min || m.getNom_Class() > NOM_min) {
//					return true;
//					}
//				}
//			}	
//			return false;
//		}

