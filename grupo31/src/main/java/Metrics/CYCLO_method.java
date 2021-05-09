package Metrics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ParseException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

// TODO: Auto-generated Javadoc
//@author grupo 31

public class CYCLO_method {

	/** The contador. */
	public static int contador;
	
	/** The i. */
	public static int i;
	
	/** The cic. */
	public static int cic = 0;
	
	/** The num. */
	public static int num;
	
	/** The list. */
	public static ArrayList<Integer> list=new ArrayList<Integer>();
	
	/** The nom class. */
	public static int nomClass;

	/** The name of methods. */
	public static ArrayList<String> nameOfMethods = new ArrayList<String>();

	//@param
	
	/**
	 * Instantiates a new CYCL O method.
	 *
	 * @param ficheiro the ficheiro
	 * @throws FileNotFoundException the file not found exception
	 */
	public CYCLO_method (String ficheiro) throws FileNotFoundException {

		contador=0;
		num = 0 ;
		nomClass=0;
		CompilationUnit unidadeC = StaticJavaParser.parse(new File(ficheiro));
		new MethodVisitor().visit(unidadeC,null);
	}

	/**
	 * The Class MethodVisitor.
	 */
	private static class MethodVisitor extends VoidVisitorAdapter {
		public void visit(MethodDeclaration m, Object arg) {
			nomClass++;

			List <Statement> a=m.findAll(Statement.class);
			for(Statement i:a) {
				if (i.isExpressionStmt() || i.isIfStmt() || i.isForStmt()||i.isWhileStmt()||i.isForEachStmt() || i.isSwitchStmt()) {
					contador++;		
				}
			}	
			String metName = (m.getNameAsString() + m.getParameters()).replace("[", "(");
			metName = metName.replace("]", ")");

			nameOfMethods.add(metName); //getParameters
			nameOfMethods.set(num,metName);			
			contador = contador +1;
			list.add(contador);
			list.set(num, contador);
			num++;
		}
	}
	
	/**
	 * Gets the contador.
	 *
	 * @return the contador
	 * @throws ParseException the parse exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public ArrayList<Integer> getContador() throws ParseException, IOException {
		return list;
	}

	/**
	 * Gets the nom class.
	 *
	 * @return the nom class
	 */
	public int getNomClass() {
		return nomClass;
	}

	/**
	 * Gets the name of methods.
	 *
	 * @return the name of methods
	 */
	public ArrayList<String> getNameOfMethods(){
		return nameOfMethods;
	}
}