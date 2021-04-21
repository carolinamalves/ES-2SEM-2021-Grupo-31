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
	public static int i;
	public static ArrayList<Integer> list=new ArrayList<Integer>();

	//Construtor 
	public CYCLO_method (String ficheiro) {
		this.ficheiro=ficheiro;
		contador=0;
	}


	void getMethodLineNumbers() throws ParseException, IOException {
		CompilationUnit unidadeC = StaticJavaParser.parse((new File(ficheiro)));

		new MethodVisitor().visit(unidadeC, null);

	}

	private static class MethodVisitor extends VoidVisitorAdapter {
		public void visit(MethodDeclaration m, Object arg) {
			int contador=0;
			List<Statement> a=m.findAll(Statement.class);
			for(Statement i:a)
			{
				if (i.isExpressionStmt() || i.isIfStmt() || i.isForStmt()||i.isWhileStmt()||i.isForEachStmt())
					contador++;
			}
			list.add(contador);
		//	System.out.println(contador);
		}

	}

	public ArrayList<Integer> getList() throws ParseException, IOException{
		getMethodLineNumbers();
		return list;
	}
	


}


