package Grupo31.g31;

public class Rules {
	public static String m1 = "LOC_method";
	public static String m2 = "CYCLO_method";
	public static String m3 = "LOC_class";
	public static String m4 = "NOM_class";
	public static String m5 = "WMC_class";
	public static String op1 = "and";
	public static String op2 = "or";
	public static String oper1 = ">";
	public static String oper2 = "<";
	
	static void longMethod (int valor1, int valor2, Method m) {

		if (m.getLoc_Method() > valor1 && m.getCYCLO_method() > valor2) {

			Create_Method.row.createCell(10).setCellValue("TRUE");
			System.out.println("LONG METHOD TRUE");

		} else {

			Create_Method.row.createCell(10).setCellValue("FALSE");
			System.out.println("LONG METHOD FALSE");
		}
	}

	static void godClass (int valor1, int valor2, Method m) {

		if (m.getWmc_Class() > valor1 || m.getNom_Class() > valor2) {

			Create_Method.row.createCell(7).setCellValue("TRUE");
			System.out.println("GOD CLASS TRUE");

		} else{

			Create_Method.row.createCell(7).setCellValue("FALSE");
			System.out.println("GOD CLASS FALSE");
		}
	}
	
	static void userRules (String metrica1, String operador1, int valor1, String op, String metrica2, String operador2, int valor2, Method m) {
		
		// LOC_Class > valor || nomClass < valor 
		
		if (metrica1.equals(m3) && operador1.equals(oper1) && op.equals(op2) && metrica2.equals(m4) && operador2.equals(oper2)) {
			if (m.getLoc_Method() > valor1 && m.getLoc_Class() > valor2) {
				
				System.out.println("REGRA USER : " + "TRUE");
			}else {
					System.out.println("REGRA USER : " + "FALSE");
				}
			}
	}
}