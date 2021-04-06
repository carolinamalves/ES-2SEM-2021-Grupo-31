package Grupo31.g31;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.github.javaparser.ParseException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;


public class LOC_Method {
		private static String ficheiro;
		
		public LOC_Method (String ficheiro) {
			this.ficheiro=ficheiro;
		}
		
		private static void getMethodLineNumbers() throws ParseException, IOException {
		    CompilationUnit unidadeC = StaticJavaParser.parse((new File(ficheiro)));
	
		    new MethodVisitor().visit(unidadeC, null);
		}

		
		
}