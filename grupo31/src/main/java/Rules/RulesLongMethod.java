package Rules;

import java.util.ArrayList;

import Support.Create_Method;
import Support.Method;

// TODO: Auto-generated Javadoc
//@author grupo 31

public class RulesLongMethod {

	/** The a. */
	static ArrayList<Method> a = Create_Method.a;

	/** The loc M. */
	static String locM = "LOC_method";

	/** The cyc M. */
	static String cycM = "CYCLO_method";

	/** The maior. */
	static String maior = ">";

	/** The menor. */
	static String menor = "<";

	/** The and. */
	static String and = "AND";

	/** The or. */
	static String or = "OR";

	/** The long values. */
	static ArrayList<String> longValues = new ArrayList<>();

	/**
	 * Rules.
	 *
	 * @param rule the rule
	 */
	public static void rules(String rule) {

		String [] splitRule = rule.split(" ");

		//so com uma metrica
		if (splitRule.length == 3) {

			//locEthod > ...
			if (splitRule[0].equals(locM) && splitRule[1].equals(maior)) {

				for (Method m : a) { 
					if( m.getLoc_Method() > Integer.parseInt(splitRule[2])) {
						longValues.add("TRUE");
					}else {
						longValues.add("FALSE");
					}
				}
			}
			//locMethod < ..
			if(splitRule[0].equals(locM) && splitRule[1].equals(menor)){

				for (Method m : a) { 

					if( m.getLoc_Method() < Integer.parseInt(splitRule[2])) {
						longValues.add("TRUE");
					}else {
						longValues.add("FALSE");
					}
				}	
			}
			//cycMethod >...
			if(splitRule[0].equals(cycM) && splitRule[1].equals(maior)){

				for (Method m : a) { 

					if( m.getCYCLO_method() > Integer.parseInt(splitRule[2])) {
						longValues.add("TRUE");
					}else {
						longValues.add("FALSE");
					}
				}	
			}
			//cyclo Method <...
			if(splitRule[0].equals(cycM) && splitRule[1].equals(menor)){

				for (Method m : a) { 

					if( m.getCYCLO_method() < Integer.parseInt(splitRule[2])) {
						longValues.add("TRUE");
					}else {
						longValues.add("FALSE");
					}
				}	
			}

			//duas metricas
			if (splitRule.length == 7) {

				//locMethod > ... && cycloMethod > ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(maior) && splitRule[3].equals(and) 
						&& splitRule[4].equals(cycM) && splitRule[5].equals(maior) || splitRule[0].equals(cycM) && splitRule[1].equals(maior) 
						&& splitRule[3].equals(and) && splitRule[4].equals(locM) && splitRule[5].equals(maior)) {

					for (Method m : a) {

						if( m.getLoc_Method() > Integer.parseInt(splitRule[2]) && m.getCYCLO_method() > Integer.parseInt(splitRule[6])) {
							longValues.add("TRUE");
						}else {
							longValues.add("FALSE");
						}
					}
				}
				//locMethod > .. && cycMethod < ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(maior) &&
						splitRule[3].equals(and) && splitRule[4].equals(cycM) && splitRule[5].equals(menor) || splitRule[0].equals(cycM) && splitRule[1].equals(menor) &&  
						splitRule[3].equals(and) && splitRule[4].equals(locM) && splitRule[5].equals(maior)) {

					for (Method m : a) {

						if( m.getLoc_Method() > Integer.parseInt(splitRule[2]) && m.getCYCLO_method() < Integer.parseInt(splitRule[6])) {
							longValues.add("TRUE");
						}else{
							longValues.add("FALSE");
						}
					}
				}

				//locMethod < ... && cycloMethod > ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(menor) &&
						splitRule[3].equals(and) && splitRule[4].equals(cycM) && splitRule[5].equals(maior) || splitRule[0].equals(cycM) && splitRule[1].equals(maior) &&  
						splitRule[3].equals(and) && splitRule[4].equals(locM) && splitRule[5].equals(menor)) {

					for (Method m : a) {

						if( m.getLoc_Method() < Integer.parseInt(splitRule[2]) && m.getCYCLO_method() > Integer.parseInt(splitRule[6])) {
							longValues.add("TRUE");
						}else {
							longValues.add("FALSE");
						}
					}
				}

				// locMethod < ... && cycloMethod < ... 
				if(splitRule[0].equals(locM) && splitRule[1].equals(menor) &&
						splitRule[3].equals(and) && splitRule[4].equals(cycM) && splitRule[5].equals(menor) || splitRule[0].equals(cycM) && splitRule[1].equals(menor) &&  
						splitRule[3].equals(and) && splitRule[4].equals(locM) && splitRule[5].equals(menor)) {

					for (Method m : a) {

						if( m.getLoc_Method() < Integer.parseInt(splitRule[2]) && m.getCYCLO_method() < Integer.parseInt(splitRule[6])) {
							longValues.add("TRUE");
						}else {
							longValues.add("FALSE");
						}
					}
				} 
				//locMethod > ... || cycM > ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(maior) && splitRule[3].equals(or) 
						&& splitRule[4].equals(cycM) && splitRule[5].equals(maior) || splitRule[0].equals(cycM) && splitRule[1].equals(maior) 
						&& splitRule[3].equals(or) && splitRule[4].equals(locM) && splitRule[5].equals(maior)) {

					for (Method m : a) {

						if( m.getLoc_Method() > Integer.parseInt(splitRule[2]) || m.getCYCLO_method() > Integer.parseInt(splitRule[6])) {
							longValues.add("TRUE");
						}else {
							longValues.add("FALSE");
						}
					}
				}
				//locMethod > .. || cycloMethod < ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(maior) &&
						splitRule[3].equals(or) && splitRule[4].equals(cycM) && splitRule[5].equals(menor) || splitRule[0].equals(cycM) && splitRule[1].equals(menor) &&  
						splitRule[3].equals(or) && splitRule[4].equals(locM) && splitRule[5].equals(maior)) {

					for (Method m : a) {

						if( m.getLoc_Method() > Integer.parseInt(splitRule[2]) || m.getCYCLO_method() < Integer.parseInt(splitRule[6])) {
							longValues.add("TRUE");
						}else {
							longValues.add("FALSE");
						}
					}
				}

				//locMethod < ... || cycMethod > ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(menor) &&
						splitRule[3].equals(or) && splitRule[4].equals(cycM) && splitRule[5].equals(maior) || splitRule[0].equals(cycM) && splitRule[1].equals(maior) &&  
						splitRule[3].equals(or) && splitRule[4].equals(locM) && splitRule[5].equals(menor)) {

					for (Method m : a) {

						if( m.getLoc_Method() < Integer.parseInt(splitRule[2]) || m.getCYCLO_method() > Integer.parseInt(splitRule[6])) {
							longValues.add("TRUE");
						}else {
							longValues.add("FALSE");
						}
					}
				}

				// locMethod < ... || cycloMethod < ... 
				if(splitRule[0].equals(locM) && splitRule[1].equals(menor) &&
						splitRule[3].equals(or) && splitRule[4].equals(cycM) && splitRule[5].equals(menor) || splitRule[0].equals(cycM) && splitRule[1].equals(menor) &&  
						splitRule[3].equals(or) && splitRule[4].equals(locM) && splitRule[5].equals(menor)) {

					for (Method m : a) {

						if( m.getLoc_Method() < Integer.parseInt(splitRule[2]) || m.getCYCLO_method() < Integer.parseInt(splitRule[6])) {
							longValues.add("TRUE");
						}else {
							longValues.add("FALSE");
						}
					}
				}
			}
		}
	}
}