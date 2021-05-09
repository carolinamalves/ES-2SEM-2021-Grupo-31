package Metrics;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

import com.github.javaparser.ParseException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

// TODO: Auto-generated Javadoc
//@author grupo 31

//Linhas de código do Método
public class LOC_method{

	/** The ficheiro. */
	private static String ficheiro;
	
	/** The total. */
	public static int total;	
	
	/** The list. */
	public static ArrayList<Integer> list = new ArrayList <Integer>();
	
	/** The num. */
	public static int num;
	
	/** The num methods. */
	public static int numMethods;
	
	/**
	 * Instantiates a new LO C method.
	 *
	 * @param fileS the file S
	 * @throws ParseException the parse exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public LOC_method (String fileS) throws ParseException, IOException {
		this.ficheiro = fileS;
		total=0;
		num = 0;
		CompilationUnit unidadeC = StaticJavaParser.parse((new File (ficheiro)));

		new MethodVisitor().visit(unidadeC, null);
	}

	/**
	 * The Class MethodVisitor.
	 */
	private static class MethodVisitor extends VoidVisitorAdapter {
		public void visit(MethodDeclaration m, Object arg) {
			total=(m.getEnd().get().line-m.getBegin().get().line+1);
			list.add(total);
			list.set(num, total);
			num++;
			numMethods++;
		}
	}

	/**
	 * Gets the list.
	 *
	 * @return the list
	 */
	public ArrayList <Integer> getList() {
		return list;
	}
}