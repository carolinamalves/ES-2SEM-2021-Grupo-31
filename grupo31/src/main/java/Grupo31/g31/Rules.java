package Grupo31.g31;

public class Rules {

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

			Create_Method.row.createCell(10).setCellValue("TRUE");
			System.out.println("LONG METHOD TRUE");

		} else {

			Create_Method.row.createCell(10).setCellValue("FALSE");
			System.out.println("LONG METHOD FALSE");
		}
	}	
}