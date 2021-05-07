package Grupo31.g31;

import java.util.ArrayList;

public class RulesLongMethod {

		static ArrayList<Method> a = Create_Method.a;
		static String locM = "LOC_method";
		static String cycM = "CYCLO_method";
		
		static String maior = ">";
		static String menor = "<";
		static String and = "AND";
		static String or = "OR";


		public static void rules(String rule) {

			String [] splitRule = rule.split(" ");
			System.out.println("REGRA" + splitRule.length);


			//so com uma metrica
			if (splitRule.length == 3) {

				//locEthod > ...
				if (splitRule[0].equals(locM) && splitRule[1].equals(maior)) {

					for (Method m : a) { 


						if( m.getLoc_Method() > Integer.parseInt(splitRule[2])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");
						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}
					}
				}

				//locMethod < ..
				if(splitRule[0].equals(locM) && splitRule[1].equals(menor)){

					for (Method m : a) { 

						if( m.getLoc_Method() < Integer.parseInt(splitRule[2])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}

					}	
				}

				//cycMethod >...
				if(splitRule[0].equals(cycM) && splitRule[1].equals(maior)){

					for (Method m : a) { 

						if( m.getCYCLO_method() > Integer.parseInt(splitRule[2])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}

					}	
				}

				//cyclo Method <...
				if(splitRule[0].equals(cycM) && splitRule[1].equals(menor)){

					for (Method m : a) { 

						if( m.getCYCLO_method() < Integer.parseInt(splitRule[2])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
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
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}

					}

				}

				//locMethod > .. && cycMethod < ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(maior) &&
						splitRule[3].equals(and) && splitRule[4].equals(cycM) && splitRule[5].equals(menor) || splitRule[0].equals(cycM) && splitRule[1].equals(menor) &&  
						splitRule[3].equals(and) && splitRule[4].equals(locM) && splitRule[5].equals(maior)) {

					for (Method m : a) {

						if( m.getLoc_Method() > Integer.parseInt(splitRule[2]) && m.getCYCLO_method() < Integer.parseInt(splitRule[6])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}

					}

				}

				//locMethod < ... && cycloMethod > ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(menor) &&
						splitRule[3].equals(and) && splitRule[4].equals(cycM) && splitRule[5].equals(maior) || splitRule[0].equals(cycM) && splitRule[1].equals(maior) &&  
						splitRule[3].equals(and) && splitRule[4].equals(locM) && splitRule[5].equals(menor)) {

					for (Method m : a) {

						if( m.getLoc_Method() < Integer.parseInt(splitRule[2]) && m.getCYCLO_method() > Integer.parseInt(splitRule[6])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}

					}

				}

				// locMethod < ... && cycloMethod < ... 
				if(splitRule[0].equals(locM) && splitRule[1].equals(menor) &&
						splitRule[3].equals(and) && splitRule[4].equals(cycM) && splitRule[5].equals(menor) || splitRule[0].equals(cycM) && splitRule[1].equals(menor) &&  
						splitRule[3].equals(and) && splitRule[4].equals(locM) && splitRule[5].equals(menor)) {

					for (Method m : a) {

						if( m.getLoc_Method() < Integer.parseInt(splitRule[2]) && m.getCYCLO_method() < Integer.parseInt(splitRule[6])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}

					}

				} 

				//locMethod > ... || cycM > ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(maior) && splitRule[3].equals(or) 
						&& splitRule[4].equals(cycM) && splitRule[5].equals(maior) || splitRule[0].equals(cycM) && splitRule[1].equals(maior) 
						&& splitRule[3].equals(or) && splitRule[4].equals(locM) && splitRule[5].equals(maior)) {

					for (Method m : a) {

						if( m.getLoc_Method() > Integer.parseInt(splitRule[2]) || m.getCYCLO_method() > Integer.parseInt(splitRule[6])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}

					}

				}

				//locMethod > .. || cycloMethod < ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(maior) &&
						splitRule[3].equals(or) && splitRule[4].equals(cycM) && splitRule[5].equals(menor) || splitRule[0].equals(cycM) && splitRule[1].equals(menor) &&  
						splitRule[3].equals(or) && splitRule[4].equals(locM) && splitRule[5].equals(maior)) {

					for (Method m : a) {

						if( m.getLoc_Method() > Integer.parseInt(splitRule[2]) || m.getCYCLO_method() < Integer.parseInt(splitRule[6])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}

					}

				}

				//locMethod < ... || cycMethod > ...
				if(splitRule[0].equals(locM) && splitRule[1].equals(menor) &&
						splitRule[3].equals(or) && splitRule[4].equals(cycM) && splitRule[5].equals(maior) || splitRule[0].equals(cycM) && splitRule[1].equals(maior) &&  
						splitRule[3].equals(or) && splitRule[4].equals(locM) && splitRule[5].equals(menor)) {

					for (Method m : a) {

						if( m.getLoc_Method() < Integer.parseInt(splitRule[2]) || m.getCYCLO_method() > Integer.parseInt(splitRule[6])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}

					}

				}

				// locMethod < ... || cycloMethod < ... 
				if(splitRule[0].equals(locM) && splitRule[1].equals(menor) &&
						splitRule[3].equals(or) && splitRule[4].equals(cycM) && splitRule[5].equals(menor) || splitRule[0].equals(cycM) && splitRule[1].equals(menor) &&  
						splitRule[3].equals(or) && splitRule[4].equals(locM) && splitRule[5].equals(menor)) {

					for (Method m : a) {

						if( m.getLoc_Method() < Integer.parseInt(splitRule[2]) || m.getCYCLO_method() < Integer.parseInt(splitRule[6])) {
							System.out.println(m.getName_class() + ":" + "TRUEEEE");

						}else {
							System.out.println(m.getName_class() + ":" + "FALSEEEE");
						}

					}

				}
			}
			}
		}
}
