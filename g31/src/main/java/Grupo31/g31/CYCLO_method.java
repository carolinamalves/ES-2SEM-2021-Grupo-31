package Grupo31.g31;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ParseException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class CYCLO_method {
	private static String ficheiro;
	public static int contador;
	//Construtor 
	public CYCLO_method (String ficheiro) {
		this.ficheiro=ficheiro;
		contador=0;
	}
	
	private static void getCYCLO_method() throws ParseException, IOException {
	    CompilationUnit unidadeC = StaticJavaParser.parse((new File(ficheiro)));

	    new MethodVisitor().visit(unidadeC, null);
	}	
}