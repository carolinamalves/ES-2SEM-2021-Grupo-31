package Grupo31.g31;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.github.javaparser.ParseException;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class LOC_method{
	private static String ficheiro;
	public static int total;	
	public static ArrayList<Integer> list = new ArrayList <Integer>();
	public static int num;
	public LOC_method (String fileS) throws ParseException, IOException{
		this.ficheiro = fileS;
		total=0;
		num = 0;
		CompilationUnit unidadeC = StaticJavaParser.parse((new File (ficheiro)));
		
		new MethodVisitor().visit(unidadeC, null);
	}

	private static class MethodVisitor extends VoidVisitorAdapter {
		public void visit(MethodDeclaration m, Object arg) {
			total=(m.getEnd().get().line-m.getBegin().get().line+1);
			list.add(total);
			list.set(num, total);
			num++;
		}
	}	
	public ArrayList <Integer> getList(){
		System.out.println("LISTA LOC" + list);
		return list;
	}
}