package Grupo31.g31;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.List;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.stmt.Statement;

public class  WMC_class {		
	private static int contador;
	private static String ficheiro;
	//construtor
	public WMC_class(String ficheiro) throws FileNotFoundException {
		contador = 0;
		this.ficheiro=ficheiro;
	}

	private void contagem() throws FileNotFoundException { 
		CompilationUnit unidadeC = StaticJavaParser.parse(new File(ficheiro));
		List<Statement> a=unidadeC.findAll(Statement.class);
		for(Statement i:a)
		{
			//counter de statement if e for
			if (i.isExpressionStmt() || i.isIfStmt() || i.isForStmt()||i.isWhileStmt()||i.isForEachStmt())
				contador++;
		}
	}	

	public int getWMC_class() {
		return contador;
	}
}