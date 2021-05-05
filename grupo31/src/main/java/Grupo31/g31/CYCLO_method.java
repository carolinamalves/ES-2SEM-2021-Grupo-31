package Grupo31.g31;

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

public class CYCLO_method {
	private static String ficheiro;

	public static int contador;
	public static int i;
	public static int cic = 0;
	public static int num;
	public static ArrayList<Integer> list=new ArrayList<Integer>();

	public CYCLO_method (String ficheiro) throws FileNotFoundException {
		this.ficheiro = ficheiro;
		contador=0;
		num = 0 ;
		CompilationUnit unidadeC = StaticJavaParser.parse((new File(ficheiro)));
		new MethodVisitor().visit(unidadeC,null);
	}


	private static class MethodVisitor extends VoidVisitorAdapter {
		public void visit(MethodDeclaration m, Object arg) {

			List <Statement> a=m.findAll(Statement.class);
			for(Statement i:a)
			{
				if (i.isExpressionStmt() || i.isIfStmt() || i.isForStmt()||i.isWhileStmt()||i.isForEachStmt()) {
					contador++;	

				}


			}
			System.out.println("contadooooor" + contador);
			list.add(contador);
			list.set(num, contador);
			num++;
		}
	}
	public ArrayList<Integer> getContador() throws ParseException, IOException {
		System.out.println("LISTA" + list);
		return list;

	}
}