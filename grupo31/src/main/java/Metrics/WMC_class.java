package Metrics;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.Statement;

// TODO: Auto-generated Javadoc
//@author grupo 31

public class  WMC_class {	

	/** The contador. */
	private static int contador;
	
	/** The ficheiro. */
	private static String ficheiro;

	/**
	 * Instantiates a new WM C class.
	 *
	 * @param ficheiro the ficheiro
	 * @throws FileNotFoundException the file not found exception
	 */
	public WMC_class(String ficheiro) throws FileNotFoundException {	
		contador = 0;
		this.ficheiro=ficheiro;
	}

	/**
	 * Contagem.
	 *
	 * @return the int
	 * @throws FileNotFoundException the file not found exception
	 */
	public int contagem() throws FileNotFoundException { 

		CompilationUnit unidadeC = StaticJavaParser.parse(new File(ficheiro));
		List<Statement> a=unidadeC.findAll(Statement.class);

		for(Statement i:a){
			if (i.isExpressionStmt() || i.isIfStmt() || i.isForStmt()||i.isWhileStmt()||i.isForEachStmt())
				contador++;
		}
		return contador;
	}	
}