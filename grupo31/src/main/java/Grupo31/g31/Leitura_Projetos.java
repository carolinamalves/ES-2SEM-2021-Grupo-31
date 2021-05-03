package Grupo31.g31;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leitura_Projetos {
	  static ArrayList <File> ficheiro = new ArrayList<>();
	 static String dirName;
	  static ArrayList <String> fimdojava = new ArrayList<>();
	  static Create_Method cm = new Create_Method();
	  public static ArrayList<File> getFicheiro() {
		  return ficheiro;
	  }
	  
	  public static String getDirName() { 
		  
		
		 return dirName;
		  
	  }
	  
	  public List <File> lista(String local_diretorio) {
	      dirName = local_diretorio;
		  File diretorio = new File(local_diretorio);
		  List <File> file= new ArrayList<>();
	        File[] listaFicheiros = diretorio.listFiles();
	        ficheiro.addAll(Arrays.asList(listaFicheiros));
	        for (File i : listaFicheiros) {
	        	if (i.isFile() && i.getAbsolutePath().endsWith(".java")) {
	        //		System.out.println("caminho"+i.getAbsolutePath());
	        	  
	        		Path fim = Paths.get(i.getAbsolutePath());
	        	    System.out.println(fim.getFileName().toString());
	        	    fimdojava.add(fim.getFileName().toString());
	        	     			        		
	            } else if (i.isDirectory()) {
	                ficheiro.addAll(lista(i.getAbsolutePath()));
	            }
	        }
	        //System.out.println(fList);
	       //System.out.println(getFicheiro());
	        return ficheiro;
	    }

	public static ArrayList<String> getFimdojava() {
		return fimdojava;
	}
  	  
	 public static void main(String[] args) {
 		// grupo31\\
	     Leitura_Projetos p = new Leitura_Projetos();		 
 		File f = new File("C:\\Users\\adilh\\git\\ES-2SEM-2021-Grupo-31\\");
 		 List<File> files=new ArrayList<>();
 		
 		 p.lista("C:\\Users\\adilh\\git\\ES-2SEM-2021-Grupo-31\\grupo31\\");
 		 System.out.println("dentro do array esta"+p.getFimdojava());
	 }	 


}
