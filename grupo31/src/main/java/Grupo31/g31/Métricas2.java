package Grupo31.g31;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class Métricas2 {

	public int numberPackage(File file) throws FileNotFoundException{

		Scanner scanner;
		String pacote = null;

		int contador=0;

		scanner = new Scanner(file);

		while(scanner.hasNext()) {
			pacote = scanner.nextLine().toString();

			if(pacote.contains("package")) {
				contador++;
			}
		}
		scanner.close();

		return contador;
	}

	public static class ClassVisitor extends VoidVisitorAdapter {
		int contador=0;

		public void contarClasses(ClassOrInterfaceDeclaration c){
			contador++;
		}

		public int numeroClasses() {
			return contador;
		}
	} 
}