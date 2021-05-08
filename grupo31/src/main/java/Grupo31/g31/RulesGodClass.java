package Grupo31.g31;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTable;

import org.apache.poi.util.SystemOutLogger;

public class RulesGodClass {

	static ArrayList<Method> a = Create_Method.a;
	static String locC = "LOC_class";
	static String nomC = "NOM_class";
	static String wmcC = "WMC_class";
	static String maior = ">";
	static String menor = "<";
	static String and = "AND";
	static String or = "OR";
	
	static ArrayList <String> godValues = new ArrayList <String> (); 
	static int it;
	
	public static void rules (String rule) {

		String [] splitRule = rule.split(" ");
		System.out.println("REGRA" + splitRule.length);
		

		//so com uma metrica
		if (splitRule.length == 3) {

			//locCLass > ...
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior)) {
				it=0;
				for (Method m : a) { 


					if( m.getLoc_Class() > Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");
						godValues.add("TRUE");
						godValues.set(it, "TRUE");
						

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
						godValues.add("FALSE");
						godValues.set(it, "FALSE");
					}
					it++;	
				}
			}

			//locClass < ..
			if(splitRule[0].equals(locC) && splitRule[1].equals(menor)){

				for (Method m : a) { 

					if( m.getLoc_Class() < Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");
						godValues.add("TRUE");
						

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					
						godValues.add("FALSE");
					}

				}	
			}

			//nomClass >...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(maior)){

