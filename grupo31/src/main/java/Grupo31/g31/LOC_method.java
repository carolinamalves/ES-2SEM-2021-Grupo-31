package Grupo31.g31;

import java.io.File;
import java.io.IOException;

import com.github.javaparser.ParseException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class LOC_method {
	private static String ficheiro;
	public static int total;
	//Construtor 
	public LOC_method (String ficheiro) {
		this.ficheiro=ficheiro;
		total=0;
	}

	void getMethodLineNumbers() throws ParseException, IOException {
		CompilationUnit unidadeC = StaticJavaParser.parse((new File(ficheiro)));

		new MethodVisitor().visit(unidadeC, null);
	}

	private static class MethodVisitor extends VoidVisitorAdapter {
		public void visit(MethodDeclaration m, Object arg) {
			int total=(m.getEnd().get().line-m.getBegin().get().line+1);

			System.out.println(total);
		}
	}
	
	public int getTotal() {
		return total;
	}
}