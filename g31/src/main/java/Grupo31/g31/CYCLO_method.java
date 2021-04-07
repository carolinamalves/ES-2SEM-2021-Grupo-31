package Grupo31.g31;

import java.awt.Point;
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
	public static List<Integer> lista = new ArrayList<Integer>();
	 
	public CYCLO_method (String ficheiro) {
		this.ficheiro=ficheiro;
		contador=0;
	}
	
	
}