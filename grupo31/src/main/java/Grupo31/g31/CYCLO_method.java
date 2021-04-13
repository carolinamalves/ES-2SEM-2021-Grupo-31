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
		public static List<Integer> lista;
		//Construtor 
		public CYCLO_method (String ficheiro) {
			this.ficheiro=ficheiro;
			contador=0;
			lista= new ArrayList<>();
		}
		
		public static List<Integer> getLista() {
			return lista;
		}

		public static void setLista(List<Integer> lista) {
			CYCLO_method.lista = lista;
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
					lista.add(contador);			
				System.out.println(getLista());
	    	}
	    	
	    	
	    	
		}

	

	    	
//		public static void main (String [] args) throws Exception {
//			String s = "C:\\Users\\adilh\\eclipse-workspace\\Contar\\src\\Contar.java";
//			CYCLO_method a = new CYCLO_method(s);
//	//		a.getCYCLO_method(0);
//			a.getMethodLineNumbers();
//		}		
}