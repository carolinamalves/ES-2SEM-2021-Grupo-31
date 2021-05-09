package Rules;

import java.util.ArrayList;

import Support.Create_Method;
import Support.Method;

// TODO: Auto-generated Javadoc
//@author grupo 31

public class RulesGodClass {

	/** The a. */
	static ArrayList<Method> a = Create_Method.a;
	
	/** The loc C. */
	static String locC = "LOC_class";
	
	/** The nom C. */
	static String nomC = "NOM_class";
	
	/** The wmc C. */
	static String wmcC = "WMC_class";
	
	/** The maior. */
	static String maior = ">";
	
	/** The menor. */
	static String menor = "<";
	
	/** The and. */
	static String and = "AND";
	
	/** The or. */
	static String or = "OR";
	
	/** The god values. */
	public static ArrayList <String> godValues = new ArrayList <String> (); 
	
	/** The it. */
	static int it;
	
	/**
	 * Rules.
	 *
	 * @param rule the rule
	 */
	public static void rules (String rule) {

		String [] splitRule = rule.split(" ");

		//so com uma metrica
		if (splitRule.length == 3) {

			//locCLass > ...
			if (splitRule[0].equals(locC) && splitRule[1].equals(maior)) {
				it = 0;
				for (Method m : a) { 

					if( m.getLoc_Class() > Integer.parseInt(splitRule[2])) {
						godValues.add("TRUE");
						godValues.set(it, "TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {	
						godValues.add("FALSE");
					}
				}	
			}

			//nomClass >...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(maior)){

				for (Method m : a) { 

					if( m.getNom_Class() > Integer.parseInt(splitRule[2])) {
						godValues.add("TRUE");
						 
					}else {					  
						godValues.add("FALSE");
					}
				}	
			}

			//nomClass <...
			if(splitRule[0].equals(nomC) && splitRule[1].equals(menor)){

				for (Method m : a) { 
					if( m.getNom_Class() < Integer.parseInt(splitRule[2])) {
						godValues.add("TRUE");
				
					}else {	
						godValues.add("FALSE");
					}
				}	
			}

			//wmcClass > ...
			if(splitRule[0].equals(wmcC) && splitRule[1].equals(maior)){

				for (Method m : a) { 

					if( m.getWmc_Class() > Integer.parseInt(splitRule[2])) {
						godValues.add("TRUE");
					}else {
						godValues.add("FALSE");
					}
				}	
			}

			//wmcClass < ...
			if(splitRule[0].equals(wmcC) && splitRule[1].equals(menor)){

				for (Method m : a) { 

					if( m.getWmc_Class() < Integer.parseInt(splitRule[2])) {
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE"); 
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else {
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
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
						godValues.add("TRUE");
					}else{
						godValues.add("FALSE");
					}
				}
			}	
		}
	}
}