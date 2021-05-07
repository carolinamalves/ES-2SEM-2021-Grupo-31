package Grupo31.g31;

import java.util.ArrayList;

import org.apache.poi.util.SystemOutLogger;

public class Rules {

	static ArrayList<Method> a = Create_Method.a;
	static String locC = "LOC_class";
	static String nomC = "NOM_class";
	static String wmcC = "WMC_class";
	static String maior = ">";
	static String menor = "<";
	static String and = "AND";
	static String or = "OR";


	public static void rules (String rule) {

		String [] splitRule = rule.split(" ");
		System.out.println("REGRA" + splitRule.length);

		//so com uma metrica
		if (splitRule.length == 3) {

			//locCLass > ...
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior)) {

				for (Method m : a) { 

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}
				}
			}

			//locClass < ..
			if(splitRule[0].equals(locC) && splitRule[1].equals(menor)){

				for (Method m : a) { 

					if( m.getLoc_Class() < Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}	
			}

			//nomClass >...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(maior)){

				for (Method m : a) { 

					if( m.getNom_Class() > Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}	
			}

			//nomClass <...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(menor)){

				for (Method m : a) { 

					if( m.getNom_Class() < Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}	
			}

			//wmcClass > ...
			if(splitRule[0].equals(wmcC) && splitRule[1].equals(maior)){

				for (Method m : a) { 

					if( m.getWmc_Class() > Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}	
			}

			//wmcClass < ...
			if(splitRule[0].equals(wmcC) && splitRule[1].equals(menor)){

				for (Method m : a) { 

					if( m.getWmc_Class() < Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}	
			}
		}

		//duas metricas
		if (splitRule.length == 7) {

			//locClass > ... && nomC > ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) 
					&& splitRule[4].equals(nomC) && splitRule[5].equals(maior) || splitRule[0].equals(nomC) && splitRule[1].equals(maior) 
					&& splitRule[3].equals(and) && splitRule[4].equals(locC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getNom_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//locCLass > .. && nomClass < ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(maior) &&
					splitRule[3].equals(and) && splitRule[4].equals(nomC) && splitRule[5].equals(menor) || splitRule[0].equals(nomC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(and) && splitRule[4].equals(locC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getNom_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//locClass < ... && nomClass > ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(and) && splitRule[4].equals(nomC) && splitRule[5].equals(maior) || splitRule[0].equals(nomC) && splitRule[1].equals(maior) &&  
					splitRule[3].equals(and) && splitRule[4].equals(locC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getNom_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			// locClass < ... && nomClass < ... 
			if(splitRule[0].equals(locC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(and) && splitRule[4].equals(nomC) && splitRule[5].equals(menor) || splitRule[0].equals(nomC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(and) && splitRule[4].equals(locC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getNom_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//locClass > ... || nomC > ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) 
					&& splitRule[4].equals(nomC) && splitRule[5].equals(maior) || splitRule[0].equals(nomC) && splitRule[1].equals(maior) 
					&& splitRule[3].equals(or) && splitRule[4].equals(locC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//locCLass > .. || nomClass < ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(maior) &&
					splitRule[3].equals(or) && splitRule[4].equals(nomC) && splitRule[5].equals(menor) || splitRule[0].equals(nomC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(or) && splitRule[4].equals(locC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//locClass < ... || nomClass > ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(or) && splitRule[4].equals(nomC) && splitRule[5].equals(maior) || splitRule[0].equals(nomC) && splitRule[1].equals(maior) &&  
					splitRule[3].equals(or) && splitRule[4].equals(locC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getNom_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			// locClass < ... || nomClass < ... 
			if(splitRule[0].equals(locC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(or) && splitRule[4].equals(nomC) && splitRule[5].equals(menor) || splitRule[0].equals(nomC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(or) && splitRule[4].equals(locC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}
			
			
			
			
			
			//locClass > ... && wmcClass > ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) 
					&& splitRule[4].equals(wmcC) && splitRule[5].equals(maior) || splitRule[0].equals(wmcC) && splitRule[1].equals(maior) 
					&& splitRule[3].equals(and) && splitRule[4].equals(locC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getWmc_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//locCLass > .. && wmcClass < ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(maior) &&
					splitRule[3].equals(and) && splitRule[4].equals(wmcC) && splitRule[5].equals(menor) || splitRule[0].equals(wmcC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(and) && splitRule[4].equals(locC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getWmc_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//locClass < ... && wmcClass > ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(and) && splitRule[4].equals(wmcC) && splitRule[5].equals(maior) || splitRule[0].equals(wmcC) && splitRule[1].equals(maior) &&  
					splitRule[3].equals(and) && splitRule[4].equals(locC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getWmc_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			// locClass < ... && wmcClass < ... 
			if(splitRule[0].equals(locC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(and) && splitRule[4].equals(wmcC) && splitRule[5].equals(menor) || splitRule[0].equals(wmcC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(and) && splitRule[4].equals(locC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getWmc_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//locClass > ... || wmcClass > ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) 
					&& splitRule[4].equals(wmcC) && splitRule[5].equals(maior) || splitRule[0].equals(wmcC) && splitRule[1].equals(maior) 
					&& splitRule[3].equals(or) && splitRule[4].equals(locC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getWmc_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//locCLass > .. || wmcClass < ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(maior) &&
					splitRule[3].equals(or) && splitRule[4].equals(wmcC) && splitRule[5].equals(menor) || splitRule[0].equals(wmcC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(or) && splitRule[4].equals(locC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getWmc_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//locClass < ... || wmcClass > ...
			if(splitRule[0].equals(locC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(or) && splitRule[4].equals(wmcC) && splitRule[5].equals(maior) || splitRule[0].equals(wmcC) && splitRule[1].equals(maior) &&  
					splitRule[3].equals(or) && splitRule[4].equals(locC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getWmc_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			// locClass < ... || wmcClass < ... 
			if(splitRule[0].equals(locC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(or) && splitRule[4].equals(wmcC) && splitRule[5].equals(menor) || splitRule[0].equals(wmcC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(or) && splitRule[4].equals(locC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getWmc_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}
			
			
			
			
			//nomC > ... && wmcClass > ...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(and) 
					&& splitRule[4].equals(wmcC) && splitRule[5].equals(maior) || splitRule[0].equals(wmcC) && splitRule[1].equals(maior) 
					&& splitRule[3].equals(and) && splitRule[4].equals(nomC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getNom_Class() > Integer.parseInt(splitRule[2]) && m.getWmc_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//nomC > .. && wmcClass < ...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(maior) &&
					splitRule[3].equals(and) && splitRule[4].equals(wmcC) && splitRule[5].equals(menor) || splitRule[0].equals(wmcC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(and) && splitRule[4].equals(nomC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getNom_Class() > Integer.parseInt(splitRule[2]) && m.getWmc_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//nomClass < ... && wmcClass > ...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(and) && splitRule[4].equals(wmcC) && splitRule[5].equals(maior) || splitRule[0].equals(wmcC) && splitRule[1].equals(maior) &&  
					splitRule[3].equals(and) && splitRule[4].equals(nomC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getNom_Class() < Integer.parseInt(splitRule[2]) && m.getWmc_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			// nomClass < ... && wmcClass < ... 
			if(splitRule[0].equals(nomC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(and) && splitRule[4].equals(wmcC) && splitRule[5].equals(menor) || splitRule[0].equals(wmcC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(and) && splitRule[4].equals(nomC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getNom_Class() < Integer.parseInt(splitRule[2]) && m.getWmc_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//nomClass > ... || wmcClass > ...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) 
					&& splitRule[4].equals(wmcC) && splitRule[5].equals(maior) || splitRule[0].equals(wmcC) && splitRule[1].equals(maior) 
					&& splitRule[3].equals(or) && splitRule[4].equals(nomC) && splitRule[5].equals(maior)) {

				for (Method m : a) {

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getWmc_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//nomC > .. || wmcClass < ...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(maior) &&
					splitRule[3].equals(or) && splitRule[4].equals(wmcC) && splitRule[5].equals(menor) || splitRule[0].equals(wmcC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(or) && splitRule[4].equals(nomC) && splitRule[5].equals(maior)) {

				for (Method m : a) {
					
					if(m.getNom_Class() > Integer.parseInt(splitRule[2]) || m.getWmc_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			//nomClass < ... || wmcClass > ...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(or) && splitRule[4].equals(wmcC) && splitRule[5].equals(maior) || splitRule[0].equals(wmcC) && splitRule[1].equals(maior) &&  
					splitRule[3].equals(or) && splitRule[4].equals(nomC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getNom_Class() < Integer.parseInt(splitRule[2]) || m.getWmc_Class() > Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}

			// nomClass < ... || wmcClass < ... 
			if(splitRule[0].equals(nomC) && splitRule[1].equals(menor) &&
					splitRule[3].equals(or) && splitRule[4].equals(wmcC) && splitRule[5].equals(menor) || splitRule[0].equals(wmcC) && splitRule[1].equals(menor) &&  
					splitRule[3].equals(or) && splitRule[4].equals(nomC) && splitRule[5].equals(menor)) {

				for (Method m : a) {

					if( m.getNom_Class() < Integer.parseInt(splitRule[2]) || m.getWmc_Class() < Integer.parseInt(splitRule[6])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					}

				}

			}
		}
			
			//3 metricas
			
//		if (splitRule.length == 11) {
//			
//			
//			
//		
//			
//			
//
//
//
//		}


	}
}