				for (Method m : a) { 

					if( m.getNom_Class() > Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");
						godValues.add("TRUE");
						 
					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					  
						godValues.add("FALSE");
					}

				}	
			}

			//nomClass <...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(menor)){

				for (Method m : a) { 

					if( m.getNom_Class() < Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");
						godValues.add("TRUE");
				
					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
						
						godValues.add("FALSE");
					}

				}	
			}

			//wmcClass > ...
			if(splitRule[0].equals(wmcC) && splitRule[1].equals(maior)){

				for (Method m : a) { 

					if( m.getWmc_Class() > Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");
						godValues.add("TRUE");
 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					 
						godValues.add("FALSE");
					}

				}	
			}

			//wmcClass < ...
			if(splitRule[0].equals(wmcC) && splitRule[1].equals(menor)){

				for (Method m : a) { 

					if( m.getWmc_Class() < Integer.parseInt(splitRule[2])) {
						System.out.println(m.getName_class() + ":" + "TRUEEEE");
						godValues.add("TRUE");
					 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
						godValues.add("FALSE");
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
						godValues.add("TRUE");
				

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
				

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				
						godValues.add("FALSE");
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
						godValues.add("TRUE");
				 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
				 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
		 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
						 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
	 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
			 
						godValues.add("FALSE");
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
						godValues.add("TRUE"); 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
				 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					 
						godValues.add("FALSE");
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

						godValues.add("TRUE");
						 
					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
						

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
				 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
				 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					 
					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					 
					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
					 
					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
					 
						godValues.add("FALSE");
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
						godValues.add("TRUE");
			 

					}else {
						System.out.println(m.getName_class() + ":" + "FALSEEEE");
				 
						godValues.add("FALSE");
					}

				}

			}
		}

		//3 metricas
		if (splitRule.length == 11) {

			// locC > ... && nomC > ... && wmcC > ... done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getNom_Class() > Integer.parseInt(splitRule[6]) && m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
			 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... && nomC > ... && wmcC < ... done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getNom_Class() > Integer.parseInt(splitRule[6]) && m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
				 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... && nomC < ... && wmcC > ... done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getNom_Class() < Integer.parseInt(splitRule[6]) && m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
						 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... && nomC > ... && wmcC > ... done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getNom_Class() > Integer.parseInt(splitRule[6]) && m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
		 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... && nomC < ... && wmcC < ...
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getNom_Class() < Integer.parseInt(splitRule[6]) && m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
						 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... && nomC < ... && wmcC < ... done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getNom_Class() < Integer.parseInt(splitRule[6]) && m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
						 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... && nomC > ... && wmcC < ... done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getNom_Class() > Integer.parseInt(splitRule[6]) && m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
				 
					}else{
						System.out.println("FALSE");
						 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... && nomC < ... && wmcC > ... done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getNom_Class() < Integer.parseInt(splitRule[6]) && m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
			 
					}else{
						System.out.println("FALSE");
 
						godValues.add("FALSE");
					}


				}
			}




			// locC > ... || nomC > ... || wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() > Integer.parseInt(splitRule[6]) || m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
				
					}else{
						System.out.println("FALSE");
			 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... || nomC > ... || wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() > Integer.parseInt(splitRule[6]) || m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... || nomC < ... || wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6]) || m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
				 
					}else{
						System.out.println("FALSE");
			 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... || nomC > ...  || wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getNom_Class() > Integer.parseInt(splitRule[6]) || m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
		 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... || nomC < ... || wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6]) || m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
					 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... || nomC < ... || wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6]) || m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
				 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... || nomC > ... || wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getNom_Class() > Integer.parseInt(splitRule[6]) || m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
			 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... || nomC < ... || wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(locC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6]) || m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
						 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}



			//OR AND


			// locC > ... || nomC > ... && wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() > Integer.parseInt(splitRule[6]) && m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
				 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... || nomC > ... && wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() > Integer.parseInt(splitRule[6]) && m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
				 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... || nomC < ... && wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6]) && m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
				 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... || nomC > ...  && wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getNom_Class() > Integer.parseInt(splitRule[6]) && m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
						 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... || nomC < ... && wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6]) && m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
			 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... || nomC < ... && wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6]) && m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
					 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... || nomC > ... && wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getNom_Class() > Integer.parseInt(splitRule[6]) && m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
					 
					}else{
						System.out.println("FALSE");
						 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... || nomC < ... && wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(wmcC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(locC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(nomC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6]) && m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
				 
					}else{
						System.out.println("FALSE");
			 
						godValues.add("FALSE");
					}


				}
			}


			//AND OR

			// locC > ... && nomC > ... || wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getNom_Class() > Integer.parseInt(splitRule[6]) || m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
					 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... && nomC > ... || wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior)) {

				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getNom_Class() > Integer.parseInt(splitRule[6]) || m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
					 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... && nomC < ... || wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior)) {



				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) || m.getNom_Class() < Integer.parseInt(splitRule[6]) && m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
						 
					}else{
						System.out.println("FALSE");
				 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... && nomC > ...  || wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getNom_Class() > Integer.parseInt(splitRule[6]) || m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
				 
					}else{
						System.out.println("FALSE");
			 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... && nomC < ... || wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor)) {

				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getNom_Class() < Integer.parseInt(splitRule[6]) || m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
		
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC > ... && nomC < ... || wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(maior)) {


				for (Method m: a) {

					if (m.getLoc_Class() > Integer.parseInt(splitRule[2]) && m.getNom_Class() < Integer.parseInt(splitRule[6]) || m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
					 
					}else{
						System.out.println("FALSE");
			 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... && nomC > ... || wmcC < ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(menor) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(maior) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor)) {


				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getNom_Class() > Integer.parseInt(splitRule[6]) || m.getWmc_Class() < Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
					 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}

			// locC < ... && nomC < ... || wmcC > ... done done
			if (splitRule[0].equals(locC) && splitRule[1].equals(menor) && splitRule[3].equals(and) && splitRule[4].equals(nomC) &&
					splitRule[5].equals(menor) && splitRule[7].equals(or) && splitRule[8].equals(wmcC) && splitRule[9].equals(maior) ||
					splitRule[0].equals(nomC) && splitRule[1].equals(menor) && splitRule[3].equals(or) && splitRule[4].equals(wmcC) &&
					splitRule[5].equals(maior) && splitRule[7].equals(and) && splitRule[8].equals(locC) && splitRule[9].equals(menor)) {

				for (Method m: a) {

					if (m.getLoc_Class() < Integer.parseInt(splitRule[2]) && m.getNom_Class() < Integer.parseInt(splitRule[6]) || m.getWmc_Class() > Integer.parseInt(splitRule[10]) ) {
						System.out.println("TRUE");
						godValues.add("TRUE");
					 
					}else{
						System.out.println("FALSE");
					 
						godValues.add("FALSE");
					}


				}
			}	

		}


	}
}
