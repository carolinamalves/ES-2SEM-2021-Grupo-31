package Grupo31.g31;


	import java.io.File;
	import java.io.FileNotFoundException;
	import java.util.ArrayList;
	import java.util.List;

	import com.github.javaparser.StaticJavaParser;
	import com.github.javaparser.ast.CompilationUnit;
	import com.github.javaparser.ast.stmt.Statement;
		

		public class  WMC {
		

			private static int contador;
			private static String ficheiro;
		

			public WMC(String ficheiro) throws FileNotFoundException {
				contador = 0;
				this.ficheiro=ficheiro;
			}
		

			private void contagem() throws FileNotFoundException { 
				CompilationUnit unidadeC = StaticJavaParser.parse(new File(ficheiro));
				List<Statement> a=unidadeC.findAll(Statement.class);
					for(Statement i:a)
				{
						if (i.isExpressionStmt() || i.isIfStmt() || i.isForStmt())
					contador++;
					}
				}	
					
			public int getWMC_class() {
				return contador;
		}
}