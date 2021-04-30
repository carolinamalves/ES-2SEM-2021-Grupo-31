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



public class LOC_method{
	private static String ficheiro;
	public static int total;
	public static ArrayList<Integer> list=new ArrayList<Integer>();
	
	//Construtor 
	public LOC_method (String fileS) {
		this.ficheiro = fileS;
		total=0;
	}

	public void getMethodLineNumbers() throws ParseException, IOException {
		CompilationUnit unidadeC = StaticJavaParser.parse((new File (ficheiro)));

		new MethodVisitor().visit(unidadeC, null);
	}

	private static class MethodVisitor extends VoidVisitorAdapter {
		public void visit(MethodDeclaration m, Object arg) {
			total=(m.getEnd().get().line-m.getBegin().get().line+1);

			
		//	System.out.println("locMethod" + total);
			list.add(total);
		//	System.out.println(total);
		}
	}
	
	public ArrayList<Integer> getList() throws ParseException, IOException {
		getMethodLineNumbers();
		return list;
	}	
	

	
	
 	 public static void main(String[] args) throws ParseException, IOException {
	     		 
 		 Leitura_Projetos s = new Leitura_Projetos();
 		List<File>lista = s.lista("C:\\Users\\adilh\\git\\ES-2SEM-2021-Grupo-31\\grupo31\\src\\main\\java\\Grupo31\\g31\\");
	//	LOC_method a = new LOC_method("");
	 for(File i:lista) {
		 LOC_method  a = new LOC_method(i.toString());
			System.out.println(a.getList()+ ""+ i);
	 }
	
	}
	
	
}